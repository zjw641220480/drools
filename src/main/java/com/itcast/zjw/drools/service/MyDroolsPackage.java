package com.itcast.zjw.drools.service;

import org.kie.api.runtime.KieSession;

import com.itcast.zjw.drools.domain.Person;
import com.itcast.zjw.drools.util.KieServiceUtil;

public class MyDroolsPackage {
	public static void main(String[] args) {
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
