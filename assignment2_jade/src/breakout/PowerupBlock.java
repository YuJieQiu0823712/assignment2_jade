package breakout;

import java.awt.Color;

import breakout.basics.Rect;
import breakout.basics.Vector;

public class PowerupBlock extends BlockState{

	
	/**
	 * Construct a PowerupBlock with the given location.
	 * @pre | location != null
	 * @post | getLocation().equals(location)
	 */
	public PowerupBlock(Rect location) {
		super(location);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Return the color of this block.
	 * @post | result.equals(new Color(255,255,0))
	 * @creates result //?
	 */
	@Override
	public Color pointBlock() {
		return new Color(255,255,0);
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
	 * Return whether this PowerupBlock is reflect.
	 * @post | result == false
	 */
	@Override
	protected boolean reflect() {
		return false;
	}

	/**
	 * Return whether this PowerupBlock is charged.
	 * @post | result == true
	 */
	@Override
	protected boolean charged() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Return whether this PowerupBlock represents a same content with the obj.
	 * @pre | obj!=null
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof PowerupBlock pblock &&
				pblock.getLocation().equals(this.getLocation());
	}

}
