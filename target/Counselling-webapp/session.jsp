<html>
<head>
<title>Passing the input value to a session variable</title>
</head>
<body>
<%
String uname=request.getParameter("inputname");
out.print("Name "+ uname);
session.setAttribute("sessname",uname);
String uname1=request.getParameter("inputname1");
out.print("Welcome "+ uname1);
session.setAttribute("sessname",uname1);
%>
<a href="appointments.jsp">Check Output Page Here </a>
</body>
</html>