<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission success</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	<table>
		<tr>
			<td>Student name:</td>
			<td>${student.studentName}</td>
		</tr>
		<tr>
			<td>Student hobby:</td>
			<td>${student.studentHobby}</td>
		</tr>
		<tr>
			<td>Student mobile:</td>
			<td>${student.studentMobile}</td>
		</tr>
		<tr>
			<td>Student dob:</td>
			<td>${student.studentDOB}</td>
		</tr>
		<tr>
			<td>Student Skills:</td>
			<td>${student.studentSkills}</td>
		</tr>
		<table>
			<tr>
				<td>Student   Address:</td>
				<td>State : ${student.studentAddress.state}</td>
				<td>City : ${student.studentAddress.city}</td>
				<td>Street : ${student.studentAddress.street}</td>
				<td>Pincode : ${student.studentAddress.pincode}</td>
			</tr>
		</table>
	</table>
</body>
</html>