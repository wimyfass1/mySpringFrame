package book30.ch07._2._2.sqlservice;

public interface SqlService {
	String getSql(String key) throws SqlRetrievalFailureException;
}
