package com.hro.core.vehiclesys;

import com.hro.core.vehiclesys.common.SpringContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@MapperScan("com.hro.core.vehiclesys.dao.mapper")
public class VehiclesysApplication {

//	@Bean
//	@ConfigurationProperties(prefix="spring.datasource")
//	public DataSource dataSource() {
//		return new com.alibaba.druid.pool.DruidDataSource();
//	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		DataSource dataSource = SpringContext.getBean(DataSource.class);
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*Mapper.xml"));

		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSource dataSource = SpringContext.getBean(DataSource.class);
		return new DataSourceTransactionManager(dataSource);
	}

	public static void main(String[] args) {
		SpringApplication.run(VehiclesysApplication.class, args);
	}

}
