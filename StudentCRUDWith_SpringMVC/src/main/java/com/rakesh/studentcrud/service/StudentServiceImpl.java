package com.rakesh.studentcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakesh.studentcrud.dao.StudentDAO;
import com.rakesh.studentcrud.model.Student;


@Service
public class StudentServiceImpl implements StudentService {
    
	@Autowired
	private StudentDAO studentDAO;
	
	public boolean add(Student s) {
		return studentDAO.add(s);
	}

	public boolean delete(int id) {
		return studentDAO.delete(id);
	}

	public Student getStudent(int id) {
		return studentDAO.getStudent(id);
	}

	public List<Student> getAllStudent() {
		return studentDAO.getAllStudent();
	}

	@Override
	public List<Student> getStudentByProperty(Object keyword) {
		return studentDAO.getStudentByProperty(keyword);
	}

	@Override
	public boolean update(Student s) {
		return studentDAO.update(s);
	}

}
