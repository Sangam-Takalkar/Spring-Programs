package in.sp.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.sp.beans.Student;
import in.sp.dao.StudentDao;

public class App 
{
    public static void main( String[] args )
    {
    	Student std = new Student();
    	std.setStdid(1);
    	std.setName("rahul");
    	std.setRollno(102);
    	std.setCity("pune");
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("/in/sp/resources/applicationContext.xml");
    	
    	StudentDao stdDao = (StudentDao) context.getBean("stdDaoImplBean");

    	stdDao.addStdDetails(std);
    	
//    	stdDao.updateStdDetails(std);
    	
//    	stdDao.searchStdDetails(2);

    //	stdDao.deleteStdDetails(std);
    }
}
