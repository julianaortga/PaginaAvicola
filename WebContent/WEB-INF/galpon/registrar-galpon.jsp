<%@include file="../util/header.jspf"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Galpon"%>
<%@ page import="model.Lote"%>
<div id="mainContent" class="main-content bgc-grey-100">
	<div class="row text-center justify-content-md-center">
		<div class="col-12">
			<h2>Finca Experimental San Pablo - UFPS</h2>
			<h3>Registrar galpón</h3>
			<hr>
		</div>
		<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">

			<%
				try {
					Galpon temporal = (Galpon) request.getAttribute("objeto");
					if (temporal != null) {
			%>
			<!-- Actualizar -->
			<form action="galpon" method="POST">
				<input type="hidden" value="4" name="seleccion"> 
				<input name="id" value="<%=temporal.getIdGalpon()%>" type="hidden" />
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="altura">Altura</label> <input type="number" step="0.1"
							class="form-control" name="altura"
							values="<%=temporal.getAltura()%>"
							placeholder="Altura del galpón" required>
					</div>
					<div class="form-group col-md-6">
						<label for="anchura">Anchura</label> <input type="number"
							step="0.1" class="form-control" name="anchura"
							values="<%=temporal.getAnchura()%>"
							placeholder="Anchura del galpón" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="estado">Estado</label> <select name="estado"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<option value="Ocupado">Ocupado</option>
							<option value="En limpieza">En limpieza</option>
							<option value="En preparación">En preparación</option>
							<option value="Vacío">Vacío</option>
						</select>
					</div>
					<div class="form-group col-md-6">
						<label for="tipoGalpon">Tipo</label> <select name="tipoGalpon"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<option value="Gallina ponedora">Gallina ponedora</option>
							<option value="Pollo de engorde">Pollo de engorde</option>
							<option value="Codorniz">Codorniz</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="obsInicial">Observación inicial</label>
					<textarea class="form-control" name="obsInicial"
						value="<%=temporal.getObsInicial()%>"
						placeholder="Ingresa la observación inicial"></textarea>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="topeMax">Tope máximo</label> <input type="number"
							class="form-control" name="topeMax"
							value="<%=temporal.getTopeMax()%>" placeholder="Tope Máximo"
							required>
					</div>
					<div class="form-group col-md-6">
						<label for="lote">Lote</label> <select name="lote"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<%
								for (Lote l : (List<Lote>) request.getAttribute("lista")) {
							%>
							<option value="<%=l.getIdLote()%>"><%=l.getIdLote()%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-danger">Guardar</button>
					<a href="galpon?seleccion=2" type="button" class="btn btn-light">Volver</a>
				</div>
			</form>
			<%
				} else {
			%>
			<!-- Registrar -->
			<form action="galpon" method="POST">
				<input type="hidden" value="3" name="seleccion">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="altura">Altura</label> <input type="number" step="0.1"
							class="form-control" name="altura" placeholder="Altura del galpón"
							required>
					</div>
					<div class="form-group col-md-6">
						<label for="anchura">Anchura</label> <input type="number"
							step="0.1" class="form-control" name="anchura"
							placeholder="Anchura del galpón" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="estado">Estado</label> <select name="estado"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<option value="Ocupado">Ocupado</option>
							<option value="En limpieza">En limpieza</option>
							<option value="En preparación">En preparación</option>
							<option value="Vacío">Vacíoo</option>
						</select>
					</div>
					<div class="form-group col-md-6">
						<label for="tipoGalpon">Tipo</label> <select name="tipoGalpon"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<option value="Gallina ponedora">Gallina ponedora</option>
							<option value="Pollo de engorde">Pollo de engorde</option>
							<option value="Codorniz">Codorniz</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="obsInicial">Observación inicial</label>
					<textarea class="form-control" name="obsInicial"
						placeholder="Ingresa la observación inicial"></textarea>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="topeMax">Tope máximo</label> <input type="number"
							class="form-control" name="topeMax" placeholder="Tope Máximo"
							required>
					</div>
					<div class="form-group col-md-6">
						<label for="lote">Lote</label> <select name="lote"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<%
								for (Lote l : (List<Lote>) request.getAttribute("lista")) {
							%>
							<option value="<%=l.getIdLote()%>"><%=l.getIdLote()%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-danger">Guardar</button>
					<a href="galpon?seleccion=2" type="button" class="btn btn-light">Volver</a>
				</div>

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