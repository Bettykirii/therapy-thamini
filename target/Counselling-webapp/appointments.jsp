<html>
<head>
<title>Output page: Fetching the value from session</title>
</head>
<body>
<%

String name=(String)session.getAttribute("sessname");
out.print("Hello User: You have entered the name: "+name );

String fname=(String)session.getAttribute("sessnam");
out.print("Hello User: You have entered the name: "+fname );

String lname=(String)session.getAttribute("sessna");
out.print("Hello User: You have entered the name: "+lname );


%>
<h1>Retrieve data from database in jsp</h1>
<table border="1">
<tr>
<td>first name</td>
<td>last name</td>
<td>City name</td>
<td>Email</td>

</tr>

<tr>
<td><%String name=(String)session.getAttribute("sessname") %></td>
<td><%String name=(String)session.getAttribute("sessname") %></td>
<td><%String name=(String)session.getAttribute("sessname") %></td>
<td><%String name=(String)session.getAttribute("sessname") %></td>
</tr>


</body>
</html>