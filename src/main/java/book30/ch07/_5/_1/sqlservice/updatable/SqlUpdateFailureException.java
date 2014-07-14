package book30.ch07._5._1.sqlservice.updatable;

public class SqlUpdateFailureException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4765907612657180326L;

	public SqlUpdateFailureException() {
		super();
	}

	public SqlUpdateFailureException(String message) {
		super(message);
	}
}
