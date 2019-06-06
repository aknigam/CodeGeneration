package code.gen;


import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


import javax.sql.DataSource;


/*
Look for annotation @AutoConfigureAfter(value = {MetricsConfiguration.class, DatabaseConfiguration.class})
Using this we can define the order in which the configurations files are loaded and used to configure beans.

The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration and
@ComponentScan with their default attributes:

To work with @ConfigurationProperties beans you can just inject them in the same way as any other bean.


todo : This service should only return the error code to the clients and not the exact error message.
todo: This way we can hide the system specific error and still give the ability to the client to debug if somethign doesn't
todo: works as expected.

 */

@Configuration
@EnableConfigurationProperties(DBConfig.class)
@EnableAutoConfiguration
//following is done only to make the test cases work
@ComponentScan("code.gen")
public class EdukanWebConfig {


    @Bean
    @Primary
    public DataSource datasource(DBConfig dbConfig){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dbConfig.getDriver());
        dataSource.setUrl(dbConfig.getUrl());
        dataSource.setUsername(dbConfig.getUsername());
        dataSource.setPassword(dbConfig.getPassword());
        return dataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource){

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        org.apache.ibatis.mapping.Environment myBatisEnvironment =
                new org.apache.ibatis.mapping.Environment("dev", transactionFactory, dataSource);
        org.apache.ibatis.session.Configuration mybatisConfiguration = new org.apache.ibatis.session.Configuration(myBatisEnvironment);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfiguration);
        mybatisConfiguration.addMappers("com.smartbookmark.repository.mybatis.mapper");
        return sessionFactory;
    }





}
