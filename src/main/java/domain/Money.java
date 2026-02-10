package domain;

public class Money {

	private final boolean isPositive;
	
	public Money(
			final boolean isPositive) {
		this.isPositive = isPositive;
	}
	
	public boolean isPositive() {
		return isPositive;
	}
	
}
