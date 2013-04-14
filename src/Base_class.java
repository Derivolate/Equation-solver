import java.util.Scanner;

public class Base_class {
	
	
	static int varleft = 0;
	static int varright = 0;

	static int numleft = 0;
	static int numright = 0;
	
	static Boolean isLeft;
	
	static Scanner scanner1 = new Scanner(System.in);
	
	public static void main(String args[]){
		int location = 0;
		
		String left = Side(true);
		String right = Side(false);
		
		scanner1.close();
		left.replace("\\s", "");
		right.replace("\\s", "");
		System.out.println(left +" = "+ right);
		isLeft = true;
		varleft = countVar(left);
		isLeft = false;
		varright = countVar(right);
		isLeft = true;
		numleft = countNum(left);
		isLeft = false;
		numright = countNum(right);
		Solve();
	}
	/*
	 * Asks for left or right side of equation
	 * and saves keyboard input in string left or right.
	 */
	public static String Side(Boolean Left){
		if (Left == true){
			System.out.println("Linkerlid: ");
			return scanner1.nextLine();
		}else{
			System.out.println("Rechterlid: ");
			return scanner1.nextLine();
		}
	}
	
	/*
	 * Solves the left side of the equation
	 */

	public static Integer countVar(String currentSide){
		Integer tempVar = 0;
		Integer location = 0;
		do {
			boolean Final = Final(location, currentSide);
			location = location(currentSide, location, Final);
			
			if (currentSide.charAt(Final == false? location -1 : location) == 'x') {
				tempVar = tempVar + Character.getNumericValue(currentSide.charAt(location - (Final == false? 2 : 1)));
			}
			location ++;
		
		} while (location < currentSide.length());
		System.out.println((isLeft == true? "varleft = " : "varright = ") + tempVar);
		return tempVar;
	}
	public static Integer countNum(String currentSide){
		Integer tempNum = 0;
		Integer location = 0;
		
		do{
			boolean Final = Final(location, currentSide);
			location = location(currentSide, location, Final);
			
			if (currentSide.charAt(Final == false? location -1 : location) != 'x') {
				tempNum = tempNum + Character.getNumericValue(currentSide.charAt(location - (Final == false? 1 : 0)));
			}
			location ++;
		}while(location < currentSide.length());
		System.out.println((isLeft == true? "numleft = " : "numright = ") + tempNum);
		return tempNum;
	}
	public static Boolean Final(Integer location, String currentSide){
		return (currentSide.indexOf('+', location) != -1? false : true);
	}
	public static Integer location(String currentSide, int location, Boolean Final){
		if (Final != true){
			return currentSide.indexOf('+', location);
		}else{
			return currentSide.length() - 1;
		}
	}
	
	public static void Solve(){
		double varfinal = 0;
		double numfinal = 0;
		if (varleft >= varright){
			varfinal = varleft - varright;
			System.out.println("varfinal=" + varfinal);
		}else{
			varfinal = varright - varleft;
			System.out.println("varfinal=" + varfinal);
		}
		if (numleft >= numright){
			numfinal = numleft - numright;
			System.out.println("numfinal=" + numfinal);
		}else{
			numfinal = numright - numleft;
			System.out.println("numfinal=" + numfinal);
		}
		numfinal = numfinal/varfinal;
		System.out.println("x="+ numfinal);
	}
}
