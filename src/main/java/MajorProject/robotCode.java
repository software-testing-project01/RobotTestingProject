package MajorProject;

import java.lang.*;

import java.util.Arrays;
import java.util.Scanner;

public class robotCode {
	public static boolean quitFlag=false;
	public static String printCheck;
	public static String printFloorCheck;
	public static int[][] floor;
    public static int dimension;
    public static int currentPositionX;
    public static int currentPositionY;
    public static boolean penDown;
    public static char direction;
    public static boolean isPrinted;
    public static boolean invalidMove;
    public static void main(String[] args) {
        
        Scanner scan=new Scanner(System.in);   
		int dimension;
		robotCode robot1=new robotCode();

		while(!quitFlag) {
			System.out.println("Enter Command: ");
			String input=scan.nextLine();
			robot1.processCommand(input);
    }
    }

    public static void processCommand(String command) {
    	if (command==null) {
            throw new java.lang.NullPointerException("cannot be null");
		}
        char cmd = Character.toUpperCase(command.charAt(0));
        String arg = command.substring(1).trim();
//        int arg=10;
        
        if (command.trim().length() == 0) {
            throw new IllegalArgumentException("cannot be blank Spaces only");
		}
        
        if (command.equals("")) {
            throw new java.lang.StringIndexOutOfBoundsException("Input cannot be empty");
		}
        
        
        
        if (command.charAt(0) != 'i' && command.charAt(0) != 'I' && command.trim().length() != 0 && command.charAt(0) != 'u' && command.charAt(0) != 'U' && command.trim().length() != 0 && 
				command.charAt(0) != 'd' && command.charAt(0) != 'D' && command.trim().length() != 0 && command.charAt(0) != 'r' && command.charAt(0) != 'R' && command.trim().length() != 0 &&
				command.charAt(0) != 'l' && command.charAt(0) != 'L' && command.trim().length() != 0 && command.charAt(0) != 'm' && command.charAt(0) != 'M' && command.trim().length() != 0 &&
				command.charAt(0) != 'p' && command.charAt(0) != 'P' && command.trim().length() != 0 && command.charAt(0) != 'c' && command.charAt(0) != 'C' && command.trim().length() != 0 &&
				command.charAt(0) != 'q' && command.charAt(0) != 'Q'  && command.trim().length() != 0){
            throw new IllegalArgumentException("Invalid Input");
        }
        
        if (command.charAt(0) == 'i' || command.charAt(0) == 'm') {
        	if(arg.length()==0) {
        		throw new IllegalArgumentException("Invalid Input, please enter a number also");
        	}
		}

        switch (cmd) {
           
            case 'D':
            	doPenDown();
               
                break;
            case 'U':
            	doPenUp();
                
                break;
            case 'R':
                rotateRight();
                break;
            case 'L':
                rotateLeft();
                break;
            case 'M':
                int steps = Integer.parseInt(arg);
                move(steps);
                break;
            case 'P':
                printFloor();
                break;
            case 'C':
                printCurrentPosition();
                break;
            case 'Q':
            	
            	quit();
               
                break;
            case 'I':
                int size = Integer.parseInt(arg);
                initializeSystem(size);
                break;
            default:
                System.out.println("Invalid command!");
                break;
        }
    }
    public static void doPenDown() {
    	
    	    penDown = true;
    }
    
    public static void doPenUp() {
    	
	    penDown = false;
}
    
    public static void quit() {
    	quitFlag=true;
    		
}

   
    public static void initializeSystem(int size) {
    	
    	 if (size == 0) {
             throw new IllegalArgumentException("Floor cannoot be Zero");
 		}
    	dimension=size;
    	floor = new int[size][size];
        currentPositionX = 0;
        currentPositionY = 0;
        penDown = false;
        direction = 'N';
        
        
    }

    public static void rotateRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }

    public static void rotateLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
        }
    }

    public static void move(int steps) {
        int newX = currentPositionX;
        int newY = currentPositionY;

        switch (direction) {
            case 'S':
                newY -= steps;
                break;
            case 'E':
                newX += steps;
                break;
            case 'N':
                newY += steps;
                break;
            case 'W':
                newX -= steps;
                break;
        }

        if (newX >= 0 && newX < floor.length && newY >= 0 && newY < floor.length) {
            if (penDown) {
                drawLine(newX, newY);
            }

            currentPositionX = newX;
            currentPositionY = newY;
        } else {
            System.out.println("Invalid move!");
            invalidMove=true;
        }
    }

    public static void drawLine(int newX, int newY) {
        if (currentPositionX == newX) {
            int start = Math.min(currentPositionY, newY);
            int end = Math.max(currentPositionY, newY);

            for (int i = start; i <= end; i++) {
                floor[i][currentPositionX] = 1;
            }
        } else if (currentPositionY == newY) {
            int start = Math.min(currentPositionX, newX);
            int end = Math.max(currentPositionX, newX);

            Arrays.fill(floor[currentPositionY], start, end + 1, 1);
        }
    }

    public static void printFloor() {
    	printFloorCheck="";
        System.out.println("Floor:");
        printFloorCheck+="Floor:\n";
        for (int i = dimension-1;i>=0;i-- ) {
        	System.out.print(i+" ");
        	printFloorCheck+=i+" ";
            for (int j=0;j<dimension;j++) {
              if(i==currentPositionY && j== currentPositionX && floor[i][j]==0) { System.out.print("R ");
            	
            	printFloorCheck+="R ";
            	}
                else if(floor[i][j]==0) { System.out.print("  ");
            	
            	printFloorCheck+="  ";
            	}
            	else { System.out.print("* ");
            	printFloorCheck+="* ";
            	}
            }
            System.out.println();
            printFloorCheck+="\n";
        }
        System.out.print(" ");
        printFloorCheck+=" ";
        for(int i=0;i<dimension;i++) {
        	System.out.print(" "+i);
        	printFloorCheck+=" "+i;
        }
        System.out.println();
        printFloorCheck+="\n";
    }

    public static void printCurrentPosition() {
    	printCheck="Current Position: [" + currentPositionX + ", " + currentPositionY + "]\n"+"Pen is " + (penDown ? "down" : "up")+"\n"+"Facing " + direction;
        System.out.println("Current Position: [" + currentPositionX + ", " + currentPositionY + "]");
        System.out.println("Pen is " + (penDown ? "down" : "up"));
        System.out.println("Facing " + direction);
        isPrinted=true;
    }
}
