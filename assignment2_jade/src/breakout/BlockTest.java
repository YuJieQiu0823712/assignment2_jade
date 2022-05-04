package breakout;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import breakout.basics.Point;
import breakout.basics.Rect;

class BlockTest {
	Point p11;
	Point p05;
	Point p38;
	Point pm14;
	
	Rect r1138;
	Rect rm1438;
	
	BlockState b1;

	@BeforeEach
	void setUp() throws Exception {
		p11 = new Point(1,1);
		p05 = new Point(0,5);
		p38 = new Point(3,8);
		pm14 = new Point(-1,4);
		r1138 = new Rect(p11,p38);
		rm1438 = new Rect(pm14,p38);
		b1 = new NormalBlock(r1138);
	}

	@Test
	void testBlock() {
		assertEquals(r1138,b1.getLocation());
	}
	
	@Test
	void test() {
		assertEquals(false,b1.replicateBall());
	}

}