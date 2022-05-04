package breakout;

import breakout.basics.Point;
import breakout.basics.Rect;
import breakout.basics.Vector;

/**
 * Represents the state of a paddle in the breakout game.
 *
 * @immutable
 * @invar | getCenter() != null
 */
public abstract class PaddleState implements Colors{
	
	public static final int HEIGHT = 500;
	public static final int WIDTH = 3000;
	
	
	/**
	 * @invar | center != null
	 */
	private final Point center;

	/**
	 * Construct a paddle located around a given center in the field.
	 * @pre | center != null
	 * @post | getCenter().equals(center)
	 */
	public PaddleState(Point center) {
		this.center = center; 
	}
	
	/**
	 * Return the center point of this paddle.
	 */
	public Point getCenter() {
		return center;
	}

	/**
	 * Return the rectangle occupied by this paddle in the field.
	 * 
	 * @post | result != null
	 * @post | result.getTopLeft().equals(getCenter().plus(new Vector(-WIDTH/2,-HEIGHT/2)))
	 * @post | result.getBottomRight().equals(getCenter().plus(new Vector(WIDTH/2,HEIGHT/2)))
	 */
	public Rect getLocation() {
		Vector halfDiag = new Vector(-WIDTH/2,-HEIGHT/2);
		return new Rect(center.plus(halfDiag), center.plus(halfDiag.scaled(-1)));
	}

// New methods below
	
	/**
	 * @pre | newCenter != null
	 * @creates | result
	 * @post | result != null
	 */
	public abstract PaddleState returnNewPaddle(Point newCenter);
	
	
	/** 
	 * @post | 0<=result && result<=3 
	 */
	public abstract int getReplicateTimes();
	
	
	/**
	 * @pre | ball != null  
	 */
	public abstract boolean replicatorPaddle(Ball ball);
	
	
	
	/** 
	 * @pre | paddle != null
	 * @pre | ball != null  
	 * @inspects | ball 
	 * @post | result != null
	 * @post | result.getCenter().equals(old(getCenter()))
	 */
	public PaddleState changePaddle(PaddleState paddle,Ball ball) {

		if(paddle.replicatorPaddle(ball)) {
			return paddle=new ReplicatorPaddle(paddle.getCenter(), 3);
		} else if (paddle.getReplicateTimes()>=1){
			if (paddle.getReplicateTimes()!=1) {
			return paddle = new ReplicatorPaddle(paddle.getCenter(), paddle.getReplicateTimes()-1);
			} else {
				return paddle = new NormalPaddle(paddle.getCenter());
			}
		} 
		
		else {
			return paddle;
		}



	}
	
	
	
	

}
