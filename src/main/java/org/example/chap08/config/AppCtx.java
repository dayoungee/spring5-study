package org.example.chap08.config;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.example.chap08.spring.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
    @Bean(destroyMethod = "close") // 커넥션 풀에 보관된 connection을 닫는다.
    public DataSource dataSource() {
        DataSource ds = new DataSource(); // 객체 생성
        ds.setDriverClassName("com.mysql.jdbc.Driver"); // jdbc 드라이버 클래스 지정, mysql 드라이버 클래스를 사용한다.
        ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8"); // jdbc url을 지정한다. 캐릭터셋을 UTF-8로 설정했으므로 지정행하낟.
        ds.setUsername("spring5");//db연결할때 사용할 사용자 계정과 암호 지정
        ds.setPassword("spring5");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        return ds;
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }
}
