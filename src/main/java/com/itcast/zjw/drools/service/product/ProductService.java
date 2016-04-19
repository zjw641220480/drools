package com.itcast.zjw.drools.service.product;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieSession;

import com.itcast.zjw.drools.domain.product.Order;
import com.itcast.zjw.drools.domain.product.Product;
import com.itcast.zjw.drools.util.KieServiceUtil;

public class ProductService {
	public static void main(String[] args) {
		KieSession kieSession = KieServiceUtil.newKieSession("product");
		Order order = new Order();
		List<Product> products = new ArrayList<Product>();
		//products.add(new Product("MP3", 120, 2));
		//products.add(new Product("MP4", 200));
		products.add(new Product("TCL电视", 3000));
		products.add(new Product("红米note2", 799, 5));
		System.out.println(799*5*0.9);
		order.setProducts(products);
		kieSession.insert(order);
		int count = kieSession.fireAllRules();
        System.out.println("总执行了"+count+"条规则");  
        System.out.println("实际需要支付：" + order.getPay());
		kieSession.dispose();
	}
}
