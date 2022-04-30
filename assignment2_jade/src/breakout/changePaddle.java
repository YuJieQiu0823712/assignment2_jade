package breakout;

public interface changePaddle {

	public default PaddleState changePaddle(PaddleState paddle,Ball ball) {

		if(paddle.replicatorPaddle(ball)) {
			return paddle=new ReplicatorPaddle(paddle.getCenter(), 3);
		} else if (paddle.getReplicateTimes()>=1){
			if (paddle.getReplicateTimes()!=1) {
			return paddle = new ReplicatorPaddle(paddle.getCenter(), paddle.getReplicateTimes()-1);
			} else {
				return paddle = new NormalPaddle(paddle.getCenter());
			}
		} 
		
		else {
			return paddle;
		}



	}



}
