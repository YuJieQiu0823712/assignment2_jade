package breakout;

import java.awt.Color;

import breakout.basics.Point;

/**
 * 
 * @immutable
 * @invar | getCenter() != null
 * @invar | 0<getReplicateTimes() && getReplicateTimes()<=3
 */
public class ReplicatorPaddle extends PaddleState {
	
	/**
	 * @invar | 0<replicateTimes && replicateTimes<=3
	 * @representaionObject//
	 */
	private int replicateTimes;

	public int getReplicateTimes() {
		return replicateTimes;
	}

	/**
	 * 
	 * @pre | center != null
	 * @pre | 0<replicateTimes && replicateTimes<=3
	 * @post | getCenter().equals(center)
	 * @post | getReplicateTimes()==replicateTimes
	 */
	public ReplicatorPaddle(Point center,int replicateTimes) {
		super(center);
		this.replicateTimes = replicateTimes;
		
	}
	
	/**
	 * @creates | result
	 * @post | getReplicateTimes()==2 && result.equals(new Color(255,0,255)) 
	 *       | || getReplicateTimes()==1 && result.equals(new Color(221,160,221))
	 *       | || getReplicateTimes()==3 && result.equals(new Color(102,0,153))
	 */
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

	/**
	 * @pre | newCenter != null
	 * @creates | result
	 * @post | result.getReplicateTimes() == getReplicateTimes()
	 * @inspect | this//
	 */
	@Override
	public PaddleState returnNewPaddle(Point newCenter) {
		return new ReplicatorPaddle(newCenter,replicateTimes);
	}

	/**
	 * @pre | ball != null
	 */
	@Override
	public boolean replicatorPaddle(Ball ball) {	
		return ball.isReplicate();
	}
	
	/**
	 * Return whether this ReplicatorPaddle represents a same content with the obj.
	 * @pre | obj!=null
	 * @post | obj instanceof ReplicatorPaddle rp &&
	 *       | rp.getCenter().equals(this.getCenter()) &&
	 *       | rp.getReplicateTimes()==this.getReplicateTimes()
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof ReplicatorPaddle rp &&
				rp.getCenter().equals(getCenter()) &&
				rp.getReplicateTimes()==replicateTimes;
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
