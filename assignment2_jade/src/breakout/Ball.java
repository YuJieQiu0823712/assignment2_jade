package breakout;

import java.util.Arrays;

import breakout.basics.Circle;
import breakout.basics.Point;
import breakout.basics.Rect;
import breakout.basics.Vector;

/**
 * Represents the state of a ball in the breakout game.
 * @invar | getLocation() != null
 * @invar | getVelocity() != null
 */
public abstract class Ball implements Colors{
	
	/**
	 * @invar | location != null
	 * 
	 */
	private Circle location;
	
	/**
	 * @invar | velocity != null
	 * @representationObject
	 */
	private Vector velocity;
	
	/**
	 * @representationObject
	 */
	private boolean replicate;
	
	/**
	 * set velocity of this Ball.
	 * @pre | velocity!=null
	 * @post | getVelocity().equals(velocity) // p42
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
	 * @mutates | this //?
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
	 * @post | result != null
	 * @creates | result
	 */
	public abstract Ball returnNewBall(Circle loc, Vector nspeed);


	/**
	 * Check whether this ball collides with a given `paddle` and if so, replicate numbers of balls 
	 * according to the ReplicateTimes of the ReplicatorPaddle and return the 
	 * new velocity this ball will have after bouncing on the given ReplicatorPaddle.
	 * 
	 * @pre | paddle != null
	 * @post | 0 <= paddle.getReplicateTimes() &&  paddle.getReplicateTimes()<=3
	 * @post | paddle.getReplicateTimes() == 3 && result.length==3 && //error
	 *       | Arrays.stream(result).allMatch(e -> e.getLocation().equals(old(this).getLocation()))  &&
	 *       | Arrays.stream(result).allMatch(e -> e.getDiameter()==old(this).getDiameter()) &&
	 *       | Arrays.stream(result).anyMatch(e -> e.getVelocity().equals(old(this).getVelocity().plus(new Vector(2,-2)))) &&
	 *       | Arrays.stream(result).anyMatch(e -> e.getVelocity().equals(old(this).getVelocity().plus(new Vector(-2,2)))) &&
	 *       | Arrays.stream(result).anyMatch(e -> e.getVelocity().equals(old(this).getVelocity().plus(new Vector(2,2)))) 
	 *       | ||
	 *       | paddle.getReplicateTimes() == 2 && result.length==2 &&
	 *       | Arrays.stream(result).allMatch(e -> e.getLocation().equals(old(this).getLocation()))  &&
	 *       | Arrays.stream(result).allMatch(e -> e.getDiameter()==old(this).getDiameter()) &&
	 *       | Arrays.stream(result).anyMatch(e -> e.getVelocity().equals(old(this).getVelocity().plus(new Vector(2,-2)))) &&
	 *       | Arrays.stream(result).anyMatch(e -> e.getVelocity().equals(old(this).getVelocity().plus(new Vector(-2,2)))) 
	 *       | || 
	 *       | paddle.getReplicateTimes() == 1 && result.length==1 &&
	 *       | Arrays.stream(result).allMatch(e -> e.getLocation().equals(old(this).getLocation()))  &&
	 *       | Arrays.stream(result).allMatch(e -> e.getDiameter()==old(this).getDiameter()) &&
	 *       | Arrays.stream(result).anyMatch(e -> e.getVelocity().equals(old(this).getVelocity().plus(new Vector(2,-2))))
     *       | ||
     *       | result.equals(this)   
     *@creates | result
     *@mutates | this //?     
	 */
	public Ball[] collideBallPaddle(PaddleState paddle) {
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
	 * @pre | replicate == true || replicate == false
	 * @post | isReplicate()==replicate // p42
	 * @mutates | this //?replicate
	 */
	public void setReplicate(boolean replicate) {
		this.replicate = replicate;
	}
	
	/**
	 * check whether this ball is collide with the block or paddle.
	 * @pre | block != null
	 * @pre | paddle != null
	 * @creates | result
	 * @mutate | this//?
	 */
	public abstract Ball collideBallBlocks(BlockState block,PaddleState paddle) ;


	
	

	
	

	
	
}