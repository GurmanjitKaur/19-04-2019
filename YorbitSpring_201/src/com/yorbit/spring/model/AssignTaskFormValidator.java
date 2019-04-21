package com.yorbit.spring.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AssignTaskFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Task.class.equals(clazz);
	}

	@Override
	public void validate(Object targetObj, Errors errors) {
		Task task = (Task) targetObj;
		ValidationUtils.rejectIfEmpty(errors, "taskDesc","desc.blank","Task Description should not be empty.");
		ValidationUtils.rejectIfEmpty(errors,"startDate","startDate.blank","Start Date should not be empty.");
		ValidationUtils.rejectIfEmpty(errors,"dueDate","dueDate.blank","Due Date should not be empty.");
		ValidationUtils.rejectIfEmpty(errors,"empList","empList.blank","Employee List for task should not be empty.");
	}

}
