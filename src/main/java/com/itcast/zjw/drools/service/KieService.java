package com.itcast.zjw.drools.service;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.itcast.zjw.drools.domain.Person;
import com.itcast.zjw.drools.util.KieServiceUtil;

public class KieService {
	public static void main(String[] args) {
		KieServices kieServices = KieServices.Factory.get();
		
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		kieContainer = kieServices.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("update");
		/*Person person = new Person();
		person.setAge(30);
		person.setName("zhangsan");*/
		List<Person> list = new ArrayList<Person>();
		for(int i=0;i<10;i++){
			Person person = new Person();
			person.setAge(30+i*10);
			person.setName("zhangsan");
			list.add(person);
			System.out.println(person.getAge()+"===========");
			kieSession.insert(person);
		}
		kieSession.fireAllRules();
		kieSession.dispose();
	}
	public static void testKieServiceUtil(){
		KieSession kieSession = KieServiceUtil.newKieSession("update");
		Person person = new Person();
		person.setAge(30);
		person.setName("zhangsan");
		kieSession.insert(person);
		kieSession.fireAllRules();
		kieSession.dispose();
	}
}
