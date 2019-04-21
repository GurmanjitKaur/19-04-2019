<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<spring:url value="/resources/js/index.js" var="indexJS" />
<script src="${indexJS}"></script>
<link
	href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"
	rel="stylesheet" type="text/css">

<script>
	$(document).ready(function() {
		IndexJs.onload();
	});
</script>



<title>Assign Task</title>
</head>
<body>
	<h2>${message}</h2>
	<form action="/YorbitSpring_201/submitAssignTaskForm" method="post">
		<fieldset>
			<legend>Assign Task</legend>
			<table>
				<tr>
					<td>Project</td>
					<td><select name="project.projectId" id="project-name">
							<c:forEach items="${projectList}" var="list">
								<option value="${list.projectId}" label="${list.projectName}" />
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><input type="text" name="taskDesc"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><form:errors path="task.taskDesc" /></td>
				</tr>
				<tr>
					<td>Start Date of Task [dd-mm-yyyy]</td>
					<td><input type="text" name="startDate" class="datepicker" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><form:errors path="task.startDate" /></td>
				</tr>
				<tr>
					<td>Due Date of Task [dd-mm-yyyy]</td>
					<td><input type="text" name="dueDate" class="datepicker" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><form:errors path="task.dueDate" /></td>
				</tr>
				<tr>
					<td>Who should do this?</td>
					<td><select name="empList" id="employee-id" multiple>
							<c:forEach items="${empList}" var="list" varStatus="vs">
								<option value="${list.empId}"
									label="${list.empId} ${list.empName}" />
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><form:errors path="task.empList" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add a task" /></td>
					<td><input type="reset" value="Cancel" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
	</br>
	<a href="/YorbitSpring_201/home.jsp">
		<button>Go Back</button>
	</a>

</body>
</html>