package com.itcast.zjw.drools.service;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.itcast.zjw.drools.domain.Person;

public class KieService {
	public static void main(String[] args) {
		System.out.println("KieService.main()----");
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("update");
		Person person = new Person();
		person.setAge(30);
		person.setName("zhangsan");
		kieSession.insert(person);
		kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println("KieService.main()++++");
	}
}
