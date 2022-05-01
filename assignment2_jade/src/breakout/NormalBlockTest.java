package breakout;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import breakout.basics.Circle;
import breakout.basics.Point;
import breakout.basics.Rect;
import breakout.basics.Vector;

class NormalBlockTest {

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
						
		
		
		assertEquals(null,NormalBlock.returnNewBlock(NormalBlockLoc));
		assertFalse(NormalBlock.reflect());
		assertFalse(NormalBlock.charged());
		assertTrue(NormalBlock.equals(NormalBlock));
		assertTrue(NormalBlock.getLocation().equals(NormalBlock.getLocation()));
		
				
						
		
	}

}
