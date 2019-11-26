<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width-device-width">
<link rel="stylesheet" href="/style.css">
<title>Unique count</title>
<%@ page import="java.util.Map"%>
<%
	Map<String, Integer> sorted = (Map) request.getAttribute("Resultmap");
	String FileName = (String) request.getAttribute("FileName");
	String Filecontent = (String) request.getAttribute("Filecontent");
%>
</head>
<body>
	<header>
		<div class="container">
			<div id="branding">
				<h1>Word Counter</h1>
			</div>
			<a href="/" class="Homebutton">
				<button>Home</button>
			</a>
		</div>
	</header>
	<divclass:"maincontent">
<p class:"title">File Name: <%=FileName%></p>
<br/>
<p class:"title"> File Content: </p>
<p class:"content"> <%=Filecontent%></p>
</div>
<table class="contenttable">
<thead>
<th> Words</th>
<th>Number of occurences</th> 
</thead>
<tbody>
<%
	for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
%>
<tr>
 <td><%=entry.getKey()%></td>
 <td><%=entry.getValue()%></td>
  </tr>
  <%
  	}
  %>
  </tbody>
  </table>
</body>
</html>