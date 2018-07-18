package reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionGuide {
	public static void main(String[] args) {
		try{
			Class cls = Class.forName("reflection.methodsTest");
			Method methodList[] = cls.getDeclaredMethods();
			Field fieldList[] = cls.getDeclaredFields();
			
			System.out.println("Class Name: " + methodList[0].getDeclaringClass());
			
			for(int i=0;i<methodList.length;i++)
				System.out.println("Method Name: " + methodList[i].getName());	

			for(int i=0;i<fieldList.length;i++)
				System.out.println("Fields Name: " + fieldList[i].getName());
			
		}catch (Throwable e){
			System.out.println("Error " + e.getMessage());
		}
	}
}