package breakout;

import java.awt.Color;

import breakout.basics.Circle;
import breakout.basics.Rect;
import breakout.basics.Vector;

public class SuperChargedBall extends Ball{
	
	private long startTime; 

	public SuperChargedBall(Circle location, Vector velocity,long startTime) {
		super(location, velocity);
		this.startTime = startTime;
	}

	
	@Override
	public Color pointBall() {
		return new Color(255,255,0);
	}

	@Override
	protected Ball returnNewBall(Circle loc, Vector nspeed) {
		if (System.currentTimeMillis()-startTime<10000) {
			
		return new SuperChargedBall(loc,nspeed,startTime);
		} else {
			return new NormalBall(loc,nspeed);
		}
	}

	@Override
	public Ball collideBallBlocks(BlockState block,PaddleState paddle) {
			Vector nspeed = this.bounceOn(block.getLocation());
			if(block.reflect()) {
				setVelocity(nspeed);
			}
			if(block.charged()) {
				return new SuperChargedBall(this.getLocation(),this.getVelocity(),System.currentTimeMillis());
			} else {
			return this;
			}

	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof SuperChargedBall sball &&
				sball.getCenter().equals(this.getCenter()) &&
				sball.getDiameter() == this.getDiameter();
	}
	
	@Override
	public String toString() {
		return this.getCenter().toString();
	}







	

	


}
