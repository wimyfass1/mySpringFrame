package book30.ch07._5._2.sqlservice;

import java.util.HashMap;
import java.util.Map;

public class HashMapSqlRegistry implements SqlRegistry {
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
