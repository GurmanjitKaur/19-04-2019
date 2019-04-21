/**
 * 
 */
package com.yorbit.spring.model;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author gkaur
 *
 */

@Entity
public class Project {
	@Id
	private Integer projectId;
	private String projectName;
	private String projectDesc;

	public Project() {}
	public Project(Integer projectId, String projectName, String projectDesc) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDesc = projectDesc;
	}
	
	/**
	 * @return the projectId
	 */
	public Integer getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId
	 *            the projectId to set
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the projectDesc
	 */
	public String getProjectDesc() {
		return projectDesc;
	}

	/**
	 * @param projectDesc
	 *            the projectDesc to set
	 */
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
}
