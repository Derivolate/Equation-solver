import java.util.Scanner;

public class Base_class {
	
	
	static int varleft = 0;
	static int varright = 0;

	static int numleft = 0;
	static int numright = 0;
	
	static Scanner scanner1 = new Scanner(System.in);
	
	public static void main(String args[]){
		int location = 0;
		
		String left = Side(true);
		String right = Side(false);
		scanner1.close();
		left.replace("\\s", "");
		right.replace("\\s", "");
		System.out.println(left +" = "+ right);
		countLeft(location, left);
		countRight(location, right);
		Solve();
	}
	/*
	 * Asks for left or right side of equation
	 * and saves keyboard input in string left or right.
	 */
	public static String Side(boolean Left){
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
	public static void countLeft(int location, String left){
		do {
			location = 0;
			boolean Final = false;
			if (left.indexOf('+', location) != -1){
				location = left.indexOf('+', location);
			}else{
				location = left.length();
				Final = true;
			}
//			int locadd = left.indexOf('+', location);
//			int locsub = left.indexOf('-', location);
//			
//			if (locadd < locsub && locadd != -1)location = locadd;
//			else if (locsub < locadd && locsub != -1)location = locsub;
//			else location = left.length();
			
			if (left.charAt(location - 1) == 'x') {
				varleft = varleft + Character.getNumericValue(left.charAt(location - (Final == false? 2 : 1)));
//				try{
//					if (left.charAt(location -3) == '-')varleft = varleft - Character.getNumericValue(left.charAt(location - 2));
//					else varleft = varleft + Character.getNumericValue(left.charAt(location - 2));
//					}catch(java.lang.StringIndexOutOfBoundsException e){
//						varleft = varleft + Character.getNumericValue(left.charAt(location - 2));
//					}
			}else{
				numleft = numleft + Character.getNumericValue(left.charAt(location - (Final == false? 1 : 0)));
//				try{
//					
//					if (left.charAt(location -2) == '-')numleft = numleft - Character.getNumericValue(left.charAt(location - 1));
//					else numleft = numleft + Character.getNumericValue(left.charAt(location - 1));
//					}catch (java.lang.StringIndexOutOfBoundsException e){
//						numleft = numleft + Character.getNumericValue(left.charAt(location - 1));
//					}
				}
			location ++;
		
		} while (location < left.length());
		System.out.println("numleft=" + numleft);
		System.out.println("xleft=" + varleft);
	}
	/*
	 * Counts the right side of the equation
	 */
	public static void countRight(int location, String right){
		
		do {
			boolean Final = false;
			location = 0;
			if (right.indexOf('+', location) != -1){
				location = right.indexOf('+', location);
			}else{
				location = right.length();
				Final = true;
			}
//			int locadd = right.indexOf('+', location);
//			int locsub = right.indexOf('-', location);
//			
//			if (locadd < locsub && locadd != -1)location = locadd;
//			else if (locadd > locsub && locsub != -1)location = locsub;
//			else location = right.length();
			
			if (right.charAt(location - 1) == 'x') {
				varright = varright + Character.getNumericValue(right.charAt(location - (Final == false? 2 : 1)));
//				try{
//					if (right.charAt(location -3) == '-')varright = varright - Character.getNumericValue(right.charAt(location - 2));
//					else varright = varright + Character.getNumericValue(right.charAt(location - 2));
//					}catch(java.lang.StringIndexOutOfBoundsException e){
//						varright = varright + Character.getNumericValue(right.charAt(location - 2));
//					}
			}else{
				numright = numright + Character.getNumericValue(right.charAt(location - (Final == false? 1 : 0)));
//				try{
//					
//					if (right.charAt(location -2) == '-')numright = numright - Character.getNumericValue(right.charAt(location - 1));
//					else numright = numright + Character.getNumericValue(right.charAt(location - 1));
//					}catch (java.lang.StringIndexOutOfBoundsException e){
//						numright = numright + Character.getNumericValue(right.charAt(location - 1));
//					}
				}
			location ++;
		} while (location < right.length());
		
		System.out.println("numright=" + numright);
		System.out.println("xright=" + varright);
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
