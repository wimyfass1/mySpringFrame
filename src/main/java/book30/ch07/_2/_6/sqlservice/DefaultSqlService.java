package book30.ch07._2._6.sqlservice;

import javax.annotation.PostConstruct;

public class DefaultSqlService extends BaseSqlService {
	public DefaultSqlService() {
		super.setSqlReader(new JaxbXmlSqlReader());
		super.setSqlRegistry(new HashMapSqlRegistry());
	}
}
