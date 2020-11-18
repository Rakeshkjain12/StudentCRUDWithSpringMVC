package com.rakesh.studentcrud.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakesh.studentcrud.model.Student;
@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sf;
	
	public boolean add(Student s) {
		
		try {
			sf.getCurrentSession().save(s);
			return true;
		} catch (Exception e) {
            e.printStackTrace();
            return false;
		}
		
	}

	

	public boolean delete(int id) {
		Student stu=sf.getCurrentSession().get(Student.class, id);
		if(stu!=null) {
			this.sf.getCurrentSession().delete(stu);
			return true;
		}else {
		return false;
		}
		
	}

	public Student getStudent(int id) {
		return sf.getCurrentSession().get(Student.class, id);
	}
	
	public List<Student> getStudentByProperty(Object keyword) {
		 
		String q= "From Student Where name=:keyword OR fname=:keyword OR dob=:keyword OR course=:keyword";
	    return sf.getCurrentSession().createQuery(q,Student.class).setParameter("keyword", keyword).getResultList();
	}

	public List<Student> getAllStudent() {
		return sf.getCurrentSession().createQuery("From Student").getResultList();
	}



	@Override
	public boolean update(Student s) {
		try {
	      sf.getCurrentSession().update(s);
	      return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
