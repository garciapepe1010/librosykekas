<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
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
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
   <script>
	  var loadFile = function(event, output) {
	    var reader = new FileReader();
	    reader.onload = function(){
	      output.src = reader.result;
	    };
	    reader.readAsDataURL(event.target.files[0]);
	  };
	</script>
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
                        <a  href="index"><i class="fa fa-dashboard fa-3x"></i> Dashboard</a>
                    </li>
                    <li>
                        <a class="active-menu" href="IndexWebPage"><i class="fa fa-desktop fa-3x"></i>Mant. Index</a>
                    </li>
                    <li>
                        <a  href="EdFabWebPage"><i class="fa fa-desktop fa-3x"></i>Mant. Ed. Fab.</a>
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
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Mant. Index</h2>   
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
                            Textos e imagenes del indice</div>
                            <% Object ob = request.getAttribute("resultadoOperacion");
                            if(ob != null){
                            %>
                            <div class="panel-heading">
                            <% out.println(ob);%></div>
                            <% }%>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <h3>Basic Form Examples</h3>
                                    <form role="form"  method="post" action="IndexWebPage" enctype="multipart/form-data" >
                                    	<div class="form-group" id="presentation">
                                            <label>Presentacion</label>
                                            <textarea class="form-control" name="presentation" rows="3"> <% Object ob1 = request.getAttribute("presentation"); out.println(ob1);%></textarea>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Comentarios 1</label>
                                            <input class="form-control" name="Comentarios_1" value="<% Object ob11 = request.getAttribute("comentario_1"); out.println(ob11);%>"/>
                                            <p class="help-block">Lo que hay en el comentario de la izquierda</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Comentarios 2</label>
                                            <input class="form-control"  name="Comentarios_2"value="<% Object ob2 = request.getAttribute("comentario_2"); out.println(ob2);%>"/>
                                            <p class="help-block">Lo que hay en el comentario del centro</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Comentarios 3</label>
                                            <input class="form-control"  name="Comentarios_3" value="<% Object ob3 = request.getAttribute("comentario_3"); out.println(ob3);%>"/>
                                            <p class="help-block">Lo que hay en el comentario de la derecha</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>La primera de las imagenes</label>
                                            <input type="file" id="imagen_1" name="imagen_1" onchange="loadFile(event,document.getElementById('output'))"/>
                                            <p class="help-block">Es la im&aacute;gen : ${imagen_1}</p>
                                            <img id="output" height="42" width="42" src="${prm.HOST_STATIC_FILES}/images/850x915_${imagen_1}" />
											
                                        </div>
                                        <div class="form-group">
                                            <label>La segunda de las imagenes</label>
                                            <input type="file" name="imagen_2" onchange="loadFile(event,document.getElementById('output2'))"/>
                                            <p class="help-block">Es la im&aacute;gen : ${imagen_2}</p>
                                             <img id="output2" height="42" width="42" src="${prm.HOST_STATIC_FILES}/images/900x1000_${imagen_2}" />
                                        </div>
                                        <div class="form-group">
                                            <label>La tercera de las imagenes</label>
                                            <input type="file" name="imagen_3" onchange="loadFile(event,document.getElementById('output3'))"/>
                                            <p class="help-block">Es la im&aacute;gen : ${imagen_3}</p>
                                             <img id="output3" height="42" width="42" src="${prm.HOST_STATIC_FILES}/images/975x915_${imagen_3}" />
                                        </div>
                                        <div class="form-group">
                                            <label>La cuarta de las imagenes</label>
                                            <input type="file" name="imagen_4" onchange="loadFile(event,document.getElementById('output4'))"/>
                                            <p class="help-block">Es la im&aacute;gen : ${imagen_4}</p>
                                             <img id="output4" height="42" width="42" src="${prm.HOST_STATIC_FILES}/images/910x1620_${imagen_4}" />
                                        </div>
                                        <div class="form-group">
                                            <label>La quinta de las imagenes</label>
                                            <input type="file" name="imagen_5" onchange="loadFile(event,document.getElementById('output5'))"/>
                                            <p class="help-block">Es la im&aacute;gen : ${imagen_5}</p>
                                             <img id="output5" height="42" width="42" src="${prm.HOST_STATIC_FILES}/images/1650x925_${imagen_5}" />
                                        </div>
                                        <button type="submit" class="btn btn-default">Guardar</button>
                                        <button type="reset" class="btn btn-primary">Limpiar</button>
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
