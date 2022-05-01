package breakout;

import java.awt.Color;

import breakout.basics.Rect;
import breakout.basics.Vector;

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
	 * @creates result //?
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
	protected BlockState returnNewBlock(Rect location) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Return whether this ReplicationBlock is reflect.
	 * @post | result == false
	 */
	@Override
	protected boolean reflect() {
		return false;
	}

	/**
	 * Return whether this ReplicationBlock is charged.
	 * @post | result == false
	 */
	@Override
	protected boolean charged() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Return whether this ReplicationBlock replicates Ball.
	 * @post | result == true
	 */
	@Override
	protected boolean replicateBall() {
		return true;
	}
	
	/**
	 * Return whether this ReplicationBlock represents a same content with the obj.
	 * @pre | obj!=null
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof ReplicationBlock rblock &&
				rblock.getLocation().equals(this.getLocation());
	}

	
	
	

}
