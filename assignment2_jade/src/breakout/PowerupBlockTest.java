package breakout;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import breakout.basics.Circle;
import breakout.basics.Point;
import breakout.basics.Rect;
import breakout.basics.Vector;

class PowerupBlockTest {

	@Test
	void test() {
		
		// ball
		Circle c1 = new Circle(new Point(2500-4,3000+350+5), 700); 
		Circle c2 = new Circle(new Point(7500-4,3000+350+5), 700); 
		Circle c3 = new Circle(new Point(12500-4,3000+350+5), 700); 
		Circle c1N = new Circle(new Point(2500,3000+350), 700); 
		Circle c2N = new Circle(new Point(7500,3000+350), 700); 
		Circle c3N = new Circle(new Point(12500,3000+350), 700);
				
		Ball NormalBall1 = new NormalBall(c1, new Vector(4,-5));
		Ball NewNormalBall1 = new NormalBall(c1N, new Vector(4,5));
				
		Ball NormalBall2 = new NormalBall(c2, new Vector(4,-5));
		SuperChargedBall NewSuperChargedBall2 = new SuperChargedBall(c2N, new Vector(4,5),0);
				
		Ball NormalBall3 = new NormalBall(c3, new Vector(4,-5));
		Ball NewNormalBall3 = new NormalBall(c3N, new Vector(4,5));
				
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
						
		
		assertEquals(null,PowerupBlock.returnNewBlock(PowerupBlockLoc));
		assertFalse(PowerupBlock.reflect());
		assertTrue(PowerupBlock.charged());
		assertTrue(PowerupBlock.equals(PowerupBlock));
		assertTrue(PowerupBlock.getLocation().equals(PowerupBlock.getLocation()));
			
		assertEquals(new Color(0,0,255),NormalBlock.pointBlock());
		assertEquals(new Color(255,255,0),PowerupBlock.pointBlock());		
		
		
	}

}