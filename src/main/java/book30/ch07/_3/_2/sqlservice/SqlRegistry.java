package book30.ch07._3._2.sqlservice;

import book30.ch07._3._2.sqlservice.SqlRetrievalFailureException;

public interface SqlRegistry {
	void registerSql(String key, String sql);
	String findSql(String key) throws SqlRetrievalFailureException;
}
