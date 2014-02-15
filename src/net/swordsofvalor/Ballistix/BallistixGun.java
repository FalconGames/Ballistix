package net.swordsofvalor.Ballistix;

public class BallistixGun {
	
	private String name;
	private String ammoType;
	private int ammoAmount;
	
	public BallistixGun(String name, String ammoType, int ammoAmount) {
		this.name = name;
		this.ammoType = ammoType;
		this.ammoAmount = ammoAmount;
	}
	
	public BallistixGun(String name) {
		this(name, null, 0);
	}
	
	public String getName() {
		return name;
	}
	
	public String getAmmoType() {
		return ammoType;
	}
	
	public int ammoAmount() {
		return ammoAmount;
	}
}
