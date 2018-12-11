<%@include file="../util/header.jspf"%>
<div id="mainContent" class="main-content bgc-grey-100">
          <div class="row text-center">
            <div class="col-12">
              <h2>Finca Experimental San Pablo - UFPS</h2>
              <h3>Módulo de lotes y galpones</h3>
              <hr>
            </div>
            <div class="space"></div>
            <div class="col-md-4 col-sm-12">
              <div class="layers bd bgc-white">
                <img src="resources/img/lote.jpg" alt="" class="img-fluid">
                <div class="overlay-card">
                  <a href="lote?seleccion=1" class="btn cur-p btn-outline-danger bdrs-10em" type="button">Registrar</a>
                  <a href="lote?seleccion=2" class="btn cur-p btn-outline-danger bdrs-10em" type="button">Consultar</a>
                  <h3>Lotes</h3>
                </div>
              </div>
            </div>
            <div class="col-md-4 col-sm-12">
              <div class="layers bd bgc-white">
                <img src="resources/img/galpon.jpg" alt="" class="img-fluid">
                <div class="overlay-card">
                    <a href="galpon?seleccion=1" class="btn cur-p btn-outline-danger bdrs-10em" type="button">Registrar</a>
                    <a href="galpon?seleccion=2" class="btn cur-p btn-outline-danger bdrs-10em" type="button">Consultar</a>
                  <h3>Galpones</h3>
                </div>
              </div>
            </div>
            <div class="col-md-4 col-sm-12">
              <div class="layers bd bgc-white">
                <img src="resources/img/material.jpg" alt="" class="img-fluid">
                <div class="overlay-card">
                    <a href="material?seleccion=1" class="btn cur-p btn-outline-danger bdrs-10em" type="button">Registrar</a>
                    <a href="material?seleccion=2" class="btn cur-p btn-outline-danger bdrs-10em" type="button">Consultar</a>
                  <h3>Material</h3>
                </div>
              </div>
            </div>
          </div>
        </div>
<%@include file="../util/footer.jspf"%>