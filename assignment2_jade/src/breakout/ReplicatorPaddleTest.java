package breakout;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import breakout.basics.Circle;
import breakout.basics.Point;
import breakout.basics.Vector;

class ReplicatorPaddleTest {

	@Test
	void test() {
		Point p1 = new Point(10000,10000);
		PaddleState myPaddleState = new ReplicatorPaddle(p1,3);
		Circle c1 = new Circle(new Point(2000, 2000), 700);
		Ball ball1 = new NormalBall(c1, new Vector(4, 5));
		
		assertEquals(myPaddleState.toString(), myPaddleState.changePaddle(myPaddleState, ball1).toString());
		assertEquals(3,myPaddleState.getReplicateTimes());
		assertTrue(myPaddleState.getCenter().equals(p1));
		assertEquals(myPaddleState,myPaddleState.returnNewPaddle(p1));
		assertEquals(new Color(102,0,153),myPaddleState.pointPaddle());
		assertTrue(myPaddleState.equals(myPaddleState));
		
		PaddleState myPaddleState2 = new ReplicatorPaddle(p1,2);
		assertEquals(new Color(255,0,255),myPaddleState2.pointPaddle());
		PaddleState myPaddleState1 = new ReplicatorPaddle(p1,1);
		assertEquals(new Color(221,160,221),myPaddleState1.pointPaddle());
		
	}

}