package book30.ch04._1;





//List 4-13
public class DuplicateUserIdException extends RuntimeException {
	public DuplicateUserIdException(Throwable cause) {
		super(cause);
	}
	
	/* List 4-14
	public void add() throws DuplicateUserIdException {
		try {
			// JDBC를 이용해 user 정보를 DB에 추가하는 코드 또는
			// 그런 기능이 있는 다른 SQLException을 던지는 메소드를 호출하는 코드
		}
		catch (SQLException e) {
			if ( e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY)
				throw new DuplicateUserIdException(e);
		}
	}
	*/
}
