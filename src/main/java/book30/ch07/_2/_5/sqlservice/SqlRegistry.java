package book30.ch07._2._5.sqlservice;

public interface SqlRegistry {
	void registerSql(String key, String sql);
	String findSql(String key) throws SqlRetrievalFailureException;
}