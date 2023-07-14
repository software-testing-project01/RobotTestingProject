package MajorProject;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

//import org.junit.Test;


public class RobotTest {
//	 @Test
//	    public void testRobotInputIsValidwithoutSpace() {
//	         
//	    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
//	             
//	            @Override
//	            public void execute() throws Throwable {
//	                Robot robot2 = new Robot();
//	                robot2.analyseInput("i4");
//	            }
//	        }, "Wrong Input");
//	    	Assertions.assertEquals("Wrong Input", thrown.getMessage());
//	    }
	 
//	 @Test
//	    public void testRobotInputIsInvalidforInvalidCommand() {
//	         
//	    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
//	             
//	            @Override
//	            public void execute() throws Throwable {
//	                Robot robot2 = new Robot();
//	                robot2.analyseInput("z4");
//	            }
//	        }, "Invalid Character Input");
//	    	Assertions.assertEquals("Invalid Character Input", thrown.getMessage());
//	    }
	
	@Test
    public void testRobotInputIsInvalidForBlankSpacesOnly() {
         
    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
             
            @Override
            public void execute() throws Throwable {
                robotCode user = new robotCode();
                user.processCommand("      ");
            }
        }, "cannot be blank Spaces only");
    	Assertions.assertEquals("cannot be blank Spaces only", thrown.getMessage());
    }
	
	@Test
    public void testRobotInputIsInvalidforInvalidCommand() {
         
    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
             
            @Override
            public void execute() throws Throwable {
            	robotCode user = new robotCode();
                user.processCommand("b6");
            }
        }, "Invalid Input");
    	Assertions.assertEquals("Invalid Input", thrown.getMessage());
    }
	
	@Test
    public void testNoNumberForInitializationAndMoveInput() {
         
    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
             
            @Override
            public void execute() throws Throwable {
            	robotCode user = new robotCode();
                user.processCommand("i   ");
            }
        }, "Invalid Input, please enter a number also");
    	Assertions.assertEquals("Invalid Input, please enter a number also", thrown.getMessage());
    }
	
	@Test
    public void testRobotforPenDown() {
         
		robotCode user = new robotCode();
		 user.processCommand("d");
		 assertEquals(true, user.penDown);
		 
    }
	
	
	
	@Test
    public void testRobotforPenUp() {
         
		robotCode user = new robotCode();
		 user.processCommand("u");
		 assertEquals(false, user.penDown);
		 
    }
	
	@Test
    public void testFloorNotInilizeWithZero() {
         
    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
             
            @Override
            public void execute() throws Throwable {
            	robotCode user = new robotCode();
                user.processCommand("i0");
            }
        }, "Floor cannoot be Zero");
    	Assertions.assertEquals("Floor cannoot be Zero", thrown.getMessage());
    }
	
	@Test
    public void RobottestMoveNorth() {
       	
		robotCode user = new robotCode();
       	user.processCommand("i10");
       	user.currentPositionX= 7;
       	user.currentPositionY= 7;
//        user.robotPosition[1]= 7;
       	user.direction='N';
       	user.penDown=true;
           user.processCommand("m2");
           //assertEquals("7", user.robotPosition[0]);
       	System.out.println(user.currentPositionX);
       	System.out.println(user.currentPositionY);
//       	System.out.println(user.robotPosition[1]);
       }
	
	@Test
    public void CheckRobotIsInitializedProperly() {
       	
		robotCode user = new robotCode();
       	user.processCommand("i10");
//       	user.currentPositionX= 7;
//       	user.currentPositionY= 7;
//        user.robotPosition[1]= 7;
//       	user.direction='N';
//       	user.penDown=true;
           user.processCommand("m2");
           //assertEquals("7", user.robotPosition[0]);
       	System.out.println(user.currentPositionX);
       	System.out.println(user.currentPositionY);
//       	System.out.println(user.robotPosition[1]);
       	assertEquals(false, user.penDown);
       	assertEquals(0, user.currentPositionX);
       	assertEquals(0, user.currentPositionX);
       	assertEquals('N', user.direction);
       }
	@Test
	 public void RobotShowsCorrectCurrentDetails() {
	       	
			robotCode user = new robotCode();
	       	user.processCommand("i10");
	       	user.currentPositionX= 7;
	       	user.currentPositionY= 7;
	    	user.penDown= true;
//	        user.robotPosition[1]= 7;
	       	user.direction='N';
	       	user.penDown=true;
	           user.processCommand("m2");
	       	user.processCommand("c");
//	          assertEquals(true,user.isPrinted);
	       	
	           assertEquals("Current Position: [7, 9]\n"
	           		+ "Pen is down\n"
	           		+ "Facing N", user.printCheck);
	    
	       
	       
	     //	System.out.println(user.processCommand("c"));
//	       	System.out.println(user.robotPosition[1]);
	       }
	
	@Test
	 public void RobotShowsCorrectFloor() {
	       	
			robotCode user = new robotCode();
	       	user.processCommand("i10");
	       	user.currentPositionX= 7;
	       	user.currentPositionY= 7;
	    	user.penDown= true;
//	        user.robotPosition[1]= 7;
	       	user.direction='N';
	       	user.penDown=true;
	           user.processCommand("m2");
	       	user.processCommand("p");
//	          assertEquals(true,user.isPrinted);
	       	
	           assertEquals("Floor:\n"
	           		+ "9               *     \n"
	           		+ "8               *     \n"
	           		+ "7               *     \n"
	           		+ "6                     \n"
	           		+ "5                     \n"
	           		+ "4                     \n"
	           		+ "3                     \n"
	           		+ "2                     \n"
	           		+ "1                     \n"
	           		+ "0                     \n"
	           		+ "  0 1 2 3 4 5 6 7 8 9\n", user.printFloorCheck);
	    
	       
	       
	     //	System.out.println(user.processCommand("c"));
//	       	System.out.println(user.robotPosition[1]);
	       }
	
	 @Test
	 public void ArrayOnlyChangeWhenPenIsDown() {
	       	
			robotCode user = new robotCode();
	       	user.processCommand("i 10");
	       	user.penDown=true;
	       	user.processCommand("m 2");
	       	
	       	assertEquals(1,user.floor[0][0]);
	          assertEquals(1,user.floor[1][0]);
	          assertEquals(1,user.floor[2][0]);
	       }
//	 
//	 @Test
//	    public void testRobotforQuit() {
//	         
//			robotCode user = new robotCode();
//			 user.processCommand("q");
//			 assertEquals(true, user.quitFlag);
//			 
//	    }
    

	
//	   public void testFloorNotInilizeWithNegativeNumber() {
//	         
//	    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
//	             
//	            @Override
//	            public void execute() throws Throwable {
//	                Robot user = new Robot();
//	                user.initailizeArray("i -2");
//	            }
//	        }, "Floor size cannot be Negative");
//	    	Assertions.assertEquals("Floor size cannot be Negative", thrown.getMessage());
//	    }
	
	
	

}





//import org.junit.Test;



//
// 
//public class TestUserException {
//
// 
//    @Test
//    public void testUsernameIsNull() {
//         
//    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
//             
//            @Override
//            public void execute() throws Throwable {
//                User user = new User();
//                user.setName(null);
//            }
//        }, "Username cannot be blank");
//    	Assertions.assertEquals("Username cannot be blank", thrown.getMessage());
//    }
//    
//    
//    @Test
//    public void testUsernameTooShort() {
//        Throwable exception = assertThrows(
//                IllegalArgumentException.class, () -> {
//                    User user = new User();
//                    user.setName("Jo");
//                }
//        );
//     
//        Assertions.assertEquals("Username is too short", exception.getMessage());     
//    }
//    
//    @Test
//    public void testUsernameTooLong() {
//        Throwable exception = assertThrows(
//                IllegalArgumentException.class, () -> {
//                    User user = new User();
//                    user.setName("Pablo Diego Jose Franciso Picasso");
//                }
//        );
//     
//        assertEquals("Username is too long", exception.getMessage());      
//    }
//    @Test
//    public void testBlankspaces() {
//        Throwable exception = assertThrows(
//                IllegalArgumentException.class, () -> {
//                    User user = new User();
//                    user.setName("     ");
//                }
//        );
//     
//        Assertions.assertEquals("Username is Blank Spaces Only", exception.getMessage());     
//    }
//    
//    @Test
//    public void testEmpty() {
//        Throwable exception = assertThrows(
//                IllegalArgumentException.class, () -> {
//                    User user = new User();
//                    user.setName("");
//                }
//        );
//     
//        Assertions.assertEquals("Username is Empty", exception.getMessage());     
//    }
//}