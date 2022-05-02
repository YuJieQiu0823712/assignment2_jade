package breakout;

import java.awt.Color;

import javax.swing.RepaintManager;

/**
 * 
 * @invar | pointBall() != null
 * @invar | pointBlock() != null
 * @invar | pointPaddle() != null
 */

public interface Colors {
	
	/**
	 * 
	 * @inspects | this
	 * @creates | result
	 * @post | result != null
	 */
	
	public default Color pointBall() {
		return new Color(255,102,0);
	}
	
	/**
	 * 
	 * @inspects | this
	 * @creates | result
	 * @post | result != null
	 */
	
	public default Color pointBlock() {
		return new Color(0,0,255);
	}
	
	/**
	 * 
	 * @inspects | this
	 * @creates | result
	 * @post | result != null
	 */
	
	public default Color pointPaddle() {
		return new Color(0,255,51);
	}
	

}
