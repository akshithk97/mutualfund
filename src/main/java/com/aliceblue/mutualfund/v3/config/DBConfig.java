package com.aliceblue.mutualfund.v3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "v3EntityManagerFactory",
        transactionManagerRef = "v3TransactionManager",
        basePackages = {"com.aliceblue.mutualfund.v3.repository"}
)
public class DBConfig {

    @Autowired
    Environment env;

    @Primary
    @Bean(name = "v3DataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("spring.datasource.driver-class-name")));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }

    @Primary
    @Bean(name = "v3EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("v3DataSource") DataSource dataSource)
    {
        return builder.dataSource(dataSource)
                .packages("com.aliceblue.mutualfund.v3.model")
                .persistenceUnit("mf_uat")
                .build();
    }

    @Primary
    @Bean(name = "v3TransactionManager")
    public PlatformTransactionManager customerTransactionManager(@Qualifier("v3EntityManagerFactory") EntityManagerFactory customerEntityManagerFactory)
    {
        return new JpaTransactionManager(customerEntityManagerFactory);
    }

    @Primary
    @Bean
    public JdbcTemplate v3JdbcTemplate(@Qualifier("v3DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
