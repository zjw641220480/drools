package com.itcast.zjw.drools.domain.product;

public class Product {
	private String name;  
    private Integer count = 1; //数量  
    private double price; //价格  
    private double discount = 1;    //折扣  
    public Product(String name, double price)  
    {  
        this.name = name;  
        this.price = price;  
    }
    public Product(String name, double price, Integer count)  
    {  
        this.name = name;  
        this.price = price;  
        this.count = count;  
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getPay()  
    {  
        return price * count * discount;  
    }
	public String toString()  
    {  
        return "[name="+name+",price="+price+",count="+count+",discount="+discount+",getPay()="+getPay()+"]";  
    } 
}
