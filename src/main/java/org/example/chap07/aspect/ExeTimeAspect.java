package org.example.chap07.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class ExeTimeAspect {

    // 공통 기능을 적용할 대상을 정한다.
    @Pointcut("execution(public * org.example.chap07.*.*(..) )")
    private void publicTarget(){
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
