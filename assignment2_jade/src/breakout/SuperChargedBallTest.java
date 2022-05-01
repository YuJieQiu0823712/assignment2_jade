package breakout;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import breakout.basics.Circle;
import breakout.basics.Point;
import breakout.basics.Rect;
import breakout.basics.Vector;

class SuperChargedBallTest {

	@Test
	void test() {
		// ball
		Circle c1 = new Circle(new Point(2500,3000+350), 700); 
		Circle c2 = new Circle(new Point(7500,3000+350), 700); 
		Circle c3 = new Circle(new Point(12500,3000+350), 700); 
				
		Ball NormalBall1 = new NormalBall(c1, new Vector(4,-5));		
		Ball NormalBall2 = new NormalBall(c2, new Vector(4,-5));
		SuperChargedBall SuperChargedBall2 = new SuperChargedBall(c2, new Vector(4,5),0);		
		Ball NormalBall3 = new NormalBall(c3, new Vector(4,-5));

		// block
		Rect NormalBlockLoc = new Rect(new Point (0,0), new Point (5000,3000));
		Rect PowerupBlockLoc = new Rect(new Point (5000,0), new Point (10000,3000));
		Rect ReplicationBlockLoc = new Rect(new Point (10000,0), new Point (15000,3000));
		BlockState NormalBlock = new NormalBlock(NormalBlockLoc);
		BlockState PowerupBlock = new PowerupBlock(PowerupBlockLoc);
		BlockState ReplicationBlock = new ReplicationBlock(ReplicationBlockLoc);
				
		// paddle
		Point p1 = new Point(10000,10000);
		PaddleState NormalPaddle = new NormalPaddle(p1);
						
		assertEquals(NormalBall1, NormalBall1.collideBallBlocks(NormalBlock, NormalPaddle)); 
		assertEquals(SuperChargedBall2, NormalBall2.collideBallBlocks(PowerupBlock, NormalPaddle));
		assertEquals(NormalBall3, NormalBall3.collideBallBlocks(ReplicationBlock, NormalPaddle)); // red
		
				
		assertTrue(SuperChargedBall2.equals(SuperChargedBall2));
		assertEquals(NormalBall1,NormalBall1.returnNewBall(c1, new Vector(4,-5)));
		assertEquals(SuperChargedBall2.toString(),SuperChargedBall2.returnNewBall(c2, new Vector(4,5)).toString());
		
		assertEquals(new Color(255,102,0),NormalBall2.pointBall());
		assertEquals(new Color(255,255,0),SuperChargedBall2.pointBall());
		
		
	}

}
