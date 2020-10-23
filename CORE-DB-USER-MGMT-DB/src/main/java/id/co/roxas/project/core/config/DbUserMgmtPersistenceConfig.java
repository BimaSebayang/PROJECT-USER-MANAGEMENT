package id.co.roxas.project.core.config;
import java.util.Properties;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "entityManager", 
        transactionManagerRef = "transactionManager", basePackages = {
		"id.co.roxas.project.core.dao" })
public class DbUserMgmtPersistenceConfig {

	
	@Primary
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:sqlserver://localhost;databaseName=USER_MGMT_DB");
		dataSource.setUsername("SA");
		dataSource.setPassword("Roxas0309.");
		return dataSource;
	}
	
	@PersistenceContext(unitName = "primary")
	@Bean(name = "entityManager")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	LocalContainerEntityManagerFactoryBean em 
        = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource());
      em.setPackagesToScan(new String[] {"id.co.roxas.project.core.repository"});
      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);
      em.setJpaProperties(additionalProperties());
      return em;
	}

	Properties additionalProperties() {
	    Properties properties = new Properties();
	    properties.setProperty("hibernate.hbm2ddl.auto", "update");
	    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
	    properties.setProperty("hibernate.show_sql", "true");  
	    properties.setProperty("hibernate.format_sql", "true");  
	    return properties;
	}
	
}
