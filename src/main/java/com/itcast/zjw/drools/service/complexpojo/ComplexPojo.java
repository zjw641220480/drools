package com.itcast.zjw.drools.service.complexpojo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.itcast.zjw.drools.domain.Person;
import com.itcast.zjw.drools.domain.Student;

public class ComplexPojo {
	/**
	 * 高级规则,pojo套pojo和List在drools中如何应用
	 */
	@Test
	public void testComplexPojo() {
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("complexpojo");
		Person  person = new Person();
		person.setAge(40);
		person.setName("zhangsan");
		Student studenta = new Student("xuesheng1",10);
		Student studentb = new Student("xuesheng1",20);
		Student studentc = new Student("xuesheng1",30);
		Student studentd = new Student("xuesheng1",4);
		//person.setStudent(studenta);
		List<Student> students = new ArrayList<Student>();
		students.add(studentc);
		students.add(studentb);
		students.add(studenta);
		students.add(studentd);
		//两个满足规则的,那么规则会执行两次
		person.setStudents(students);
		kieSession.insert(person);
		/*kieSession.insert(studenta);
		kieSession.insert(studentd);*/
		//kieSession.insert(studenta);
		kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println("ComplexPojo.main(),end");
	}
}
