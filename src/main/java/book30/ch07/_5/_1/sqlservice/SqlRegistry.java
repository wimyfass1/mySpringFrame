package book30.ch07._5._1.sqlservice;

import book30.ch07._5._1.sqlservice.SqlRetrievalFailureException;

public interface SqlRegistry {
	void registerSql(String key, String sql);
	String findSql(String key) throws SqlRetrievalFailureException;
}
