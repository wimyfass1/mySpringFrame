package book30.ch07._5._1.sqlservice.updatable;

import java.awt.Event;

public class SqlAdminService implements AdminEventListener {
	private UpdatableSqlRegistry updatableSqlRegistry;

	public void setUpdatableSqlRegistry(UpdatableSqlRegistry updatableSqlRegistry) {
		this.updatableSqlRegistry = updatableSqlRegistry;
	}
	
	@Override
	public void updateEventListener(Event event) {
		this.updatableSqlRegistry.updateSql(event.toString(), event.toString());	
	}
}