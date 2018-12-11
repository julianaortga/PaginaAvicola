<%@include file="../util/header.jspf"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Material"%>
<%@ page import="model.Galpon"%>
<div id="mainContent" class="main-content bgc-grey-100">
	<div class="row text-center justify-content-md-center">
		<div class="col-12">
			<h2>Finca Experimental San Pablo - UFPS</h2>
			<h3>Registrar Galpon</h3>
			<hr>
		</div>
		<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">

			<%
				try {
					Material temporal = (Material) request.getAttribute("objeto");
					if (temporal != null) {
			%>
			<!-- Actualizar -->
			<form action="material" method="POST">
				<input type="hidden" value="4" name="seleccion"> <input
					name="id" value="<%=temporal.getIdMaterial()%>" type="hidden" />
				<div class="form-group">
					<label for="descripcion">Descripción</label>
					<textarea class="form-control" name="descripcion"
						value="<%=temporal.getDescripcion()%>"
						placeholder="Ingresa la descripción del material"></textarea>
				</div>

				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="fechaIngreso">Fecha de ingreso</label> <input
							type="date" class="form-control" name="fechaIngreso"
							value="<%=temporal.getFechaIngreso()%>"
							placeholder="Fecha de ingreso" required>
					</div>
					<div class="form-group col-md-6">
						<label for="galpon">Galpón</label> <select name="galpon"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<%
								for (Galpon g : (List<Galpon>) request.getAttribute("lista")) {
							%>
							<option value="<%=g.getIdGalpon()%>"><%=g.getIdGalpon()%>
								-
								<%=g.getTipoGalpon()%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-danger">Guardar</button>
					<a href="index?seleccion=3" type="button" class="btn btn-light">Volver</a>
				</div>
			</form>
			<%
				} else {
			%>
			<!-- Registrar -->
			<form action="material" method="POST">
				<input name="seleccion" value="3" type="hidden" />
				<div class="form-group">
					<label for="descripcion">Descripción</label>
					<textarea class="form-control" name="descripcion"
						placeholder="Ingresa la descripción del material"></textarea>
				</div>

				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="fechaIngreso">Fecha de ingreso</label> <input
							type="date" class="form-control" name="fechaIngreso"
							placeholder="Fecha de ingreso" required>
					</div>
					<div class="form-group col-md-6">
						<label for="galpon">Galpón</label> <select name="galpon"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<%
								for (Galpon g : (List<Galpon>) request.getAttribute("lista")) {
							%>
							<option value="<%=g.getIdGalpon()%>"><%=g.getIdGalpon()%>
								-
								<%=g.getTipoGalpon()%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-danger">Guardar</button>
					<a href="index?seleccion=3" type="button" class="btn btn-light">Volver</a>
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