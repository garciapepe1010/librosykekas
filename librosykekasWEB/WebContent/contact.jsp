<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Libros y Kekas &mdash; Pagina de Make Garcia</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Libros y muñecas" />
	<meta name="keywords" content="Libros, muñecas,viajes" />
	<meta name="author" content="Make García" />



  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,300,700|Roboto:300,400' rel='stylesheet' type='text/css'>
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="${prm.HOST_STATIC_FILES}/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="${prm.HOST_STATIC_FILES}/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="${prm.HOST_STATIC_FILES}/css/bootstrap.css">

	<link rel="stylesheet" href="${prm.HOST_STATIC_FILES}/css2/style.css">


	<!-- Modernizr JS -->
	<script src="${prm.HOST_STATIC_FILES}/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="${prm.HOST_STATIC_FILES}/js/respond.min.js"></script>
	<![endif]-->
	
	        <style>
            /* jssor slider loading skin spin css */
            .jssorl-009-spin img {
                animation-name: jssorl-009-spin;
                animation-duration: 1.6s;
                animation-iteration-count: infinite;
                animation-timing-function: linear;
            }

            @keyframes jssorl-009-spin {
                from {
                    transform: rotate(0deg);
                }

                to {
                    transform: rotate(360deg);
                }
            }


            .jssorb051 .i {position:absolute;cursor:pointer;}
            .jssorb051 .i .b {fill:#fff;fill-opacity:0.5;}
            .jssorb051 .i:hover .b {fill-opacity:.7;}
            .jssorb051 .iav .b {fill-opacity: 1;}
            .jssorb051 .i.idn {opacity:.3;}

            .jssora051 {display:block;position:absolute;cursor:pointer;}
            .jssora051 .a {fill:none;stroke:#fff;stroke-width:360;stroke-miterlimit:10;}
            .jssora051:hover {opacity:.8;}
            .jssora051.jssora051dn {opacity:.5;}
            .jssora051.jssora051ds {opacity:.3;pointer-events:none;}
        </style>
        	<!-- jQuery -->
			<script src="${prm.HOST_STATIC_FILES}/js/jquery.min.js"></script>
			<!-- Slider-->
			<script src="${prm.HOST_STATIC_FILES}/js/jssor.slider.min.js"></script>
			<!-- jQuery Easing -->
			<script src="${prm.HOST_STATIC_FILES}/js/jquery.easing.1.3.js"></script>
			<!-- Bootstrap -->
			<script src="${prm.HOST_STATIC_FILES}/js/bootstrap.min.js"></script>
			<!-- Waypoints -->
			<script src="${prm.HOST_STATIC_FILES}/js/jquery.waypoints.min.js"></script>
		
			<!-- Main JS (Do not remove) -->
			<script src="${prm.HOST_STATIC_FILES}/js/main.js"></script>

	</head>
	<body>
	<div class="box-wrap">
		<header role="banner" id="fh5co-header">
			<div class="container">
				<nav class="navbar navbar-default">
					<div class="row">
						<c:set var="slider_sldrs" value="${sldrs}" scope="request" />
						<jsp:include page="slider.jsp" flush="true" />
					</div>
					<div class="row">
						<div class="col-md-3">
							<div class="fh5co-navbar-brand">
								<a class="fh5co-logo" href="index"><img src="${prm.HOST_STATIC_FILES}/images/brand-nav.png" alt="Closest Logo"></a>
							</div>
						</div>
						<div class="col-md-6">
							<ul class="nav text-center">
								<li ><a href="index"><span>Principal</span></a></li>
								<li><a href="inside">Acerca de</a></li>
								<li><a href="services">Comentarios</a></li>
								<li class="active"><a href="contact">Contacto</a></li>
							</ul>
						</div>
						<div class="col-md-3">
							<ul class="social">
								<li><a href="#"><i class="icon-twitter"></i></a></li>
								<li><a href="#"><i class="icon-dribbble"></i></a></li>
								<li><a href="#"><i class="icon-instagram"></i></a></li>
							</ul>
						</div>
					</div>
				</nav>
		  </div>
		</header>
		<!-- END: header -->
		<section id="intro">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-lg-offset-3 col-md-8 col-md-offset-2 text-center">
						<div class="intro animate-box">
							<c:if test="${not empty resultado}">
								<h1>${resultado}</h1>
							</c:if>
							<h1>Contacta conmigo</h1>
							<h2>Si cualquier cosa de este sitio web te ha llamado la atenci&oacute;n ponte en contacto conmigo</h2>
						</div>
					</div>
				</div>
			<div>
		</section>

		<main id="main">
			<div class="container">
				<div class="col-md-8 col-md-offset-2 animate-box">
					<form action="contact" method="post">
						<div class="form-group row">
							<div class="col-md-6 field">
								<label for="firstname">Nombre</label>
								<input type="text" name="firstname" id="firstname" class="form-control">
							</div>
							<div class="col-md-6 field">
								<label for="lastname">Apellidos</label>
								<input type="text" name="lastname" id="lastname" class="form-control">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-6 field">
								<label for="email">Email</label>
								<input type="text" name="email" id="email" class="form-control">
							</div>
							<div class="col-md-6 field">
								<label for="phone">Tel&eacute;fono</label>
								<input type="text" name="phone" id="phone" class="form-control">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-12 field">
								<label for="message">Mensaje</label>
								<textarea name="message" id="message" cols="30" rows="10" class="form-control"></textarea>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-12 field">
								<input type="submit" id="submit" class="btn btn-primary" value="Envia mensaje">
							</div>
						</div>
					</form>
				</div>
				<!-- <div class="col-md-4"></div> -->
			</div>
		</main>

		
		

		<section id="services">
			<div class="container">
				<div class="row">
					<div class="col-md-4 animate-box">
						<div class="service">
							<div class="service-icon">
								<i class="icon-command"></i>
							</div>
							<h2>Brand Identity</h2>	
							<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>
						</div>
					</div>
					<div class="col-md-4 animate-box">
						<div class="service">
							<div class="service-icon">
								<i class="icon-drop2"></i>
							</div>
							<h2>Web Design &amp; UI</h2>
							<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>
						</div>
					</div>
					<div class="col-md-4 animate-box">
						<div class="service">
							<div class="service-icon">
								<i class="icon-anchor"></i>
							</div>
							<h2>Development &amp; CMS</h2>
							<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>
						</div>
					</div>
				</div>
			</div>
		</section>

		

	

		<footer id="footer" role="contentinfo">
			<div class="container">
				<div class="row">
					<div class="col-md-12 text-center">
						<div class="footer-widget border">
							<p class="pull-left"><small>&copy; Make Garcia.</small></p>
							<p class="pull-right"><small> Designed by  <a href="http://freehtml5.co/" ta>freehtml5.co</a></small></p>
							
						</div>
					</div>
				</div>
			</div>
		</footer>
	</div>
	<!-- END: box-wrap -->
	

	<!-- Main JS (Do not remove) -->
	<script src="${prm.HOST_STATIC_FILES}/js/main.js"></script>

	</body>
</html>

