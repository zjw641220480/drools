package com.itcast.zjw.drools.service.attribute;

import org.junit.Test;

import com.itcast.zjw.drools.domain.Student;
import com.itcast.zjw.drools.util.KieServiceUtil;

public class ActivationGropTest {
	@Test
	public void activationGropTest(){
		//System.setProperty("drools.dateformat", "yyyy-MM-dd");
		Student student1 = new Student();
		student1.setSname("张三");
		Student student2 = new Student();
		student2.setSname("李四");
		KieServiceUtil.runSessionFact(student1, "attributeSession");
		KieServiceUtil.runSessionFact(student2, "attributeSession");
	}
}
