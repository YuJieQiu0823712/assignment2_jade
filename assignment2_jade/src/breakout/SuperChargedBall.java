package breakout;

import java.awt.Color;

import breakout.basics.Circle;
import breakout.basics.Point;
import breakout.basics.Rect;
import breakout.basics.Vector;

/**
 * Represents the state of a SuperChargedBall in the breakout game.
 * @mutable
 * @invar | getLocation() != null
 * @invar | getVelocity() != null
 */

public class SuperChargedBall extends Ball{
	
	/**
//	 * @invar | startTime > 0
	 */
	private int startTime; 

	
	/**
	 * Construct a SuperChargedBall with the given location, velocity, startTime.
	 * 
	 * @pre | location != null
	 * @pre | velocity != null
//	 * @pre | startTime > 0
	 * @post | getLocation().equals(location)
	 * @post | getVelocity().equals(velocity)
	 * @post | startTime == startTime //? add get startTime
	 */
	public SuperChargedBall(Circle location, Vector velocity,int startTime) {
		super(location, velocity);
		this.startTime = startTime;
	}

	/**
	 * Return the color of this ball.
	 * @post | result.equals(new Color(255,255,0))
	 * @creates result //?
	 */
	@Override
	public Color pointBall() {
		return new Color(255,255,0);
	}

	
	/**
	 * Return the NewBall with given location and velocity.
//	 * @post | result.equals(new SuperChargedBall(loc,nspeed,startTime))//?protected
	 * @creates result 
	 */
	@Override
	protected Ball returnNewBall(Circle loc, Vector nspeed) {
		if ((int)System.currentTimeMillis()-startTime<10000) {

			return new SuperChargedBall(loc,nspeed,startTime);
		} else {
			return new NormalBall(loc,nspeed);
		}
	}

	/**
	 * Check whether this ball collides with a given `block` and if so, return the 
	 * new velocity this ball will have after bouncing on the given block and
	 * decide whether NormalBall changes to SuperChargedBall
	 * 
	 * @mutate
//	 * @pre | block.getLocation() != null
//	 * @post | block.charged().equals(True) && result.equals(new SuperChargedBall(this.getLocation(),this.getVelocity(),System.currentTimeMillis())) || // ?protected
//	 *       | block.reflect().equals(True) && result.equals(setVelocity(this.bounceOn(block.getLocation()))) || //?protected 
	 *       | result.equals(this)
	 */
	
	@Override
	public Ball collideBallBlocks(BlockState block,PaddleState paddle) {
		Vector nspeed = this.bounceOn(block.getLocation());
		if (block.replicateBall()) {
			this.setReplicate(true);
		}
		if(block.reflect()) {
			setVelocity(nspeed); 
		}
		if(block.charged()) {
			return new SuperChargedBall(this.getLocation(),this.getVelocity(),(int)System.currentTimeMillis());
		} else {
			return this;
		}

	}

	
	/**
	 * Return whether this SuperChargedBall represents a same content with the obj.
	 * @pre | obj!=null
	 */	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof SuperChargedBall sball &&
				sball.getCenter().equals(this.getCenter()) &&
				sball.getDiameter() == this.getDiameter();
	}
	
	/**
	 * Return a string representation of this center.
	 * @post | result != null
	 */
	@Override
	public String toString() {
		return this.getCenter().toString();
	}







	

	


}
