package breakout;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import breakout.basics.Circle;
import breakout.basics.Point;
import breakout.basics.Rect;
import breakout.basics.Vector;

class SturdyBlockTest {

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
		Rect SturdyBlockLoc = new Rect(new Point (15000,0), new Point (20000,3000));
		
		BlockState NormalBlock = new NormalBlock(NormalBlockLoc);
		BlockState PowerupBlock = new PowerupBlock(PowerupBlockLoc);
		BlockState ReplicationBlock = new ReplicationBlock(ReplicationBlockLoc);
		SturdyBlock SturdyBlock3 = new SturdyBlock(SturdyBlockLoc,3);
		SturdyBlock SturdyBlock2 = new SturdyBlock(SturdyBlockLoc,2);
		SturdyBlock SturdyBlock1 = new SturdyBlock(SturdyBlockLoc,1);
		
				
		// paddle
		Point p1 = new Point(10000,10000);
		PaddleState NormalPaddle = new NormalPaddle(p1);
						
		
		assertEquals(SturdyBlock2,SturdyBlock3.returnNewBlock(SturdyBlockLoc));
		assertEquals(SturdyBlock1,SturdyBlock2.returnNewBlock(SturdyBlockLoc));
		assertEquals(null,SturdyBlock1.returnNewBlock(SturdyBlockLoc));
		
		assertEquals(3,SturdyBlock3.getHitTimes());
		
		assertTrue(SturdyBlock3.reflect());
		assertTrue(SturdyBlock2.reflect());
		assertFalse(SturdyBlock1.reflect());
		
		assertFalse(SturdyBlock3.charged());
		
		assertTrue(SturdyBlock3.equals(SturdyBlock3));
		assertTrue(SturdyBlock3.getLocation().equals(SturdyBlock3.getLocation()));
		assertEquals(SturdyBlock3.toString(),SturdyBlock3.returnNewBlock(SturdyBlockLoc).toString());
			
		assertEquals(new Color(0,0,255),NormalBlock.pointBlock());
		assertEquals(new Color(153,153,153),SturdyBlock3.pointBlock());		
		assertEquals(new Color(102,102,102),SturdyBlock2.pointBlock());	
		assertEquals(new Color(51,51,51),SturdyBlock1.pointBlock());	
	}

}
