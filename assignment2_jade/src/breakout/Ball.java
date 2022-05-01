package breakout;

import breakout.basics.Circle;
import breakout.basics.Point;
import breakout.basics.Rect;
import breakout.basics.Vector;


/**
 * Represents the state of a ball in the breakout game.
 * @mutable
 * @invar | getLocation() != null
 * @invar | getVelocity() != null
 */
public abstract class Ball implements Colors,changePaddle{
	
	private Circle location;
	private Vector velocity;
	
	private boolean replicate;

	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}

	/**
	 * Construct a new ball at a given `location`, with a given `velocity`.
	 * 
	 * @pre | location != null
	 * @pre | velocity != null
	 * @post | getLocation() == location
	 * @post | getVelocity().equals(velocity) 
	 */
	public Ball(Circle location, Vector velocity) {
		this.location = location;
		this.velocity = velocity;
	}
	
	/**
	 * Return this ball's location.
	 */
	public Circle getLocation() {
		return location;
	}

	/**
	 * Return this ball's velocity.
	 */
	public Vector getVelocity() {
		return velocity;
	}

	/**
	 * Check whether this ball collides with a given `rect` and if so, return the 
	 * new velocity this ball will have after bouncing on the given rect.
	 * 
	 * @pre | rect != null
	 * @post | (rect.collideWith(getLocation()) == null && result == null) ||
	 *       | (getVelocity().product(rect.collideWith(getLocation())) <= 0 && result == null) || 
	 *       | (result.equals(getVelocity().mirrorOver(rect.collideWith(getLocation()))))
	 */
	public Vector bounceOn(Rect rect) {
		Vector coldir = rect.collideWith(location);
		if(coldir != null && velocity.product(coldir) > 0) {
			return velocity.mirrorOver(coldir);
		}
		return null;
	}

	/**
	 * Return this point's center.
	 * 
	 * @post | getLocation().getCenter().equals(result)
	 */
	public Point getCenter() {
		return getLocation().getCenter();
	}

	
	public void hitBlock(Rect rect, boolean destroyed) {
		//this method is responsible for changing the velocity of the ball in accordance.
		if (destroyed) {
			bounceOn(rect);
		} 
	}
	
	public int getDiameter() {
		return getLocation().getDiameter();
	}

	protected abstract Ball returnNewBall(Circle loc, Vector nspeed);


	
	protected Ball[] collideBallPaddle(PaddleState paddle) { // how to check collide?
		Ball[] newBalls = new Ball[paddle.getReplicateTimes()];
		
		
		if (paddle.getReplicateTimes() == 3) {
			
			newBalls[0]=this.returnNewBall(location, velocity.plus(new Vector(2, -2)));
			newBalls[1]=this.returnNewBall(location, velocity.plus(new Vector(-2, 2)));
			newBalls[2]=this.returnNewBall(location, velocity.plus(new Vector(2, 2)));
			 
		} else if (paddle.getReplicateTimes() == 2) {
			newBalls[0]=this.returnNewBall(location, velocity.plus(new Vector(2, -2)));
			newBalls[1]=this.returnNewBall(location, velocity.plus(new Vector(-2, 2)));
		} else if (paddle.getReplicateTimes() == 1)  {
			newBalls[0]=this.returnNewBall(location, velocity.plus(new Vector(2, -2)));
		}
		
		return newBalls;

	}

	public boolean isReplicate() {
		return replicate;
	}

	public void setReplicate(boolean replicate) {
		this.replicate = replicate;
	}
	
	public abstract Ball collideBallBlocks(BlockState block,PaddleState paddle) ;

	


	
	
}
