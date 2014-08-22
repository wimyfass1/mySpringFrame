package book30.ch04._1;

import java.sql.SQLException;

import com.mysql.jdbc.MysqlErrorNumbers;

public class ExceptionHandling {
	
	/* List 4-6
	int maxretry = MAX_RETRY;
	while(maxtry --> 0) {
		try {
			...			// 예외가 발생할 가능성이 있는 시도
			return;	// 작업 성공
		}
		catch(SomeException e) {
			// 로그 출력. 정해진 시간만큼 대기
		}
		finally {
			// 리소스 반납, 정리 작업
		}
	}
	throw new RetryFailedException(); // 최대 재시도 횟수를 넘기면 직접 예외 발생
	*/
	
	/* List 4-7
	public void add() throws SQLException {
		// JDBC API
	}
	
	List 4-8
	public void add() throws SQLException {
		// 로그 출력
		throw e;
	}
	*/
	
	/* List 4-9
	public void add(User uer) throws DuplicateUserIdException, SQLException {
		try {
			// JDBC를 이용해 user 정보를 DB에 추가하는 코드 또는
			// 그런 기능을 가진 다른 SQLException을 던지는 메소드를 호출하는 코드
		}
		catch(SQLException e) {
			// ErrorCode가 MYSQL의 "Duplicate Entry(1062)"이면 예외 전환
			if( e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY)
				throw DuiplicateUserIdException();
			else
				throw e; // 그 외의 경우는 SQLException 그대로
		}
	}
	*/
	
	
	/* List 4-10
	 catch(SQLException e) {
	 	...
	 	throw DuplicateUserIdException(e);
	 }
	 
	 List 4-11
	 catch(SQLException e) {
	 	...
	 	throw DuplicateUserIdException().initCase(e);
	 }
	 */
	
	/* List 4-12
	try {
		OrderHome orderHome = EJBHomeFactory.getInstance().getOrderHome();
		Order order = orderHome.findByPrimaryKey(Integer id);
	} catch (NamingException ne) {
		throw new EJBException(ne);
	} catch (SQLException se) {
		throw new EJBException(se);
	} catch (SQLException re) {
		throw new EJBException(re);
	}
	*/

	/* List 4-15
	try {
		BigDecimal balance = account.withdraw(amount);
		...
		// 정상적인 처리 결과를 출력하도록 진행
	}
	catch(InsufficientBalanceException e) { // 체크 예외
		// InsufficientBalanceException에 담긴 인출 가능한 잔고금액 정보를 가져옴
		BigDecimal availFuncs = e.getAvailFunds();
		...
		// 잔고 부족 안내 메시지를 준비하고 이를 출력하도록 진행
	}
	*/
}
