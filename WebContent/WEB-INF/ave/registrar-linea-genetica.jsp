<%@include file="../util/header.jspf"%>
<%@ page import="java.util.List"%>
<%@ page import="model.LineaG"%>
<%@ page import="model.TipoAve"%>
<div id="mainContent" class="main-content bgc-grey-100">
	<div class="row text-center justify-content-md-center">
		<div class="col-12">
			<h2>Finca Experimental San Pablo - UFPS</h2>
			<h3>Registrar linea genética</h3>
			<hr>
		</div>
		<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">
			<%
				try {
					LineaG temporal = (LineaG) request.getAttribute("objeto");
					if (temporal != null) {
			%>
			<!-- Actualizar -->
			<form action="linea-genetica" method="POST">
				<input name="seleccion" value="4" type="hidden" /> <input name="id"
					value="<%=temporal.getIdLineaG()%>" type="hidden" />
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="nombre">Nombre de la linea genética</label> <input
							type="text" class="form-control" name="nombre"
							placeholder="Linea genética del ave"
							value="<%=temporal.getNombre()%>" required>
					</div>
					<div class="form-group col-md-6">
						<label for="tipoAveBean">Tipo</label> <select name="tipoAveId"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<%
								for (TipoAve ta : (List<TipoAve>) request.getAttribute("lista")) {
							%>
							<option value="<%=ta.getIdTipoAve()%>"><%=ta.getNombre()%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="observacion">Observación</label>
					<textarea class="form-control" name="observacion"
						placeholder="Ingresa las observaciones"
						value="<%=temporal.getObservacion()%>"></textarea>
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-danger">Guardar</button>
					<a href="linea-genetica?seleccion=2" type="button" class="btn btn-light">Volver</a>
				</div>

			</form>
			<%
				} else {
			%>
			<!-- Registrar -->
			<form action="linea-genetica" method="POST">
				<input name="seleccion" value="3" type="hidden" />
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="nombre">Nombre de la linea genética</label> <input
							type="text" class="form-control" name="nombre"
							placeholder="Linea genética del ave" required>
					</div>
					<div class="form-group col-md-6">
						<label for="tipoAveBean">Tipo</label> <select name="tipoAveId"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<%
								for (TipoAve ta : (List<TipoAve>) request.getAttribute("lista")) {
							%>
							<option value="<%=ta.getIdTipoAve()%>"><%=ta.getNombre()%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="observacion">Observación</label>
					<textarea class="form-control" name="observacion"
						placeholder="Ingresa las observaciones"></textarea>
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-danger">Guardar</button>
					<a href="index?seleccion=2" type="button" class="btn btn-light">Volver</a>
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