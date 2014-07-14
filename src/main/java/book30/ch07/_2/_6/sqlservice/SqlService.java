package book30.ch07._2._6.sqlservice;

public interface SqlService {
	String getSql(String key) throws SqlRetrievalFailureException;
}
