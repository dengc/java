
//Name:Chufan Deng
//USC NetID: 6202597662
//CS 455 PA1
//Spring 2017

import javax.swing.JFrame;
public class CoinSimViewer {

	public static void main(String[] args) {

		JFrame frame = new JFrame();

		frame.setSize(1200, 700);
		frame.setTitle("CoinSim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CoinSimComponent component = new CoinSimComponent();
		frame.add(component);

		frame.setVisible(true);

	}

}
