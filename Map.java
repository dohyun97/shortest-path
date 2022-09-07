
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
 READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
 the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Dohyun Kim
Student Number: 216030116
Course Section: A
*/

package Assignment1;
import java.util.*;

/**
 * 
 * @author EECS2030 Team
 *
 */

public class Map {
	boolean [][] map; 
	private int row;
	private int column;
	private  int c=0;
	private int rr;
	private int cc;
	private  String t="";
	private ArrayList<String> p=new ArrayList<String>();
	
	
	/**
	 * This is the constructor that constructs the city map, 
	 * which is a grid of row by column.
	 * @param row is the number of east-west streets of the city
	 * @param column is the number of north-south streets of the city
	 */
	public Map(int row, int column) {
		// Please implement the constructor
		this.row=row;
		this.column=column;
	}
	/**
	 * This method checks the correctness of the input parameters. If the preconditions are not met 
	 * an exception is thrown, otherwise depending to the direction, it calls 
	 * one of the four recursive functions of goSouthWest, goSouthEast, goNorthWest and goNorthEast.
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre the integer parameters should be in the range of the city grid.(i.e. [0, N) if N is the number of east-west streets and [0, M) if 
	 * M is the number of north-south streets.) 
	 * @exception IllegalArgumentException if any of the precondition did not meet.
	 */
	public String getPath (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow<0 || startCol<0 || destRow<0 ||destCol<0 || startRow>row || startCol>column ||destRow>row || destCol>column){
			throw new IllegalArgumentException();
		}
		else if(startRow >= destRow && startCol <= destCol) {
			return goSouthEast(startRow,startCol,destRow,destCol,path);
		}else if (startRow <= destRow && startCol <= destCol ) {
			return goNorthEast(startRow,startCol,destRow,destCol,path);
		}else if(startRow<=destRow && startCol>=destCol) {
			return goNorthWest(startRow,startCol,destRow,destCol,path);
		}else if(startRow>=destRow && startCol>=destCol) {
			return goSouthWest(startRow,startCol,destRow,destCol,path);
		} 
		 return getPath(startRow,startCol,destRow,destCol,path);
	}
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point.  
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol >= destCol </code>
	 */
	
	private String goSouthWest (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		 //you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow==destRow && startCol==destCol) {
			return path;
		  } else if(startRow-1>=destRow) {
			  startRow=startRow-1;		
			  path=path+ "("+startRow + ","+ startCol+ ") ";
				return goSouthWest(startRow,startCol,destRow,destCol,path);
		}else if(startCol-1>=destCol) {
			startCol=startCol-1;
			path=path+ "("+startRow + ","+ startCol+ ") ";
			return goSouthWest(startRow,startCol,destRow,destCol,path);
		}
		return path;	
		}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goSouthEast (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow==destRow && startCol==destCol) {
			return path;
		  } else if(startRow-1>=destRow) {
			  startRow=startRow-1;	
			  path=path+ "("+startRow + ","+ startCol+ ") ";
				return goSouthEast(startRow,startCol,destRow,destCol,path);
			
		}else if(startCol+1<=destCol) {
			startCol=startCol+1;
			path=path+ "("+startRow + ","+ startCol+ ") ";
			return goSouthEast(startRow,startCol,destRow,destCol,path);
		}
		return path;	
	}
	
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goNorthEast (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow==destRow && startCol==destCol) {
			return path;
		  } else if(startRow+1<=destRow) {
			  startRow=startRow+1;		
			  path=path+ "("+startRow + ","+ startCol+ ") ";
				return goNorthEast(startRow,startCol,destRow,destCol,path);
		}else if(startCol+1<=destCol) {
			startCol=startCol+1;
			path=path+ "("+startRow + ","+ startCol+ ") ";
			return goNorthEast(startRow,startCol,destRow,destCol,path);
		}
		return path;	
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and <code> startCol >= destCol </code>
	 */
	private String goNorthWest (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow==destRow && startCol==destCol) {
			return path;
		  } else if(startRow+1<=destRow) {
			  startRow=startRow+1;		
			  path=path+ "("+startRow + ","+ startCol+ ") ";
				return goNorthWest(startRow,startCol,destRow,destCol,path);
		}else if(startCol-1>=destCol) {
			startCol=startCol-1;
			path=path+ "("+startRow + ","+ startCol+ ") ";
			return goNorthWest(startRow,startCol,destRow,destCol,path);
		}
		return path;	
	}
	/**
	 * This method find a path from (startRow, startCol) to a border point of the city. 
	 * Please note that the starting point should be included in the path.
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @return is a path from (starting row, staring col) to a border point of the city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 */

	public String findPath (int startRow, int startCol) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
	
		String s="";		
		p.add(startRow+","+startCol);
		if(c==0) {	
		  if(startRow==0||startCol==0) {
			  return "("+startRow + ","+ startCol+ ") ";
		  }
		s="("+startRow + ","+ startCol+ ") ";	
		
		arr(startRow,startCol);
		}
		
		c++;
		int direction = (int)(Math.random() * 4)+1;
		
		if(direction ==1) {
			startRow=startRow+1;    
		}else if(direction==2) {
			startCol=startCol+1;
		}else if(direction==3) {
			startCol=startCol-1;
		}else if(direction==4) {
			startRow=startRow-1;
		}
		
		if(startRow==0 || startCol==0 || startRow==row || startCol==column) {
			 t=s+t+"("+startRow + ","+ startCol+ ") ";
			 return t;				
		}else if(p.contains(startRow+","+startCol)) {
			p.clear();
			c=0;t="";
			return findPath(rr,cc);
			
		}else if(!p.contains(startRow+","+startCol)){
			p.add(startRow +","+ startCol);			 
			 t=s+t+"("+startRow + ","+ startCol+ ") ";
			 return findPath(startRow,startCol);			 
		}
		return t;		
	}
   private void arr (int rr ,int cc) {				
		this.rr=rr;		
		this.cc=cc;		
	}
	
} // end of class
