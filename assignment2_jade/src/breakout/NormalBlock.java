package breakout;

import java.awt.Color;

import breakout.basics.Rect;
import breakout.basics.Vector;

public class NormalBlock extends BlockState{

	public NormalBlock(Rect location) {
		super(location);
	}

	@Override
	protected BlockState returnNewBlock(Rect location) {
		return null;
	}

	@Override
	protected boolean reflect() {
		return false;
	}

	@Override
	protected boolean charged() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof NormalBlock nblock &&
				nblock.getLocation().equals(this.getLocation());
	}





}
