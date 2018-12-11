<%@include file="../util/header.jspf"%>
<%@ page import="model.TipoAve"%>
<div id="mainContent" class="main-content bgc-grey-100">
	<div class="row text-center justify-content-md-center">
		<div class="col-12">
			<h2>Finca Experimental San Pablo - UFPS</h2>
			<h3>Registrar tipo de ave</h3>
			<hr>
		</div>
		<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">
			<%
				try {
					TipoAve temporal = (TipoAve) request.getAttribute("objeto");
					if (temporal != null) {
			%>
			<!-- Actualizar -->
			<form action="tipo-ave" method="POST">
				<input name="seleccion" value="4" type="hidden" /> <input name="id"
					value="<%=temporal.getIdTipoAve()%>" type="hidden" />
				<div class="form-group">
					<div class="form-group col-md-12" class="text-left">
						<label for="nombre" class="text-left">Nombre del tipo de
							ave</label> <input type="text" class="form-control" name="nombre"
							placeholder="Tipo de ave" value="<%=temporal.getNombre()%>"
							required>
					</div>
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-danger">Guardar</button>
					<a href="tipo-ave?seleccion=2" type="button" class="btn btn-light">Volver</a>
				</div>
			</form>
			<%
				} else {
			%>
			<!-- Registrar -->
			<form action="tipo-ave" method="POST">
				<input type="hidden" value="3" name="seleccion">
				<div class="form-group">
					<div class="form-group col-md-12" class="text-left">
						<label for="nombre" class="text-left">Nombre del tipo de
							ave</label> <input type="text" class="form-control" name="nombre"
							placeholder="Tipo de ave" required>
					</div>
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