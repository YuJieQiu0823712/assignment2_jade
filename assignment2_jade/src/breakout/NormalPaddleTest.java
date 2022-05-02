package breakout;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import breakout.basics.Circle;
import breakout.basics.Point;
import breakout.basics.Vector;

class NormalPaddleTest {

	@Test
	void test() {
		Point p1 = new Point(10000,10000);
		PaddleState myPaddleState = new NormalPaddle(p1);
		
		Circle c1 = new Circle(new Point(2000, 2000), 700);
		Ball ball1 = new NormalBall(c1, new Vector(4, 5));	

		assertEquals(myPaddleState, myPaddleState.changePaddle(myPaddleState, ball1));
		assertEquals(0,myPaddleState.getReplicateTimes());
		
		assertTrue(myPaddleState.equals(myPaddleState));
		assertEquals(myPaddleState,myPaddleState.returnNewPaddle(p1));
		
		assertEquals(myPaddleState.toString(),"(10000,10000)");
		
	}

}
