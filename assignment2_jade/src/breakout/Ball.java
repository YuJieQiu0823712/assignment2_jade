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
	
	/**
	 * @invar | location != null
	 * @invar | velocity != null
	 * @representationObject
	 */
	private Circle location;
	private Vector velocity;
	private boolean replicate;
	// data encaptuation

	/**
	 * set velocity of this Ball. 
	 * @mutate | this
	 */
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
//	 * @post | result.equals()
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
	 * @post | getLocation().getCenter().equals(result)
	 */
	public Point getCenter() {
		return getLocation().getCenter();
	}

	/**
	 * Check whether this ball collides with block and change the velocity of the ball.
	 * @pre | rect!=null
//	 * @post | 
	 */
	public void hitBlock(Rect rect, boolean destroyed) {
		//this method is responsible for changing the velocity of the ball in accordance.
		if (destroyed) {
			bounceOn(rect);
		} 
	}
	
	/**
	 * Return the diameter of this ball.
	 * @post | result==getLocation().getDiameter()
	 */
	public int getDiameter() {
		return getLocation().getDiameter();
	}

	/**
	 * Return new NormalBall
	 * @pre | loc != null
	 * @pre | nspeed != null
	 */
	protected abstract Ball returnNewBall(Circle loc, Vector nspeed);

	
	/**
	 * Check whether this ball collides with a given `paddle` and if so, replicate numbers of balls 
	 * according to the ReplicateTimes of the ReplicatorPaddle and return the 
	 * new velocity this ball will have after bouncing on the given ReplicatorPaddle.
	 * 
	 * @pre | paddle != null
	 * @post | 0 <= paddle.getReplicateTimes() &&  paddle.getReplicateTimes()<=3
//	 * @post | paddle.getReplicateTimes() == 3 && result.equals(array.stream element|| element >=1 <=3) ||
//	 *       | paddle.getReplicateTimes() == 2 && result.equals(getBalls().length==2) || 
//	 *       | paddle.getReplicateTimes() == 1 && result.equals(getBalls().length==1)
//	 * @post | Arrays.stream(newBalls).anyMatch(e -> e.getVelocity().equals(this.getVelocity().plus(new Vector(2,-2))))
//   * @post | if (result.length ==2)  Arrays.stream(e->e.getvelocity == this.getvelocity.plus(new Vector(2, -2) 
//	 * 			|| this.getvelocity.plus(new Vector(-2, 2)))  
	 */
	
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

	/**
	 * Return whether this ball is replicated.
	 */
	public boolean isReplicate() {
		return replicate; 
	}

	/**
	 * set this ball is replicated.
	 * @mutate | replicate
	 */
	public void setReplicate(boolean replicate) {
		this.replicate = replicate;
	}
	
	/**
	 * check whether this ball is collide with the block or paddle.
	 * @pre | block!= null
	 * @pre | paddle!= null
	 */
	public abstract Ball collideBallBlocks(BlockState block,PaddleState paddle) ;

	


	
	
}
