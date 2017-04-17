package com.yztc.aop.pointcut;

import org.springframework.stereotype.Repository;

//被代理的目标类
@Repository("dst")
public class DoSomeThing {

	public void doThings(){
		System.out.println("正在搞事情");
		int i = 1/0;
	}

	public void doThings2() {
		System.out.println("正在搞事情2");
	}
}
