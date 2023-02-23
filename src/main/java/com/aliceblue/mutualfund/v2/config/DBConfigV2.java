package com.aliceblue.mutualfund.v2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        entityManagerFactoryRef = "v2EntityManagerFactory",
        transactionManagerRef = "v2TransactionManager",
        basePackages = {"com.aliceblue.mutualfund.v2.repository"}
)
public class DBConfigV2 {

    @Autowired
    Environment env;

    @Bean(name = "v2DataSource")
    @ConfigurationProperties(prefix = "additional.datasource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("additional.datasource.driver-class-name")));
        dataSource.setUrl(env.getProperty("additional.datasource.url"));
        dataSource.setUsername(env.getProperty("additional.datasource.username"));
        dataSource.setPassword(env.getProperty("additional.datasource.password"));

        return dataSource;
    }

    @Bean(name = "v2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean v2EntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("v2DataSource") DataSource dataSource)
    {
        return builder.dataSource(dataSource)
                        .packages("com.aliceblue.mutualfund.v2.entity")
                        .persistenceUnit("MUTUALFUNDV2")
                        .build();
    }

    @Bean(name = "v2TransactionManager")
    public PlatformTransactionManager productTransactionManager(@Qualifier("v2EntityManagerFactory") EntityManagerFactory productEntityManagerFactory)
    {
        return new JpaTransactionManager(productEntityManagerFactory);
    }

    @Bean
    public JdbcTemplate v2JdbcTemplate(@Qualifier("v2DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
