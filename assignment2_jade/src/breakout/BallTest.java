package breakout;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import breakout.basics.Circle;
import breakout.basics.Point;
import breakout.basics.Rect;
import breakout.basics.Vector;

class BallTest {
	Point p11;
	Point p05;
	Point p38;
	Point pm14;
	
	Rect r1138;
	Rect rm1438;
	
	Vector v1010;
	
	Circle c052;
	Circle c389;
	Ball b1;
	Ball b2;
	
	@BeforeEach
	void setUp() throws Exception {
		p11 = new Point(1,1);
		p05 = new Point(0,5);
		p38 = new Point(3,8);
		pm14 = new Point(-1,4);
		r1138 = new Rect(p11,p38);
		rm1438 = new Rect(pm14,p38);
		c052 = new Circle(p05,2);
		c389 = new Circle(p38,9);
		v1010 = new Vector(10,10);
		int time = (int)(System.currentTimeMillis()%1000000);
		b1 = new NormalBall(c052, v1010);
		b2 = new SuperChargedBall(c052,v1010,time);
	}

	@Test
	void testBall() {
		assertEquals(p05, b1.getLocation().getCenter());
		assertEquals(2, b1.getLocation().getDiameter());
		assertEquals(v1010, b1.getVelocity());
	}

	@Test
	void testBounceOn() {
		assertEquals(new Vector(-10,10),b1.bounceOn(r1138));
	}

	@Test
	void test() {
		
		// ball
		Circle c1 = new Circle(new Point(2500,3000+350), 700);  
		
		Ball NormalBall1 = new NormalBall(c1, new Vector(4,5));
		Ball NewBall1 = new NormalBall(c1, new Vector(6,3));
		Ball NewBall2 = new NormalBall(c1, new Vector(2,7));		
		Ball NewBall3 = new NormalBall(c1, new Vector(6,7));
					
		Ball[] Balls3 = new Ball[] {NewBall1,NewBall2,NewBall3};
			
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
		PaddleState ReplicatorPaddle3 = new ReplicatorPaddle(p1,3);
		PaddleState ReplicatorPaddle2 = new ReplicatorPaddle(p1,2);	
		PaddleState ReplicatorPaddle1 = new ReplicatorPaddle(p1,1);
		

		assertTrue(Balls3[0].getCenter().equals(NormalBall1.collideBallPaddle(ReplicatorPaddle3)[0].getCenter()));
		assertTrue(Balls3[1].getCenter().equals(NormalBall1.collideBallPaddle(ReplicatorPaddle3)[1].getCenter()));
		assertTrue(Balls3[2].getCenter().equals(NormalBall1.collideBallPaddle(ReplicatorPaddle3)[2].getCenter()));
		

		assertTrue(Balls3[0].getCenter().equals(NormalBall1.collideBallPaddle(ReplicatorPaddle2)[0].getCenter()));
		assertTrue(Balls3[1].getCenter().equals(NormalBall1.collideBallPaddle(ReplicatorPaddle2)[1].getCenter()));
		

		assertTrue(Balls3[0].getCenter().equals(NormalBall1.collideBallPaddle(ReplicatorPaddle1)[0].getCenter()));
		
		//NormalBall1.hitBlock(NormalBlockLoc, true);
		
		

		
		

		
	}

	
}