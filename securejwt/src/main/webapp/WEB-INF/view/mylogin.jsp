<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>Login Page</title>
</head>
<body>

<form id="theForm"  action="/generateToken" method="post">
<table>
<tr>
<td>
User:
 <input type="text" id="user" >
 </td>
</tr>
<tr>
<td>
Password
 <input type="text" id="password">
 </td>
</tr>

<tr><td>
 <input type="submit" value="Submit">
 </td></tr>
</table>
</form>
</body>
</html>