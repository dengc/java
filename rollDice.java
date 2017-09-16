import java.util.Random;

public class rollDice {

	public static void main(String[] args) {

		int [ ] [ ] scores = new int [ 156 ] [ 2 ] ;
		for(int i = 0; i<52;i++){
			scores [i][0]=0;
			scores [i][1]=0;
		}
		for(int i = 52; i<104;i++){
			scores [i][0]=0;
			scores [i][1]=1;
		}
		for(int i = 104; i<156;i++){
			scores [i][0]=1;
			scores [i][1]=1;
		}

		int count =0;
		int countAtOne =0;
		for(int n=0;n<30000;n++){
			Random rand = new Random();

			int i = rand.nextInt(156);
			int j = rand.nextInt(2);
			int num = scores[i][j];
			int numBack=-1;
			if(num ==1){
				count ++;
				if(j == 0){
					numBack = scores[i][1];
				}
				else{
					numBack = scores[i][0];
				}
				//System.out.println(numBack);
			}
			if(numBack == 1){
				countAtOne ++;
			}

		}
		double prob = (double) countAtOne/count;
		System.out.println("Total count: "+count);
		System.out.println("Total count of (1,1): "+countAtOne);
		System.out.println("The probability of (1,1) is ");
		System.out.printf("%.2f", prob);
	}

}
