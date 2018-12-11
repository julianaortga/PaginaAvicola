<%@include file="../util/header.jspf"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Lote"%>
<div id="mainContent" class="main-content bgc-grey-100">
	<div class="row text-center justify-content-md-center">
			<div class="col-12">
				<h2>Finca Experimental San Pablo - UFPS</h2>
				<h3>Registrar lote</h3>
				<hr>
			</div>
			<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">
             <%
				try {
					Lote temporal = (Lote) request.getAttribute("objeto");
					if (temporal != null) {
			%>
			<!-- Actualizar -->
             <form action="lote" method="POST">
             <input type="hidden" value="4" name="seleccion">
             <input name="id" value="<%=temporal.getIdLote()%>" type="hidden" />
                <div class="form-group">
                  <label for="obsInicial">Observación inicial</label>
                  <textarea class="form-control" name="obsInicial" value="<%=temporal.getObsInicial()%>" 
                   placeholder="Ingresa las observaciones iniciales"></textarea>
                </div>
                <div class="form-row">
                  <div class="form-group col-md-12">
                    <label for="ubicacion">Ubicación</label>
                    <input type="text" class="form-control" name="ubicacion" value="<%=temporal.getUbicacion()%>" 
                    placeholder="Ubicación" required>
                  </div>
                </div>
                <div class="text-center">
                  <button type="submit" class="btn btn-danger">Guardar</button>
                  <a href="lote?seleccion=2" type="button" class="btn btn-light">Volver</a>
                </div>
              </form>
            <%
				} else {
			%>
            <!-- Registrar -->
             <form action="lote" method="POST">
             <input type="hidden" value="3" name="seleccion">
                <div class="form-group">
                  <label for="obsInicial">Observación inicial</label>
                  <textarea class="form-control" name="obsInicial" placeholder="Ingresa las observaciones iniciales"></textarea>
                </div>
                <div class="form-row">
                  <div class="form-group col-md-12">
                    <label for="ubicacion">Ubicación</label>
                    <input type="text" class="form-control" name="ubicacion" placeholder="Ubicación" required>
                  </div>
                </div>
                <div class="text-center">
                  <button type="submit" class="btn btn-danger">Guardar</button>
                  <a href="lote?seleccion=2" type="button" class="btn btn-light">Volver</a>
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