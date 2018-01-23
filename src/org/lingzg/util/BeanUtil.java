package org.lingzg.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtil {

	public static Object getfieldValue(Object bean, String fieldName){
		try {
			String methodName = "get"+StringUtil.toUpperCaseFirstOne(fieldName);
			Method get = bean.getClass().getDeclaredMethod(methodName);
			return get.invoke(bean);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException("Error Field : "+fieldName);
		}
	}
	
	public static void setfieldValue(Object bean, String fieldName, Object value){
		try {
			String getMethodName = "get" + StringUtil.toUpperCaseFirstOne(fieldName);
			String setMethodName = "s" + getMethodName.substring(1);
			Class<?> beanClass = bean.getClass();
			Method getMethod = beanClass.getDeclaredMethod(getMethodName);
			Class<?> returnType = getMethod.getReturnType();
			Method setMethod = beanClass.getDeclaredMethod(setMethodName, returnType);
			setMethod.invoke(bean, value);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException("Error Field : "+fieldName);
		}
	}
	
	public static String column2field(Class<?> clazz, String columnName){
		try {
			Method method = clazz.getMethod("column2field",String.class);
			return (String) method.invoke(null, columnName);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException("Error MethodName : column2field");
		}
	}
}
