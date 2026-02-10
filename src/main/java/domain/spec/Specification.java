package domain.spec;

@FunctionalInterface
public interface Specification<T> {

	boolean isSatisfiedBy(T candidate);
	
	default Specification<T> and(
			final Specification<T> other) {
		return candidate -> 
			this.isSatisfiedBy(candidate) && 
			other.isSatisfiedBy(candidate);
	}
	
	default Specification<T> or(
			final Specification<T> other) {
		return candidate -> 
			this.isSatisfiedBy(candidate) || 
			other.isSatisfiedBy(candidate);
	}
	
	default Specification<T> not() {
		return candidate -> !this.isSatisfiedBy(candidate);
	}

}
