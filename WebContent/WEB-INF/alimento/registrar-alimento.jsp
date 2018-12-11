<%@include file="../util/header.jspf"%>
<%@ page import="model.Alimento"%>
<div id="mainContent" class="main-content bgc-grey-100">
	<div class="row text-center justify-content-md-center">
		<div class="col-12">
			<h2>Finca Experimental San Pablo - UFPS</h2>
			<h3>Registrar alimento</h3>
			<hr>
		</div>
		<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">
			<%
				try {
					Alimento temporal = (Alimento) request.getAttribute("objeto");
					if (temporal != null) {
			%>
			<!-- Actualizar -->
			<form action="alimento" method="POST">
				<input name="seleccion" value="4" type="hidden" /> <input name="id"
					value="<%=temporal.getIdAlimento()%>" type="hidden" />
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="nombre">Nombre</label> <input type="text"
							class="form-control" name="nombre" value="<%=temporal.getNombre() %>"
							 placeholder="Nombre" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="tipo">Tipo</label> <select name="tipo"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<option value="granos">Granos de maíz</option>
							<option value="sorgo">Sorgo</option>
							<option value="maicillo">Maicillo</option>
							<option value="concentrado">Concentrado</option>
						</select>
					</div>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-danger">Guardar</button>
					<a href="alimento?seleccion=2" type="button" class="btn btn-light">Volver</a>
				</div>

			</form>
			<%
				} else {
			%>
			<!-- Registrar -->
			<form action="alimento" method="POST">
				<input type="hidden" value="3" name="seleccion">
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="nombre">Nombre</label> <input type="text"
							class="form-control" name="nombre" placeholder="Nombre" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="tipo">Tipo</label> <select name="tipo"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<option value="granos">Granos de maíz</option>
							<option value="sorgo">Sorgo</option>
							<option value="maicillo">Maicillo</option>
							<option value="concentrado">Concentrado</option>
						</select>
					</div>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-danger">Guardar</button>
					<a href="alimento?seleccion=2" type="button" class="btn btn-light">Volver</a>
				</div>

			</form>
			<%
				}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			%>
		</div>
	</div>
</div>
<%@include file="../util/footer.jspf"%>