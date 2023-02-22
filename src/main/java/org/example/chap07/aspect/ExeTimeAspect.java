package org.example.chap07.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
@Order(1)
public class ExeTimeAspect {

    // 공통 기능을 적용할 대상을 정한다.
    @Pointcut("execution(public * org.example.chap07.*.*(..) )")
    //private void publicTarget(){
    public void publicTarget(){ // 다른 클래스에 위치한 @Around 애노테이션에서 publicTarget 메서드의 Pointcut을 사용하고 싶다면 public으로
    }

    @Around("publicTarget()") //Around Advice 를 설정 한다. publicTarget() 메서드에 정의한 Pointcut에 공통 기능을 적용한다.
     public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
         long start = System.nanoTime();
         try {
             Object result = joinPoint.proceed();
             return result;
             } finally {
             long finish = System.nanoTime();
             Signature sig = joinPoint.getSignature();
             System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",
                     joinPoint.getTarget().getClass().getSimpleName(),
                     sig.getName(), Arrays.toString(joinPoint.getArgs()),
                     (finish - start));
             }
         }

}
