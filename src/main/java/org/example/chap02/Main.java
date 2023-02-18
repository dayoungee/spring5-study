package org.example.chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // AnnotationConfigApplicationContext 클래스는 자바 설정에서 정보를 읽어와 빈 객체를 생성하고 관리한다.
        // AnnotationConfigApplicationContext 객체를 생성할 떄, 작성한 AppContext를 생성자 파라미터로 전달한다.
        // AnnotationConfigApplicationContext 는 AppContext에 정의한 @Bean 설정 정보를 읽어와 Greeter 객체를 생성하고 초기화한다.
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppContext.class) ;
        // getBean 메서드는 AnnotationConfigApplicationContext가 자바 설정을 읽어와 생성한 빈 객체를 검색할 때 사용된다.
        // getBean 메서드의 첫번째 파라미터는 @Bean 애노테이션의 메서드 이름인 빈 객체의 이름이며, 두번째 인자는 검색할 빈 객체의 타입이다.
        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        Greeter g2 = ctx.getBean("greeter2", Greeter.class);
        String msg = g1.greet("스프링");
        System.out.println(msg) ;
        System.out.println(g1 == g2);
        ctx.close();
    }
}
