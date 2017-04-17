package com.yztc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAop {
	
	@Test  //使用XML类配置AOP
	public void byXml(){
		ApplicationContext appContext = new ClassPathXmlApplicationContext("aop_xml.xml");
		com.yztc.aop.DoSomeThing dst = (com.yztc.aop.DoSomeThing) appContext.getBean("dst");
		dst.doThings();
		dst.doThings2();
	}
	
	@Test  //使用XML类配置AOP
	public void byAnnotation(){
		ApplicationContext appContext = new ClassPathXmlApplicationContext("aop_annotation.xml");
		com.yztc.aop.annotation.DoSomeThing dst = (com.yztc.aop.annotation.DoSomeThing) appContext.getBean("dst");
		dst.doThings();
		dst.doThings2();
	}
	
	@Test  //使用XML类配置AOP
	public void byPointCut(){
		ApplicationContext appContext = new ClassPathXmlApplicationContext("aop_annotation_pointcut.xml");
		com.yztc.aop.pointcut.DoSomeThing dst = (com.yztc.aop.pointcut.DoSomeThing) appContext.getBean("dst");
		dst.doThings();
		//dst.doThings2();
	}
}
