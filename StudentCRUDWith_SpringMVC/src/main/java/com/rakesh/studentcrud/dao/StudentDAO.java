package com.rakesh.studentcrud.dao;
 import java.util.List;

import com.rakesh.studentcrud.model.Student;
public interface StudentDAO {
   
	public boolean add(Student s);
	public boolean update(Student s);
	public boolean delete(int id);
	public Student getStudent(int id);
	public List<Student> getAllStudent();
	public List<Student> getStudentByProperty(Object keyword);
}
