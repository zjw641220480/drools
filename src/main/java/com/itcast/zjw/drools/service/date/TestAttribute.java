package com.itcast.zjw.drools.service.date;

import java.util.Date;

import org.junit.Test;

import com.itcast.zjw.drools.domain.Student;
import com.itcast.zjw.drools.util.KieServiceUtil;

public class TestAttribute {
	//一种规则引擎中只能有一种时间格式;下面一句话不能运行
	@Test
	public void testAttribute(){
		KieServiceUtil.runSessionFact(null, "dateSession");
	}
	@Test
	public void testAttributeDateEffectiveFormat(){
		System.setProperty("drools.dateformat", "yyyy-MM-dd");
		KieServiceUtil.runSessionFact(null, "dateSession");
	}
	@Test
	public void testStudentDate(){
		System.setProperty("drools.dateformat", "yyyy-MM-dd");
		Student student = new Student();
		student.setDate(new Date());
		student.setSname("比较时间");
		KieServiceUtil.runSessionFact(student, "dateSession");
	}
}
