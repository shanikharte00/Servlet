package com.basic;

public class DynaObject {

	public static void main(String[] args) {
		
		Class c1=null, c2=null;
		Object oj1=null,oj2=null;
		
		try {
		//load the class dynamically at a runtime	
		c1=Class.forName(args[0]);
		c2=Class.forName(args[1]);
		//create the object
		oj1=c1.newInstance();
		oj2=c2.newInstance();
		//print those object
		System.out.println(oj1.toString()+" "+oj2.toString());
		System.out.println(oj1.hashCode()+""+oj2.hashCode());
		}
		catch(InstantiationException ie) {
			ie.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
