package reflections;

import java.util.ArrayList;
import java.util.List;

public class Numbers{
	public Numbers() {
		System.out.println("This is a constructor Numbers()");
	}
	
	public Numbers(int a) {
		System.out.println("This is a constructor Numbers(int a) and argument a: " + a);
	}
	
	public static void getNumbers(){
		int[] a = {1,8,9,16,3,20};
		for(int b : a)
		System.out.print(b + ", ");
	}
	
	protected List<Integer> integerList = new ArrayList<Integer>();
	
	public List<Integer> getIntegerList(){
		return this.integerList;
	}
 	
	public static void main(String args[]) {
		Numbers numbersClass = new Numbers();
		numbersClass.getNumbers();
	}
}