package breakout;

import java.awt.Color;

import breakout.basics.Rect;
import breakout.basics.Vector;

public class PowerupBlock extends BlockState{

	public PowerupBlock(Rect location) {
		super(location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color pointBlock() {
		return new Color(255,255,0);
	}

	@Override
	protected BlockState returnNewBlock(Rect location) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected boolean reflect() {
		return false;
	}

	@Override
	protected boolean charged() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof PowerupBlock pblock &&
				pblock.getLocation().equals(this.getLocation());
	}

}
