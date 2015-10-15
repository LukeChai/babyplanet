package com.bp.app.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.bp.app.configuration" })
@MapperScan("com.bp.app.mapper")
public class MyBatisConfiguration {
	
	@Autowired
	DataSource dataSource;
	
	@Value("classpath:sqlMapConfig.xml")
	Resource config;

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setConfigLocation(config);
		sessionFactory.setTypeAliasesPackage("com.bp.app.model");
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public SqlSessionTemplate sqlSession(SqlSessionFactoryBean sqlSessionFactory) throws Exception{
		SqlSessionTemplate sqlSession = new SqlSessionTemplate(sqlSessionFactory.getObject());
		
		return sqlSession;
	} 
}
