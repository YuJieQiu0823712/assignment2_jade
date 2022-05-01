package breakout;

import java.awt.Color;

import breakout.basics.Rect;
import breakout.basics.Vector;

public class NormalBlock extends BlockState{

	/**
	 * Construct a NormalBlock with the given location.
	 * @pre | location != null
	 * @post | getLocation().equals(location)
	 */
	public NormalBlock(Rect location) {
		super(location);
	}

	/**
	 * Return NewBlock.
	 * @post | result == null
	 */
	@Override
	protected BlockState returnNewBlock(Rect location) {
		return null;
	}

	/**
	 * Return whether this NormalBlock is reflect.
	 * @post | result == false
	 */
	@Override
	protected boolean reflect() {
		return false;
	}

	/**
	 * Return whether this NormalBlock is charged.
	 * @post | result == false
	 */
	@Override
	protected boolean charged() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Return whether this NormalBlock represents a same content with the obj.
	 * @pre | obj!=null
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof NormalBlock nblock &&
				nblock.getLocation().equals(this.getLocation());
	}





}
