package breakout;

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
		long time = System.currentTimeMillis();
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

}
