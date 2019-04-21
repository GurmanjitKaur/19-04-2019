/**
 * 
 */
package com.yorbit.spring.dao;

import java.util.List;

import com.yorbit.spring.Exception.DAOException;
import com.yorbit.spring.model.Employee;
import com.yorbit.spring.model.Project;
import com.yorbit.spring.model.Task;

/**
 * @author gkaur
 *
 */
public interface TaskManagementDao {
	
	public List<Project> getprojectList();

	public List<Employee> getEmpoyeesForProject(Integer projectId);

	public void addTask(Task task) throws DAOException;

	public List<Task> getTasksForProject(Integer projectId);

}
