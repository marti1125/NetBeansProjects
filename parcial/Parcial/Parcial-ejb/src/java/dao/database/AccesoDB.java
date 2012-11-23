package dao.database;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class AccesoDB {

	private JdbcTemplate jdbcTemplate = null;

	public JdbcTemplate getJdbcTemplate() throws Exception {
		if (this.jdbcTemplate == null) {
			try {
				DriverManagerDataSource dataSource = new DriverManagerDataSource();
				dataSource.setDriverClassName("com.mysql.jdbc.Driver");
				dataSource.setUrl("jdbc:mysql://localhost:3306/perumodel");
				dataSource.setUsername("root");
				dataSource.setPassword("admin");
				jdbcTemplate = new JdbcTemplate(dataSource);
			} catch (Exception e) {
				this.jdbcTemplate = null;
				throw e;
			}
		}
		return jdbcTemplate;
	}
}
