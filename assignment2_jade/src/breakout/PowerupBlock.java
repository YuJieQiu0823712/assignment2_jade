package breakout;

import java.awt.Color;

import breakout.basics.Rect;

/**
 * Represents the state of a block in the breakout game.
 * @immutable
 */
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
	 * @creates | result 
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
	public BlockState returnNewBlock(Rect location) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * Return whether this PowerupBlock is reflect.
	 */
	@Override
	public boolean reflect() {
		
		return false;
	}

	/**
	 * Return whether this PowerupBlock is charged.
	 */
	@Override
	public boolean charged() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * Return whether this PowerupBlock represents a same content with the obj.
	 * @pre | obj!=null
//	 * @post | obj instanceof PowerupBlock pblock &&
//	 *       | pblock.getLocation().equals(this.getLocation())
	 *   
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof PowerupBlock pblock &&
				pblock.getLocation().equals(this.getLocation());
	}

}