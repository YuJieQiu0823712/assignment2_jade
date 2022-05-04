package breakout;

import java.awt.Color;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;

import breakout.basics.Circle;
import breakout.basics.Vector;

public class SuperChargedBall extends Ball{
	
	/**
//	 * @invar | getStartTime() > 0 //error
	 * @representationObject
	 */
	private int startTime; 


	/**
	 * Construct a SuperChargedBall with the given location, velocity, startTime.
	 * 
	 * @pre | location != null
	 * @pre | velocity != null
//	 * @pre | startTime >= 0 //error
	 * @post | getLocation().equals(location)
	 * @post | getVelocity().equals(velocity)
//	 * @post | getStartTime() == startTime 
	 * 
	 */
	public SuperChargedBall(Circle location, Vector velocity,int startTime) {
		super(location, velocity);
		this.startTime = startTime;
	}

	/**
	 * Return the startTime of this superChargedBall.
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * Return the color of this ball.
	 * @post | result.equals(new Color(255,255,0))
	 * @creates | result
	 */
	@Override
	public Color pointBall() {
		return new Color(255,255,0);
	}

	/**
	 * Return the NewBall with given location and velocity.
//	 * @post | System.currentTimeMillis()-getStartTime()<10000 ?
//	 *       | result.equals(new SuperChargedBall(loc,nspeed,getStartTime()))
//	 *       | :
//	 *       | result.equals(new NormalBall(loc,nspeed))
	 * @creates | result 
	 */ 
	@Override
	public Ball returnNewBall(Circle loc, Vector nspeed) {
		if (currentTimeMillis()-startTime<10000) {

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
	 * 
	 * @pre | block != null
	 * @pre | paddle != null
	 * 
	 *
	 * @post | block.charged() == true 
	 * 		 |    && result.getLocation().equals(old(this).getLocation()) 
	 * 		 |	  && result.getVelocity().equals(old(this).getVelocity()) 
	 * 		 |	  && result.getDiameter()==old(this).getDiameter()
	 * 		 | || 
	 *       | block.reflect() == true 
	 *       |    && result.getLocation().equals(old(this).getLocation()) 
	 *       |    && result.getVelocity().equals(old(this).bounceOn(block.getLocation())) 
	 *       |	  && result.getDiameter()==old(this).getDiameter()
	 *       | ||  
	 *       | result.equals(this)
	 * 
	 * @post | block.replicateBall() ?
	 * 		 | this.isReplicate()
	 * 		 | :
	 * 		 | !this.isReplicate()
	 * @creates | result 
	 * @mutate | this //?    
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
			return new SuperChargedBall(this.getLocation(),this.getVelocity(),currentTimeMillis());
		} else {
			return this;
		}

	}
	
	/**
	 * Return currentTime of the SuperChargedBall.
	 */
	
	private int currentTimeMillis() {
		return (int)(System.currentTimeMillis()%1000000);	
	}
	
	

	/**
	 * Return whether this SuperChargedBall represents a same content with the obj.
	 * @pre | obj!=null
	 * @post | obj instanceof SuperChargedBall sball &&
	 *       | sball.getCenter().equals(this.getCenter()) &&
	 *       | sball.getDiameter() == this.getDiameter() &&
	 *       | sball.getVelocity().equals(this.getVelocity())
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof SuperChargedBall sball &&
				sball.getCenter().equals(this.getCenter()) &&
				sball.getDiameter() == this.getDiameter() &&
				sball.getVelocity().equals(this.getVelocity());
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