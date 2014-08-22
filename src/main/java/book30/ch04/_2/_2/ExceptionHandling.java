package book30.ch04._2._2;

public class ExceptionHandling {

	/* List 4-17
	public void add() throws DuplicateKeyException {
		// JdbcTemplate을 이용해 User를 add 하는 코드
	}
	*/
	
	/* List 4-18
	public void add() throws DuplicateUserIdException {
		try {
			// jdbcTemplate을 이용해 User를 add 하는 코드
		}
		catch(DuplicateKeyException e) {
			// 로그를 남기는 등의 필요한 작업
			throw new DuplicateUserIdException(e);
		}
	}
	*/
}
