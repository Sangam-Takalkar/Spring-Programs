package in.sp.main;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import in.sp.resources.SpringConfigFile;

public class App 
{
    public static void main( String[] args )
    {
     
    	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
    	
    	JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("myJdbcTemplate");
     
      
       
       try
       {
    	   Connection con = jdbcTemplate.getDataSource().getConnection();
    	   if(con != null)
    	   {
    		   System.out.println("Success.....");
    	   }
    	   else
    	   {
    		   System.out.println("Fail..");
    	   }
       }
       catch (Exception e) 
       {
    	   e.printStackTrace();
       }
       
    }
}
