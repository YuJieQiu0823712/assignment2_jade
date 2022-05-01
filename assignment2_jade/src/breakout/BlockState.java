package breakout;

import java.awt.Color;

import breakout.basics.Point;
import breakout.basics.Rect;

/**
 * Represents the state of a block in the breakout game.
 *
 * @immutable
 * @invar | getLocation() != null
 */
public abstract class BlockState implements Colors{
	
	/**
	 * @invar | location != null
	 */
	private final Rect location;


	/**
	 * Construct a block occupying a given rectangle in the field.
	 * @pre | location != null
	 * @post | getLocation().equals(location)
	 */
	public BlockState(Rect location) {
		this.location = location;
	}

	/**
	 * Return the rectangle occupied by this block in the field.
	 */
	public Rect getLocation() {
		return location;
	}

	/**
	 * Return NewBlock.
	 */
	
	protected abstract BlockState returnNewBlock(Rect location);
	
	/**
	 * Return whether this Block is reflect.
	 */
	protected abstract boolean reflect();
	
	/**
	 * Return whether this Block is charged.
	 */
	protected abstract boolean charged();
	
	/**
	 * Return whether this ball is replicated by this block.
	 * @post | result == false
	 */
	protected boolean replicateBall() {
		return false;
	}
	
	
	
	
}
