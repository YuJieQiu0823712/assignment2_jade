package breakout;

import breakout.basics.Point;
/**
 * 
 * @immutable
 * 
 */
public class NormalPaddle extends PaddleState{
	
	/**
	 * @pre | center != null
	 * @post | getCenter().equals(center)
	 */

	public NormalPaddle(Point center) {
		super(center);
	}
	
	/**
	 * @pre | newCenter != null
	 * @creates | result
	 */
	@Override
	public PaddleState returnNewPaddle(Point newCenter) {
		return new NormalPaddle (newCenter);
	}
	
	/**
	 * @post | result == 0
	 */
	@Override
	public int getReplicateTimes() {
		return 0;
	}

	/**
	 * @pre | ball != null
	 */
	@Override
	public boolean replicatorPaddle(Ball ball) {
		return ball.isReplicate();

	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof NormalPaddle np &&
				np.getCenter().equals(getCenter());
	} 
	
	@Override
	public String toString() {
		return this.getCenter().toString();
	}











}
