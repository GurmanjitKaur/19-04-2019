/**
 * 
 */
package com.yorbit.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yorbit.spring.Exception.DAOException;
import com.yorbit.spring.model.Employee;
import com.yorbit.spring.model.Project;
import com.yorbit.spring.model.Task;

/**
 * @author gkaur
 *
 */
@Repository
@Transactional
public class TaskManagementDaoImpl implements TaskManagementDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Project> getprojectList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Project");
		return (List<Project>) query.list();
	}

	@Override
	public List<Employee> getEmpoyeesForProject(Integer projectId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Employee where projectId = "+projectId);
		return (List<Employee>)query.list();
	}

	@Override
	public void addTask(Task task) throws DAOException{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(task);
		}catch(Exception dao) {
			throw new DAOException("Exception while saving to DB", dao);
		}
	}

	@Override
	public List<Task> getTasksForProject(Integer projectId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = (projectId == 0) ? session.createQuery("from Task ") : session.createQuery("from Task where projectId = "+projectId);
		return (List<Task>)query.list();
	}
}
