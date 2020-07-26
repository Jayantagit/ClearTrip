package com.ClearTrip.Tests;

public class Overload {
	
	int x;
	Double y;
	
	void add(int a,int b)
	{
		x=a+b;
	}
	
	void add(Double a,Double b)
	{
		y=a+b;
	}
	
	
	public Overload() {
		
		this.x = 0;
		this.y = 0.0;
	}



	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Overload obj=new Overload();
		int a=2;
		Double b=3.2;
		obj.add(a, a);
		obj.add(b, b);
		
		System.out.println(obj.x+"=="+obj.y);
		

	}

}
