package breakout;

import java.awt.Color;
//Your implementation of these methods should consist of very simple code 
//that simply forwards the invocation to the relevant method in the other classes you've implemented.

import breakout.basics.Circle;
import breakout.basics.Point;
import breakout.basics.Rect;
import breakout.basics.Vector;

//No documentation required for this class
public class BreakoutFacade {
	public PaddleState createNormalPaddleState(Point center) {
		// TODO
		return new NormalPaddle(center);
	}

	public Ball createNormalBall(Point center, int diameter, Vector initBallVelocity) {
		// TODO
		Circle location = new Circle(center,diameter);
		return new NormalBall(location,initBallVelocity);
	}

	public Ball createSuperchargedBall(Point center, int diameter, Vector initBallVelocity, int lifetime) {
		// TODO
		Circle location = new Circle(center,diameter);
		return new SuperChargedBall(location,initBallVelocity,lifetime);
	}

	public BreakoutState createBreakoutState(Ball[] balls, BlockState[] blocks, Point bottomRight,
			PaddleState paddle) {
		// TODO
		return new BreakoutState(balls,blocks,bottomRight,paddle);
	}

	public BlockState createNormalBlockState(Point topLeft, Point bottomRight) {
		// TODO
		Rect location = new Rect(topLeft,bottomRight);
		return new NormalBlock(location);
	}

	public BlockState createSturdyBlockState(Point topLeft, Point bottomRight, int i) {
		Rect location = new Rect(topLeft,bottomRight);
		return new SturdyBlock(location,i);
	}

	public BlockState createReplicatorBlockState(Point topLeft, Point bottomRight) {
		Rect location = new Rect(topLeft,bottomRight);
		return new ReplicationBlock(location);
	}

	public BlockState createPowerupBallBlockState(Point topLeft, Point bottomRight) {
		Rect location = new Rect(topLeft,bottomRight);
		return new PowerupBlock(location);
	}

	public Color getColor(PaddleState paddle) {
		// TODO
		return paddle.pointPaddle();
	}

	public Color getColor(Ball ball) {
		// TODO
		return ball.pointBall();
	}

	public Rect getLocation(PaddleState paddle) {
		// TODO
		return paddle.getLocation();
	}

	public Point getCenter(Ball ball) {
		// TODO
		return ball.getCenter();
	}

	public int getDiameter(Ball ball) {
		// TODO
		return ball.getDiameter();
	}

	public Ball[] getBalls(BreakoutState breakoutState) {
		// TODO
		return breakoutState.getBalls();
	}

	public Color getColor(BlockState block) {
		// TODO
		return block.pointBlock();
	}

	public Rect getLocation(BlockState block) {
		// TODO
		return block.getLocation();
	}
}