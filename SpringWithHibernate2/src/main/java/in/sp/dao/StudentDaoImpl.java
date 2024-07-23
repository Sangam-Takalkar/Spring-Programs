package in.sp.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import in.sp.beans.Student;

public class StudentDaoImpl implements StudentDao
{
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	@Override
	public void addStdDetails(Student std) 
	{
		try
		{
			hibernateTemplate.save(std);
			System.out.println("Student details added successfully");
		}
		catch(Exception e)
		{
			System.out.println("Student details not added due to some error");
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void updateStdDetails(Student std)
	{
		try
		{
			hibernateTemplate.update(std);
			System.out.println("Student details updated successfully");
		}
		catch(Exception e)
		{
			System.out.println("Student details not updated due to some error");
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void deleteStdDetails(Student std)
	{
		try
		{
			hibernateTemplate.delete(std);
			System.out.println("Student details deleted successfully");
		}
		catch(Exception e)
		{
			System.out.println("Student details not deleted due to some error");
			e.printStackTrace();
		}
	}

	@Override
	public void searchStdDetails(int id) 
	{
		try
		{
			Student std = (Student) hibernateTemplate.get(Student.class, id);
			System.out.println("Student details :-");
			System.out.println("Name : "+std.getName());
			System.out.println("Rollno : "+std.getRollno());
			System.out.println("City : "+std.getCity());
			
		}
		catch(Exception e)
		{
			System.out.println("Student details not retrieved due to some error");
			e.printStackTrace();
		}
	}
}
