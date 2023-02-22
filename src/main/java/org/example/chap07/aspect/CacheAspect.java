package org.example.chap07.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Order(2)
public class CacheAspect {
    private Map<Long, Object> cache = new HashMap<>();

    @Pointcut("execution(public * org.example.chap07.*.*(..) )")
    public void cacheTarget() {
    }

    //@Around("cacheTarget()")
    @Around("ExeTimeAspect.publicTarget()") // 같은 패키지에 있으므로 패키지를 포함한 풀네임을 쓸 필요가 없다.
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        Long num = (Long) joinPoint.getArgs()[0];
        if (cache.containsKey(num)) {
            System.out.printf("CacheAspect: Cache 에서 구함 [%d] \n", num);
            return cache.get(num);
        }
        Object result = joinPoint.proceed();
        cache.put(num, result);
        System.out.printf("CacheAspect: Cache에 추가 [%d] \n",num);
        return result;
    }
}
