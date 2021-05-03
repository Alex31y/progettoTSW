<%@ page language="java" import="model.*" import="java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
	Database db = new Database();
	ArrayList<ArticoloBean> articoli = db.getArticoli();
	Carrello car = (Carrello) session.getAttribute("carrello");
	if (car == null)
		car = new Carrello();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Catalogo</title>
</head>
<body>
	<a href="homepage.html" id="logo"> <img src="images/logo.png"
		align="left"
		style="border: 5px solid #ff7514; max-width: 250px; max-height: 250px;"></a>
	<a href="carrello.jsp" id="logoCarrello"> <img
		src="images/logocarrello.png" align="right"
		style="max-width: 200px; max-height: 200px;">
	</a>
	<h2 id="carrello">
		Nel carrello ci sono:
		<%=car.getNumeroElementi()%>
		articoli, per un totale di
		<%=car.getAmount()%>
		euri
	</h2>
	<br>


	<%
		if (articoli.isEmpty()) {
	%>
	<b>Non ci sono articoli nel catalogo </b>
	<br>
	<%
		} else {
	%>
	<h2>
		<b>Lista articoli disponibili: 
	</h2>
	</b>
	<br>
	<table>
		<%
			Iterator<ArticoloBean> it = articoli.iterator();
				ArticoloBean el;
				ArticoloBean el2 = null;
				while (it.hasNext()) {

					el = it.next();
					if (it.hasNext())
						el2 = it.next();
		%>
		<tr>
			<td>
				<h2>
					Id:
					<%=el.getId()%>
					Nome:
					<%=el.getNome()%></h2> <br>
				<form action="Servlet" method="get">
					<input type="image" name="dettagli<%=el.getId()%>"
						src="images/<%=el.getImg()%>" alt="Submit"
						class="immaginedettagli">
					<p class="descrizione">
						<b>Descrizione: <%=el.getDescrizione()%><br>Costo: <%=el.getPrezzo()%>
							euri
						</b>
					</p>
					<input type="submit" name="dettagli<%=el.getId()%>"
						value="dettagli"> <input type="submit"
						name="aquista<%=el.getId()%>" value="aquista">
			</td>

			<td>
				<h2>
					Id:
					<%=el2.getId()%>
					Nome:
					<%=el2.getNome()%></h2> <input type="image"
				name="dettagli<%=el2.getId()%>" src="images/<%=el2.getImg()%>"
				alt="Submit" class="immaginedettagli">
				<p class="descrizione">
					<b>Descrizione: <%=el2.getDescrizione()%><br>Costo: <%=el2.getPrezzo()%>
						euri
					</b>
				</p> <input type="submit" name="dettagli<%=el2.getId()%>"
				value="dettagli"> <input type="submit"
				name="aquista<%=el2.getId()%>" value="aquista">
			</td>
		</tr>



		</form>
		<%
			}

			}
		%>

	</table>
</body>
</html>