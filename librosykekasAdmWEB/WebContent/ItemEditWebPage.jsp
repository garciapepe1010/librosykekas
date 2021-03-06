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
    <link type="text/css" rel="stylesheet" href="http://jqueryte.com/css/temp.css" charset="utf-8" >
	<link type="text/css" rel="stylesheet" href="http://jqueryte.com/css/jquery-te.css" charset="utf-8" >
	<link type="text/css" rel="stylesheet" href="http://jqueryte.com/css/jquery-te-green.css" charset="utf-8" >
	<link type="text/css" rel="stylesheet" href="http://jqueryte.com/css/jquery.snippet.min.css" charset="utf-8" >
	
	<script type="text/javascript" src="https://code.jquery.com/jquery.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="${prm.HOST_STATIC_FILES}/js/jquery-te-1.4.0.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="http://jqueryte.com/js/jquery.snippet.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="http://jqueryte.com/js/site.js" charset="utf-8"></script>
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
                        <a  href="EdFabWebPage"><i class="fa fa-desktop fa-3x"></i>Mant. Ed. Fab.</a>
                    </li>
                    <li>
                        <a  class="active-menu"  href="ItemWebPage"><i class="fa fa-desktop fa-3x"></i>Mant. Items.</a>
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
                     <h2>Mant. Items.</h2>   
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
                            Items
						         <c:if test = "${ItemAccion == 'E'}">
						            (Edici&oacute;n)
						         </c:if>
						         
						         <c:if test = "${ItemAccion == 'A'}">
						           (A&ntilde;adir)
						         </c:if>
						         
						         <c:if test = "${ItemAccion == 'D'}">
						           (Duplicar)
						         </c:if>
						         
						         <c:if test = "${ItemAccion == 'X'}">
						           (Eliminar)
						         </c:if>

                            </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <h3>Edici&oacute;n de Items</h3>
                                    <form role="form"  method="post" action="ItemWebPage" >
                                    	<div class="form-group" id="presentation">
                                            <label>C&oacute;digo</label>
                                            <label>${Item.code}</label>
                                        </div>



                                            <td>${item.editorial}</td>
                                            
                                        <div class="form-group">
                                            <label>T&iacute;tulo</label>
   
									         	<c:if  test = "${ItemAccion == 'A'}">
													<textarea class="form-control" id="titulo" name="titulo" rows="3"></textarea>
									         	</c:if>
									         	<c:if  test = "${ItemAccion == 'E'}">
													<textarea class="form-control" id="titulo" name="titulo" rows="3">${Item.titulo}</textarea>
									         	</c:if>
									         	<c:if  test = "${ItemAccion == 'D'}">
													<textarea class="form-control" id="titulo" name="titulo" rows="3" editable=false>${Item.titulo}</textarea>
									         	</c:if>
									         	<c:if  test = "${ItemAccion == 'X'}">
													<textarea class="form-control" id="titulo" name="titulo" rows="3" editable=false>${Item.titulo}</textarea>
									         	</c:if>

                                            <p class="help-block">T&iaute;tulo del item</p>
                                        </div>
                                        
                                        
                                        <div class="form-group">
                                            <label>Rese&ntilde;a</label>
   
									         	<c:if  test = "${ItemAccion == 'A'}">
													<textarea class="form-control" id="resena" name="resena" rows="6"></textarea>
									         	</c:if>
									         	<c:if  test = "${ItemAccion == 'E'}">
													<textarea class="form-control" id="resena" name="resena" rows="6">${Item.resena}</textarea>
									         	</c:if>
									         	<c:if  test = "${ItemAccion == 'D'}">
													<textarea class="form-control" id="resena" name="resena" rows="6" editable=false>${Item.resena}</textarea>
									         	</c:if>
									         	<c:if  test = "${ItemAccion == 'X'}">
													<textarea class="form-control" id="resena" name="resena" rows="6" editable=false>${Item.resena}</textarea>
									         	</c:if>

                                            <p class="help-block">Rese&ntilde;a</p>
                                        </div>    
                                        
                                        <div class="form-group">
                                            <label>Comentario</label>
   
									         	<c:if  test = "${ItemAccion == 'A'}">
									         		<textarea class="form-control" id="comentario" name="comentario" rows="6"></textarea>
									         	</c:if>
									         	<c:if  test = "${ItemAccion == 'E'}">
													<textarea class="form-control" id="comentario" name="comentario" rows="6">${Item.comentario}</textarea>
									         	</c:if>
									         	<c:if  test = "${ItemAccion == 'D'}">
									         		<textarea class="form-control" id="comentario" name="comentario" rows="6" editable=false >${Item.comentario}</textarea>
									         	</c:if>
									         	<c:if  test = "${ItemAccion == 'X'}">
									         		<textarea class="form-control" id="comentario" name="comentario" rows="6" editable=false >${Item.comentario}</textarea>
									         	</c:if>

                                            <p class="help-block">Comentario del item</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Categor&iacute;a</label>
									         	<c:if  test = "${ItemAccion == 'A'}">
		                                            <select class="form-control"  name="categoria">
		                                            	<option selected= value="NONE">Ninguna</option>
		                                            	<c:forEach items="${Cats}" var="item2">
		                                            		<c:if  test = "${item2.clave == Item.categoria.clave}">
		                                            			<option selected value="${item2.clave}">${item2.nombre}</option>
		                                            		</c:if>
		                                            		<c:if  test = "${item2.clave != Item.categoria.clave}">
		                                            			<option value="${item2.clave}">${item2.nombre}</option>
		                                            		</c:if>
		                                            	</c:forEach>
		                                            </select>
									         	</c:if>
									         	<c:if  test = "${ItemAccion == 'E'}">
		                                            <select class="form-control"  name="categoria">
		                                            	<option selected= value="NONE">Ninguna</option>
		                                            	<c:forEach items="${Cats}" var="item2">
		                                            		<c:if  test = "${item2.clave == Item.categoria.clave}">
		                                            			<option selected value="${item2.clave}">${item2.nombre}</option>
		                                            		</c:if>
		                                            		<c:if  test = "${item2.clave != Item.categoria.clave}">
		                                            			<option value="${item2.clave}">${item2.nombre}</option>
		                                            		</c:if>
		                                            	</c:forEach>
		                                            </select>
									         	</c:if>
									         	<c:if  test = "${ItemAccion == 'D'}">
		                                            <select class="form-control"  name="categoria">
		                                            	<option selected= value="NONE">Ninguna</option>
		                                            	<c:forEach items="${Cats}" var="item2">
		                                            		<c:if  test = "${item2.clave == Item.categoria.clave}">
		                                            			<option selected value="${item2.clave}">${item2.nombre}</option>
		                                            		</c:if>
		                                            		<c:if  test = "${item2.clave != Item.categoria.clave}">
		                                            			<option value="${item2.clave}">${item2.nombre}</option>
		                                            		</c:if>
		                                            	</c:forEach>
		                                            </select>
									         	</c:if>
									         	<c:if  test = "${ItemAccion == 'X'}">
		                                            <select class="form-control"  name="categoria" >
		                                            	<option selected= value="NONE">Ninguna</option>
		                                            	<c:forEach items="${Cats}" var="item2">
		                                            		<c:if  test = "${item2.clave == Item.categoria.clave}">
		                                            			<option selected value="${item2.clave}">${item2.nombre}</option>
		                                            		</c:if>
		                                            		<c:if  test = "${item2.clave != Item.categoria.clave}">
		                                            			<option value="${item2.clave}">${item2.nombre}</option>
		                                            		</c:if>
		                                            	</c:forEach>
		                                            </select>
											    </c:if>
                                            <p class="help-block">Categor&iacute;a del item</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Editorial F&aacute;brica</label>
									         	<c:if  test = "${ItemAccion == 'A'}">
		                                            <select class="form-control"  name="editorialFab">
		                                            	<option selected= value="NONE">Ninguna</option>
		                                            	<c:forEach items="${Efs}" var="item2">
		                                            		<c:if  test = "${item2.code == Item.editorial.code}">
		                                            			<option selected= value="${item2.code}">${item2.nombre}</option>
		                                            		</c:if>
		                                            		<c:if  test = "${item2.code != Item.editorial}">
		                                            			<option value="${item2.code}">${item2.nombre}</option>
		                                            		</c:if>
		                                            	</c:forEach>
		                                            </select>
									         	</c:if>
									         	<c:if  test = "${ItemAccion == 'E'}">
		                                            <select class="form-control"  name="editorialFab">
		                                            	<option selected= value="NONE">Ninguna</option>
		                                            	<c:forEach items="${Efs}" var="item2">
		                                            		<c:if  test = "${item2.code == Item.editorial.code}">
		                                            			<option selected value="${item2.code}">${item2.nombre}</option>
		                                            		</c:if>
		                                            		<c:if  test = "${item2.code != Item.editorial}">
		                                            			<option value="${item2.code}">${item2.nombre}</option>
		                                            		</c:if>
		                                            	</c:forEach>
		                                            </select>
									         	</c:if>
									         	<c:if  test = "${ItemAccion == 'D'}">
		                                            <select class="form-control"  name="editorialFab" >
		                                            	<option selected= value="NONE">Ninguna</option>
		                                            	<c:forEach items="${Efs}" var="item2">
		                                            		<c:if  test = "${item2.code == Item.editorial.code}">
		                                            			<option selected value="${item2.code}">${item2.nombre}</option>
		                                            		</c:if>
		                                            		<c:if  test = "${item2.code != Item.editorial}">
		                                            			<option value="${item2.code}">${item2.nombre}</option>
		                                            		</c:if>
		                                            	</c:forEach>
		                                            </select>
									         	</c:if>
									         	<c:if  test = "${ItemAccion == 'X'}">
		                                            <select class="form-control"  name="editorialFab" >
		                                            	<option selected= value="NONE">Ninguna</option>
		                                            	<c:forEach items="${Efs}" var="item2">
		                                            		<c:if  test = "${item2.code == Item.editorial.code}">
		                                            			<option selected value="${item2.code}">${item2.nombre}</option>
		                                            		</c:if>
		                                            		<c:if  test = "${item2.code != Item.editorial}">
		                                            			<option value="${item2.code}">${item2.nombre}</option>
		                                            		</c:if>
		                                            	</c:forEach>
		                                            </select>
											    </c:if>
                                            <p class="help-block">Editorial o f&aacute;brica del item</p>
                                        </div>
                                          
								         <c:if  test = "${ItemAccion == 'E'}">
								            <input type="hidden" name="codigo" value="${Item.code}">
                                            <input type="hidden" name="accion" value="XE">
								         </c:if>
								         
								         <c:if   test = "${ItemAccion == 'A'}">
								           <input type="hidden" name="codigo" value="${Item.code}">
                                            <input type="hidden" name="accion" value="XA">
								         </c:if>
								         
								         <c:if   test = "${ItemAccion == 'D'}">
								           <input type="hidden" name="codigo" value="${Item.code}">
                                            <input type="hidden" name="accion" value="XD">
								         </c:if>
								         
								         <c:if   test = "${ItemAccion == 'X'}">
								           <input type="hidden" name="codigo" value="${Item.code}">
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

      <!-- BOOTSTRAP SCRIPTS -->
    <script src="${prm.HOST_STATIC_FILES}/assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="${prm.HOST_STATIC_FILES}/assets/js/jquery.metisMenu.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="${prm.HOST_STATIC_FILES}/assets/js/custom.js"></script>
    
       <script type="text/javascript">
    	$("#comentario").jqte();
    	$("#resena").jqte();
    	$("#titulo").jqte();
    </script>
</body>
</html>
