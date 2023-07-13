package MajorProject;

import java.util.Scanner;

public class Robot {
	boolean arrayInitailiazeddFlag=false;
	int floorSize;
	String penPosition="up";
	int robotPosition[]= {0,0};
	
	String robotDirection="N";
//	Scanner scan=new Scanner(System.in);
//	
//	int n=scan.nextInt();
//	int arrRoom[][];
	int[][]  arrRoom1=new int[1][1];
	
	public  void analyseInput(String input) {
//		if (input.charAt(0) != 'i') {
//            throw new IllegalArgumentException("Wrong Input");
//        }
		
		String firstInputCharacter= String.valueOf(input.charAt(0));
		if(firstInputCharacter.equalsIgnoreCase("i")) 
			initailizeArray(input);
		
			else if(firstInputCharacter.equalsIgnoreCase("r") && arrayInitailiazeddFlag==true) 
				changeDirection(input.toLowerCase());
		
				else if(firstInputCharacter.equalsIgnoreCase("l") && arrayInitailiazeddFlag==true) 
					changeDirection(input.toLowerCase());
		
				else if(firstInputCharacter.equalsIgnoreCase("u") && arrayInitailiazeddFlag==true) 
					changePenPosition(input.toLowerCase());
		
				else if(firstInputCharacter.equalsIgnoreCase("d") && arrayInitailiazeddFlag==true) 
					changePenPosition(input.toLowerCase());
		
				else if(firstInputCharacter.equalsIgnoreCase("m") && arrayInitailiazeddFlag==true) 
					moveRobot(input.toLowerCase());
		
				else if(firstInputCharacter.equalsIgnoreCase("p") && arrayInitailiazeddFlag==true) 
					printArray();
		
				else if(firstInputCharacter.equalsIgnoreCase("q")) {
					System.out.println("Program has ended");
					System.exit(1);
				}
					
		
				else if(firstInputCharacter.equalsIgnoreCase("c") && arrayInitailiazeddFlag==true) 
					printDetails();
		
				else
					System.out.println("Please Initialize the Array First");
					
		
	}

	public  void initailizeArray(String input) {
//		System.out.println("Inside initialize array");
		String tempcommand=input.substring(1).trim();
		int command= Integer.parseInt(tempcommand);
		floorSize=command;
//		System.out.println("Inside initialize array :: "+ tempcommand);

	     arrRoom1=new int[command][command];
	     
	     for(int i=0; i<arrRoom1.length; i++) {
	    	 for(int j=0; j<arrRoom1.length; j++) {
	    		 arrRoom1[i][j]=0;
	    	 }
	    	
	     }
	     
	     robotPosition[1]= 0;
	     robotPosition[0]= command-1;
	     arrayInitailiazeddFlag=true;
//	     arrRoom1[robotPosition[0]][robotPosition[1]]=1;
	 
	    
//	     System.out.println("x: "+ robotPosition[0]+"y: "+ robotPosition[1]);
//	     for(int i=0; i<arrRoom1.length; i++) {
//	    	 for(int j=0; j<arrRoom1.length; j++) {
//	    		 System.out.print(arrRoom1[i][j]);
//	    	 }
//	    	 System.out.println();
//	     }
	     
	}
	
	public void printArray() {
		for(int i=0; i<arrRoom1.length; i++) {
	    	 for(int j=0; j<arrRoom1.length; j++) {
	    		 if(arrRoom1[i][j]==0) {
	    			 System.out.print(" "); 
	    		 }
	    		 else {
	    			 System.out.print("*");
	    		 }
	    			
	    		
	    	 }
	    	 System.out.println();
	     }
	}
	
	public  void changeDirection(String input) {
		if (robotDirection.equals("N") && input.equals("r"))
			robotDirection = "E";
		else if (robotDirection.equals("N") && input.equals("l"))
			robotDirection = "W";
		else if (robotDirection.equals("S") && input.equals("r"))
			robotDirection = "W";
		else if (robotDirection.equals("S") && input.equals("l"))
			robotDirection = "E";
		else if (robotDirection.equals("E") && input.equals("r"))
			robotDirection = "S";
		else if (robotDirection.equals("E") && input.equals("l"))
			robotDirection = "N";
		else if (robotDirection.equals("W") && input.equals("r"))
			robotDirection = "N";
		else if (robotDirection.equals("W") && input.equals("l"))
			robotDirection = "S";
		
		
		
		
		
		System.out.println("Current Direction is: "+ robotDirection);
		
	     
	}
	
	public  void changePenPosition(String input) {
		if (input.equals("u"))
			penPosition="up";
		
		if (input.equals("d"))
			penPosition="down";
		
		System.out.println("Current Pen Direction is: "+ penPosition);
	}
	
	public int moveRobot(String input) {
		String tempcommand=input.substring(1).trim();
		int command= Integer.parseInt(tempcommand);
		
		if(robotDirection.equals("N")) {
			if(robotPosition[0]-command<0) {
				System.out.println("Current Input is Invalid as it goes Outside Floor Bounds, Please try again");
				return 0;
			}
		}
		else if(robotDirection.equals("E")) {
			if(robotPosition[1]+command>floorSize) {
				System.out.println("Current Input is Invalid as it goes Outside Floor Bounds, Please try again");
				return 0;
			}
		}
else if(robotDirection.equals("S")) {
	if(robotPosition[0]+command>floorSize) {
		System.out.println("Current Input is Invalid as it goes Outside Floor Bounds, Please try again");
		return 0;
	}	
		}
else if(robotDirection.equals("W")) {
	if(robotPosition[1]-command<0) {
		System.out.println("Current Input is Invalid as it goes Outside Floor Bounds, Please try again");
		return 0;
	}
}
//		try {
		if(penPosition.equals("up")) {

			if(robotDirection.equals("N")) {
				for(int i=0; i<command;i++) {
					robotPosition[0]=robotPosition[0]-1 ;
				    
				}
			}
			else if(robotDirection.equals("E")) {
				for(int i=0; i<command;i++) {
					robotPosition[1]=robotPosition[1]+1 ;
				    
				}
			}
	else if(robotDirection.equals("S")) {
		for(int i=0; i<command;i++) {
			robotPosition[0]=robotPosition[0]+1 ;
		    
		}
			}
	else if(robotDirection.equals("W")) {
		for(int i=0; i<command;i++) {
			robotPosition[1]=robotPosition[1]-1 ;
		    
		}
	}
			return 0;
		}
		
if(penPosition.equals("down")) {

	if(robotDirection.equals("N")) {
		for(int i=0; i<command;i++) {
			arrRoom1[robotPosition[0]][robotPosition[1]]=1;
			robotPosition[0]=robotPosition[0]-1 ;
		    
		}
	}
	else if(robotDirection.equals("E")) {
		for(int i=0; i<command;i++) {
			arrRoom1[robotPosition[0]][robotPosition[1]]=1;
			robotPosition[1]=robotPosition[1]+1 ;
		    
		}
	}
else if(robotDirection.equals("S")) {
for(int i=0; i<command;i++) {
	arrRoom1[robotPosition[0]][robotPosition[1]]=1;
	robotPosition[0]=robotPosition[0]+1 ;
    
}
	}
else if(robotDirection.equals("W")) {
for(int i=0; i<command;i++) {
	arrRoom1[robotPosition[0]][robotPosition[1]]=1;
	robotPosition[1]=robotPosition[1]-1 ;
    
}
}
}
		
//	}
//		catch(Exception e){
//			System.out.println("Array Out of bounds");
//			return(0);
//		}
		return 0;
	}
	
	public void printDetails() {
		System.out.println("Current Pen Position is :");
		System.out.println("X: "+ robotPosition[0]+ " Y: "+ robotPosition[1]);
		System.out.println("---------------------------------------------");
		System.out.println("Pen is :" + penPosition +" and it is facing "+ robotDirection);

	}
	
//	public  void temp() {
//		
//		 System.out.println(" inside temp");
//		 for(int i=0; i<arrRoom1.length; i++) {
//	    	 for(int j=0; j<arrRoom1.length; j++) {
//	    		 System.out.print(arrRoom1[i][j]);
//	    	 }
//	    	 System.out.println();
//	     }
//	}
	
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Please Enter the input");
		Robot robot1=new Robot();
		
		
		while(true) {
			String input=scan.nextLine();
			robot1.analyseInput(input);
		}
	
	}
	
	

}

