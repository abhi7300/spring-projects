<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Spring Web App - Login Page</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div align="center">
		<form:form method="post"
			action="/MySpringMVCApp/mymvcapp/validatelogin" modelAttribute="user">

			<table>
			   <tr><form:errors path="*" cssClass="error" /> </tr>
			    <tr><br><br></tr>
				<tr>
					<td>User Id</td>
					<td><form:input path="userId" size="30" /></td>
					<td><form:errors path="userId" /></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><form:password path="password" size="30" /></td>
					<td><form:errors path="password" /></td>
				</tr>

			</table>
			<br />
			<input type="submit" value="Submit" />

		</form:form>

	</div>
</body>
</html>