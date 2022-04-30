package breakout;

import java.awt.Color;

import breakout.basics.Point;
import breakout.basics.Vector;

public class ReplicatorPaddle extends PaddleState {
	
	private int replicateTimes;

	public int getReplicateTimes() {
		return replicateTimes;
	}

	public ReplicatorPaddle(Point center,int replicateTimes) {
		super(center);
		this.replicateTimes = replicateTimes;
		
	}
	
	@Override
	public Color pointPaddle() {
		if (getReplicateTimes() == 2) {
			return new Color(255,0,255); //	pink
		} else if (getReplicateTimes() == 1) {
			return new Color(221,160,221); //light pink
		} 
 
		else {
			return new Color(102,0,153); //purple
		}
	}

	@Override
	protected PaddleState returnNewPaddle(Point newCenter) {
		return new ReplicatorPaddle(newCenter,replicateTimes);
	}

	@Override
	public boolean replicatorPaddle(Ball ball) {	
		return ball.isReplicate();
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof ReplicatorPaddle rp &&
				rp.getCenter().equals(getCenter()) &&
				rp.getReplicateTimes()==replicateTimes;
	}
	
	@Override
	public String toString() {
		return this.getCenter().toString();
	}





	




}


	




