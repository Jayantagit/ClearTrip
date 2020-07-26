package com.ClearTrip.Tests;

public class Test
{
	int a;
	int b;
	public Test(int i,int j)
	{ 
		a=i;
		b=j;		
	}
	
	public void meth(Test o)
	{
		o.a*=2;
		o.b/=2;
	}

}
