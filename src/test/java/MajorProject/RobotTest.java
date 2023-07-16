import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;



public class RobotTest {
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
