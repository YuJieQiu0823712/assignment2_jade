package breakout;

import java.awt.Color;

import breakout.basics.Circle;
import breakout.basics.Rect;
import breakout.basics.Vector;

/**
 * Represents the state of a normalBall in the breakout game.
 * @mutable
 * @invar | getLocation() != null
 * @invar | getVelocity() != null
 */


public class NormalBall extends Ball{

	/**
	 * Construct a new ball at a given `location`, with a given `velocity`.
	 * 
	 * @pre | location != null
	 * @pre | velocity != null
	 * @post | getLocation() == location
	 * @post | getVelocity().equals(velocity) 
	 */
	
	public NormalBall(Circle location, Vector velocity) {
		super(location, velocity);
	}

	/**
	 * Return new NormalBall
//	 * @pre | loc != null
//	 * @pre |　nspeed != null
	 * @creates | result
	 */
	@Override
	protected Ball returnNewBall(Circle loc, Vector nspeed) {

		return new NormalBall(loc,nspeed);
	}
	
	/**
	 * Check whether this ball collides with a given `rect` and if so, return the 
	 * new velocity this ball will have after bouncing on the given rect and 
	 * decide whether NormalBall changes to SuperChargedBall.
	 * 
	 * @mutate
//	 * @pre | block != null
//	 * @pre | paddle != null
//	 * @post | block.charged().equals(True) && result.equals(new SuperChargedBall(this.getLocation(),this.getVelocity(),System.currentTimeMillis())) || // ?protected
//	 *       | block.replicateBall().equals(True) && result.equals(this) || //?protected 
	 *       | result.equals(this)
	 */
	@Override
	public Ball collideBallBlocks(BlockState block,PaddleState paddle) 	{
		Vector nspeed = this.bounceOn(block.getLocation());
		setVelocity(nspeed);			
		if (block.charged()) {
			return new SuperChargedBall(this.getLocation(),nspeed,System.currentTimeMillis());
		} else if (block.replicateBall()) {
			//this.Repaint(new Color(102,0,153));
			this.setReplicate(true);
			return this;
		}
			
		else {
			return this;
		}
	}
	
	/**
	 * Return whether this NormalBall represents a same content with the obj.
	 * @pre | obj!=null
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof NormalBall nball &&
				nball.getCenter().equals(this.getCenter()) &&
				nball.getDiameter() == this.getDiameter();
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
