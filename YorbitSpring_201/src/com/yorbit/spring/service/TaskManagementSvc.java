/**
 * 
 */
package com.yorbit.spring.service;

import java.util.List;
import java.util.Map;

import com.yorbit.spring.Exception.ServiceException;
import com.yorbit.spring.model.Employee;
import com.yorbit.spring.model.Project;
import com.yorbit.spring.model.Task;

/**
 * @author gkaur
 *
 */
public interface TaskManagementSvc {
	
	public List<Project> getProjectList();

	public List<Employee> getEmpoyeesForProject(Integer projectId);

	public void addTask(Task task) throws ServiceException;

	public  List<List<Task>> getTasksForProject(Integer projectId);


}
