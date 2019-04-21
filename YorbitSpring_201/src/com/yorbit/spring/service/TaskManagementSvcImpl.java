/**
 * 
 */
package com.yorbit.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yorbit.spring.Exception.DAOException;
import com.yorbit.spring.Exception.ServiceException;
import com.yorbit.spring.dao.TaskManagementDao;
import com.yorbit.spring.model.Employee;
import com.yorbit.spring.model.Project;
import com.yorbit.spring.model.Task;

/**
 * @author gkaur
 *
 */
@Service
public class TaskManagementSvcImpl implements TaskManagementSvc {

	@Autowired
	private TaskManagementDao taskManagementDao;
	
	@Override
	public List<Project> getProjectList() {
		return taskManagementDao.getprojectList();
	}

	@Override
	public List<Employee> getEmpoyeesForProject(Integer projectId) {
		return taskManagementDao.getEmpoyeesForProject(projectId);
	}

	@Override
	public void addTask(Task task) throws ServiceException{
		try {
			taskManagementDao.addTask(task);
		} catch (DAOException e) {
			throw new ServiceException("Exception while saving", e); 
		}
	}

	@Override
	public List<List<Task>> getTasksForProject(Integer projectId) {
		List<Task> taskList = taskManagementDao.getTasksForProject(projectId);
		Map<String,List<Task>> map = new HashMap<>();
		taskList.forEach((task)->{
			String key = task.getProject().getProjectName();
			List<Task> tasks = map.get(key);
			if(tasks == null) {
				tasks = new ArrayList<>();
			}
			tasks.add(task);
			map.put(task.getProject().getProjectName(), tasks);
		});
		List<List<Task>> listTask = new ArrayList<>();
		map.forEach((k,v)->{
			listTask.add(v);
		});
		return listTask;
	}

}
