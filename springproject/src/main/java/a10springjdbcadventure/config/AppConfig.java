package a10springjdbcadventure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages = "a10springjdbcadventure")
@PropertySource("classpath:database.properties")
public class AppConfig {


    @Value("${database.url}")
    private String dbUrl;

    @Value("${database.username}")
    private String dbUsername;

    @Value("${database.password}")
    private String dbPassword;

    @Value("${database.driverClass}")
    private String dbDriverClass;



    // Configure the H2 DataSource
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(dbDriverClass);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        /*dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
     */   return dataSource;
    }

    // Configure JdbcTemplate
    @Bean
    public JdbcTemplate jdbcTemplate() {
        try {
            runScripts(dataSource().getConnection());
        } catch (SQLException e) {
            throw new RuntimeException("oh know error connection problems");
        }
        return new JdbcTemplate(dataSource());
    }

    // Run SQL scripts

    public void runScripts(Connection connection) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        // Load the SQL script
        populator.addScript(new ClassPathResource("schema-data.sql"));  // SQL script file
        populator.setContinueOnError(false); // Throw an exception if any error occurs
        populator.populate(connection);  // Execute the script
    }
}
