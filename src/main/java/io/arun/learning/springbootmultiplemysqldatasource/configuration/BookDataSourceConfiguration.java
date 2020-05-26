/**
 * 
 */
package io.arun.learning.springbootmultiplemysqldatasource.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import io.arun.learning.springbootmultiplemysqldatasource.model.book.Book;

/**
 * @author arun
 *
 */
@Configuration
@EnableJpaRepositories(
		basePackages = {"io.arun.learning.springbootmultiplemysqldatasource.repository.book"},
		entityManagerFactoryRef = "bookEntityManagerFactory",
		transactionManagerRef = "bookTransactionManager"
		)
public class BookDataSourceConfiguration {

	@Bean
	@ConfigurationProperties("app.datasource.book")
	public DataSourceProperties bookDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	public DataSource bookDataSource() {
		return bookDataSourceProperties()
					.initializeDataSourceBuilder()
					.type(BasicDataSource.class)
					.build();
	}
	
	@Bean(name="bookEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean bookEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(bookDataSource())
				.packages("io.arun.learning.springbootmultiplemysqldatasource.model.book")
				.build();
	}
	
	@Bean
	public PlatformTransactionManager bookTransactionManager(@Qualifier("bookEntityManagerFactory") LocalContainerEntityManagerFactoryBean bookEntityManagerFactory){
		return new JpaTransactionManager(bookEntityManagerFactory.getObject());
	}
}
