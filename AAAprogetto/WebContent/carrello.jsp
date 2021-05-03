<%@ page language="java" import="model.*" import="java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
	Carrello car = (Carrello) session.getAttribute("carrello");
%>


<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Carrello</title>
</head>
<body>
	<%
		if (car == null) {
	%>
	<p class="carrello">
		<b>Il carrello è vuoto</b>
	</p>
	<%
		} else {
			List<ArticoloBean> articoli = car.getArticoli();
			Iterator<ArticoloBean> it = articoli.iterator();
	%>
	<p class="carrello">
		<b>Nel carrello ci sono <%=car.getNumeroElementi()%> elementi per
			un totale di <%=car.getAmount()%> euri:
		</b><p>
	<br>
		<%
			while (it.hasNext()) {
					ArticoloBean el = it.next();
		%><h2>
		Elemento numero
		<%=car.getArticoli().indexOf(el) + 1%>:
		<%=el.getNome()%></h2>
	<img src="images/<%=el.getImg()%>" width="200" height="125" class="immaginedettagli">
	<br>
	<form action="Servlet">
		<b>Quantità:</b> <input type="number" name="val<%=el.getId()%>"
			value="<%=el.getPezzi()%>" min="1"> <input type="submit"
			name="change<%=el.getId()%>" value="aggiorna"> <input
			type="submit" name="rimuovi<%=el.getId()%>" value="rimuovi">
	</form>

	<br>
	<b>Prezzo: <%=el.getPezzi() * el.getPrezzo()%> euri
	</b>

	<%
		}
		}
	%>
	<form action="Servlet">
		<input type="submit" name="paga" value="checkout">
	</form>
	<br>
	<a href="articoli.jsp">torna indietro</a>
</body>
</html>