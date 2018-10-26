
package com.business.ventas.configuracion;

import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ConfiguracionDb {

    ConfigProperties conf = ConfigProperties.getInstancia(ConfigProperties.XML);

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(" com.business.ventas.model");
        sessionFactoryBean.setHibernateProperties(hibernetProperties());
        return sessionFactoryBean;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(conf.getClassName());
        dataSource.setUrl(conf.getUrl());
        dataSource.setUsername(conf.getUserName());
        dataSource.setPassword(conf.getPassword());
        return dataSource;
    }

    public Properties hibernetProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", conf.getDialect());
        properties.put("show_sql",conf.getShowSql());
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
        return hibernateTransactionManager;
    }

}
