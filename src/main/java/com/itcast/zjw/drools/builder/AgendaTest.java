package com.itcast.zjw.drools.builder;

import java.util.Iterator;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Test;

import com.itcast.zjw.drools.domain.Student;

public class AgendaTest {
	@Test
	public void testAgenda(){
		KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		knowledgeBuilder.add(ResourceFactory.newClassPathResource("/droolstest/attribute/agenda-grop.drl", MyDroolsTest.class), ResourceType.DRL);
		if(knowledgeBuilder.hasErrors()){
			System.out.println("规则中存在错误,错误如下");
			KnowledgeBuilderErrors errors = knowledgeBuilder.getErrors();
			Iterator<KnowledgeBuilderError> iterator = errors.iterator();
			if(iterator.hasNext()){
				System.out.println(iterator.next());
			}
		}
		KnowledgeBase knowledgeBase2 = KnowledgeBaseFactory.newKnowledgeBase();
		StatefulKnowledgeSession statefulKnowledgeSession = knowledgeBase2.newStatefulKnowledgeSession();
		Student student = new Student();
		student.setSname("李四");
		statefulKnowledgeSession.insert(student);
		//statefulKnowledgeSession.getAgenda().getAgendaGroup("002").setFocus();
		statefulKnowledgeSession.fireAllRules();
		statefulKnowledgeSession.dispose();
		System.out.println("AgendaTest.testAgenda()");
	}
}
