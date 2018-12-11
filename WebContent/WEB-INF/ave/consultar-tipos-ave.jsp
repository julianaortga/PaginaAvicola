<%@include file="../util/header.jspf"%>
<%@ page import="java.util.List"%>
<%@ page import="model.TipoAve"%>
<div id="mainContent" class="main-content bgc-grey-100">
	<div class="row text-center justify-content-md-center">
		<div class="col-12">
			<h2>Finca Experimental San Pablo - UFPS</h2>
			<h3>Consulta de tipos de aves</h3>
			<hr>
		</div>
		<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">
			<div class="row">
				<div class="col-md-10">
					<h2>Listado de tipos de aves</h2> 
				</div>	
					<div class="col-md-2"><a href="index?seleccion=2" type="button" class="btn btn-light">Volver</a>
				</div>	
			</div>	
			<table id="dataTable" class="table table-striped table-bordered"
				cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th width="30%">Acción</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Acción</th>
					</tr>
				</tfoot>
				<tbody>
					<%
						List<TipoAve> lista = (List<TipoAve>) request.getAttribute("lista");
						for (TipoAve ta : lista) {
					%>
					<tr>
						<th><%=ta.getIdTipoAve()%></th>
						<th><%=ta.getNombre()%></th>
						<th><a href="tipo-ave?seleccion=1&id=<%=ta.getIdTipoAve()%>"
							class="btn bdrs-10p btn-outline-danger">Modificar</a> <a
							href="tipo-ave?seleccion=5&id=<%=ta.getIdTipoAve()%>"
							class="btn bdrs-10p btn-danger">Eliminar</a></th>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@include file="../util/footer.jspf"%>
