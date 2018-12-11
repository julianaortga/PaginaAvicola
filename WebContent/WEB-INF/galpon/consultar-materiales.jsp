<%@include file="../util/header.jspf"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Material"%>
<div id="mainContent" class="main-content bgc-grey-100">
	<div class="row text-center justify-content-md-center">
		<div class="col-12">
			<h2>Finca Experimental San Pablo - UFPS</h2>
			<h3>Consulta de Materiales</h3>
			<hr>
		</div>
		<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">
			<div class="row">
				<div class="col-md-10">
					<h2>Listado de Materiales</h2> 
				</div>	
					<div class="col-md-2"><a href="index?seleccion=3" type="button" class="btn btn-light">Volver</a>
				</div>	
			</div>	
			<table id="dataTable" class="table table-striped table-bordered"
				cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Id</th>
						<th>Fecha</th>
						<th>Descripcion</th>
						<th>Galpon</th>
						<th width="30%">Acción</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Id</th>
						<th>Fecha</th>
						<th>Descripcion</th>
						<th>Galpon</th>
						<th>Acción</th>
					</tr>
				</tfoot>
				<tbody>
					<%
						List<Material> lista = (List<Material>) request.getAttribute("lista");
						for (Material m : lista) {
					%>
					<tr>
						<th><%=m.getIdMaterial()%></th>
						<th><%=m.getFechaIngreso()%></th>
						<th><%=m.getDescripcion()%></th>
						<th><%=m.getGalpon().getIdGalpon()%> de tipo <%=m.getGalpon().getTipoGalpon() %></th>
						<th><a href="material?seleccion=1&id=<%=m.getIdMaterial()%>"
							class="btn bdrs-10p btn-outline-danger">Modificar</a> <a
							href="material?seleccion=5&id=<%=m.getIdMaterial()%>"
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
