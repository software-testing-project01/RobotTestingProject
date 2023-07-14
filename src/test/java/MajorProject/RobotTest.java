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
        }, "Floor size cannot be zero or negative");
    	Assertions.assertEquals("Floor size cannot be zero", thrown.getMessage());
    }
	
	@Test
    public void testMoveNorth() {
       	
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