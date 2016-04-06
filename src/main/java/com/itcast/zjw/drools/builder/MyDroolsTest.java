package com.itcast.zjw.drools.builder;

import java.util.Collection;
import java.util.Iterator;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.QueryResults;

import com.itcast.zjw.drools.domain.Classes;
import com.itcast.zjw.drools.domain.Person;

public class MyDroolsTest {
	public static void main(String[] args) {
		KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		knowledgeBuilder.add(ResourceFactory.newClassPathResource("/droolstest/testupdate/testupdate.drl", MyDroolsTest.class), ResourceType.DRL);
		if(knowledgeBuilder.hasErrors()){
			System.out.println("规则中存在错误,错误如下");
			KnowledgeBuilderErrors errors = knowledgeBuilder.getErrors();
			Iterator<KnowledgeBuilderError> iterator = errors.iterator();
			if(iterator.hasNext()){
				System.out.println(iterator.next());
			}
		}
		Collection<KnowledgePackage> knowledgePackage = knowledgeBuilder.getKnowledgePackages();
		
		//KnowledgeBase knowledgeBase = knowledgeBuilder.newKnowledgeBase();
		
		KnowledgeBaseConfiguration knowledgeBaseConfiguration = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();
		knowledgeBaseConfiguration.setProperty("org.drools.sequential", "true");
		KnowledgeBase knowledgeBase2 = KnowledgeBaseFactory.newKnowledgeBase(knowledgeBaseConfiguration);
		knowledgeBase2.addKnowledgePackages(knowledgePackage);
		StatefulKnowledgeSession statefulKnowledgeSession = knowledgeBase2.newStatefulKnowledgeSession();
		//全局对象设置不成功
		//statefulKnowledgeSession.setGlobal("globalTest", new Object());
		Person person = new Person();
		person.setAge(30);
		person.setName("zhangsan");
		/*Classes classes = new Classes();
		classes.setPerson(person);
		classes.setCname("一班");*/
		//不进行代码插入的时候,顺序来运行
		statefulKnowledgeSession.insert(person);
		statefulKnowledgeSession.fireAllRules();
		statefulKnowledgeSession.dispose();
		QueryResults queryResults = statefulKnowledgeSession.getQueryResults("query fact count");
		System.out.println("customet 对象数目\t"+queryResults.size());
		System.out.println("运行结束");
	}
}
