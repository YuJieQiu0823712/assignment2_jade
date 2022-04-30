package breakout;

import java.awt.Color;

import javax.swing.RepaintManager;

public interface Colors {
	
	public default Color pointBall() {
		return new Color(255,102,0);
	}
	
	public default Color pointBlock() {
		return new Color(0,0,255);
	}
	
	public default Color pointPaddle() {
		return new Color(0,255,51);
	}
	
//	public default Color Repaint(Color newColor) {
//		return newColor;
//	}

}
