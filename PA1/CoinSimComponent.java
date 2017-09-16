
//Name:Chufan Deng
//USC NetID: 6202597662
//CS 455 PA1
//Spring 2017

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JComponent;

import java.util.Scanner;
public class CoinSimComponent extends JComponent{

	CoinTossSimulator coinTry = new CoinTossSimulator();
	Scanner in = new Scanner(System.in);


	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		if(coinTry.getNumTrials()==0){
			System.out.println("Numbers you want to run:");
			int input = in.nextInt();

			coinTry.run(input);
		}


		int x = getWidth();
		int y = getHeight();

		int numTrials = coinTry.getNumTrials();
		int twoHeads = coinTry.getTwoHeads();
		int twoTails = coinTry.getTwoTails();
		int headTails = coinTry.getHeadTails();

		int twoHeads_percent = Math.round(twoHeads * 100/numTrials);
		int headTails_percent = Math.round(headTails * 100/numTrials);
		int twoTails_percent = 100-twoHeads_percent-headTails_percent;

		String label1 = "Two Head: " + twoHeads +" ("+ twoHeads_percent +"%)";
		String label2 = "A Head and a Tall: " + headTails +" ("+ headTails_percent +"%)";
		String label3 = "Two Tails: " + twoTails +" ("+ twoTails_percent +"%)";

		double scale = (y-100)/100.0;
		//System.out.println(scale);
		int height1 = (int) (scale*twoHeads_percent);
		int height2 = (int) (scale*headTails_percent);
		int height3 = (int) (scale*twoTails_percent);

		Bar bar1 = new Bar(y-height1-50,(x-3*50)/4,50,twoHeads_percent,scale,Color.red,label1);

		Bar bar2 = new Bar(y-height2-50,(x-3*50)/2+50,50,headTails_percent,scale,Color.green,label2);

		Bar bar3 = new Bar(y-height3-50,x-(x-3*50)/4-50,50,twoTails_percent,scale,Color.blue,label3);


		bar1.draw(g2);
		bar2.draw(g2);
		bar3.draw(g2);

	}

}
