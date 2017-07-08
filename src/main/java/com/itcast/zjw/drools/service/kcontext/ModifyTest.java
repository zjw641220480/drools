package com.itcast.zjw.drools.service.kcontext;

import org.junit.Test;

import com.itcast.zjw.drools.domain.Student;
import com.itcast.zjw.drools.util.KieServiceUtil;

public class ModifyTest {
	@Test
	public void testModify(){
		Student student = new Student();
		student.setSname("测试modify");
		KieServiceUtil.runSessionFact(student, "kcontextSession");
		System.out.println(student.getSage());
		System.out.println(student.getSname());
	}
}
