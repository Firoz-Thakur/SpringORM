package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {

	
	private HibernateTemplate hibernateTemplate;
	// used for write operation
	@Transactional
	public int insert(Student student)
	{
		
		Integer x = (Integer) hibernateTemplate.save(student);
		return x;
	}
	
	public Student getStudent(int id)
	{
		return this.hibernateTemplate.get(Student.class, id);
	}
	
	public List<Student> getAllStudents()
	{
		
		return this.hibernateTemplate.loadAll(Student.class);
		
	}
	
	@Transactional
	public void deleteStudent(int id)
	{
		Student stu = this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(stu);
	}
	@Transactional
	public void updateStudent(Student stu , int id)
	{
		Student stu1 = this.hibernateTemplate.get(Student.class, id);
		stu1.setId(stu.getId());
		stu1.setCity(stu.getCity());
		stu1.setName(stu.getName());
	    this.hibernateTemplate.update(stu1);
	}

	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
	
	
}
