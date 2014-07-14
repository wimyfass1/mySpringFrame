package book30.ch07._4._2.sqlservice;

public class SqlRetrievalFailureException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5762168757087101913L;

	public SqlRetrievalFailureException() {
		super();
	}

	public SqlRetrievalFailureException(String message) {
		super(message);
	}

	public SqlRetrievalFailureException(Throwable cause) {
		super(cause);
	}

	public SqlRetrievalFailureException(String message, Throwable cause) {
		super(message, cause);
	}
}