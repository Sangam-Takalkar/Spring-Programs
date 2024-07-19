package in.sp.main;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class App 
{
    public static void main( String[] args )
    {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       
       dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
       dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
       dataSource.setUsername("root");
       dataSource.setPassword("Sangam@9935");
       
       JdbcTemplate jdbcTemplate = new JdbcTemplate();
       jdbcTemplate.setDataSource(dataSource);
       
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
