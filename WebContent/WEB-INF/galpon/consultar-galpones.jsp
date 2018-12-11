<%@include file="../util/header.jspf"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Galpon"%>
		
<div id="mainContent" class="main-content bgc-grey-100">
	<div class="row text-center justify-content-md-center">
		<div class="col-12">
			<h2>Finca Experimental San Pablo - UFPS</h2>
			<h3>Consulta de galpones</h3>
			<hr>
		</div>
		
		<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">
			<div class="row">
				<div class="col-md-10">
					<h2>Listado de galpones</h2> 
				</div>	
					<div class="col-md-2"><a href="index?seleccion=3" type="button" class="btn btn-light">Volver</a>
				</div>	
			</div>	
			<table id="dataTable" class="table table-striped table-bordered"
				cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Id</th>
						<th>Observación Inicial</th>
						<th>Tipo de Galpón</th>
						<th>Estado</th>
						<th>Altura</th>
						<th>Anchura</th>
						<th>Tope Máximo</th>
						<th>Lote</th>
						<th width="30%">Acción</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Id</th>
						<th>Observación Inicial</th>
						<th>Tipo de Galpón</th>
						<th>Estado</th>
						<th>Altura</th>
						<th>Anchura</th>
						<th>Tope Máximo</th>
						<th>Lote</th>
						<th>Acción</th>
					</tr>
				</tfoot>
				<tbody>
					<%
						for (Galpon g : (List<Galpon>) request.getAttribute("lista")) {
					%>
					<tr>
						<th><%= g.getIdGalpon()%></th>
						<th><%= g.getObsInicial()%></th>
						<th><%= g.getTipoGalpon()%></th>
						<th><%= g.getEstado()%></th>
						<th><%= g.getAltura()%></th>
						<th><%= g.getAnchura()%></th>
						<th><%= g.getTopeMax()%></th>
						<th><%= g.getLoteBean().getIdLote()%></th>
						<th><a href="galpon?seleccion=1&id=<%=g.getIdGalpon()%>"
							class="btn bdrs-10p btn-outline-danger">Modificar</a> <a
							href="galpon?seleccion=5&id=<%=g.getIdGalpon()%>"
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