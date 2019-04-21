/**
 * 
 */
package com.yorbit.spring.editor;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import com.yorbit.spring.model.Employee;

/**
 * @author gkaur
 *
 */
public class EmployeeListCustomEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String emplist) throws IllegalArgumentException{
		String[] args = emplist.split(",");
		List<Employee> list = new ArrayList<>();
		
		for(String a: args) {
			Employee emp = new Employee();
			emp.setEmpId(a);
			list.add(emp);
		}
		setValue(list);
	}

}
