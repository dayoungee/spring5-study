package org.example.chap08.config;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.example.chap08.spring.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@Transactional 애노테이션이 붙은 메서드를 트랜잭션 범위에서 실행하는 기능 활성화 PlatformTransactionManager 빈을 사용해서 트랜잭션을 적용
public class AppCtx {
    @Bean(destroyMethod = "close") // 커넥션 풀에 보관된 connection을 닫는다.
    public DataSource dataSource() {
        DataSource ds = new DataSource(); // 객체 생성
        ds.setDriverClassName("com.mysql.jdbc.Driver"); // jdbc 드라이버 클래스 지정, mysql 드라이버 클래스를 사용한다.
        ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8"); // jdbc url을 지정한다. 캐릭터셋을 UTF-8로 설정했으므로 지정행하낟.
        ds.setUsername("spring5");//db연결할때 사용할 사용자 계정과 암호 지정
        ds.setPassword("spring5");
        ds.setInitialSize(2);   // 최초에 생성할 커넥션 개수
        ds.setMaxActive(10); // 커넥션 풀에서 가져올 수 있는 커넥션 max개수
                            // maxWait() -> 모든 커넥션이 활성상태일때 다른 커넥션이 반환될 때까지 대기하는 시간, 대기 시간 내에 반환된 커넥션이 없으면 익센셥
        ds.setTestWhileIdle(true); // 유휴 커넥션 검사
        ds.setMinEvictableIdleTimeMillis(60000 * 3); // 최소 유휴 시간 3분
        ds.setTimeBetweenEvictionRunsMillis(10 * 1000); // 10초주기로 검사
        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() { // PlatformTransactionManager: 스프링이 제공하는 트랜잭션 매니저 인터페이스
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());
        return tm;
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }

    @Bean
    public MemberRegisterService memberRegSvc() {
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePwdSvc() {
        ChangePasswordService pwdSvc = new ChangePasswordService();
        pwdSvc.setMemberDao(memberDao());
        return pwdSvc;
    }

    @Bean
    public MemberPrinter memberPrinter()
    {
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter() {
        return new MemberListPrinter(memberDao(), memberPrinter());
    }

    @Bean
    public MemberInfoPrinter infoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setMemberDao(memberDao());
        infoPrinter.setPrinter(memberPrinter());
        return infoPrinter;
    }
}
