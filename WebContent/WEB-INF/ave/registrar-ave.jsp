<%@include file="../util/header.jspf"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Galpon"%>
<%@ page import="model.Raza"%>
<%@ page import="model.Ave"%>
<div id="mainContent" class="main-content bgc-grey-100">
	<div class="row text-center justify-content-md-center">
		<div class="col-12">
			<h2>Finca Experimental San Pablo - UFPS</h2>
			<h3>Registrar ave</h3>
			<hr>
		</div>
		<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">
			<%
				try {
					Ave temporal = (Ave) request.getAttribute("objeto");
					if (temporal != null) {
			%>
			<!-- Actualizar -->
			<form action="ave" method="POST">
				<input type="hidden" value="4" name="seleccion">
				 <input name="id" value="<%=temporal.getIdAve()%>" type="hidden" />
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="fechaIngreso">Fecha de ingreso</label> <input
							autofocus type="date" class="form-control" name="fechaIngreso"
							placeholder="Fecha de ingreso"
							value="<%=temporal.getFechaIngreso()%>" required>
					</div>
					<div class="form-group col-md-6">
						<label for="fechaBaja">Fecha de baja</label> <input type="date"
							class="form-control" name="fechaBaja" placeholder="Fecha de baja"
							value="<%=temporal.getFechaBaja()%>" required>
					</div>
				</div>
				<div class="form-group">
					<label for="obsInicial">Observación inicial</label>
					<textarea class="form-control" name="observacion" placeholder="Ingresa la observación inicial"
						value="<%=temporal.getObsInicial()%>"></textarea>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="peso">Peso (en gramos)</label> <input type="number"
							class="form-control" name="peso" placeholder="Peso en gramos"
							value="<%=temporal.getPeso()%> " required>
					</div>
					<div class="form-group col-md-6">
						<label for="edad">Edad (en meses)</label> <input type="number"
							class="form-control" name="edad" placeholder="Edad en meses"
							value="<%=temporal.getEdad()%>" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="raza">Raza</label> <select name="raza"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<%
								List<Raza> combo1 = (List<Raza>) request.getAttribute("r");
										for (Raza r : combo1) {
							%>
							<option value="<%=r.getIdRaza()%>"><%=r.getNombre()%></option>
							<%
								}
							%>
						</select>
					</div>
					<div class="form-group col-md-6">
						<label for="galpon">Galpón</label> <select name="galpon"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<%
								List<Galpon> combo2 = (List<Galpon>) request.getAttribute("g");
										for (Galpon g : combo2) {
							%>
							<option value="<%=g.getIdGalpon()%>"><%=g.getIdGalpon()%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>
				<fieldset class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<p>Sexaje</p>
						</div>
						<div class="col-sm-10">
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="radio" name="sexaje"
									id="sexajeM" value="M" checked="checked"> Masculino
								</label>
							</div>
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="radio" name="sexaje"
									id="sexajeF" value="F"> Femenino
								</label>
							</div>
						</div>
					</div>
				</fieldset>

				<button type="submit" class="btn btn-danger">Guardar</button>
				<a href="ave?seleccion=2" type="button" class="btn btn-light">Volver</a>
			</form>
			
			<%
				} else {
			%>
			<!-- Registrar -->
			<form action="ave" method="POST">
				<input type="hidden" value="3" name="seleccion">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="fechaIngreso">Fecha de ingreso</label> <input
							autofocus type="date" class="form-control" name="fechaIngreso"
							placeholder="Fecha de ingreso" required>
					</div>
					<div class="form-group col-md-6">
						<label for="fechaBaja">Fecha de baja</label> <input type="date"
							class="form-control" name="fechaBaja" placeholder="Fecha de baja"
							required>
					</div>
				</div>
				<div class="form-group">
					<label for="obsInicial">Observación inicial</label>
					<textarea class="form-control" name="observacion"
						placeholder="Ingresa la observación inicial"></textarea>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="peso">Peso (en gramos)</label> <input type="number"
							class="form-control" name="peso" placeholder="Peso en gramos"
							required>
					</div>
					<div class="form-group col-md-6">
						<label for="edad">Edad (en meses)</label> <input type="number"
							class="form-control" name="edad" placeholder="Edad en meses"
							required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="raza">Raza</label> <select name="raza"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<%
								for (Raza r : (List<Raza>) request.getAttribute("r")) {
							%>
							<option value="<%=r.getIdRaza()%>"><%=r.getNombre()%></option>
							<%
								}
							%>
						</select>
					</div>
					<div class="form-group col-md-6">
						<label for="galpon">Galpón</label> <select name="galpon"
							class="form-control">
							<option selected="selected">Seleccionar...</option>
							<%
								for (Galpon g : (List<Galpon>) request.getAttribute("g")) {
							%>
							<option value="<%=g.getIdGalpon()%>"><%=g.getIdGalpon()%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>
				<fieldset class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<p>Sexaje</p>
						</div>
						<div class="col-sm-10">
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="radio" name="sexaje"
									id="sexajeM" value="M" checked="checked"> Masculino
								</label>
							</div>
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="radio" name="sexaje"
									id="sexajeF" value="F"> Femenino
								</label>
							</div>
						</div>
					</div>
				</fieldset>
				<hr>
				<button type="submit" class="btn btn-danger">Guardar</button>
				<a href="index?seleccion=2" type="button" class="btn btn-light">Volver</a>
			</form>
			<hr>
			
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