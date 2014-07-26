package book30.ch11.additional.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import book30.ch11.domain.Contact;
import book30.ch11.domain.ContactRowMapper;

public class ContactDao {
	@Autowired
	private ContactRowMapper contactRowMapper;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	//deleteAll
	public void deleteAll() {
		this.namedParameterJdbcTemplate.update("DELETE FROM CONTACTS", (SqlParameterSource)null);
	}
	
	//addMember
	public void addContact(Contact contact) {
		this.namedParameterJdbcTemplate.update("INSERT INTO CONTACTS(USER_ID, ADDRESS, PHONE) VALUES(:userId, :address, :phone)", 
													new BeanPropertySqlParameterSource(contact));
		
	}
}