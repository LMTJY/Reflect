package com.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestReflect {

	public static void main(String[] args) throws Exception {
		Class sunObjectClass = Class.forName("com.example.SunObject");
		String fullName = sunObjectClass.getName();
		String simpleName = sunObjectClass.getSimpleName();
		System.out.println(fullName);
		System.out.println(simpleName);
		System.out.println(sunObjectClass.getCanonicalName());
		System.out.println("-------------------");
		
		//getMethods: 返回类及其父类的所有公共方法
		Method[] methods = sunObjectClass.getMethods();
		for(Method m : methods){
			System.out.println( m.getName() );
		}
		
		System.out.println("-------------------");
		//根据方法的名称和参数类型， 获取该方法
		Method method = sunObjectClass.getMethod("setAge", int.class);
		System.out.println(method.getName());
		for( Class clz : method.getParameterTypes() ){
			System.out.println( "方法的参数： " + clz.getName() );
		}
		System.out.println("-------------------");
		//调研方法
		Object so = sunObjectClass.newInstance();
		method.invoke(so, 1);
		System.out.println( "age = " + ((SunObject)so).getAge()  );
		
		System.out.println("-------------------");
		//判断方法修饰词，public , private , final , static, 
		int modifiers = method.getModifiers();
		System.out.println( "isPublic : " + Modifier.isPublic(modifiers));
		System.out.println( "isPrivate : " + Modifier.isPrivate(modifiers));
		System.out.println( "isFinal : " + Modifier.isFinal(modifiers));
		System.out.println( "isStatic : " + Modifier.isStatic(modifiers));
		
		System.out.println("-------------------");
		//获取类的包信息
		Package apackage = sunObjectClass.getPackage();
		System.out.println(apackage.getName());
		
		System.out.println("-------------------");
		//获取父类Class对象
		Class superClass = sunObjectClass.getSuperclass();
		System.out.println( superClass.getName() );
		
		System.out.println("-------------------");
		
		System.out.println( "superclass isAbstract : " + Modifier.isAbstract( superClass.getModifiers() ));
		
		//获取类的成员变量
		Field field = superClass.getDeclaredField("father");
		System.out.println(field.getName());
		
		System.out.println("-------------------");
		//获取类的接口信息
		Class[] classes = superClass.getInterfaces();
		System.out.println("接口： " + classes[0].getName());
	}

}
