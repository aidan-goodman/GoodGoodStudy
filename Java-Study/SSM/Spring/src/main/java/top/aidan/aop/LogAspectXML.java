package top.aidan.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by Aidan on 2021/8/17 14:35
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class LogAspectXML {
    /**
     * 前置通知
     */
    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法开始执行");
    }

    /**
     * 后置通知
     *
     * @param joinPoint 切入点
     */
    public void after(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法执行结束");
    }

    /**
     * 返回通知，可以在该方法中获取目标方法的返回值，如果目标方法的返回值为 void，则收到 null
     *
     * @param joinPoint 切入点
     * @param r         返回的参数名称，和这里方法的参数名一一对应
     */
    public void returning(JoinPoint joinPoint, Object r) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法返回值：" + r);
    }

    /**
     * 异常通知，当目标方法抛出异常时，该方法会被触发
     *
     * @param joinPoint 切入点
     * @param e         异常参数，和方法的参数名一一对应，注意异常的类型，
     */
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法异常通知：" + e.getMessage());
    }

    /**
     * 环绕通知，环绕通知是上面四种通知的集大成者，环绕通知的核心类似于在反射中执行方法
     *
     * @param pjp 执行切入点，控制在何时运行
     * @return 方法的返回值
     */
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //这个有点类似于 method.invoke 方法，我们可以在这个方法的前后分别添加日志，相当于前置/后置通知
        /*
        Object proceed = pjp.proceed();
        return proceed;
        */
        return pjp.proceed();
    }
}
