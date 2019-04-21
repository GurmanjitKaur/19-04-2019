/**
 * 
 */
package com.yorbit.spring.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author gkaur
 *
 */
@Entity
public class Task {
	@Id
	@GeneratedValue
	private Integer taskId;
	private String taskDesc;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy") 
	private Date startDate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy") 
	private Date dueDate;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "projectId")
	private Project project;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "Task_Employee", joinColumns = @JoinColumn(name = "taskId"), inverseJoinColumns = @JoinColumn(name = "empId"))
	private List<Employee> empList;

	/**
	 * @return the taskId
	 */
	public Integer getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId
	 *            the taskId to set
	 */
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the taskDesc
	 */
	public String getTaskDesc() {
		return taskDesc;
	}

	/**
	 * @param taskDesc
	 *            the taskDesc to set
	 */
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate
	 *            the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the empList
	 */
	public List<Employee> getEmpList() {
		return empList;
	}

	/**
	 * @param empList
	 *            the empList to set
	 */
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
}
