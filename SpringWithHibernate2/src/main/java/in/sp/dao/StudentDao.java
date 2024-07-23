package in.sp.dao;

import in.sp.beans.Student;

public interface StudentDao
{
	public void addStdDetails(Student std);
	public void updateStdDetails(Student std);
	public void deleteStdDetails(Student std);
	public void searchStdDetails(int id);
}
