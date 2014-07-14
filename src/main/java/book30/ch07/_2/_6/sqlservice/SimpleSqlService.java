package book30.ch07._2._6.sqlservice;

import java.util.Map;

public class SimpleSqlService implements SqlService {
	private Map<String, String> sqlMap;
	
	public void setSqlMap(Map<String, String> sqlMap) {
		this.sqlMap = sqlMap;
	}

	@Override
	public String getSql(String key) throws SqlRetrievalFailureException {
		String sql = sqlMap.get(key);
		if (sql == null) {
			throw new SqlRetrievalFailureException(key + "에 대한 SQL 찾기 실패");
		} else {
			return sql;
		}
	}
}