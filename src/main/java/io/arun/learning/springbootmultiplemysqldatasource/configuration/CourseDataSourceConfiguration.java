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

import io.arun.learning.springbootmultiplemysqldatasource.model.course.Course;

@Configuration
@EnableJpaRepositories(
		basePackages = {"io.arun.learning.springbootmultiplemysqldatasource.repository.course"},
		entityManagerFactoryRef = "courseEntityManagerFactory",
		transactionManagerRef = "courseTransactionManager"
		)
public class CourseDataSourceConfiguration {

	@Bean
	@ConfigurationProperties("app.datasource.course")
	public DataSourceProperties courseDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	public DataSource courseDataSource() {
		return courseDataSourceProperties()
					.initializeDataSourceBuilder()
					.type(BasicDataSource.class)
					.build();
	}
	
	@Bean(name="courseEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean courseEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
					.dataSource(courseDataSource())
					.packages("io.arun.learning.springbootmultiplemysqldatasource.model.course")
					.build();			
	}
	
	@Bean
	public PlatformTransactionManager courseTransactionManager(@Qualifier("courseEntityManagerFactory") LocalContainerEntityManagerFactoryBean courseEntityManagerFactory) {
		return new JpaTransactionManager(courseEntityManagerFactory.getObject());
	}
}
