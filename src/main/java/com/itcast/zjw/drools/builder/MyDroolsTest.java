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

import com.itcast.zjw.drools.domain.Person;

/**
 * 涉及到的类主要有:KnowledgeBuilder,KnowledgeBase,StatefulKnowledgeSession
 * @author Administrator
 *
 */
public class MyDroolsTest {
	public static void main(String[] args) {
		//第一步产生KnowledgeBuilder
		KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		//第二步使用KnowledgeBuilder来加载规则文件
		knowledgeBuilder.add(ResourceFactory.newClassPathResource("/droolstest/eval/eval.drl", MyDroolsTest.class), ResourceType.DRL);
		if(knowledgeBuilder.hasErrors()){
			System.out.println("规则中存在错误,错误如下");
			KnowledgeBuilderErrors errors = knowledgeBuilder.getErrors();
			Iterator<KnowledgeBuilderError> iterator = errors.iterator();
			if(iterator.hasNext()){
				System.out.println(iterator.next());
			}
		}
		//第三步:根据KnowledgeBuilder来获取规则文件包
		Collection<KnowledgePackage> knowledgePackage = knowledgeBuilder.getKnowledgePackages();
		//第四步:根据knowledgeBuilder来生成KnowledgeBase,这个时候没有了全局配置文件,但是同样的不需要自己再手动的添加规则包
		KnowledgeBase knowledgeBase1 = knowledgeBuilder.newKnowledgeBase();
		
		KnowledgeBaseConfiguration knowledgeBaseConfiguration = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();
		knowledgeBaseConfiguration.setProperty("org.drools.sequential", "true");
		
		KnowledgeBase knowledgeBase2 = KnowledgeBaseFactory.newKnowledgeBase(knowledgeBaseConfiguration);
		
		knowledgeBase2.addKnowledgePackages(knowledgePackage);
		//第五步:由KnowledgeBase来得到StatefulKnowledgeSession
		StatefulKnowledgeSession statefulKnowledgeSession = knowledgeBase2.newStatefulKnowledgeSession();
		//全局对象设置不成功
		//statefulKnowledgeSession.setGlobal("globalTest", new Object());
		/*Person person = new Person();
		person.setAge(30);
		person.setName("zhangsan");*/
		/*Classes classes = new Classes();
		classes.setPerson(person);
		classes.setCname("一班");*/
		//不进行代码插入的时候,顺序来运行
		/*List<Person> list = new ArrayList<Person>();
		for(int i=0;i<3;i++){
			Person person = new Person();
			person.setAge(30+i*10);
			person.setName("zhangsan");
			list.add(person);
		}
		for(Person p:list){
			System.out.println(p.getAge()+"===========");
			statefulKnowledgeSession.insert(p);
			statefulKnowledgeSession.fireAllRules();
		}*/
		Person person1 = new Person();
		person1.setAge(30);
		person1.setName("zhangsan");
		statefulKnowledgeSession.insert(person1);
		//statefulKnowledgeSession.fireAllRules();
		Person person2 = new Person();
		person2.setAge(30);
		person2.setName("lisi");
		statefulKnowledgeSession.insert(person2);
		statefulKnowledgeSession.fireAllRules();
		statefulKnowledgeSession.dispose();
		QueryResults queryResults = statefulKnowledgeSession.getQueryResults("query fact count");
		System.out.println("customet 对象数目\t"+queryResults.size());
		System.out.println("运行结束");
	}
}
