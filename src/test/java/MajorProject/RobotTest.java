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
  
}
