package com.itcast.zjw.drools.util;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class KieServiceUtil {
	private static KieContainer kieContainer = null;
	static{
		KieServices kieServices = KieServices.Factory.get();
		kieContainer = kieServices.getKieClasspathContainer(ClassLoader.getSystemClassLoader());
	}
	public static KieSession newKieSession(String sessionName){
		return kieContainer.newKieSession(sessionName);
	}
	public static void runSessionFact(Object obj,String sessionName){
		KieSession kieSession = kieContainer.newKieSession(sessionName);
		kieSession.insert(obj);
		kieSession.fireAllRules();
		kieSession.dispose();
	}
}
