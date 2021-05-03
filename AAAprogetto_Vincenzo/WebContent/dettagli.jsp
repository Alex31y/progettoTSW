<%@ page language="java" import="java.util.*" import="model.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
	Database db = new Database();
	ArticoloBean el = db.getArticolo((Integer) session.getAttribute("idElem"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Dettagli</title>
</head>


<body>
	<h1 id="descrizione">
		Questa è la pagina della
		<%=el.getNome()%></h1>
	<img src="images/<%=el.getImg()%>" class= "immaginedettagli">
	<br>
	<h3>Descrizione:</h3>
	<b><%=el.getDescrizione()%></b>
	<h3>prezzo:</h3>
	<strong><%=el.getPrezzo()%> euri</strong>
	<form action="Servlet" method="get">
		<input type="submit" name="aquista<%=el.getId()%>" value="aquista">
	</form>
	<br>
	<a href="articoli.jsp">torna indietro</a>

</body>
</html>