<%@page import="com.revature.bean.TuitionReimbursementForm"%>
<%@page import="java.util.List"%>
<%@page import="com.revature.daoimpl.TuitionReimbursementFormDAOImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<table class="table">
	<thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
		<th>Employee_username</td>
		<th>Employee_first</td>
		<th>Employee_last</th>
		<th>City</th>
		<th>State</td>
		<th>Zip</th>
		<th>Description</th>
		<th>Event_type</th>
		<th>Passing_grade</th>
		<th>Reimbursment_amount</th>
		<th>Start_date</th>
		<th>Work_related_justification</th>
		<th>Work_time_missed</th>	
		<th>Submit_date</th>
		<th>Submit_time</th>
		<th>Requested_information</th>
    </tr>
  </thead>
	<%
		TuitionReimbursementFormDAOImplementation impl = new TuitionReimbursementFormDAOImplementation();
		List<TuitionReimbursementForm> list = impl.getAllForms();
		for(int i =0; i < list.size(); i++){
	%>
	
	<tr>
	      <th scope="row"><%=i%></th>
		<td><%=list.get(i).getEmployee_username()%></td>
		<td><%=list.get(i).getEmployee_first()%></td>
		<td><%=list.get(i).getEmployee_last()%></td>
		<td><%=list.get(i).getCity()%></td>
		<td><%=list.get(i).getState()%></td>
		<td><%=list.get(i).getZip()%></td>
		<td><%=list.get(i).getDescription()%></td>
		<td><%=list.get(i).getEvent_type()%></td>
		<td><%=list.get(i).getPassing_grade()%></td>
		<td><%=list.get(i).getReimbursment_amount()%></td>
		<td><%=list.get(i).getStart_date()%></td>
		<td><%=list.get(i).getWork_related_justification()%></td>
		<td><%=list.get(i).getWork_time_missed()%></td>	
		<td><%=list.get(i).getSubmit_date()%></td>
		<td><%=list.get(i).getSubmit_time()%></td>
		<td><%=list.get(i).getRequested_information()%></td>
		
		<td><input type="submit" value="Submit" id="button-1" method = ""/></td>
	</tr>
	<%		
		}
	%>
	</table>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>