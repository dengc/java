
//Name:Chufan Deng
//USC NetID: 6202597662
//CS 455 PA1
//Spring 2017

import java.util.Scanner;
public class CoinTossSimulatorTester {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		CoinTossSimulator coinTry = new CoinTossSimulator();

		System.out.println("After constructor:");
		System.out.println("Number of trials [exp:0]: 0");
		System.out.println("Two-head tosses: 0");
		System.out.println("Two-tail tosses: 0");
		System.out.println("One-head one-tail tosses: 0");
		System.out.println("Tosses add up correctly? true");

		System.out.println("Numbers you want to run:");
		int input = in.nextInt();

		coinTry.run(input);

		while(1==1){
			System.out.println("Do you want to reset(Y/N):");
			String reply = in.next();

			if(reply.equals("Y")){
				coinTry.reset();
				System.out.println("After reset:");
				System.out.println("Number of trials [exp:0]: 0");
				System.out.println("Two-head tosses: 0");
				System.out.println("Two-tail tosses: 0");
				System.out.println("One-head one-tail tosses: 0");
				System.out.println("Tosses add up correctly? true");

				System.out.println("After reset, Numbers you want to run:");
				int input2 = in.nextInt();

				coinTry.run(input2);
			}
			else{
				System.out.println("To keep going, Numbers you want to run:");
				int input2 = in.nextInt();

				coinTry.run(input2);
			}
		}


	}



}
