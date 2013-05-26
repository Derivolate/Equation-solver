import java.util.Scanner;

/**
 * @author Bastiaan
 *
 */
public class Base_class {
	
	static int varleft;
	static int varright;
	static int numleft;
	static int numright;
	static Boolean isLeft;
	static Scanner scanner1 = new Scanner(System.in);
	static String Equation;
	public static void main(String args[]){
		Integer Loop = 1;
		do{
			varleft = varright = numleft = numright = 0;
			Equation = GetEquation();
			String[] temp = Equation.split("=");
			System.out.println(temp[1] + "\t" + temp[2]);
//			String left = Side(true);
//			String right = Side(false);
//			left.replace("\\s", "");
//			right.replace("\\s", "");
//			System.out.println(left + " = " + right);
//			isLeft = true;
//			varleft = countVar(left);
//			isLeft = false;
//			varright = countVar(right);
//			isLeft = true;
//			numleft = countNum(left);
//			isLeft = false;
//			numright = countNum(right);
//			Solve();
		}while(Loop != 0);
	}
	public static String GetEquation() {
		System.out.println("Equation: ");
		return scanner1.nextLine();
		
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
	 *Counts the x's in the side (currentside = left || right)
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
	
	/*
	 *Counts the plain numbers in the side (currentside = left || right)
	 */
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
	/*
	 * Gets the current location (the whole string of one side[left || right],
	 *		the previous location, if there is any '+' left)
	 */
	public static Integer location(String currentSide, int location, Boolean Final){
		if (Final != true){
			return currentSide.indexOf('+', location);
		}else{
			return currentSide.length() - 1;
		}
	}
	
	/*
	 * Small function to determine if the location is at the end of the string
	 */
	public static boolean Final(Integer location, String currentSide){
		return (currentSide.indexOf('+', location) != -1? false : true);
	}
	/*
	 * Final method to solve the equation
	 */
	public static void Solve(
){
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
