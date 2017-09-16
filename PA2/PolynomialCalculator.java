//Name: Chufan Deng
//USC loginid:6202597662
//CSCI 455 PA2
//Spring 2017

import java.util.*;
public class PolynomialCalculator {

	public static void main(String[] args) {

		Scanner in =new Scanner(System.in);

		ArrayList <Polynomial> polys = new ArrayList <Polynomial>();

		//create an array of 10 polynomials
		for(int i = 0; i < 10;i++){
			polys.add( new Polynomial());
		}

		String input = in.nextLine();
		Scanner newScan = new Scanner(input);

		while(newScan.hasNext()){

			//for what command
			String commandRun = newScan.next().toLowerCase();

			if(commandRun.equals("help")){
				System.out.println("You need to command(create, print, add, eval, or quit)");
				input = in.nextLine();
				newScan = new Scanner(input);
			}

			else if (commandRun.equals("quit")) {
				return;
			}

			//Create command
			else if(commandRun.equals("create")){

				if(newScan.hasNextInt() ){
					int create = newScan.nextInt();

					doCreate(polys,create);
				}
				else {
					System.out.println("ERROR: No index input");
				}

				input = in.nextLine();
				newScan = new Scanner(input);
			}

			//Print command
			else if (commandRun.equals("print")) {

				//Only 10 Polynomials in this arraylist
				if(newScan.hasNextInt()){
					int print = newScan.nextInt();

					doPrint(polys,print);
				}
				else{
					System.out.println("ERROR: No index input");
				}

				input = in.nextLine();
				newScan = new Scanner(input);
			}

			//Add command
			else if (commandRun.equals("add")) {

				//has numbers
				if(newScan.hasNextInt()){

					//the sum, first value
					int addSum = newScan.nextInt();
					if(newScan.hasNextInt()){

						//one index to be added, second value
						int add1 = newScan.nextInt();
						if(newScan.hasNextInt()){

							//the other index to be added, third value
							int add2 = newScan.nextInt();

							doAdd(polys,addSum, add1, add2);
						}
						else {
							System.out.println("ERROR: 3 indexes inputs");
						}
					}
					else {
						System.out.println("ERROR: 3 indexes inputs");
					}
				}
				else{
					System.out.println("ERROR: 3 indexes inputs");
				}

				input = in.nextLine();
				newScan = new Scanner(input);
			}

			//Eval command
			else if (commandRun.equals("eval")) {

				//Only 10 Polynomials in this arraylist
				if(newScan.hasNextInt()){
					int eval = newScan.nextInt();

					doEval(polys,eval);

				}
				else{
					System.out.println("ERROR: No index input");
				}

				input = in.nextLine();
				newScan = new Scanner(input);
			}

			//Error Message
			else{
				System.out.println("Illegal command.  Type 'help' for command options.");
				input = in.nextLine();
				newScan = new Scanner(input);
			}
		}


	}

	//Create Helper method
	public static void doCreate(ArrayList<Polynomial> polys, int createIndex){

		if(createIndex <10){
			System.out.println("Enter a space-separated sequence of coeff-power pairs terminated by <nl>");

			//create a new Polynomial
			Polynomial newP = new Polynomial();

			Scanner in =new Scanner(System.in);
			String inputIndex = in.nextLine();
			Scanner newCreate = new Scanner(inputIndex);

			while(newCreate.hasNextDouble()){

				double newCoeff = newCreate.nextDouble();
				if(newCreate.hasNextInt()){

					newP = newP.add(new Polynomial (new Term(newCoeff,Math.abs(newCreate.nextInt()))));
				}
			}

			polys.set(createIndex, newP);
		}
		else{
			System.out.println("ERROR: illegal index for a poly.  must be between 0 and 9, inclusive");
		}
	}

	//Print Helper method
	public static void doPrint(ArrayList<Polynomial> polys, int printIndex){

		if(printIndex < 10){
			System.out.println(polys.get(printIndex).toFormattedString());
		}
		else{
			System.out.println("ERROR: illegal index for a poly.  must be between 0 and 9, inclusive");
		}
	}

	//Add Helper method
	public static void doAdd(ArrayList<Polynomial> polys, int sum, int add1, int add2){

		if(sum >=10 || add1 >=10 || add2 >=10){
			System.out.println("ERROR: illegal index for a poly.  must be between 0 and 9, inclusive");
			return;
		}

		//Adding polys
		Polynomial p1 = polys.get(add1);
		Polynomial p2 = polys.get(add2);

		polys.set(sum, p1.add(p2));

	}

	//Eval Helper method
	public static void doEval(ArrayList<Polynomial> polys, int evalIndex){

		if(evalIndex<10){
			System.out.print("Enter a floating point value for x: ");

			// a new scanner for the x input
			Scanner scan = new Scanner(System.in);
			double x = scan.nextDouble();

			System.out.println(polys.get(evalIndex).eval(x));
		}
		else{
			System.out.println("ERROR: illegal index for a poly.  must be between 0 and 9, inclusive");
		}
	}

}
