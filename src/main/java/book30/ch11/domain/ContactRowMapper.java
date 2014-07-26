package book30.ch11.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ContactRowMapper implements RowMapper<Contact> {
	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		contact.setId(rs.getInt("ID"));
		contact.setUserId(rs.getInt("USER_ID"));
		contact.setAddress(rs.getString("ADDRESS"));
		contact.setPhone(rs.getString("PHONE"));
		return contact;
	}
}