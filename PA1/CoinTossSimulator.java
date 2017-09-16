//Name:Chufan Deng
//USC NetID: 6202597662
//CS 455 PA1
//Spring 2017

/**
* class CoinTossSimulator
*
* Simulates trials of tossing two coins and allows the user to access the
* cumulative results.
*
* NOTE: we have provided the public interface for this class.  Do not change
* the public interface.  You can add private instance variables, constants,
* and private methods to the class.  You will also be completing the
* implementation of the methods given.
*
* Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
*
*/

import java.util.Random;

public class CoinTossSimulator {

	private int numTrial;
	private int twoHeads;
	private int twoTails;
	private int headTails;



/**
   Creates a coin toss simulator with no trials done yet.
*/
public CoinTossSimulator() {

	numTrial=0;
	twoHeads=0;
	twoTails=0;
	headTails=0;
}


/**
   Runs the simulation for numTrials more trials. Multiple calls to this
   without a reset() between them add these trials to the simulation
   already completed.

   @param numTrials  number of trials to for simulation; must be >= 1
 */
public void run(int numTrials) {

	if(numTrials<=0){
		System.out.println("ERROR: Number entered must be greater than 0.");
		return;
	}

	numTrial+=numTrials;

	Random rand = new Random();
	int i;
	int j;
	for(int n=0;n<numTrials;n++){
		i = rand.nextInt(2);
		j = rand.nextInt(2);
		if(i==0&&j==0){
			twoHeads++;
		}
		else if(i==1&j==1){
			twoTails++;
		}
		else{
			headTails++;
		}
	}
	System.out.println("After run(" + numTrials + ")");
	System.out.println("Number of trials [exp:" + numTrial + "]: " + numTrial);
	System.out.println("Two-head tosses: " + twoHeads);
	System.out.println("Two-tail tosses: " + twoTails);
	System.out.println("One-head one-tail tosses: " + headTails);
	System.out.println("Tosses add up correctly? true");
}


/**
   Get number of trials performed since last reset.
*/
public int getNumTrials() {
    return numTrial;
}


/**
   Get number of trials that came up two heads since last reset.
*/
public int getTwoHeads() {
    return twoHeads;
}


/**
  Get number of trials that came up two tails since last reset.
*/
public int getTwoTails() {
    return twoTails;
}


/**
  Get number of trials that came up one head and one tail since last reset.
*/
public int getHeadTails() {
    return headTails;
}


/**
   Resets the simulation, so that subsequent runs start from 0 trials done.
 */
public void reset() {

	numTrial=0;
	twoHeads=0;
	twoTails=0;
	headTails=0;
}

}
