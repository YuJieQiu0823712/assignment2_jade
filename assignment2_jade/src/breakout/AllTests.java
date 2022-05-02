package breakout;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import breakout.basics.Circle;
import breakout.basics.Point;
import breakout.basics.Vector;


public class AllTests {

	private Ball normalBall;
	private Ball superChargedBall;

	private Ball[] normalBalls;
	private Ball[] superChargedBalls;

	private BlockState normalBlock;
	private BlockState sturdyBlock;
	private BlockState powerUpBlock;
	private BlockState replicationBlock;

	private BlockState[] normalBlocks;
	private BlockState[] sturdyBlocks;
	private BlockState[] powerUpBlocks;
	private BlockState[] ReplicationBlocks;

	private Point bottomRight;
	private PaddleState normalPaddle;
	private PaddleState replicatorPaddle;

	private BreakoutState stateBeforeBounceNormalBlock;
	private BreakoutState stateBeforeBounceSturdyBlock;
	private BreakoutState stateBeforeBouncePowerUpBlock;
	private BreakoutState stateBeforeBounceReplicationBlock;
	
	private BreakoutState stateBeforeBounceNormalBlock2;
	private BreakoutState stateBeforeBounceSturdyBlock2;
	private BreakoutState stateBeforeBouncePowerUpBlock2;
	private BreakoutState stateBeforeBounceReplicationBlock2;

	private BreakoutFacade facade = new BreakoutFacade();


	@BeforeEach
	void setUp() throws Exception {
		//normalBall hits a normalBlock
		normalBall = facade.createNormalBall(new Point(1000, 1000), 100, new Vector(0, 5));
		normalBalls = new Ball[] { normalBall };
		normalBlock = facade.createNormalBlockState(new Point(0, 1051), new Point(2000, 1200));
		normalBlocks = new BlockState[] { normalBlock };
		bottomRight = new Point(10000, 2000);
		normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
		stateBeforeBounceNormalBlock = facade.createBreakoutState(normalBalls, normalBlocks, bottomRight, normalPaddle);

		//normalBall hits a sturdyBlock
		normalBall = facade.createNormalBall(new Point(1000, 1000), 100, new Vector(0, 5));
		normalBalls = new Ball[] { normalBall };
		sturdyBlock = facade.createSturdyBlockState(new Point(0, 1051), new Point(2000, 1200),3);
		sturdyBlocks = new BlockState[] { sturdyBlock };
		bottomRight = new Point(10000, 2000);
		normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
		stateBeforeBounceSturdyBlock = facade.createBreakoutState(normalBalls, sturdyBlocks, bottomRight, normalPaddle);

		//normalBall hits a powerUpBlock
		normalBall = facade.createNormalBall(new Point(1000, 1000), 100, new Vector(0, 5));
		normalBalls = new Ball[] { normalBall };
		powerUpBlock = facade.createPowerupBallBlockState(new Point(0, 1051), new Point(2000, 1200));
		normalBlock = facade.createPowerupBallBlockState(new Point(0, 1051+149), new Point(2000,1200+149));//?normalBall
		powerUpBlocks = new BlockState[] { powerUpBlock,normalBlock };
		bottomRight = new Point(10000, 2000);
		normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
		stateBeforeBouncePowerUpBlock = facade.createBreakoutState(normalBalls, powerUpBlocks, bottomRight, normalPaddle);
	
		//normalBall hits a replicationBlock
		normalBall = facade.createNormalBall(new Point(1000, 1000), 100, new Vector(0, 5));
		normalBalls = new Ball[] { normalBall };
		replicationBlock = facade.createReplicatorBlockState(new Point(0, 1051), new Point(2000, 1200));
		ReplicationBlocks = new BlockState[] { replicationBlock };
		bottomRight = new Point(10000, 2000);
		normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
		stateBeforeBounceReplicationBlock = facade.createBreakoutState(normalBalls, ReplicationBlocks, bottomRight, normalPaddle);

		/////////
		
		//superchargedBall hits a normalBlock
		superChargedBall = facade.createSuperchargedBall(new Point(1000, 1000), 100, new Vector(0, 5),5000);
		superChargedBalls = new Ball[] { superChargedBall };
		normalBlock = facade.createNormalBlockState(new Point(0, 1051), new Point(2000, 1200));
		normalBlocks = new BlockState[] { normalBlock };
		bottomRight = new Point(10000, 2000);
		normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
		stateBeforeBounceNormalBlock2 = facade.createBreakoutState(superChargedBalls, normalBlocks, bottomRight, normalPaddle);

		//superchargedBall hits a sturdyBlock
		superChargedBall = facade.createSuperchargedBall(new Point(1000, 1000), 100, new Vector(0, 5),5000);
		superChargedBalls = new Ball[] { superChargedBall };
		sturdyBlock = facade.createSturdyBlockState(new Point(0, 1051), new Point(2000, 1200),3);
		sturdyBlocks = new BlockState[] { sturdyBlock };
		bottomRight = new Point(10000, 2000);
		normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
		stateBeforeBounceSturdyBlock2 = facade.createBreakoutState(superChargedBalls, sturdyBlocks, bottomRight, normalPaddle);

		//superchargedBall hits a powerUpBlock
		superChargedBall = facade.createSuperchargedBall(new Point(1000, 1000), 100, new Vector(0, 5),5000);
		superChargedBalls = new Ball[] { superChargedBall };
		powerUpBlock = facade.createPowerupBallBlockState(new Point(0, 1051), new Point(2000, 1200));
		powerUpBlocks = new BlockState[] { powerUpBlock };
		bottomRight = new Point(10000, 2000);
		normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
		stateBeforeBouncePowerUpBlock2 = facade.createBreakoutState(superChargedBalls, powerUpBlocks, bottomRight, normalPaddle);
				
		//superchargedBall hits a replicationBlock
		superChargedBall = facade.createSuperchargedBall(new Point(1000, 1000), 100, new Vector(0, 5),5000);
		superChargedBalls = new Ball[] { superChargedBall };
		replicationBlock = facade.createReplicatorBlockState(new Point(0, 1051), new Point(2000, 1200));
		ReplicationBlocks = new BlockState[] { replicationBlock };
		bottomRight = new Point(10000, 2000);
		normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
		stateBeforeBounceReplicationBlock2 = facade.createBreakoutState(superChargedBalls, ReplicationBlocks, bottomRight, normalPaddle);

	}


	@Test
	void testTickBounceNormalBlock() {
		stateBeforeBounceNormalBlock.tick(1, 1);
		assertEquals(1, stateBeforeBounceNormalBlock.getBalls().length);
		assertEquals(0, stateBeforeBounceNormalBlock.getBlocks().length);
		assertEquals(new Vector(0, -5), stateBeforeBounceNormalBlock.getBalls()[0].getVelocity());
	}
	
	
	@Test
	void testTickBounceSturdyBlock() {
		assertEquals(3,((SturdyBlock) stateBeforeBounceSturdyBlock.getBlocks()[0]).getHitTimes());
		stateBeforeBounceSturdyBlock.tick(1, 1);
		assertEquals(1, stateBeforeBounceSturdyBlock.getBalls().length);
		assertEquals(1, stateBeforeBounceSturdyBlock.getBlocks().length); //block is still there.
		assertEquals(2,((SturdyBlock) stateBeforeBounceSturdyBlock.getBlocks()[0]).getHitTimes()); // HitTimes minus 1
		assertEquals(new Vector(0, -5), stateBeforeBounceSturdyBlock.getBalls()[0].getVelocity());
		
	}
	
	@Test
	void testTickBouncePowerUpBlock() {	
		stateBeforeBouncePowerUpBlock.tick(1, 1);
		assertEquals(1, stateBeforeBouncePowerUpBlock.getBalls().length);
		assertEquals(1, stateBeforeBouncePowerUpBlock.getBlocks().length);
		assertEquals(stateBeforeBouncePowerUpBlock.getBalls()[0].getClass().toString(),"class breakout.SuperChargedBall");
		assertEquals(new Vector(0, -5), stateBeforeBouncePowerUpBlock.getBalls()[0].getVelocity()); //velocity changes at the first hit.
		
		//After tick 200 times, the ball hits the game field top and bounce back.
		for (int i =0; i<=200; i++) {
			stateBeforeBouncePowerUpBlock.tick(1, 1);
		}
		assertEquals(new Vector(0, 5), stateBeforeBouncePowerUpBlock.getBalls()[0].getVelocity());
		
		for (int i =0; i<=250; i++) {
			stateBeforeBouncePowerUpBlock.tick(1, 1);
		}
		
		//and hit the normal block.
		assertEquals(0, stateBeforeBouncePowerUpBlock.getBlocks().length); //The normal block is hit.
		assertEquals(new Vector(0, 5), stateBeforeBouncePowerUpBlock.getBalls()[0].getVelocity()); //The velocity doesn't change.
		
		
		
	}
	
	
	@Test
	void testTickBounceReplicationBlock() {
		stateBeforeBounceReplicationBlock.tick(1, 1);
		assertEquals(1, stateBeforeBounceReplicationBlock.getBalls().length);
		assertEquals(0, stateBeforeBounceReplicationBlock.getBlocks().length);
		assertEquals(new Vector(0, -5), stateBeforeBounceReplicationBlock.getBalls()[0].getVelocity());
		assertEquals(stateBeforeBounceReplicationBlock.getPaddle().getClass().toString(),"class breakout.ReplicatorPaddle"); //create a replicator paddle 
		assertEquals(3,((ReplicatorPaddle) stateBeforeBounceReplicationBlock.getPaddle()).getReplicateTimes());
		

		//The ball hits the replicator paddle and then creates 3 additional balls with respective velocity
		for (int i =0; i<=500; i++) {
			stateBeforeBounceReplicationBlock.tick(1, 1);
		}
		assertEquals(4, stateBeforeBounceReplicationBlock.getBalls().length);
		assertEquals(new Vector(2, -5), stateBeforeBounceReplicationBlock.getBalls()[0].getVelocity());
		assertEquals(stateBeforeBounceReplicationBlock.getBalls()[0].getVelocity().plus(new Vector(2, -2)), stateBeforeBounceReplicationBlock.getBalls()[1].getVelocity());
		assertEquals(stateBeforeBounceReplicationBlock.getBalls()[0].getVelocity().plus(new Vector(-2, 2)), stateBeforeBounceReplicationBlock.getBalls()[2].getVelocity());
		assertEquals(stateBeforeBounceReplicationBlock.getBalls()[0].getVelocity().plus(new Vector(2, 2)), stateBeforeBounceReplicationBlock.getBalls()[3].getVelocity());
		
		//The paddle's ReplicateTimes minus one
		assertEquals(2,((ReplicatorPaddle) stateBeforeBounceReplicationBlock.getPaddle()).getReplicateTimes()); 
		
		
		for (int i =0; i<=500; i++) {
			stateBeforeBounceReplicationBlock.tick(1, 1);
		}
		//The paddle's ReplicateTimes minus one
		assertEquals(1,((ReplicatorPaddle) stateBeforeBounceReplicationBlock.getPaddle()).getReplicateTimes());
		
		
		for (int i =0; i<=500; i++) {
			stateBeforeBounceReplicationBlock.tick(1, 1);
		}
		
		
		// The paddle change back to normal paddle after hit 3 times
		assertEquals(stateBeforeBounceReplicationBlock.getPaddle().getClass().toString(),"class breakout.NormalPaddle");   
		
	}

	////////

	@Test
	void testTickSuperBallBounceNormalBlock() { // same velocity, destroyed block
		stateBeforeBounceNormalBlock2.tick(1, 1);
		assertEquals(1, stateBeforeBounceNormalBlock2.getBalls().length);
		assertEquals(0, stateBeforeBounceNormalBlock2.getBlocks().length);
		assertEquals(new Vector(0, 5), stateBeforeBounceNormalBlock2.getBalls()[0].getVelocity());// (0,-5)?
	}
	
	
	@Test
	void testTickSuperBallBounceSturdyBlock() { // bounce back, block remain 2 time
		assertEquals(3,((SturdyBlock) stateBeforeBounceSturdyBlock2.getBlocks()[0]).getHitTimes());
		stateBeforeBounceSturdyBlock2.tick(1, 1);
		assertEquals(1, stateBeforeBounceSturdyBlock2.getBalls().length);
		assertEquals(1, stateBeforeBounceSturdyBlock2.getBlocks().length); //block is still there.
		assertEquals(2,((SturdyBlock) stateBeforeBounceSturdyBlock2.getBlocks()[0]).getHitTimes()); // HitTimes minus 1
		assertEquals(new Vector(0, -5), stateBeforeBounceSturdyBlock2.getBalls()[0].getVelocity());
		
	}
	
	@Test
	void testTickSuperBallBouncePowerUpBlock() { // same velocity, destroyed block
		stateBeforeBouncePowerUpBlock2.tick(1, 1);
		assertEquals(1, stateBeforeBouncePowerUpBlock2.getBalls().length);
		assertEquals(0, stateBeforeBouncePowerUpBlock2.getBlocks().length);
		assertEquals(stateBeforeBouncePowerUpBlock2.getBalls()[0].getClass().toString(),"class breakout.SuperChargedBall"); 
//		assertEquals(new Vector(0, 5), stateBeforeBouncePowerUpBlock2.getBalls()[0].getVelocity()); //(0-5)?
		
	}
	
	
	
	@Test
	void testTickSuperBallBounceReplicationBlock() { // same velocity, destroyed block, replicatorPaddle
		stateBeforeBounceReplicationBlock2.tick(1, 1);
		assertEquals(1, stateBeforeBounceReplicationBlock2.getBalls().length);
		assertEquals(0, stateBeforeBounceReplicationBlock2.getBlocks().length);
//		assertEquals(new Vector(0, 5), stateBeforeBounceReplicationBlock2.getBalls()[0].getVelocity());//(0-5)?
		assertEquals(stateBeforeBounceReplicationBlock2.getPaddle().getClass().toString(),"class breakout.ReplicatorPaddle"); //create a replicator paddle 
		assertEquals(3,((ReplicatorPaddle) stateBeforeBounceReplicationBlock2.getPaddle()).getReplicateTimes());
		

		//The ball hits the replicator paddle and then creates 3 additional balls with respective velocity
		for (int i =0; i<=500; i++) {
			stateBeforeBounceReplicationBlock2.tick(1, 1);
		}
		assertEquals(4, stateBeforeBounceReplicationBlock2.getBalls().length);
		assertEquals(new Vector(2, -5), stateBeforeBounceReplicationBlock2.getBalls()[0].getVelocity());
		assertEquals(stateBeforeBounceReplicationBlock2.getBalls()[0].getVelocity().plus(new Vector(2, -2)), stateBeforeBounceReplicationBlock2.getBalls()[1].getVelocity());
		assertEquals(stateBeforeBounceReplicationBlock2.getBalls()[0].getVelocity().plus(new Vector(-2, 2)), stateBeforeBounceReplicationBlock2.getBalls()[2].getVelocity());
		assertEquals(stateBeforeBounceReplicationBlock2.getBalls()[0].getVelocity().plus(new Vector(2, 2)), stateBeforeBounceReplicationBlock2.getBalls()[3].getVelocity());
		
		//The paddle's ReplicateTimes minus one
		assertEquals(2,((ReplicatorPaddle) stateBeforeBounceReplicationBlock2.getPaddle()).getReplicateTimes()); 
		
		
		for (int i =0; i<=500; i++) {
			stateBeforeBounceReplicationBlock2.tick(1, 1);
		}
		//The paddle's ReplicateTimes minus one
		assertEquals(1,((ReplicatorPaddle) stateBeforeBounceReplicationBlock2.getPaddle()).getReplicateTimes());
		
		
		for (int i =0; i<=500; i++) {
			stateBeforeBounceReplicationBlock2.tick(1, 1);
		}
		
		
		//The paddle change back to normal paddle after hit 3 times
		assertEquals(stateBeforeBounceReplicationBlock2.getPaddle().getClass().toString(),"class breakout.NormalPaddle");   

		
		
	}
	
	
	
	

	@Test
	void testTickBounceBlock() {                 
		BlockState block2 = facade.createPowerupBallBlockState(new Point(0, 1051), new Point(2000, 1200));
		BlockState block3 = facade.createNormalBlockState(new Point(0, 849), new Point(2000, 949));
		BlockState[] oneBlock2 = new BlockState[] { block2, block3 };
		BreakoutState stateBeforeBounceBlock2 = facade.createBreakoutState(normalBalls, oneBlock2, bottomRight, normalPaddle);
		stateBeforeBounceBlock2.tick(1, 1);
		assertEquals(1, stateBeforeBounceBlock2.getBalls().length);
		assertEquals(1, stateBeforeBounceBlock2.getBlocks().length);
		stateBeforeBounceBlock2.tick(1, 1);
		stateBeforeBounceBlock2.tick(1, 1);
		assertEquals(1, stateBeforeBounceBlock2.getBalls().length);
		assertEquals(0, stateBeforeBounceBlock2.getBlocks().length);
		assertEquals(new Vector(0, -5), stateBeforeBounceBlock2.getBalls()[0].getVelocity());
	}
	
	

}
