/**
 * 
 */
package com.yorbit.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yorbit.spring.Exception.ServiceException;
import com.yorbit.spring.editor.EmployeeListCustomEditor;
import com.yorbit.spring.model.AssignTaskFormValidator;
import com.yorbit.spring.model.Employee;
import com.yorbit.spring.model.Project;
import com.yorbit.spring.model.Task;
import com.yorbit.spring.service.TaskManagementSvc;

/**
 * @author gkaur
 *
 */
@Controller
public class TaskManagmentController {

	@Autowired
	private TaskManagementSvc taskManagementSvc;
	
	@RequestMapping(value = "/AssignTask", method = RequestMethod.GET)
	public ModelAndView getAssignTaskForm() {
		
		ModelAndView modelAndView = new ModelAndView("AssignTask");
		modelAndView.addObject("projectList",getProjectList());
		List<Employee> empList = taskManagementSvc.getEmpoyeesForProject(1);
		modelAndView.addObject("empList",empList);
		modelAndView.addObject("task",new Task());
		return modelAndView;
	}

	private List<Project> getProjectList() {
		return taskManagementSvc.getProjectList();
	}
	
	@ResponseBody
	@RequestMapping(value = "/getEmployeesForProject/{projectId}", method = RequestMethod.GET)
	public List<Employee> getEmployeesForProject(@PathVariable("projectId") Integer projectId) {
		List<Employee> empList = taskManagementSvc.getEmpoyeesForProject(projectId);
		return empList;
	}
	
	@RequestMapping(value = "/submitAssignTaskForm", method = RequestMethod.POST)
	public ModelAndView addTask(@ModelAttribute("task") Task task, BindingResult results) {
		new AssignTaskFormValidator().validate(task, results);
		ModelAndView modelAndView = new ModelAndView("AssignTask");
		modelAndView.addObject("projectList",getProjectList());
		List<Employee> empList = taskManagementSvc.getEmpoyeesForProject(1);
		modelAndView.addObject("empList",empList);
		if(results.hasErrors()) {
			return modelAndView;
		}
		
		modelAndView.addObject("message","Task added successfully");
		try {
			taskManagementSvc.addTask(task);
		} catch (ServiceException e) {
			modelAndView.addObject("message","Unable to save due to some technical error");
			return modelAndView;
		}
		return modelAndView;
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    binder.registerCustomEditor(List.class,"empList", new EmployeeListCustomEditor());
	}
	
	@RequestMapping(value = "/ViewTask", method = RequestMethod.GET)
	public ModelAndView getViewTaskScreen() {
		ModelAndView modelAndView = new ModelAndView("ViewTask");
		modelAndView.addObject("projectList",getProjectList());
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getTasksForProject/{projectId}", method = RequestMethod.GET)
	public  List<List<Task>> getTasksForProject(@PathVariable("projectId") Integer projectId) {
		return taskManagementSvc.getTasksForProject(projectId);
		//return taskList;
	}
}
