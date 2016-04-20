package com.itcast.zjw.drools.service.operator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.kie.api.runtime.KieSession;

import com.itcast.zjw.drools.domain.Person;
import com.itcast.zjw.drools.domain.Student;
import com.itcast.zjw.drools.util.KieServiceUtil;

/**
 * contains比较符的测试
 * @author Administrator
 *
 */
public class ContainsTest {
	@Test
	public void testContains(){
		Person person = new Person();
		Student student1 = new Student();
		student1.setSname("xuesheng1");
		Student student2 = new Student();
		student2.setSname("xuesheng2");
		List<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		person.setStudents(students);
		person.setAge(30);
		person.setName("person1");
		KieSession kieSession = KieServiceUtil.newKieSession("operatorSession");
		Student student3 = new Student();
		student3.setSname("xuesheng1");
		kieSession.insert(student1);
		//即使对象的内容相同也不行
		//kieSession.insert(student3);
		kieSession.insert(person);
		kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println("运行结束");
	}
	@Test
	public void testEquals(){
		Student student1 = new Student();
		student1.setSname("xuesheng1");
		Student student2 = new Student();
		student2.setSname("xuesheng1");
		System.out.println(student1.equals(student2));
		System.out.println(student1==student2);
	}
}
