<%@ page language="java" import="model.*" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	Database db = new Database();
	ArrayList<ArticoloBean> articoli = db.getArticoli();
	Carrello car = (Carrello) session.getAttribute("carrello");
	if(car == null)
		car = new Carrello();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo</title>
</head>
<body>

<h2>Nel carrello ci sono: <%=car.getNumeroElementi()%> articoli, per un totale di <%=car.getAmount() %> euri</h2>



<%if(articoli.isEmpty()){ %>
	<b>Non ci sono articoli nel catalogo </b><br>
<%}else{ %>
<b>Lista articoli disponibili:</b><br>
<%
	Iterator<ArticoloBean> it = articoli.iterator();
	ArticoloBean el;
	while(it.hasNext()){
		el = it.next();
%>
	<h2> Id: <%=el.getId()%> Nome: <%=el.getNome()%></h2><br>
	<img border="0" src="images/<%=el.getImg()%>" alt="non cie limmagine" width="400" height="300"> <br>
	<b>Descrizione: <%=el.getDescrizione() %><br>Costo: <%=el.getPrezzo() %> euri</b>
	<form action="Servlet" method="get">
	<input type="submit" name="dettagli<%=el.getId()%>" value="dettagli"><input type="submit" name="aquista<%=el.getId()%>" value="aquista">
	</form>
<%		
	}
	
} %>
</body>
</html>