package breakout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import breakout.basics.Circle;
import breakout.basics.Point;
import breakout.basics.Vector;

class PaddleStateTest {
	Point p11;
	PaddleState p1;
	
	

	@BeforeEach
	void setUp() throws Exception {
		p11 = new Point(1,1);
		p1 = new NormalPaddle(p11);
	}

	@Test
	void testPaddle() {
		assertEquals(p11, p1.getCenter());
	}

	@Test
	void testGetLocation() {
		assertEquals(new Point(1-PaddleState.WIDTH/2,1-PaddleState.HEIGHT/2), p1.getLocation().getTopLeft());
		assertEquals(new Point(1+PaddleState.WIDTH/2,1+PaddleState.HEIGHT/2), p1.getLocation().getBottomRight());
	}
	
	
	
	
	@Test
	void testChangePaddle() {
		Circle c1 = new Circle(new Point(2000, 2000), 700);
		Ball ball1 = new NormalBall(c1, new Vector(4, 5));
		assertEquals(p1.changePaddle(p1,ball1),p1);

	}


}
