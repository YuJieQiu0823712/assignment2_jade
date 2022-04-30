package breakout;

import java.awt.Color;

import breakout.basics.Rect;
import breakout.basics.Vector;

public class SturdyBlock extends BlockState{

	private int hitTimes;

	public int getHitTimes() {
		return hitTimes;
	}

	public SturdyBlock(Rect location,int hitTimes) {
		super(location);
		this.hitTimes = hitTimes;
	}

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


	@Override
	protected BlockState returnNewBlock(Rect location) {
		if(hitTimes > 1) {
			return new SturdyBlock(location,hitTimes-1);
		} else {
			return null;
		}

	}

	@Override
	protected boolean reflect() {
		if (hitTimes>1) {
		return true;
		} else {
			return false;
		}
		
	}

	@Override
	protected boolean charged() {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof SturdyBlock sblock &&
				sblock.getLocation().equals(this.getLocation());
	}
	
	@Override
	public String toString() {
		return this.getLocation().toString();
	}




}
