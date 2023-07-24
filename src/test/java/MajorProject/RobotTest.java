package MajorProject;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;



public class RobotTest {
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
    public void testRobotInputIsInvalidForNull() {
         
		java.lang.NullPointerException thrown = Assertions.assertThrows(java.lang.NullPointerException.class, new Executable() {
             
            @Override
            public void execute() throws Throwable {
                robotCode user = new robotCode();
                user.processCommand(null);
            }
        }, "cannot be null");
    	Assertions.assertEquals("cannot be null", thrown.getMessage());
    
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
    public void testRobotInputIsInvalidforEmpty() {
         
		java.lang.StringIndexOutOfBoundsException thrown = Assertions.assertThrows(java.lang.StringIndexOutOfBoundsException.class, new Executable() {
             
            @Override
            public void execute() throws Throwable {
            	robotCode user = new robotCode();
                user.processCommand("");
            }
        }, "String index out of range: 0");
    	Assertions.assertEquals("String index out of range: 0", thrown.getMessage());
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
    public void testMoveNorthIsValid() {
       	
		robotCode user = new robotCode();
       	user.processCommand("i10");
       	user.currentPositionX= 7;
       	user.currentPositionY= 7;
     	user.direction='N';
       	user.penDown=true;
           user.processCommand("m2");
           assertEquals(9, user.currentPositionY);

       }
	
	@Test
    public void testMoveNorthIsInvalid() {
       	
		robotCode user = new robotCode();
       	user.processCommand("i10");
       	user.currentPositionX= 7;
       	user.currentPositionY= 7;
       	user.direction='N';
       	user.penDown=true;
           user.processCommand("m7");
          assertEquals(true, user.invalidMove);

       }
	
	@Test
    public void testMoveSouthIsValid() {
       	
		robotCode user = new robotCode();
       	user.processCommand("i10");
       	user.currentPositionX= 7;
       	user.currentPositionY= 7;

       	user.direction='S';
       	user.penDown=true;
           user.processCommand("m2");
          assertEquals(5, user.currentPositionY);

       }
	
	@Test
    public void testMoveSouthIsInvalid() {
       	
		robotCode user = new robotCode();
       	user.processCommand("i10");
       	user.currentPositionX= 5;
       	user.currentPositionY= 5;
       	user.direction='S';
       	user.penDown=true;
           user.processCommand("m7");
          assertEquals(true, user.invalidMove);

       }
	
	@Test
    public void testMoveEastIsValid() {
       	
		robotCode user = new robotCode();
       	user.processCommand("i10");
       	user.currentPositionX= 7;
       	user.currentPositionY= 7;
       	user.direction='E';
       	user.penDown=true;
           user.processCommand("m2");
          assertEquals(9, user.currentPositionX);

       }
	
	@Test
    public void testMoveEastIsInvalid() {
       	
		robotCode user = new robotCode();
       	user.processCommand("i10");
       	user.currentPositionX= 5;
       	user.currentPositionY= 5;
       	user.direction='E';
       	user.penDown=true;
           user.processCommand("m7");
          assertEquals(true, user.invalidMove);
    }
	 @Test
	 public void testIfQuitWorks() {
	       	
			robotCode user = new robotCode();
			user.quitFlag=true;
			user.processCommand("q");
//	       	user.penDown=false;
//	       	user.processCommand("m 2");
	       	user.processCommand("i10");
	       	assertEquals(true,user.quitFlag);
            
	       	user.quitFlag=false;
	       	assertEquals(false,user.quitFlag);
	       	user.processCommand("i10");
	       }
	@Test
	    public void testMoveWest() {
	       	
			robotCode user = new robotCode();
	       	user.processCommand("i10");
	       	user.currentPositionX= 7;
	       	user.currentPositionY= 7;

	       	user.direction='E';
	       	user.penDown=true;
	           user.processCommand("m2");
	         assertEquals(9, user.currentPositionX);

	       }
		
		@Test
	    public void testMoveWestIsInvalid() {
	       	
			robotCode user = new robotCode();
	       	user.processCommand("i10");
	       	user.currentPositionX= 5;
	       	user.currentPositionY= 5;
	       	user.direction='W';
	       	user.penDown=true;
	           user.processCommand("m7");
	          assertEquals(true, user.invalidMove);

	       }
		
	  @Test
	  public void testMoveRight() {
	  	
		  robotCode user = new robotCode();
		  user.processCommand("i10");
		  user.direction='W';
		  user.processCommand("R");
	        assertEquals('N', user.direction);
	        user.processCommand("R");
	        assertEquals('E', user.direction);
	        user.processCommand("R");
	        assertEquals('S', user.direction);
	        user.processCommand("R");
	        assertEquals('W', user.direction);
	        user.direction='A';
	        user.processCommand("R");
		        assertNotEquals('S', user.direction);
	  }
	  @Test
	  public void testMoveLeft() {
	  	
		  robotCode user = new robotCode();
		  user.processCommand("i10");
		  user.direction='W';
		  user.processCommand("L");
	        assertEquals('S', user.direction);
	        user.processCommand("L");
	        assertEquals('E', user.direction);
	        user.processCommand("L");
	        assertEquals('N', user.direction);
	        user.processCommand("L");
	        assertEquals('W', user.direction);
	        user.direction='A';
	        user.processCommand("L");
		        assertNotEquals('S', user.direction);
	        
	  }

	  
	  @Test
	public void testInvalidMoveRight() {
		  robotCode user = new robotCode();
		  user.processCommand("i10");
		  user.direction='W';
		  user.rotateRight();
		
	    assertNotEquals("S", user.direction);
	    assertNotEquals("E", user.direction);
	    assertNotEquals("W", user.direction);
	    
	}
	  
	  @Test
	  public void testInvalidMoveLeft() {
	  	  robotCode user = new robotCode();
	  	  user.processCommand("i10");
	  	  user.direction='W';
	  	  user.rotateLeft();
	  	
	      assertNotEquals("N", user.direction);
	      assertNotEquals("E", user.direction);
	      assertNotEquals("W", user.direction);
	  }
	
@Test
    public void CheckRobotIsInitializedProperly() {
       	
		robotCode user = new robotCode();
       	user.processCommand("i10");
           user.processCommand("m2");

       	System.out.println(user.currentPositionX);
       	System.out.println(user.currentPositionY);

       	assertEquals(false, user.penDown);
       	assertEquals(0, user.currentPositionX);
       	assertEquals(0, user.currentPositionX);
       	assertEquals('N', user.direction);
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
	 public void ArrayOnlyChangeWhenPenIsDown() {
	       	
			robotCode user = new robotCode();
	       	user.processCommand("i 10");
	       	user.penDown=true;
	       	user.processCommand("m 2");
	       	
	       	assertEquals(1,user.floor[0][0]);
	          assertEquals(1,user.floor[1][0]);
	          assertEquals(1,user.floor[2][0]);
	       }

	 @Test
	 public void ArrayDoesNotChangeWhenPenIsUp() {
	       	
			robotCode user = new robotCode();
	       	user.processCommand("i 10");
	       	user.penDown=false;
	       	user.processCommand("m 2");
	       	
	       	assertEquals(0,user.floor[0][0]);
	          assertEquals(0,user.floor[1][0]);
	          assertEquals(0,user.floor[2][0]);
	       }
	@Test
	 public void RobotShowsCorrectCurrentDetails() {
	       	
			robotCode user = new robotCode();
	       	user.processCommand("i10");
	       	user.currentPositionX= 7;
	       	user.currentPositionY= 7;
	    	user.penDown= true;

	       	user.direction='N';
	       	user.penDown=true;
	           user.processCommand("m2");
	       	user.processCommand("c");

	       	
	           assertEquals("Current Position: [7, 9]\n"
	           		+ "Pen is down\n"
	           		+ "Facing N", user.printCheck);
	    
	       
	       

	       }
	
	@Test
	 public void RobotShowsCorrectFloor() {
	       	
			robotCode user = new robotCode();
	       	user.processCommand("i10");
	       	user.currentPositionX= 7;
	       	user.currentPositionY= 7;
	    	user.penDown= true;

	       	user.direction='N';
	       	user.penDown=true;
	           user.processCommand("m2");
	       	user.processCommand("p");

	       	
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
	    
	       
	       

	       }
       
  
}
