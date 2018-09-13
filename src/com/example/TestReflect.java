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
		
		//getMethods: �����༰�丸������й�������
		Method[] methods = sunObjectClass.getMethods();
		for(Method m : methods){
			System.out.println( m.getName() );
		}
		
		System.out.println("-------------------");
		//���ݷ��������ƺͲ������ͣ� ��ȡ�÷���
		Method method = sunObjectClass.getMethod("setAge", int.class);
		System.out.println(method.getName());
		for( Class clz : method.getParameterTypes() ){
			System.out.println( "�����Ĳ����� " + clz.getName() );
		}
		System.out.println("-------------------");
		//���з���
		Object so = sunObjectClass.newInstance();
		method.invoke(so, 1);
		System.out.println( "age = " + ((SunObject)so).getAge()  );
		
		System.out.println("-------------------");
		//�жϷ������δʣ�public , private , final , static, 
		int modifiers = method.getModifiers();
		System.out.println( "isPublic : " + Modifier.isPublic(modifiers));
		System.out.println( "isPrivate : " + Modifier.isPrivate(modifiers));
		System.out.println( "isFinal : " + Modifier.isFinal(modifiers));
		System.out.println( "isStatic : " + Modifier.isStatic(modifiers));
		
		System.out.println("-------------------");
		//��ȡ��İ���Ϣ
		Package apackage = sunObjectClass.getPackage();
		System.out.println(apackage.getName());
		
		System.out.println("-------------------");
		//��ȡ����Class����
		Class superClass = sunObjectClass.getSuperclass();
		System.out.println( superClass.getName() );
		
		System.out.println("-------------------");
		
		System.out.println( "superclass isAbstract : " + Modifier.isAbstract( superClass.getModifiers() ));
		
		//��ȡ��ĳ�Ա����
		Field field = superClass.getDeclaredField("father");
		System.out.println(field.getName());
		
		System.out.println("-------------------");
		//��ȡ��Ľӿ���Ϣ
		Class[] classes = superClass.getInterfaces();
		System.out.println("�ӿڣ� " + classes[0].getName());
	}

}
