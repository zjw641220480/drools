package com.itcast.zjw.drools.service.fact;

import org.junit.Test;

import com.itcast.zjw.drools.domain.Student;
import com.itcast.zjw.drools.util.KieServiceUtil;

public class TestFact {
	@Test
	public void testFact(){
		KieServiceUtil.runSessionFact(null, "factSession");
	}
	@Test
	public void testStudentFact(){
		Student student = new Student();
		student.setSname("学生1");
		KieServiceUtil.runSessionFact(student, "factSession");
	}
}
