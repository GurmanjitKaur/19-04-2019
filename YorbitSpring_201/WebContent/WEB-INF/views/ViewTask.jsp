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
		IndexJs.getTask();
	});
</script>
<title>Insert title here</title>
</head>
<body>
	
		<table>
			<tr>
				<td>Filter by Project</td>
				
				<td><select name="project.projectId" id="project-view-task">
						<option value="0" label="All Projects" selected/>
						<c:forEach items="${projectList}" var="list">
							<option value="${list.projectId}" label="${list.projectName}" />
						</c:forEach>
				</select></td>
			</tr>
		</table><br>
		<a href="/YorbitSpring_201/home.jsp">
			    <button>Go Back</button>
		</a>
		<div id = "task-details-id">
		</div>
	
</body>
</html>