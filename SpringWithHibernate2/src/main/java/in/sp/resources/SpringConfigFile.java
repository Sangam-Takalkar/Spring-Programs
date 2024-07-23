package in.sp.resources;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import in.sp.dao.StudentDao;
import in.sp.dao.StudentDaoImpl;

@Configuration
@EnableTransactionManagement
public class SpringConfigFile 
{
	@Bean
	public DriverManagerDataSource dmDataSource()
	{
		DriverManagerDataSource dmDataSource = new DriverManagerDataSource();
		
		dmDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmDataSource.setUrl("jdbc:mysql://localhost:3306/spring_hibernate_db");
		dmDataSource.setUsername("root");
		dmDataSource.setPassword("Sangam@9935");
		
		return dmDataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean mySessionFactory()
	{
		LocalSessionFactoryBean mySessionFactory = new LocalSessionFactoryBean();
		
		mySessionFactory.setDataSource(dmDataSource());
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.format_sql", "true");
		mySessionFactory.setHibernateProperties(hibernateProperties);
		
		mySessionFactory.setMappingResources("/in/sp/resources/student.hbm.xml");
		
		return mySessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager()
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(mySessionFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public HibernateTemplate myHibernateTemplate()
	{
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(mySessionFactory().getObject());
		return hibernateTemplate;
	}
	
	@Bean
	public StudentDao stdDaoImplBean()
	{
		StudentDaoImpl stdDaoImpl = new StudentDaoImpl();
		stdDaoImpl.setHibernateTemplate(myHibernateTemplate());
		return stdDaoImpl;
	}
}
