package breakout;

import java.awt.Color;

import breakout.basics.Rect;

/**
 * Represents the state of a block in the breakout game.
 * @immutable
 */
public class ReplicationBlock extends BlockState {
	
	/**
	 * Construct a ReplicationBlock with the given location.
	 * @pre | location != null
	 * @post | getLocation().equals(location)
	 */
	public ReplicationBlock(Rect location) {
		super(location);
	}

	/**
	 * Return the color of this ReplicationBlock.
	 * @post | result.equals(new Color(102,0,153))
	 * @creates | result 
	 */
	@Override
	public Color pointBlock() {
		return new Color(102,0,153);
	}

	/**
	 * Return NewBlock.
	 * @post | result == null
	 */
	@Override
	public BlockState returnNewBlock(Rect location) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Return whether this ReplicationBlock is reflect.
	 */
	@Override
	public boolean reflect() {
		return false;
	}

	/**
	 * Return whether this ReplicationBlock is charged.
	 */
	@Override
	public boolean charged() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Return whether this ReplicationBlock replicates Ball.
	 */
	@Override
	public boolean replicateBall() {
		return true;
	}
	
	/**
	 * Return whether this ReplicationBlock represents a same content with the obj.
	 * @pre | obj!=null
	 * @post | obj instanceof ReplicationBlock rblock &&
	 *       | rblock.getLocation().equals(this.getLocation())
	 *   
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof ReplicationBlock rblock &&
				rblock.getLocation().equals(this.getLocation());
	}



	
	
	

}