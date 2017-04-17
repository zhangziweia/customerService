package com.yztc.aop.pointcut;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Repository;

//此通知类就是做DoSomeThing的切面处理类
@Repository("advices")
@Aspect
public class Advices {
	//切入点
	@Pointcut("execution(* com.yztc.aop.pointcut.DoSomeThing.doThings(..))")
	public void pointCut(){
	}
	
	//前置
	@Before("pointCut()")
	public void before(JoinPoint jp){
        System.out.println("----------搞事情之前----------");
    }
	
	//最终通知
    @After("pointCut()")
    public void after(JoinPoint jp){
        System.out.println("----------搞事情之后----------");
    }
    
    //环绕
    @Around("execution(* com.yztc.aop.pointcut.DoSomeThing.doThings(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
    	System.out.println(pjp.getSignature().getName());
        System.out.println("----------环绕前置----------");
        Object result=pjp.proceed();  //调用实际的方法
        System.out.println("----------环绕后置----------");
        return result;
    }
    
    //返回结果通知
    @AfterReturning(pointcut="execution(* com.yztc.aop.pointcut.DoSomeThing.doThings(..))",returning="result")
    public void afterReturning(JoinPoint jp,Object result){
        System.out.println(jp.getSignature().getName());
        //System.out.println("结果是："+result);
        System.out.println("----------返回结果----------");
    }
    
    //异常后通知
    @AfterThrowing(pointcut="execution(* com.yztc.aop.pointcut.DoSomeThing.doThings(..))",throwing="exp")
    public void afterThrowing(JoinPoint jp,Exception exp){
        System.out.println(jp.getSignature().getName());
        System.out.println("异常消息："+exp.getMessage());
        System.out.println("----------异常通知----------");
    }
}
