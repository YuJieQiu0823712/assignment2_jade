package breakout;

import java.awt.Color;

import breakout.basics.Rect;
import breakout.basics.Vector;

public class ReplicationBlock extends BlockState {
	

	public ReplicationBlock(Rect location) {
		super(location);
	}

	@Override
	public Color pointBlock() {
		return new Color(102,0,153);
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
		return false;
	}
	
	@Override
	protected boolean replicateBall() {
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof ReplicationBlock rblock &&
				rblock.getLocation().equals(this.getLocation());
	}

	
	
	

}
