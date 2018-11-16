<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Rapid Cargo EIRL</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">


  <!-- Twitter Cards integration: https://dev.twitter.com/cards/  -->
  <meta name="twitter:card" content="summary">
  <meta name="twitter:site" content="">
  <meta name="twitter:title" content="">
  <meta name="twitter:description" content="">
  <meta name="twitter:image" content="">

  <!-- Fav and touch icons -->
  <s:url value="/resources/bootstrapExtranet/img/icons" var="icons"/>
  <s:url value="/resources/bootstrapExtranet/img" var="image"/>
  <link rel="shortcut icon" href="${icons}/favicon.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${icons}/114x114.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${icons}/72x72.png">
  <link rel="apple-touch-icon-precomposed" href="${icons}/default.png">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" rel="stylesheet">

  <!-- Bootstrap CSS File -->
  <s:url value="/resources/bootstrapExtranet/lib/bootstrap/css/bootstrap.min.css" var="css1"/>
  <link href="${css1}" rel="stylesheet">

  <!-- Libraries CSS Files -->
  <s:url value="/resources/bootstrapExtranet/lib/font-awesome/css/font-awesome.min.css" var="css2"/>
  <link href="${css2}" rel="stylesheet">
  <s:url value="/resources/bootstrapExtranet/lib/owlcarousel/owl.carousel.min.css" var="css3"/>
  <link href="${css3}" rel="stylesheet">
  <s:url value="/resources/bootstrapExtranet/lib/owlcarousel/owl.theme.min.css" var="css4"/>
  <link href="${css4}" rel="stylesheet">
  <s:url value="/resources/bootstrapExtranet/lib/owlcarousel/owl.transitions.min.css" var="css5"/>
  <link href="${css5}" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <s:url value="/resources/bootstrapExtranet/css/style.css" var="maincss"/>
  <link href="${maincss}" rel="stylesheet">

  <!--Your custom colour override - predefined colours are: colour-blue.css, colour-green.css, colour-lavander.css, orange is default-->
  <link href="#" id="colour-scheme" rel="stylesheet">

  <!-- =======================================================
    Theme Name: Flexor
    Theme URL: https://bootstrapmade.com/flexor-free-multipurpose-bootstrap-template/
    Author: BootstrapMade.com
    Author URL: https://bootstrapmade.com
  ======================================================= -->
</head>

<body class="page-index has-hero">
  <!--Change the background class to alter background image, options are: benches, boots, buildings, city, metro -->
  <div id="background-wrapper" class="buildings" data-stellar-background-ratio="0.1">

    <!-- ======== @Region: #navigation ======== -->
    <div id="navigation" class="wrapper">
      <!--Header & navbar-branding region-->
      <div class="header">
        <div class="header-inner container">
          <div class="row">
            <div class="col-md-8">
              <!--navbar-branding/logo - hidden image tag & site name so things like Facebook to pick up, actual logo set via CSS for flexibility -->
              <a class="navbar-brand" href="${pageContext.request.contextPath}/" title="Home">
              </a>
            </div>
            <!--header rightside-->
            <div class="col-md-4">
              <!--user menu-->
              <ul class="list-inline user-menu pull-right">
                <li class=""><i class="fa fa-sign-in text-primary"></i> <a href="${pageContext.request.contextPath}/login" class="text-uppercase">Login</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="container">
        <div class="navbar navbar-default">
          <!--mobile collapse menu button-->
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <!--social media icons-->
          <div class="navbar-text social-media social-media-inline pull-right">
            <!--@todo: replace with company social media details-->
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
            <a href="#"><i class="fa fa-google-plus"></i></a>
          </div>
          <!--everything within this div is collapsed on mobile-->
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav" id="main-menu">
              <li class="icon-link">
                <a href="${pageContext.request.contextPath}/"><i class="fa fa-home"></i></a>
              </li>
              <li><a href="#">Seguimiento</a></li>
              <li>
                <a href="#">Sobre Nosotros</a>
              </li>
              <li>
                <a href="#">Contacto</a>
              </li>
            </ul>
          </div>
          <!--/.navbar-collapse -->
        </div>
      </div>
    </div>
    <div class="hero" id="highlighted">
      <div class="inner">
        <!--Slideshow-->
        <div id="highlighted-slider" class="container">
          <div class="item-slider" data-toggle="owlcarousel" data-owlcarousel-settings='{"singleItem":true, "navigation":true, "transitionStyle":"fadeUp"}'>
            <!--Slideshow content-->
            <!--Slide 1-->
            <div class="item">
              <div class="row">
                <div class="col-md-6 col-md-push-6 item-caption">
                  <h2 class="h1 text-weight-light">
                     <span class="text-primary">Rapid Cargo</span>
                    </h2>
                  <h4>
                      Envío de encomiendas en las ciudades más importantes del país. 100% garantizado.
                    </h4>
                  <p>Nos consolidamos como una de las empresas más serias en todo el pais debido al 
                     compromiso que tenemos con cada uno de nuestros clientes y sus encomiendas,
                     garantizando la seguridad de las mismas en todo momento. </p>
                  <a href="https://bootstrapmade.com" class="btn btn-more btn-lg i-right">Envía ahora <i class="fa fa-plus"></i></a>
                </div>
                <div class="col-md-6 col-md-pull-6 hidden-xs">
                  <img src="${image}/slides/slide3.png" alt="Slide 1" class="center-block img-responsive">
                </div>
              </div>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>

 
  <!-- ======== @Region: #content ======== -->
  <div id="content">
    <!-- Services -->
    <div class="services block block-bg-gradient block-border-bottom">
      <div class="container">
        <h2 class="block-title">
            Nuestros servicios
          </h2>
        <div class="row">
          <div class="col-md-4 text-center">
            <span class="fa-stack fa-5x">
              <i class="fa fa-circle fa-stack-2x text-primary"></i>
              <i class="fa fa-group fa-stack-1x fa-inverse"></i> </span>
            <h4 class="text-weight-strong">
                Veloces como el rayo
              </h4>
            <p>Entregamos sus encomiendas en un rango de entre 24-48 horas después de que usted lo envía.</p>
            <p>
              <a href="#" class="btn btn-more i-right">Leer más <i class="fa fa-angle-right"></i></a>
            </p>
          </div>
          <div class="col-md-4 text-center">
            <span class="fa-stack fa-5x">
              <i class="fa fa-circle fa-stack-2x text-primary"></i>
              <i class="fa fa-pencil fa-stack-1x fa-inverse"></i> </span>
            <h4 class="text-weight-strong">
                ¿Alguien dijo caro?
              </h4>
            <p>En RapidCargo Encomiendas pensamos que no tiene porqué pagar más por un buen servicio. Usted merece tenerlo por un precio justo.</p>
            <p>
              <a href="#" class="btn btn-more i-right">Leer más <i class="fa fa-angle-right"></i></a>
            </p>
          </div>
          <div class="col-md-4 text-center">
            <span class="fa-stack fa-5x">
              <i class="fa fa-circle fa-stack-2x text-primary"></i>
              <i class="fa fa-cogs fa-stack-1x fa-inverse"></i> </span>
            <h4 class="text-weight-strong">
                Su pedido bajo siete llaves
              </h4>
            <p> Cuando usted envía algo con nosotros, puede tener la confianza de que no se perderá o llegará dañado. </p>
            <p>
              <a href="#" class="btn btn-more i-right">Leer más <i class="fa fa-angle-right"></i></a>
            </p>
          </div>
        </div>
      </div>
    </div>
</div>
  <!-- ======== @Region: #footer ======== -->
  <footer id="footer" class="block block-bg-grey-dark" data-block-bg-img="img/bg_footer-map.png" data-stellar-background-ratio="0.4">
    <div class="container">

      <div class="row" id="contact">
        <div class="col-md-3">
        </div>
        <div class="col-md-3">
          <address>
              <strong>Rapid Cargo Encomiendas EIRL</strong>
              <br>
              <i class="fa fa-map-pin fa-fw text-primary"></i> Jr. Las Amatistas 1123 - Surco, Lima, Perú
              <br>
              <i class="fa fa-phone fa-fw text-primary"></i> 019223 8092344
              <br>
              <i class="fa fa-envelope-o fa-fw text-primary"></i> informes@rcargo.com
              <br>
            </address>
        </div>

        <div class="col-md-3">
          <h4 class="text-uppercase">
              Siguenos en:
            </h4>
          <!--social media icons-->
          <div class="social-media social-media-stacked">
            <!--@todo: replace with company social media details-->
            <a href="#"><i class="fa fa-twitter fa-fw"></i> Twitter</a>
            <a href="#"><i class="fa fa-facebook fa-fw"></i> Facebook</a>
            <a href="#"><i class="fa fa-linkedin fa-fw"></i> LinkedIn</a>
            <a href="#"><i class="fa fa-google-plus fa-fw"></i> Google+</a>
          </div>
        </div>

      </div>

      <div class="row subfooter">
        <!--@todo: replace with company copyright details-->
        <div class="col-md-7">
          <p>Copyright © Rapid Cargo Encomiendas 2014-2017 </p>
          <div class="credits">
            <!--
              All the links in the footer should remain intact.
              You can delete the links only if you purchased the pro version.
              Licensing information: https://bootstrapmade.com/license/
              Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Flexor
            -->
            <a href="#">Portal web Rapid Cargo </a> de bulletclub.com
          </div>
        </div>
        <div class="col-md-5">
          <ul class="list-inline pull-right">
            <li><a href="#">Terminos</a></li>
            <li><a href="#">Privacidad</a></li>
            <li><a href="#">Contáctanos</a></li>
          </ul>
        </div>
      </div>

      <a href="#top" class="scrolltop">Top</a>

    </div>
  </footer>

  <!-- Required JavaScript Libraries -->
  <s:url value="/resources/bootstrapExtranet/lib/jquery/jquery.min.js" var="js1"/>
  <script src="${js1}"></script>
  <s:url value="/resources/bootstrapExtranet/lib/bootstrap/js/bootstrap.min.js" var="js2"/>
  <script src="${js2}"></script>
  <s:url value="/resources/bootstrapExtranet/lib/owlcarousel/owl.carousel.min.js" var="js3"/>
  <script src="${js3}"></script>
  <s:url value="/resources/bootstrapExtranet/lib/stellar/stellar.min.js" var="js4"/>
  <script src="${js4}"></script>
  <s:url value="/resources/bootstrapExtranet/lib/waypoints/waypoints.min.js" var="js5"/>
  <script src="${js5}"></script>
  <s:url value="/resources/bootstrapExtranet/lib/counterup/counterup.min.js" var="js6"/>
  <script src="${js6}"></script>
  <s:url value="/resources/bootstrapExtranet/contactform/contactform.js" var="js7"/>
  <script src="${js7}"></script>

  <!-- Template Specisifc Custom Javascript File -->
  
  <script src="${js8}"></script>

  <!--Custom scripts demo background & colour switcher - OPTIONAL -->
  
  <s:url value="/resources/bootstrapExtranet/js/color-switcher.js" var="js9"/>
  <script src="${js9}"></script>

  <!--Contactform script -->
   <s:url value="/resources/bootstrapExtranet/contactform/contactform.js" var="js10"/>
  <script src="${js10}"></script>
</body>
</html>
