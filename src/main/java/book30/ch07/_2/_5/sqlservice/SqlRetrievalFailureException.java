package book30.ch07._2._5.sqlservice;

public class SqlRetrievalFailureException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4011649104687276764L;

	public SqlRetrievalFailureException(String message) {
		super(message);
	}
	
	public SqlRetrievalFailureException(String message, Throwable cause) {
		super(message, cause);
	}
}
