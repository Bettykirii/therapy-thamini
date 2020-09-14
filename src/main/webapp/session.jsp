<html>
<head>
<title>Passing the input value to a session variable</title>
</head>
<body>
<%
String uname=request.getParameter("fname");
out.print("Welcome "+ uname);
session.setAttribute("sessname",uname);<br/>

String lname=request.getParameter("lname");
out.print("Welcome "+ lname);
session.setAttribute("sessnam",lname);<br/>

String email=request.getParameter("email");
out.print("Welcome "+ email);
session.setAttribute("sessna",email);


%>


<a href="output.jsp">Check Output Page Here </a>
</body>
</html>