package breakout;

import java.awt.Color;
import java.util.Arrays;

import breakout.basics.Point;
import breakout.basics.Rect;
import breakout.basics.Vector;

public class SturdyBlock extends BlockState{

	
	/**
	 * 
	 * @invar | hitTimes>=0 && hitTimes<=3
	 */
	private int hitTimes;

	/**
	 * Return the HitTimes of this SturdyBlock. 
	 * @post | result==getHitTimes() //error
	 */
	public int getHitTimes() { //error
		return hitTimes; //error
	}

	/**
	 * Construct a SturdyBlock with the given location and hitTimes.
	 * @pre | location != null
	 * @pre | hitTimes>=0 && hitTimes<=3
	 * @post | getLocation().equals(location)
	 * @post | getHitTimes()==hitTimes
	 */
	public SturdyBlock(Rect location,int hitTimes) {
		super(location);
		this.hitTimes = hitTimes;
	}

	/**
	 * Return the color of this SturdyBlock.
	 * @post | result.equals(new Color(102,102,102)) ||
	 *       | result.equals(new Color(51,51,51)) ||
	 *       | result.equals(new Color(153,153,153))
	 * @creates result //?
	 */
	@Override
	public Color pointBlock() {
		if (hitTimes == 2) {
			return new Color(102,102,102);
		}
		else if (hitTimes == 1) {
			return new Color(51,51,51);
		} else {
			return new Color(153,153,153);
		}
	}

	/**
	 * Return NewBlock.
	 * @post | result == null ||
	 *       | result.equals(new SturdyBlock(location,getHitTimes()-1))
	 */
	@Override
	protected BlockState returnNewBlock(Rect location) {
		if(hitTimes > 1) {
			return new SturdyBlock(location,hitTimes-1);
		} else {
			return null;
		}


	}

	/**
	 * Return whether this SturdyBlock is reflect.
	 * @post | result == false
	 */
	@Override
	protected boolean reflect() {
		if (hitTimes>1) {
		return true;
		} else {
			return false;
		}
		
	}

	/**
	 * Return whether this SturdyBlock is charged.
	 * @post | result == false
	 */
	@Override
	protected boolean charged() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Return whether this SturdyBlock represents a same content with the obj.
	 * @pre | obj!=null
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof SturdyBlock sblock &&
				sblock.getLocation().equals(this.getLocation());
	}
	
	/**
	 * Return a string representation of this Location.
	 * @post | result != null
	 */
	@Override
	public String toString() {
		return this.getLocation().toString();
	}




}
