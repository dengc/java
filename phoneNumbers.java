import java.io.*;
import java.util.Scanner;

public class phoneNumbers {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Chinese Mobile, press 1; US Mobile, press 2:");

		int n = sc.nextInt();

		switch(n){

		case 1:
			int [] num = new int[]{4,6,1,5,3};
			int [] index = new int[]{2,4,1,3,2,2,4,2,2,0,2};

			String mobNum = "";
			for (int i:index){

				mobNum+=num[i];
			}

			System.out.println(mobNum);
			break;

		case 2:
			int [] num2 = new int[]{5,2,4,1,0,8,7,9,6};
			int [] index2 = new int[]{6,8,0,2,3,5,1,4,0,7};

			String mobNum2 = "";
			for (int i:index2){

				mobNum2+=num2[i];
			}

			System.out.println(mobNum2);
			break;

		}

	}

}
