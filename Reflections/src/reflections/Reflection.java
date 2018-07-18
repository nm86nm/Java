package reflections;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Reflection {
	public void simple() {
		Class numbers = Numbers.class;		
		Class numbers2 = Numbers2.class;
		//Constructor constructor = numbers.getConstructor(parameterTypes)ructor(new Class[] {String.class});
		Constructor[] constractors = numbers.getConstructors();		
		int modifiers = numbers.getModifiers();
		Package packageFor = numbers.getPackage();
		
		System.out.println("classFor.getSimpleName(): " + numbers.getSimpleName());	
		System.out.println("Modifier.isStatic(modifiers): " + Modifier.isStatic(modifiers));
		System.out.println("Modifier.isPublic(modifiers): " + Modifier.isPublic(modifiers));
		System.out.println("packageFor.getName(): " + packageFor.getName());
		System.out.println("classFor2.getSuperclass().getSimpleName(): " + numbers2.getSuperclass().getSimpleName());
		System.out.println("constractors[0]: " + constractors[0] + ", constractors[1]: "  + constractors[1]);
	}
	
	public void generics() throws NoSuchMethodException, SecurityException {
		Numbers numbers = new Numbers();
		Method method = Numbers.class.getMethod("getIntegerList", null);

		Type returnType = method.getGenericReturnType();

		if(returnType instanceof ParameterizedType){
		    ParameterizedType type = (ParameterizedType) returnType;
		    Type[] typeArguments = type.getActualTypeArguments();
		    for(Type typeArgument : typeArguments){
		        Class typeArgClass = (Class) typeArgument;
		        System.out.println("typeArgClass = " + typeArgClass);
		    }
		}
	}
	
	public void array() {
		int[] intArray = (int[]) Array.newInstance(int.class, 3);
		
		Array.set(intArray, 0, 123);
		Array.set(intArray, 1, 456);
		Array.set(intArray, 2, 789);
		
		for(int length = 0; length < intArray.length; length++) 
		System.out.println("Array.get(intArray," + length + ") = " + Array.get(intArray, length));		
	}
	
	public static void main(String[] args) {
		Reflection reflection = new Reflection();		
		
		/*try {
		reflection.generics();
		} catch(NoSuchMethodException | SecurityException e) {
			System.out.println("NoSuchMethodException | SecurityException" + e.getLocalizedMessage());
		}*/

		reflection.array();		
	}
}