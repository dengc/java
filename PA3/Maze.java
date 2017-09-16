//Name: Chufan Deng
//USC loginid:chufande
//CS 455 PA3
//Spring 2017

import java.util.LinkedList;


/**
Maze class

Stores information about a maze and can find a path through the maze
(if there is one).

Assumptions about structure of the maze, as given in mazeData, startLoc, and endLoc
(parameters to constructor), and the path:
-- no outer walls given in mazeData -- search assumes there is a virtual
   border around the maze (i.e., the maze path can't go outside of the maze
   boundaries)
-- start location for a path is maze coordinate startLoc
-- exit location is maze coordinate exitLoc
-- mazeData input is a 2D array of booleans, where true means there is a wall
   at that location, and false means there isn't (see public FREE / WALL
   constants below)
-- in mazeData the first index indicates the row. e.g., mazeData[row][col]
-- only travel in 4 compass directions (no diagonal paths)
-- can't travel through walls

*/

public class Maze {

	public static final boolean FREE = false;
	public static final boolean WALL = true;

	//REPRESENTATIONS
	private boolean[][] mazeData;
	private MazeCoord startLoc;
	private MazeCoord exitLoc;

	private boolean[][] visited;
	private LinkedList<MazeCoord> path;

	/**

	  REPRESENTATION INVARIANT:
	* startLoc shoule be inside the maze
	* endLoc should be inside the maze
	* visited points should be inside the maze
	*/

	/**
	   Constructs a maze.
	   @param mazeData the maze to search.  See general Maze comments above for what
	   goes in this array.
	   @param startLoc the location in maze to start the search (not necessarily on an edge)
	   @param exitLoc the "exit" location of the maze (not necessarily on an edge)
	   PRE: 0 <= startLoc.getRow() < mazeData.length and 0 <= startLoc.getCol() < mazeData[0].length
	      and 0 <= endLoc.getRow() < mazeData.length and 0 <= endLoc.getCol() < mazeData[0].length

	 */
	public Maze(boolean[][] mazeData, MazeCoord startLoc, MazeCoord exitLoc) {

		assert isValidMaze();

		this.mazeData = mazeData;
		this.startLoc = startLoc;
		this.exitLoc = exitLoc;

		visited = new boolean[mazeData.length][mazeData[0].length];

		for(int i=0;i<mazeData.length;i++){
			for(int j=0;j<mazeData[0].length;j++){
				visited[i][j]= false;
			}
		}

		path = new LinkedList<MazeCoord>();
	}


	/**
	   Returns the number of rows in the maze
	   @return number of rows
	*/
	public int numRows() {

	    return mazeData.length;
	}


	/**
	   Returns the number of columns in the maze
	   @return number of columns
	*/
	public int numCols() {

		return mazeData[0].length;
	}


	/**
	   Returns true iff there is a wall at this location
	   @param loc the location in maze coordinates
	   @return whether there is a wall here
	   PRE: 0 <= loc.getRow() < numRows() and 0 <= loc.getCol() < numCols()
	*/
	public boolean hasWallAt(MazeCoord loc) {

		assert loc.getRow()>=0 && loc.getRow() < numRows();
		assert loc.getCol()>=0 && loc.getCol() < numCols();

		return mazeData[loc.getRow()][loc.getCol()] == WALL;
	}


	/**
	   Returns the entry location of this maze.
	 */
	public MazeCoord getEntryLoc() {

		return startLoc;
	}


	/**
	  Returns the exit location of this maze.
	*/
	public MazeCoord getExitLoc() {

		return exitLoc;
	}


	/**
	   Returns the path through the maze. First element is start location, and
	   last element is exit location.  If there was not path, or if this is called
	   before a call to search, returns empty list.

	   @return the maze path
	 */
	public LinkedList<MazeCoord> getPath() {

		return path;
	}


	/**
	   Find a path from start location to the exit location (see Maze
	   constructor parameters, startLoc and exitLoc) if there is one.
	   Client can access the path found via getPath method.

	   @return whether a path was found.
	 */
	public boolean search()  {

		return searchCoord(startLoc);
	}


	//recursive check with mazecoord parameter
	public boolean searchCoord(MazeCoord loc){

		MazeCoord newCoord;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;

		//if it is a wall
		if(hasWallAt(loc)){
			return false;
		}
		//if visited
		else if(visited[loc.getRow()][loc.getCol()]){
			return false;
		}
		else if(loc.equals(exitLoc)){
			path.add(loc);
			return true;
		}
		else{
			visited[loc.getRow()][loc.getCol()] = true;
			if(loc.getRow()!=numRows()-1){
				newCoord = new MazeCoord(loc.getRow()+1, loc.getCol());
				flag1 = searchCoord(newCoord);
				if(flag1){
					path.add(loc);
				}
			}
			if(loc.getRow()!=0){
				newCoord = new MazeCoord(loc.getRow()-1, loc.getCol());
				flag2 = searchCoord(newCoord);
				if(flag2){
					path.add(loc);
				}
			}
			if(loc.getCol()!=numCols()-1){
				newCoord = new MazeCoord(loc.getRow(), loc.getCol()+1);
				flag3 = searchCoord(newCoord);
				if(flag3){
					path.add(loc);
				}
			}
			if(loc.getCol()!=0){
				newCoord = new MazeCoord(loc.getRow(), loc.getCol()-1);
				flag4 = searchCoord(newCoord);
				if(flag4){
					path.add(loc);
				}
			}
		}
		return flag1||flag2||flag3||flag4;
	}

	/**
       Returns true iff the maze data is in a valid state.
    */
    private boolean isValidMaze() {

		//startLoc is inside the maze
		if(startLoc.getRow()<0 || startLoc.getRow() >= mazeData.length){
			return false;
		}
		else if (startLoc.getCol()<0 || startLoc.getCol() >= mazeData[0].length) {
			return false;
		}

		//exitLoc is inside the maze
		if(exitLoc.getRow()<0 || exitLoc.getRow() >= mazeData.length){
			return false;
		}
		else if (exitLoc.getCol()<0 || exitLoc.getCol() >= mazeData[0].length) {
			return false;
		}

		return true;
    }
}
