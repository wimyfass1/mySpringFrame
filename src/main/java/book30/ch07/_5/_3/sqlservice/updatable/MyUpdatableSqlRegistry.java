package book30.ch07._5._3.sqlservice.updatable;

import java.util.HashMap;
import java.util.Map;

import book30.ch07._5._3.sqlservice.SqlRetrievalFailureException;

public class MyUpdatableSqlRegistry implements UpdatableSqlRegistry {
	@Override
	public void updateSql(String key, String sql)
			throws SqlUpdateFailureException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSql(Map<String, String> sqlmap)
			throws SqlUpdateFailureException {
		// TODO Auto-generated method stub
		
	}

	private Map<String, String> sqlMap = new HashMap<String, String>();
		
	@Override
	public String findSql(String key) throws SqlRetrievalFailureException {
		String sql = sqlMap.get(key);
		if (sql == null) throw new SqlRetrievalFailureException(key + "를 이용해서 SQL을 찾을 수 없습니다");
		else return sql;
	}

	@Override
	public void registerSql(String key, String sql) {
		sqlMap.put(key, sql);
	}
}
