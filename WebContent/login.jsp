<!doctype html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,shrink-to-fit=no">
<title>Iniciar sesión - Finca experimental San Pablo UFPS</title>
<style>
#loader {
	transition: all .3s ease-in-out;
	opacity: 1;
	visibility: visible;
	position: fixed;
	height: 100vh;
	width: 100%;
	background: #fff;
	z-index: 90000
}

#loader.fadeOut {
	opacity: 0;
	visibility: hidden
}

.spinner {
	width: 40px;
	height: 40px;
	position: absolute;
	top: calc(50% - 20px);
	left: calc(50% - 20px);
	background-color: #333;
	border-radius: 100%;
	-webkit-animation: sk-scaleout 1s infinite ease-in-out;
	animation: sk-scaleout 1s infinite ease-in-out
}

@
-webkit-keyframes sk-scaleout { 0%{
	-webkit-transform: scale(0)
}

100%{
-webkit-transform










:scale(1)










;
opacity










:










0
}
}
@
keyframes sk-scaleout { 0%{
	-webkit-transform: scale(0);
	transform: scale(0)
}
100%{
-webkit-transform










:scale(1)










;
transform










:scale(1)










;
opacity










:










0
}
}
</style>
<link href="resources/css/style.css" rel="stylesheet">
</head>

<body class="app">
	<div id="loader">
		<div class="spinner"></div>
	</div>
	<script>
		window.addEventListener('load', function() {
			const loader = document.getElementById('loader');
			setTimeout(function() {
				loader.classList.add('fadeOut');
			}, 300);
		});
	</script>
	<div class="peers ai-s fxw-nw h-100vh">
		<div
			class="d-n@sm- peer peer-greed h-100 pos-r bgr-n bgpX-c bgpY-c bgsz-cv"
			style="background-image: url(resources/img/bg.jpg)">
			<div class="pos-a centerXY">
				<div class="bgc-white bdrs-10p pos-r"
					style="width: 120px; height: 120px">
					<img class="pos-a centerXY" src="resources/img/logoufps.png" alt="">
				</div>
			</div>
		</div>
		<div
			class="col-12 col-md-4 peer pX-40 pY-80 h-100 bgc-white scrollable pos-r"
			style="min-width: 320px">
			<h2 class="text-center">
				Finca experimental<br>San Pablo
			</h2>
			<h5 class="text-center">Universidad Francisco de Paula Santander</h5>
			<hr>
			<h4 class="fw-300 c-grey-900 mB-40 text-center">Iniciar sesión</h4>
			<form action="seguridad" method="POST">
				<div class="form-group">
					<label class="text-normal text-dark">Correo electrónico</label> <input
						name="correo" type="email" class="form-control"
						placeholder="Ingresa tu email">
				</div>
				<div class="form-group">
					<label class="text-normal text-dark">Contraseña</label> <input
						name="contrasena" type="password" class="form-control"
						placeholder="Ingresa tu contraseña">
				</div>
				<div class="form-group">
					<div class="peers ai-c jc-sb fxw-nw">
						<div class="peer">
							<div class="checkbox checkbox-circle checkbox-info peers ai-c">
								<input type="checkbox" id="inputCall1"
									name="inputCheckboxesCall" class="peer"> <label
									for="inputCall1" class="peers peer-greed js-sb ai-c"><span
									class="peer peer-greed">Recordarme</span></label>
							</div>
						</div>
						<div class="peer">
							<button href="index.jsp" class="btn btn-danger">Iniciar
								sesión</button>
						</div>
					</div>
				</div>
			</form>
			<%
				try {
					// justo así, pero no sesion, sino exito
					// si me entendiste? lo del alert no te lo hago porque para el front malo sí sooy :c vale amorchis tranquil
					boolean sesion = Boolean.parseBoolean(request.getAttribute("sesion").toString());
					if (!sesion) {
			%>
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				<strong>Error en el inicio de sesión!</strong> Verifique los datos de ingreso
				o que se encuentre registrado.
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>


			<%
				}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			%>
		</div>
	</div>
	<script type="text/javascript" src="resources/js/vendor.js"></script>
	<script type="text/javascript" src="resources/js/bundle.js"></script>
</body>

</html>