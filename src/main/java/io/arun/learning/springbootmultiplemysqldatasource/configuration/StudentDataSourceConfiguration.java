package io.arun.learning.springbootmultiplemysqldatasource.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import io.arun.learning.springbootmultiplemysqldatasource.model.student.Student;

@Configuration
@EnableJpaRepositories(basePackages = {
		"io.arun.learning.springbootmultiplemysqldatasource.repository.student" }, 
		entityManagerFactoryRef = "studentEntityManagerFactory", 
		transactionManagerRef = "studentTransactionManager")
public class StudentDataSourceConfiguration {

	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.student")
	public DataSourceProperties studentDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	public DataSource studentDataSource() {
		return studentDataSourceProperties()
					.initializeDataSourceBuilder()
					.type(HikariDataSource.class)
					.build();
	}

	@Bean(name = "studentEntityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean studentEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
					.dataSource(studentDataSource())
					.packages(Student.class)
					.build();
	}

	@Bean
	@Primary
	public PlatformTransactionManager studentTransactionManager(
			@Qualifier("studentEntityManagerFactory") LocalContainerEntityManagerFactoryBean studentENtityManagerFactory) {
		return new JpaTransactionManager(studentENtityManagerFactory.getObject());
	}
}
