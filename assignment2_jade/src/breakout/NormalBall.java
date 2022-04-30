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

	public NormalBall(Circle location, Vector velocity) {
		super(location, velocity);
	}

	@Override
	protected Ball returnNewBall(Circle loc, Vector nspeed) {

		return new NormalBall(loc,nspeed);
	}

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
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof NormalBall nball &&
				nball.getCenter().equals(this.getCenter()) &&
				nball.getDiameter() == this.getDiameter();
	}
	
	@Override
	public String toString() {
		return this.getCenter().toString();
	}










	
}
