<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission form</title>
</head>
<body>
	<link rel="stylesheet" href="<spring:theme code="styleSheet"></spring:theme>" type="text/css">
	<a href="/student/AdmissionForm?siteTheme=green">Green</a>
	<a href="/student/AdmissionForm?siteTheme=red">Red</a>
	
	<a href="/student/AdmissionForm?siteLanguage=en">English</a>
	<a href="/student/AdmissionForm?siteLanguage=fr">French</a>
	<form action="/student/Admissionsuccess.html" method="post">
		<h1>${headerMessage}</h1>
		<form:errors path="student.*"></form:errors>
		<table>
			<tr>
				<td><spring:message code="Label.studentName" /></td>
				<td>
					<input type="text" name="studentName" placeholder="Enter student name">
				</td>
			</tr>
			<tr>
				<td><spring:message code="Label.studentHobby" /></td>
				<td>
					<input type="text" name="studentHobby" placeholder="Enter student hobby">
				</td>
			</tr>
			<tr>
				<td><spring:message code="Label.studentMobile" /></td>
				<td>
					<input type="text" name="studentMobile" placholder="Enter student Mobile">
				</td>
			</tr>
			<tr>
				<td><spring:message code="Label.studentDOB" /></td>
				<td>
					<input type="text" name="studentDOB" placholder="Enter student dob">
				</td>
			</tr>
			<tr>
				<td><spring:message code="Label.studentSkills" /></td>
				<td>
					<select name="studentSkills" multiple="multiple">
						<option value="Java core">Java core</option>
						<option value="Spring core">Spring core</option>
						<option value="Spring mvc">Spring mvc</option>
						<option value="Hibernate">Hibernate</option>
						<option value="Gradle">Gradle</option>
					</select>
				</td>
			</tr>
			<table>
				<tr>
					<td><spring:message code="Label.studentAddress" /></td>
					<td>
						<input type="text" name="studentAddress.state" placholder="Enter student state">
						<input type="text" name="studentAddress.city" placholder="Enter student city">
						<input type="text" name="studentAddress.street" placholder="Enter student street">
						<input type="text" name="studentAddress.pincode" placholder="Enter student pincode">
					</td>
				</tr>
			</table>
			<tr>
				<td>
					<input type="submit" value="Submit">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>