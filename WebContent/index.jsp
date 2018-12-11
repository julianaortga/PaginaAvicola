<%@include file="WEB-INF/util/header.jspf"%>
<%@ page import="model.Usuario"%>
<%
	try {
		Usuario u = (Usuario) request.getSession().getAttribute("sesion");
		if (u == null) {
			response.sendRedirect("login.jsp");
		}
	} catch (Exception ex) {
		response.sendRedirect("login.jsp");
	}

%>

<div id="mainContent" class="main-content bgc-white-100">
	<h2 align="center">Finca Experimental San Pablo - UFPS</h2>
	<img id="img-finca" alt="" src="resources/img/finca.jpg">
</div>
<%@include file="WEB-INF/util/footer.jspf"%>