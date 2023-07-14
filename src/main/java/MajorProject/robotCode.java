package MajorProject;

import java.lang.*;

import java.util.Arrays;
import java.util.Scanner;

public class robotCode {
	public static int[][] floor;
    public static int dimension;
    public static int currentPositionX;
    public static int currentPositionY;
    public static boolean penDown;
    public static char direction;

    public static void main(String[] args) {
//        initializeSyst)em(10; // Initialize the system with a 10x10 floor

        // Sample commands for testing
//        processCommand("D");
//        processCommand("M 5");
//        processCommand("R");
//        processCommand("M 3");
//        processCommand("U");
//        processCommand("M 2");
//        processCommand("L");
//        processCommand("M 4");
//        processCommand("P");
//        processCommand("C");
//        processCommand("Q");
        
        Scanner scan=new Scanner(System.in);
//    	System.out.println("Please Enter the Floor Size");
		int dimension;
//		initializeSystem(dimension);
		robotCode robot1=new robotCode();
		
		
		while(true) {
			System.out.println("Enter Command: ");
			String input=scan.nextLine();
			robot1.processCommand(input);
    }
    }

    public static void processCommand(String command) {
        char cmd = Character.toUpperCase(command.charAt(0));
        String arg = command.substring(1).trim();
//        int arg=10;
        
        if (command.trim().length() == 0) {
            throw new IllegalArgumentException("cannot be blank Spaces only");
		}
        
        if (command.charAt(0) != 'i' && command.charAt(0) != 'I' && command.trim().length() != 0 && command.charAt(0) != 'u' && command.charAt(0) != 'U' && command.trim().length() != 0 && 
				command.charAt(0) != 'd' && command.charAt(0) != 'D' && command.trim().length() != 0 && command.charAt(0) != 'r' && command.charAt(0) != 'R' && command.trim().length() != 0 &&
				command.charAt(0) != 'l' && command.charAt(0) != 'L' && command.trim().length() != 0 && command.charAt(0) != 'm' && command.charAt(0) != 'M' && command.trim().length() != 0 &&
				command.charAt(0) != 'p' && command.charAt(0) != 'P' && command.trim().length() != 0 && command.charAt(0) != 'c' && command.charAt(0) != 'C' && command.trim().length() != 0 &&
				command.charAt(0) != 'q' && command.charAt(0) != 'Q'  && command.trim().length() != 0){
            throw new IllegalArgumentException("Invalid Input");
        }

        switch (cmd) {
           
            case 'D':
                penDown = true;
                break;
            case 'U':
                penDown = false;
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
                System.exit(0);
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

    private static void initializeSystem(int size) {
        dimension=size;
    	floor = new int[size][size];
        currentPositionX = 0;
        currentPositionY = 0;
        penDown = false;
        direction = 'N';
        
        if (size == 0) {
            throw new IllegalArgumentException("Floor size cannot be zero");
		}
    }

    private static void rotateRight() {
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

    private static void rotateLeft() {
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

    private static void move(int steps) {
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
        }
    }

    private static void drawLine(int newX, int newY) {
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
        System.out.println("Floor:");
        for (int i = dimension-1;i>=0;i-- ) {
        	System.out.print(i+" ");
            for (int j=0;j<dimension;j++) {
            	if(floor[i][j]==0) System.out.print("  ");
            	else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.print(" ");
        for(int i=0;i<dimension;i++) {
        	System.out.print(" "+i);
        }
        System.out.println();
    }

    private static void printCurrentPosition() {
        System.out.println("Current Position: [" + currentPositionX + ", " + currentPositionY + "]");
        System.out.println("Pen is " + (penDown ? "down" : "up"));
        System.out.println("Facing " + direction);
    }
}
