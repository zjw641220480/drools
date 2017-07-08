package com.itcast.zjw.drools.service.operator;

import org.junit.Test;
import org.kie.api.runtime.KieSession;

import com.itcast.zjw.drools.domain.Student;
import com.itcast.zjw.drools.util.KieServiceUtil;

public class MatchesTest {
	@Test
	public void matchesTest(){
		Student student = new Student();
		student.setSname("李四");
		KieSession kieSession = KieServiceUtil.newKieSession("operatorSession");
		kieSession.insert(student);
		kieSession.fireAllRules();
		kieSession.dispose();
	}
}
