package com.itcast.zjw.drools.service.eval;

import org.junit.Test;
import org.kie.api.runtime.KieSession;

import com.itcast.zjw.drools.util.KieServiceUtil;

public class EvalTest {
	@Test
	public void evalTest(){
		KieSession kieSession = KieServiceUtil.newKieSession("evalSession");
		kieSession.fireAllRules();
		kieSession.dispose();
	}
}	
