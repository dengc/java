//Name: Chufan Deng
//USC loginid:chufande
//CS 455 PA3
//Spring 2017

import java.awt.Graphics;

import javax.swing.JComponent;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;

/**
MazeComponent class

A component that displays the maze and path through it if one has been found.
*/
public class MazeComponent extends JComponent
{

	private static final int START_X = 10; // top left of corner of maze in frame
	private static final int START_Y = 10;
	private static final int BOX_WIDTH = 20;  // width and height of one maze "location"
	private static final int BOX_HEIGHT = 20;
	private static final int INSET = 2;  // how much smaller on each side to make entry/exit inner box

	//private attributes
	private Maze maze;


	/**
	   Constructs the component.
	   @param maze   the maze to display
	*/
	public MazeComponent(Maze maze)
	{
	   this.maze = maze;
	}


	/**
	  Draws the current state of maze including the path through it if one has
	  been found.
	  @param g the graphics context
	*/
	public void paintComponent(Graphics g)
	{

		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;

		//fill the walls or free in the maze
		for(int row =0; row<maze.numRows(); row++){
			for(int col=0; col<maze.numCols(); col++){

				Rectangle mazeRec = new Rectangle(START_X + col*BOX_WIDTH, START_Y + row*BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);

				if(maze.hasWallAt(new MazeCoord(row, col))){
					g2.setColor(Color.BLACK);
				}
				else{
					g2.setColor(Color.WHITE);
				}

				g2.fill(mazeRec);
			}
		}

		//draw the start location square
		Rectangle startRec = new Rectangle(START_X + maze.getEntryLoc().getCol()*BOX_WIDTH + INSET, START_Y + maze.getEntryLoc().getRow()*BOX_HEIGHT + INSET, BOX_WIDTH - 2*INSET, BOX_HEIGHT - 2*INSET);
		g2.setColor(Color.YELLOW);
		g2.fill(startRec);

		//draw the exit location square
		Rectangle exitRec = new Rectangle(START_X + maze.getExitLoc().getCol()*BOX_WIDTH + INSET, START_Y + maze.getExitLoc().getRow()*BOX_HEIGHT + INSET, BOX_WIDTH - 2*INSET, BOX_HEIGHT - 2*INSET);
		g2.setColor(Color.GREEN);
		g2.fill(exitRec);

		//draw the maze border
		Rectangle mazeBorder = new Rectangle(START_X, START_Y, BOX_WIDTH * maze.numCols(), BOX_HEIGHT * maze.numRows());
		g2.setColor(Color.BLACK);
		g2.draw(mazeBorder);

		//draw the path
		if(maze.getPath().size()>0){
			for(int i=0;i<maze.getPath().size()-1;i++){
				g2.setColor(Color.BLUE);
				g2.drawLine(maze.getPath().get(i).getCol()*BOX_WIDTH +BOX_WIDTH/2+ START_X, maze.getPath().get(i).getRow()*BOX_HEIGHT +BOX_HEIGHT/2+ START_Y, maze.getPath().get(i+1).getCol()*BOX_WIDTH +BOX_WIDTH/2+ START_X, maze.getPath().get(i+1).getRow()*BOX_HEIGHT +BOX_HEIGHT/2+ START_Y);
			}
		}
	}

}
