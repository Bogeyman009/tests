<%
	if(session.getAttribute("name")==null){
		response.sendRedirect("login.jsp");	}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello World
<form action="register" method="post">
UserName : <input type="text" name="name">
Email :: <input type="email" name="email">
PassWord : <input type="passwprd" name="password">
Mobile : <input type="text" name="mob">
<input type="submit" value="Log in">
</form>
</body>
</html> 