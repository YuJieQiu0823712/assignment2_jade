package breakout;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import breakout.basics.Circle;
import breakout.basics.Point;
import breakout.basics.Vector;


public class AllTests {

	private Ball normalBall;
	private Ball superChargedBall;
	
	private Ball normalBall1;
	private Ball normalBall2;
	private Ball normalBall3;
	private Ball normalBall4;
	private Ball superBall1;
	private Ball superBall2;
	private Ball superBall3;
	private Ball superBall4;
	
	private Ball[] normalBalls;
	private Ball[] superChargedBalls;
	
	private Ball[] normalBalls1;
	private Ball[] normalBalls2;
	private Ball[] normalBalls3;
	private Ball[] normalBalls4;
	
	private Ball[] superBalls1;
	private Ball[] superBalls2;
	private Ball[] superBalls3;
	private Ball[] superBalls4;

	private BlockState normalBlock;
	private BlockState sturdyBlock;
	private BlockState powerUpBlock;
	private BlockState replicationBlock;
	
	private BlockState normalBlock1;
	private BlockState sturdyBlock2;
	private BlockState replicationBlock4;;
	
	private BlockState powerUpBlock1;
	private BlockState powerUpBlock2;
	private BlockState powerUpBlock3;
	private BlockState powerUpBlock4;
	private BlockState powerUpBlock5;

	private BlockState[] normalBlocks;
	private BlockState[] sturdyBlocks;
	private BlockState[] powerUpBlocks;
	private BlockState[] ReplicationBlocks;
	
	private BlockState[] normalBlocks1;
	private BlockState[] sturdyBlocks2;
	private BlockState[] powerUpBlocks3;
	private BlockState[] replicationBlocks4;
	
	private BlockState[] powerUpBlocksN;
	private BlockState[] powerUpBlocksS;
	private BlockState[] powerUpBlocksP;
	private BlockState[] powerUpBlocksR;

	private Point bottomRight;
	private PaddleState normalPaddle;
	private PaddleState replicatorPaddle;

	private BreakoutState stateBeforeBounceNormalBlock;
	private BreakoutState stateBeforeBounceSturdyBlock;
	private BreakoutState stateBeforeBouncePowerUpBlock;
	private BreakoutState stateBeforeBounceReplicationBlock;
	
	
	private BreakoutState stateBeforeBounceNormalBlock1;
	private BreakoutState stateBeforeBounceSturdyBlock2;
	private BreakoutState stateBeforeBouncePowerUpBlock3;
	private BreakoutState stateBeforeBounceReplicationBlock4;

//	private BreakoutState stateBeforeBounceNormalBlock2;
//	private BreakoutState stateBeforeBounceSturdyBlock2;
//	private BreakoutState stateBeforeBouncePowerUpBlock2;
//	private BreakoutState stateBeforeBounceReplicationBlock2;

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


	/////////
//@BeforeEach
//void setUp2() throws Exception {
//	//superchargedBall hits a normalBlock
//	normalBall1 = facade.createNormalBall(new Point(1000, 1000), 100, new Vector(0, 5));
//	normalBalls1 = new Ball[] { normalBall1 };
//	powerUpBlock1 = facade.createPowerupBallBlockState(new Point(0, 1051), new Point(2000, 1200));
//	normalBlock1 = facade.createNormalBlockState(new Point(0, 1051+149), new Point(2000,1200+149));
//	powerUpBlocksN = new BlockState[] { powerUpBlock1,normalBlock1 };
//	bottomRight = new Point(10000, 2000);
//	normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
//	stateBeforeBounceNormalBlock1 = facade.createBreakoutState(normalBalls1, powerUpBlocksN, bottomRight, normalPaddle);
//
//	//superchargedBall hits a sturdyBlock
//	normalBall2 = facade.createNormalBall(new Point(1000, 1000), 100, new Vector(0, 5));
//	normalBalls2 = new Ball[] { normalBall2 };
//	powerUpBlock2 = facade.createPowerupBallBlockState(new Point(0, 1051), new Point(2000, 1200));
//	sturdyBlock2 = facade.createSturdyBlockState(new Point(0, 1051+149), new Point(2000,1200+149),3);
//	powerUpBlocksS = new BlockState[] { powerUpBlock2,sturdyBlock2 };
//	bottomRight = new Point(10000, 2000);
//	normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
//	stateBeforeBounceSturdyBlock2 = facade.createBreakoutState(normalBalls2, powerUpBlocksS, bottomRight, normalPaddle);
//
//	//superchargedBall hits a powerUpBlock
//	normalBall3 = facade.createNormalBall(new Point(1000, 1000), 100, new Vector(0, 5));
//	normalBalls3 = new Ball[] { normalBall3 };
//	powerUpBlock3 = facade.createPowerupBallBlockState(new Point(0, 1051), new Point(2000, 1200));
//	powerUpBlock4 = facade.createPowerupBallBlockState(new Point(0, 1051+149), new Point(2000,1200+149));
//	powerUpBlocksP = new BlockState[] { powerUpBlock3,powerUpBlock4 };
//	bottomRight = new Point(10000, 2000);
//	normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
//	stateBeforeBouncePowerUpBlock3 = facade.createBreakoutState(normalBalls3, powerUpBlocksP, bottomRight, normalPaddle);
//
//	//superchargedBall hits a replicationBlock
//	superBall4 = facade.createSuperchargedBall(new Point(1000, 1000), 100, new Vector(0, 5),(int)System.currentTimeMillis());
//	superBalls4 = new Ball[] { superBall4 };
//	replicationBlock4 = facade.createReplicatorBlockState(new Point(0, 1051), new Point(2000,1200));
//	powerUpBlocksR = new BlockState[] {replicationBlock4};
//	bottomRight = new Point(10000, 2000);
//	normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
//	stateBeforeBounceReplicationBlock4 = facade.createBreakoutState(superBalls4, powerUpBlocksR, bottomRight, normalPaddle);
//
//}

//	@Test
//	void testTickBounceNormalBlock1() { // same velocity, destroyed block
//		assertEquals(new Color(255,102,0),stateBeforeBounceNormalBlock1.getBalls()[0].pointBall()); // normalBall
//		assertEquals(new Vector(0, 5), stateBeforeBounceNormalBlock1.getBalls()[0].getVelocity()); 
//		
//		stateBeforeBounceNormalBlock1.tick(1, 1);
//		assertEquals(1, stateBeforeBounceNormalBlock1.getBalls().length);
//		assertEquals(1, stateBeforeBounceNormalBlock1.getBlocks().length);
//		assertEquals(stateBeforeBounceNormalBlock1.getBalls()[0].getClass().toString(),"class breakout.SuperChargedBall");
//		assertEquals(new Vector(0, -5), stateBeforeBounceNormalBlock1.getBalls()[0].getVelocity()); //velocity changes at the first hit.
//		assertEquals(new Color(255,255,0),stateBeforeBounceNormalBlock1.getBalls()[0].pointBall()); 
//
//		
//		//After tick 200 times, the ball hits the game field top and bounce back.
//		for (int i =0; i<=200; i++) {
//			stateBeforeBounceNormalBlock1.tick(1, 1);
//		}
//		assertEquals(new Vector(0, 5), stateBeforeBounceNormalBlock1.getBalls()[0].getVelocity());
//		
//		for (int i =0; i<=250; i++) {
//			stateBeforeBounceNormalBlock1.tick(1, 1);
//		}
//		
//		//and hit the normal block.
//		assertEquals(0, stateBeforeBounceNormalBlock1.getBlocks().length); //The normal block is hit.
//		assertEquals(new Vector(0, 5), stateBeforeBounceNormalBlock1.getBalls()[0].getVelocity()); //The velocity doesn't change.
//		
//		
//	}
//	
//	
//	@Test
//	void testTickBounceSturdyBlock2() { // bounce back, block remain 2 time
//		assertEquals(new Color(255,102,0),stateBeforeBounceSturdyBlock2.getBalls()[0].pointBall()); // normalBall
//		assertEquals(new Vector(0, 5), stateBeforeBounceSturdyBlock2.getBalls()[0].getVelocity()); 
//		
//		stateBeforeBounceSturdyBlock2.tick(1, 1);
//		assertEquals(1, stateBeforeBounceSturdyBlock2.getBalls().length);
//		assertEquals(1, stateBeforeBounceSturdyBlock2.getBlocks().length);
//		assertEquals(stateBeforeBounceSturdyBlock2.getBalls()[0].getClass().toString(),"class breakout.SuperChargedBall");
//		assertEquals(new Vector(0, -5), stateBeforeBounceSturdyBlock2.getBalls()[0].getVelocity()); //velocity changes at the first hit.
//		assertEquals(new Color(255,255,0),stateBeforeBounceSturdyBlock2.getBalls()[0].pointBall()); 
//
//		
//		//After tick 200 times, the ball hits the game field top and bounce back.
//		for (int i =0; i<=200; i++) {
//			stateBeforeBounceSturdyBlock2.tick(1, 1);
//		}
//		assertEquals(new Vector(0, 5), stateBeforeBounceSturdyBlock2.getBalls()[0].getVelocity());
//		assertEquals(3,((SturdyBlock) stateBeforeBounceSturdyBlock2.getBlocks()[0]).getHitTimes());
//		
//		for (int i =0; i<=250; i++) {
//			stateBeforeBounceSturdyBlock2.tick(1, 1);
//		}
//		
//		//and hit the sturdy block.
//		assertEquals(1, stateBeforeBounceSturdyBlock2.getBlocks().length); //The sturdy block is hit and still there.
//		assertEquals(2,((SturdyBlock) stateBeforeBounceSturdyBlock2.getBlocks()[0]).getHitTimes()); // HitTimes minus 1
//		assertEquals(new Vector(0, -5), stateBeforeBounceSturdyBlock2.getBalls()[0].getVelocity()); //The velocity changes.
//		assertEquals(new Color(255,255,0),stateBeforeBounceSturdyBlock2.getBalls()[0].pointBall());
//		
//	}
//	
//	@Test
//	void testTickBouncePowerUpBlock2() { // same velocity, destroyed block
//		assertEquals(new Color(255,102,0),stateBeforeBouncePowerUpBlock3.getBalls()[0].pointBall()); // normalBall
//		assertEquals(new Vector(0, 5), stateBeforeBouncePowerUpBlock3.getBalls()[0].getVelocity()); 
//		
//		stateBeforeBouncePowerUpBlock3.tick(1, 1);
//		assertEquals(1, stateBeforeBouncePowerUpBlock3.getBalls().length);
//		assertEquals(1, stateBeforeBouncePowerUpBlock3.getBlocks().length);
//		assertEquals(stateBeforeBouncePowerUpBlock3.getBalls()[0].getClass().toString(),"class breakout.SuperChargedBall");
//		assertEquals(new Vector(0, -5), stateBeforeBouncePowerUpBlock3.getBalls()[0].getVelocity()); //velocity changes at the first hit.
//		assertEquals(new Color(255,255,0),stateBeforeBouncePowerUpBlock3.getBalls()[0].pointBall()); 
//
//		
//		//After tick 200 times, the ball hits the game field top and bounce back.
//		for (int i =0; i<=200; i++) {
//			stateBeforeBouncePowerUpBlock3.tick(1, 1);
//		}
//		assertEquals(new Vector(0, 5), stateBeforeBouncePowerUpBlock3.getBalls()[0].getVelocity());
//		
//		
//		for (int i =0; i<=250; i++) {
//			stateBeforeBouncePowerUpBlock3.tick(1, 1);
//		}
//		
//		//and hit the powerUp block.
//		assertEquals(0, stateBeforeBouncePowerUpBlock3.getBlocks().length); //The powerUp block is destroyed.
//		
//		assertEquals(new Vector(0, 5), stateBeforeBouncePowerUpBlock3.getBalls()[0].getVelocity()); //The velocity doesn't change.
//		assertEquals(new Color(255,255,0),stateBeforeBouncePowerUpBlock3.getBalls()[0].pointBall());
//	
//	}
//	
//	
//	
//	@Test
//	void testTickSuperBallBounceReplicationBlock() { // same velocity, destroyed block, replicatorPaddle
//		assertEquals(new Color(255,102,0),stateBeforeBounceReplicationBlock4.getBalls()[0].pointBall()); // normalBall
//		assertEquals(new Vector(0, 5), stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity()); 
//		
////		assertEquals(stateBeforeBounceReplicationBlock4.getBlocks().getClass().toString(),"class breakout.ReplicationBlock"); 
//		//[Lbreakout.BlockState; ? 
//		
//		stateBeforeBounceReplicationBlock4.tick(1, 1);
//		assertEquals(1, stateBeforeBounceReplicationBlock4.getBalls().length);
//		assertEquals(1, stateBeforeBounceReplicationBlock4.getBlocks().length);
//		assertEquals(stateBeforeBounceReplicationBlock4.getBalls()[0].getClass().toString(),"class breakout.SuperChargedBall");
//		assertEquals(new Vector(0, -5), stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity()); //velocity changes at the first hit.
//		assertEquals(new Color(255,255,0),stateBeforeBounceReplicationBlock4.getBalls()[0].pointBall()); 
//
//		
//		//After tick 200 times, the ball hits the game field top and bounce back.
//		for (int i =0; i<=200; i++) {
//			stateBeforeBounceReplicationBlock4.tick(1, 1);
//		}
//		assertEquals(new Vector(0, 5), stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity());
//		
//		for (int i =0; i<=250; i++) {
//			stateBeforeBounceReplicationBlock4.tick(1, 1);
//		}
//		
//		//and hit the replication block.
//		assertEquals(0, stateBeforeBounceReplicationBlock4.getBlocks().length);
////		assertEquals(stateBeforeBounceReplicationBlock4.getPaddle().getClass().toString(),"class breakout.ReplicatorPaddle"); //error
////		assertEquals(3,((ReplicatorPaddle) stateBeforeBounceReplicationBlock4.getPaddle()).getReplicateTimes()); //error
//		assertEquals(new Vector(0, 5), stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity()); //The velocity doesn't change.
//		assertEquals(new Color(255,255,0),stateBeforeBounceReplicationBlock4.getBalls()[0].pointBall());
//
//
//		//The ball hits the replicator paddle and then creates 3 additional balls with respective velocity
//		for (int i =0; i<=500; i++) {
//			stateBeforeBounceReplicationBlock4.tick(1, 1);
//		}
//		assertEquals(4, stateBeforeBounceReplicationBlock4.getBalls().length); //error
//		assertEquals(new Vector(2, -5), stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity());
//		assertEquals(stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity().plus(new Vector(2, -2)), stateBeforeBounceReplicationBlock4.getBalls()[1].getVelocity());
//		assertEquals(stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity().plus(new Vector(-2, 2)), stateBeforeBounceReplicationBlock4.getBalls()[2].getVelocity());
//		assertEquals(stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity().plus(new Vector(2, 2)), stateBeforeBounceReplicationBlock4.getBalls()[3].getVelocity());
//		
//		//The paddle's ReplicateTimes minus one
//		assertEquals(2,((ReplicatorPaddle) stateBeforeBounceReplicationBlock4.getPaddle()).getReplicateTimes()); 
//		
//		
//		for (int i =0; i<=500; i++) {
//			stateBeforeBounceReplicationBlock4.tick(1, 1);
//		}
//		//The paddle's ReplicateTimes minus one
//		assertEquals(1,((ReplicatorPaddle) stateBeforeBounceReplicationBlock4.getPaddle()).getReplicateTimes());
//		
//		
//		for (int i =0; i<=500; i++) {
//			stateBeforeBounceReplicationBlock4.tick(1, 1);
//		}
//		
//		
//		//The paddle change back to normal paddle after hit 3 times
//		assertEquals(stateBeforeBounceReplicationBlock4.getPaddle().getClass().toString(),"class breakout.NormalPaddle");   
//
//		
//	}

	


@BeforeEach
void setUp2() throws Exception {
	//superchargedBall hits a normalBlock
	superBall1 = facade.createSuperchargedBall(new Point(1000, 1000), 100, new Vector(0, 5),(int)System.currentTimeMillis());
	superBalls1 = new Ball[] { superBall1 };
	normalBlock1 = facade.createNormalBlockState(new Point(0, 1051), new Point(2000, 1200));
	normalBlocks1 = new BlockState[] { normalBlock1 };
	bottomRight = new Point(10000, 2000);
	normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
	stateBeforeBounceNormalBlock1 = facade.createBreakoutState(superBalls1, normalBlocks1, bottomRight, normalPaddle);

	//superchargedBall hits a sturdyBlock
	superBall2 = facade.createSuperchargedBall(new Point(1000, 1000), 100, new Vector(0, 5),(int)System.currentTimeMillis());
	superBalls2 = new Ball[] { superBall2 };
	sturdyBlock2 = facade.createSturdyBlockState(new Point(0, 1051), new Point(2000,1200),3);
	sturdyBlocks2 = new BlockState[] { sturdyBlock2 };
	bottomRight = new Point(10000, 2000);
	normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
	stateBeforeBounceSturdyBlock2 = facade.createBreakoutState(superBalls2, sturdyBlocks2, bottomRight, normalPaddle);

	//superchargedBall hits a powerUpBlock
	superBall3 = facade.createSuperchargedBall(new Point(1000, 1000), 100, new Vector(0, 5),(int)System.currentTimeMillis());
	superBalls3 = new Ball[] { superBall3 };
	powerUpBlock3 = facade.createPowerupBallBlockState(new Point(0, 1051), new Point(2000, 1200));
	powerUpBlocks3 = new BlockState[] { powerUpBlock3 };
	bottomRight = new Point(10000, 2000);
	normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
	stateBeforeBouncePowerUpBlock3 = facade.createBreakoutState(superBalls3, powerUpBlocks3, bottomRight, normalPaddle);

	
	//superchargedBall hits a replicationBlock
	superBall4 = facade.createSuperchargedBall(new Point(1000, 1000), 100, new Vector(0, 5),(int)System.currentTimeMillis());
	superBalls4 = new Ball[] { superBall4 };
	replicationBlock4 = facade.createReplicatorBlockState(new Point(0, 1051), new Point(2000,1200));
	replicationBlocks4 = new BlockState[] {replicationBlock4};
	bottomRight = new Point(10000, 2000);
	normalPaddle = facade.createNormalPaddleState(new Point(2000, 1750));
	stateBeforeBounceReplicationBlock4 = facade.createBreakoutState(superBalls4, replicationBlocks4, bottomRight, normalPaddle);
}

	
	
	@Test
	void testTickBounceNormalBlock2() { // same velocity, destroyed block
		assertEquals(new Vector(0, 5), stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity()); 
		assertEquals(stateBeforeBounceReplicationBlock4.getBalls()[0].getClass().toString(),"class breakout.SuperChargedBall");
		
		stateBeforeBounceNormalBlock1.tick(1, 1);
		assertEquals(1, stateBeforeBounceNormalBlock1.getBalls().length);
		assertEquals(0, stateBeforeBounceNormalBlock1.getBlocks().length);
		assertEquals(new Vector(0, 5), stateBeforeBounceNormalBlock1.getBalls()[0].getVelocity());
		assertEquals(new Color(255,255,0),stateBeforeBounceNormalBlock1.getBalls()[0].pointBall());
	}
	
	@Test
	void testTickBounceSturdyBlock2() { // bounce back, block remain 2 time
		assertEquals(new Vector(0, 5), stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity()); 
		assertEquals(stateBeforeBounceReplicationBlock4.getBalls()[0].getClass().toString(),"class breakout.SuperChargedBall");
		
		assertEquals(3,((SturdyBlock) stateBeforeBounceSturdyBlock2.getBlocks()[0]).getHitTimes());
		stateBeforeBounceSturdyBlock2.tick(1, 1);
		assertEquals(1, stateBeforeBounceSturdyBlock2.getBalls().length);
		assertEquals(1, stateBeforeBounceSturdyBlock2.getBlocks().length); //block is still there.
		assertEquals(2,((SturdyBlock) stateBeforeBounceSturdyBlock2.getBlocks()[0]).getHitTimes()); // HitTimes minus 1
		assertEquals(new Vector(0, -5), stateBeforeBounceSturdyBlock2.getBalls()[0].getVelocity());
		assertEquals(new Color(255,255,0),stateBeforeBounceSturdyBlock2.getBalls()[0].pointBall());//(255,102,0)?
	}
	
	@Test
	void testTickBouncePowerUpBlock2() { // same velocity, destroyed block
	
		assertEquals(new Vector(0, 5), stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity()); 
		assertEquals(stateBeforeBounceReplicationBlock4.getBalls()[0].getClass().toString(),"class breakout.SuperChargedBall");
		
		stateBeforeBouncePowerUpBlock3.tick(1, 1);
		assertEquals(1, stateBeforeBouncePowerUpBlock3.getBalls().length);
		assertEquals(0, stateBeforeBouncePowerUpBlock3.getBlocks().length);
		assertEquals(stateBeforeBouncePowerUpBlock3.getBalls()[0].getClass().toString(),"class breakout.SuperChargedBall"); 
		assertEquals(new Vector(0, 5), stateBeforeBouncePowerUpBlock3.getBalls()[0].getVelocity()); 
		assertEquals(new Color(255,255,0),stateBeforeBouncePowerUpBlock3.getBalls()[0].pointBall());
	}
	
	
	
	@Test
	void testTickBounceReplicationBlock2() { // same velocity, destroyed block, replicatorPaddle
		
		assertEquals(new Vector(0, 5), stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity()); 
		assertEquals(stateBeforeBounceReplicationBlock4.getBalls()[0].getClass().toString(),"class breakout.SuperChargedBall");
		
		stateBeforeBounceReplicationBlock4.tick(1, 1);
		assertEquals(1, stateBeforeBounceReplicationBlock4.getBalls().length);
		assertEquals(0, stateBeforeBounceReplicationBlock4.getBlocks().length);

		assertEquals(stateBeforeBounceReplicationBlock4.getBalls()[0].getClass().toString(),"class breakout.SuperChargedBall");
		assertEquals(stateBeforeBounceReplicationBlock4.getPaddle().getClass().toString(),"class breakout.ReplicatorPaddle");
		assertEquals(new Vector(0, 5), stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity()); //velocity changes at the first hit.
		assertEquals(new Color(255,255,0),stateBeforeBounceReplicationBlock4.getBalls()[0].pointBall()); 


		//After tick 200 times, the ball hits the replicator paddle and then creates 3 additional balls with respective velocity
		for (int i =0; i<=200; i++) {
			stateBeforeBounceReplicationBlock4.tick(1, 1);
		}
		
		assertEquals(4, stateBeforeBounceReplicationBlock4.getBalls().length);
		assertEquals(new Vector(2, -5), stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity());
		assertEquals(stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity().plus(new Vector(2, -2)), stateBeforeBounceReplicationBlock4.getBalls()[1].getVelocity());
		assertEquals(stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity().plus(new Vector(-2, 2)), stateBeforeBounceReplicationBlock4.getBalls()[2].getVelocity());
		assertEquals(stateBeforeBounceReplicationBlock4.getBalls()[0].getVelocity().plus(new Vector(2, 2)), stateBeforeBounceReplicationBlock4.getBalls()[3].getVelocity());
		
		assertEquals(new Color(255,255,0),stateBeforeBounceReplicationBlock4.getBalls()[0].pointBall());
	
		//The paddle's ReplicateTimes minus one
		assertEquals(2,((ReplicatorPaddle) stateBeforeBounceReplicationBlock4.getPaddle()).getReplicateTimes()); 
		
		
		for (int i =0; i<=400; i++) {
			stateBeforeBounceReplicationBlock4.tick(1, 1);
		}
		//The paddle's ReplicateTimes minus one
		assertEquals(1,((ReplicatorPaddle) stateBeforeBounceReplicationBlock4.getPaddle()).getReplicateTimes());
		
		
		for (int i =0; i<=600; i++) {
			stateBeforeBounceReplicationBlock4.tick(1, 1);
		}
		
		
		//The paddle change back to normal paddle after hit 3 times
		assertEquals(stateBeforeBounceReplicationBlock4.getPaddle().getClass().toString(),"class breakout.NormalPaddle");  
	}
	
	

//	@Test
//	void testTickBounceBlock() {                 
//		BlockState block2 = facade.createPowerupBallBlockState(new Point(0, 1051), new Point(2000, 1200));
//		BlockState block3 = facade.createNormalBlockState(new Point(0, 849), new Point(2000, 949));
//		BlockState[] oneBlock2 = new BlockState[] { block2, block3 };
//		BreakoutState stateBeforeBounceBlock2 = facade.createBreakoutState(normalBalls, oneBlock2, bottomRight, normalPaddle);
//		stateBeforeBounceBlock2.tick(1, 1);
//		assertEquals(1, stateBeforeBounceBlock2.getBalls().length);
//		assertEquals(1, stateBeforeBounceBlock2.getBlocks().length);
//		stateBeforeBounceBlock2.tick(1, 1);
//		stateBeforeBounceBlock2.tick(1, 1);
//		assertEquals(1, stateBeforeBounceBlock2.getBalls().length);
//		assertEquals(0, stateBeforeBounceBlock2.getBlocks().length);
//		assertEquals(new Vector(0, -5), stateBeforeBounceBlock2.getBalls()[0].getVelocity());
//	}
	
	

}
