<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Administrador librosykekas</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="${prm.HOST_STATIC_FILES}/assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="${prm.HOST_STATIC_FILES}/assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="${prm.HOST_STATIC_FILES}/assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index">Administrador librosykekas</a> 
            </div>
  <div style="color: white;
padding: 15px 50px 5px 50px;
float: right;
font-size: 16px;"> Last access : 30 May 2014 &nbsp; <a href="LogOut" class="btn btn-danger square-btn-adjust">Logout</a> </div>
        </nav>   
           <!-- /. NAV TOP  -->
                <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
				<li class="text-center">
                    <img src="${prm.HOST_STATIC_FILES}/assets/img/find_user.png" class="user-image img-responsive"/>
					</li>
					
                    <li>
                        <a href="index.jsp"><i class="fa fa-dashboard fa-3x"></i> Dashboard</a>
                    </li>
                    <li>
                        <a  href="IndexWebPage"><i class="fa fa-desktop fa-3x"></i>Mant. Index</a>
                    </li>
                    <li>
                        <a  class="active-menu"  href="EdFabWebPage"><i class="fa fa-desktop fa-3x"></i>Mant. Ed. Fab.</a>
                    </li>
                    <li>
                        <a  href="ItemWebPage"><i class="fa fa-desktop fa-3x"></i>Mant. Items.</a>
                    </li>
                    <li>
                        <a  href="CategoriaWebPage"><i class="fa fa-desktop fa-3x"></i>Mant. Categorias.</a>
                    </li>
                    <li>
                        <a href="AcercaDeWebPage"><i class="fa fa-desktop fa-3x"></i>Mant. Acerca De.</a>
                    </li>
                   	<li>
                        <a  href="Slider"><i class="fa fa-desktop fa-3x"></i>Mant. Slider.</a>
                    </li>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Mant. Ed. Fab.</h2>   
                        <h5>Bienvenida tata. Me alegro de verte de nuevo.</h5>
                       
                    </div>
                </div>
                 <!-- /. ROW  -->
                 <hr />
               <div class="row">
                <div class="col-md-12">
                    <!-- Form Elements -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Editoriales y F&aacute;bricas

						         <c:if test = "${EditFabAccion == 'E'}">
						            (Edici&oacute;n)
						         </c:if>
						         
						         <c:if test = "${EditFabAccion == 'A'}">
						           (A&ntilde;adir)
						         </c:if>
						         
						         <c:if test = "${EditFabAccion == 'D'}">
						           (Duplicar)
						         </c:if>
						         
						         <c:if test = "${EditFabAccion == 'X'}">
						           (Eliminar)
						         </c:if>

                            </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <h3>Basic Form Examples</h3>
                                    <form role="form"  method="post" action="EdFabWebPage" >
                                    	<div class="form-group" id="presentation">
                                            <label>C&oacute;digo</label>
                                            <label>${EditFab.code}</label>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Direcci&oacute;n</label>
   
									         	<c:if  test = "${EditFabAccion == 'A'}">
													<input class="form-control" name="direccion"/>
									         	</c:if>
									         	<c:if  test = "${EditFabAccion == 'E'}">
													<input class="form-control" name="direccion" value="${EditFab.direccion}"/>
									         	</c:if>
									         	<c:if  test = "${EditFabAccion == 'D'}">
													<input class="form-control" name="direccion" value="${EditFab.direccion}" editable=false/>
									         	</c:if>
									         	<c:if  test = "${EditFabAccion == 'X'}">
													<input class="form-control" name="direccion" value="${EditFab.direccion}" editable=false/>
									         	</c:if>

                                            <p class="help-block">Direcci&oacute;n de la editorial o f&aacute;brica</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>email</label>
  
									         	<c:if   test = "${EditFabAccion == 'A'}">
													<input class="form-control" name="email"/>
									         	</c:if>
									         	<c:if   test = "${EditFabAccion == 'E'}">
													<input class="form-control" name="email" value="${EditFab.email}"/>
									         	</c:if>
									         	<c:if  test = "${EditFabAccion == 'D'}">
													<input class="form-control" name="email" value="${EditFab.email}" editable=false/>
									         	</c:if>
									         	<c:if  test = "${EditFabAccion == 'X'}">
													<input class="form-control" name="email" value="${EditFab.email}" editable=false/>
									         	</c:if>

                                            <p class="help-block">email de la editorial o f&aacute;brica</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Nombre</label>
  
									         	<c:if   test = "${EditFabAccion == 'A'}">
													<input class="form-control" name="nombre" value="${EditFab.nombre}"/>
									         	</c:if>
									         	<c:if   test = "${EditFabAccion == 'E'}">
													<input class="form-control" name="nombre" value="${EditFab.nombre}" />
									         	</c:if>	
									         	<c:if  test = "${EditFabAccion == 'D'}">
													<input class="form-control" name="nombre" value="${EditFab.nombre}" editable=false/>
									         	</c:if>
									         	<c:if  test = "${EditFabAccion == 'X'}">
													<input class="form-control" name="nombre" value="${EditFab.nombre}" editable=false/>
									         	</c:if>

                                            <p class="help-block">Nombre de la editorial o f&aacute;brica</p>
                                        </div>
                                          
								         <c:if  test = "${EditFabAccion == 'E'}">
								            <input type="hidden" name="codigo" value="${EditFab.code}">
                                            <input type="hidden" name="accion" value="XE">
								         </c:if>
								         
								         <c:if   test = "${EditFabAccion == 'A'}">
								           <input type="hidden" name="codigo" value="${EditFab.code}">
                                            <input type="hidden" name="accion" value="XA">
								         </c:if>
								         
								         <c:if   test = "${EditFabAccion == 'D'}">
								           <input type="hidden" name="codigo" value="${EditFab.code}">
                                            <input type="hidden" name="accion" value="XD">
								         </c:if>
								         
								         <c:if   test = "${EditFabAccion == 'X'}">
								           <input type="hidden" name="codigo" value="${EditFab.code}">
                                            <input type="hidden" name="accion" value="XX">
								         </c:if>

                                        
                                        <button type="submit" class="btn btn-default">Guardar</button>
                                    </form>
                                    <br />

                                </div>
                            </div>
                        </div>
                    </div>
                     <!-- End Form Elements -->
                </div>
            </div>
                <!-- /. ROW  -->
    </div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="${prm.HOST_STATIC_FILES}/assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="${prm.HOST_STATIC_FILES}/assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="${prm.HOST_STATIC_FILES}/assets/js/jquery.metisMenu.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="${prm.HOST_STATIC_FILES}/assets/js/custom.js"></script>
    
   
</body>
</html>
