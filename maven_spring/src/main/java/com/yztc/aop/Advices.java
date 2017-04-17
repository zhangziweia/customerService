package com.yztc.aop;

import org.aspectj.lang.JoinPoint;

//此通知类就是做DoSomeThing的切面处理类
public class Advices {
	
	public void before(JoinPoint jp){
        System.out.println("----------搞事情之前----------");
        //得到切入点的签名的名字
        System.out.println(jp.getSignature().getName());
    }
    
    public void after(JoinPoint jp){
        System.out.println("----------搞事情之后----------");
    }
    
}
