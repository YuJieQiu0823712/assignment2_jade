package breakout;

import breakout.basics.Point;

public class NormalPaddle extends PaddleState{
	

	public NormalPaddle(Point center) {
		super(center);
	}

	@Override
	protected PaddleState returnNewPaddle(Point newCenter) {
		return new NormalPaddle (newCenter);
	}

	@Override
	protected int getReplicateTimes() {
		return 0;
	}

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