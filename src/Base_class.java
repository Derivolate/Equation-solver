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
		
		count(location, left);
		count(location, right);
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

	public static void count(int location, String currentSide){
		do {
			boolean Final;
			location = 0;
			if (currentSide.indexOf('+', location) != -1){
				location = currentSide.indexOf('+', location);
				Final = false;
			}else{
				location = currentSide.length() - 1;
				Final = true;
			}
//			int locadd = left.indexOf('+', location);
//			int locsub = left.indexOf('-', location);
//			
//			if (locadd < locsub && locadd != -1)location = locadd;
//			else if (locsub < locadd && locsub != -1)location = locsub;
//			else location = left.length();
			
			if (currentSide.charAt(Final == false? location -1 : location) == 'x') {
				varleft = varleft + Character.getNumericValue(currentSide.charAt(location - (Final == false? 2 : 1)));
//				try{
//					if (left.charAt(location -3) == '-')varleft = varleft - Character.getNumericValue(left.charAt(location - 2));
//					else varleft = varleft + Character.getNumericValue(left.charAt(location - 2));
//					}catch(java.lang.StringIndexOutOfBoundsException e){
//						varleft = varleft + Character.getNumericValue(left.charAt(location - 2));
//					}
			}else{
				numleft = numleft + Character.getNumericValue(currentSide.charAt(location - (Final == false? 1 : 0)));
//				try{
//					
//					if (left.charAt(location -2) == '-')numleft = numleft - Character.getNumericValue(left.charAt(location - 1));
//					else numleft = numleft + Character.getNumericValue(left.charAt(location - 1));
//					}catch (java.lang.StringIndexOutOfBoundsException e){
//						numleft = numleft + Character.getNumericValue(left.charAt(location - 1));
//					}
				}
			location ++;
		
		} while (location < currentSide.length());
		System.out.println("numleft=" + numleft);
		System.out.println("xleft=" + varleft);
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
