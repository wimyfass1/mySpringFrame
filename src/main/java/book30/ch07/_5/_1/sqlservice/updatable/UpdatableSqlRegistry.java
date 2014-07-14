package book30.ch07._5._1.sqlservice.updatable;

import java.util.Map;

import book30.ch07._5._1.sqlservice.SqlRegistry;

public interface UpdatableSqlRegistry extends SqlRegistry {
	public void updateSql(String key, String sql) throws SqlUpdateFailureException;
	public void updateSql(Map<String, String> sqlmap) throws SqlUpdateFailureException;
}
