<%@include file="../util/header.jspf"%>
<%@ page import="java.util.List"%>

	<div id="mainContent" class="main-content bgc-grey-100">
		<div class="row text-center justify-content-md-center">
			<div class="col-12">
				<h2>Finca Experimental San Pablo - UFPS</h2>
				<h3>Registrar usuario</h3>
				<hr>
			</div>
			<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">
				<form>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="nombre">Nombre</label> <input type="text"
								class="form-control" id="nombre"
								placeholder="Nombre completo del usuario" required>
						</div>
						<div class="form-group col-md-6">
							<label for="username">Username</label> <input type="text"
								class="form-control" id="username"
								placeholder="Username del usuario" required>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="correo">Correo electrónico</label> <input type="email"
								class="form-control" id="correo" placeholder="Correo electrónico"
								required>
						</div>
						<div class="form-group col-md-6">
							<label for="raza">Rol</label> <select id="rol"
								class="form-control">
								<option selected="selected">Seleccionar...</option>
								<option value="1">Usuario</option>
								<option value="2">Estudiante</option>
								<option value="3">Visitante</option>
							</select>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="contrasena">Contraseña</label> <input type="password"
								class="form-control" id="contrasena" placeholder="Contraseña"
								required>
						</div>
						<div class="form-group col-md-6">
							<label for="contrasena2">Repite la contraseña</label> <input
								type="password" class="form-control" id="contrasena2"
								placeholder="Contraseña" required>
						</div>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-danger">Guardar</button>
						<a type="button" class="btn btn-light">Volver</a>
					</div>
	
				</form>
			</div>
		</div>
	</div>
<%@include file="../util/footer.jspf"%>