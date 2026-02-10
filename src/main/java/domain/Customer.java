package domain;

public class Customer {

	private boolean blocked;
	
	public Customer(
			final boolean blocked) {
		this.blocked = blocked;
	}
	
	public boolean isBlocked() {
		return blocked;
	}
	
}
