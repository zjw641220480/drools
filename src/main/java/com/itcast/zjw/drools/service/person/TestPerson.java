package com.itcast.zjw.drools.service.person;

import org.junit.Test;
import org.kie.api.runtime.KieSession;

import com.itcast.zjw.drools.domain.Person;
import com.itcast.zjw.drools.util.KieServiceUtil;

public class TestPerson {
	@Test
	public void testPerson(){
		//一个kieSession中包含有多个规则
		KieSession kieSession = KieServiceUtil.newKieSession("person");
		Person person = new Person();
		person.setAge(30);
		person.setName("zhangsan");
		kieSession.insert(person);
		kieSession.fireAllRules();
		System.out.println(person.getAge());
		kieSession.destroy();
	}
}
