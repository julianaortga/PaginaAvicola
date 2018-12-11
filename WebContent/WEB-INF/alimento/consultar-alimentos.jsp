<%@include file="../util/header.jspf"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Alimento"%>
<div id="mainContent" class="main-content bgc-grey-100">
	<div class="row text-center justify-content-md-center">
		<div class="col-12">
			<h2>Finca Experimental San Pablo - UFPS</h2>
			<h3>Consulta de Alimentos</h3>
			<hr>
		</div>
		<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">
			<div class="row">
				<div class="col-md-10">
					<h2>Listado de Alimentos</h2> 
				</div>	
					<div class="col-md-2"><a href="index?seleccion=4" type="button" class="btn btn-light">Volver</a>
				</div>	
			</div>	
			<table id="dataTable" class="table table-striped table-bordered"
				cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombrea</th>
						<th>Tipo de Alimento</th>
						<th width="30%">Acción</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Id</th>
						<th>Nombrea</th>
						<th>Tipo de Alimento</th>
						<th>Acción</th>
					</tr>
				</tfoot>
				<tbody>
					<%
						List<Alimento> lista = (List<Alimento>) request.getAttribute("lista");
						for (Alimento a : lista) {
					%>
					<tr>
						<th><%=a.getIdAlimento()%></th>
						<th><%=a.getNombre()%></th>
						<th><%=a.getTipo()%></th>
						<th><a href="alimento?seleccion=1&id=<%=a.getIdAlimento()%>"
							class="btn bdrs-10p btn-outline-danger">Modificar</a> <a
							href="material?seleccion=5&id=<%=a.getIdAlimento()%>"
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
