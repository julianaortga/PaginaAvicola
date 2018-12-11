<%@include file="../util/header.jspf"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Lote"%>
<div id="mainContent" class="main-content bgc-grey-100">
	<div class="row text-center justify-content-md-center">
		<div class="col-12">
			<h2>Finca Experimental San Pablo - UFPS</h2>
			<h3>Consulta de Lotes</h3>
			<hr>
		</div>
		<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">
			<div class="row">
				<div class="col-md-10">
					<h2>Listado de Lotes</h2> 
				</div>	
					<div class="col-md-2"><a href="index?seleccion=3" type="button" class="btn btn-light">Volver</a>
				</div>	
			</div>	
			<table id="dataTable" class="table table-striped table-bordered"
				cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Id</th>
						<th>Observacion</th>
						<th>Ubicacion</th>
						<th width="30%">Acción</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Id</th>
						<th>Observacion</th>
						<th>Ubicacion</th>
						<th>Acción</th>
					</tr>
				</tfoot>
				<tbody>
					<%
						List<Lote> lista = (List<Lote>) request.getAttribute("lista");
						for (Lote l : lista) {
					%>
					<tr>
						<th><%=l.getIdLote()%></th>
						<th><%=l.getObsInicial()%></th>
						<th><%=l.getUbicacion()%></th>
						<th><a href="lote?seleccion=1&id=<%=l.getIdLote()%>"
							class="btn bdrs-10p btn-outline-danger">Modificar</a> <a
							href="lote?seleccion=5&id=<%=l.getIdLote()%>"
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
