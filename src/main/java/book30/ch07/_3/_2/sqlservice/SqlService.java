package book30.ch07._3._2.sqlservice;

public interface SqlService {
	String getSql(String key) throws SqlRetrievalFailureException;
}
