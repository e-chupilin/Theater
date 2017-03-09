package by.gsu.epamlab.model.beans;
import static by.gsu.epamlab.model.ConstantsModel.*;

public enum Category {
	VIP(VIP_RATE_PERCENT),PARTERRE(PARTERRE_RATE_PERCENT),BALCONY(BALCONY_RATE_PERCENT);
	
	private int ratePercent;
	
	private Category(int ratePercent) {
		this.ratePercent = ratePercent;		
	}
	
	public int getFullCost(int cost) {
		return (int) Math.ceil(cost * (HUNDRED_PERCENT + ratePercent) / 1000) * 10;		
	}	
}
