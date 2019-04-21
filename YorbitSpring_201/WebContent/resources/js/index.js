var IndexJs = {
    onload: function () {
    	var self = this;
    	
    	$("#project-name").change(function(){
    		
    		var projectId =  $("#project-name").val();
    		self.ajaxCallFunc("/YorbitSpring_201/getEmployeesForProject/"+projectId,"GET",null,self.appendEmployeeList,undefined);
    	});
    	$( ".datepicker" ).datepicker({
    		dateFormat: 'dd-mm-yy', startDate: '-3d' 
    	});
    },
    
    getTask: function(){
    	var self = this;
    	$("#project-view-task").change(function(){
    		var projectId =  $("#project-view-task").val();
    		self.ajaxCallFunc("/YorbitSpring_201/getTasksForProject/"+projectId,"GET",null,self.appendTaskList,undefined);
    	});
    	self.ajaxCallFunc("/YorbitSpring_201/getTasksForProject/"+0,"GET",null,self.appendTaskList,undefined);
    },
    
    ajaxCallFunc: function(requestedUrl, methodType, inputData, successCallBack, failureCallBack){
    	$.ajax({
    		url: requestedUrl,
    		method: methodType,
    		dataType: "JSON",
    		contentType : "application/JSON; charset=UTF-8",
    		success: function(data){
    			successCallBack(data);
    		},
    		error : function(request,error){
    	        console.log("Request: "+JSON.stringify(request)+" \n error is "+error);    	        	    
    	    }
    	});
    },
    
    appendEmployeeList: function(responseData){
    	var selectData = "";
    	$(responseData).each(function(index, data){
    		selectData += "<option value = "+data.empId+">"+data.empId+" "+data.empName+"</option>";
    	});
    	$("#employee-id").html(selectData);
    },
    
    appendTaskList: function(responseData){
    	var selectData = "";
    	if(responseData.length == 0){
    		selectData += "<h2>NO TASKS AVAILABLE FOR THIS PROJECT</h2>";
    	}
    	$(responseData).each(function(index, data){
    		var projectNm = data[0].project.projectName;
    		selectData += "<h2>Project: "+projectNm+"</h2>";
    		$(data).each(function(i,d){
    			selectData += "<label>Task Description: "+d.taskDesc+"</label>" +
  			  				  "</br><label>Task Start Date: "+d.startDate+"</label></br><label>Task End Date: "+d.dueDate+"</label></br>" +
  			  				  "</br><table border = '1'><tr><td><b>MID</b></td><td><b>Employee Name</b></td></tr>";
    			$(d.empList).each(function(i1,d1){
        			selectData += "<tr><td>"+d1.empId+"</td><td>"+d1.empName+"</td></tr>";
        		});   		
    		    		
    		selectData += "</table>";
    		selectData += "</br></br>";
    		});
    	});
    	$("#task-details-id").html(selectData);
    }    
    
}

