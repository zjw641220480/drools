package com.itcast.zjw.drools.service.function;

import org.junit.Test;

import com.itcast.zjw.drools.domain.Student;
import com.itcast.zjw.drools.util.KieServiceUtil;

public class TestFunction {
	@Test
	public void testFunction(){
		Student student = new Student();
		student.setSname("测试drools规则中的function");
		KieServiceUtil.runSessionFact(student, "functionSession");
	}
}
