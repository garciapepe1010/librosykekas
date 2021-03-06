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
   
      <link type="text/css" rel="stylesheet" href="http://jqueryte.com/css/temp.css" charset="utf-8" >
	<link type="text/css" rel="stylesheet" href="http://jqueryte.com/css/jquery-te.css" charset="utf-8" >
	<link type="text/css" rel="stylesheet" href="http://jqueryte.com/css/jquery-te-green.css" charset="utf-8" >
	<link type="text/css" rel="stylesheet" href="http://jqueryte.com/css/jquery.snippet.min.css" charset="utf-8" >
	
	<script type="text/javascript" src="https://code.jquery.com/jquery.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="${prm.HOST_STATIC_FILES}/js/jquery-te-1.4.0.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="http://jqueryte.com/js/jquery.snippet.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="http://jqueryte.com/js/site.js" charset="utf-8"></script>
	
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
                        <a  href="IndexWebPage"><i class="fa fa-desktop fa-3x"></i>Mant. Index</a>
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
                        <a class="active-menu" href="AcercaDeWebPage"><i class="fa fa-desktop fa-3x"></i>Mant. Acerca De.</a>
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
                                    <h3>Mant P&aacute;gina de Acerca de</h3>
                                    <form role="form"  method="post" action="AcercaDeWebPage" enctype="multipart/form-data" >
                                    
                                    	<div class="form-group" id="presentation">
                                            <label>Acerca de</label>
                                            <textarea class="form-control" name="acercade" rows="6">${acercade}</textarea>
                                        </div>
                                        <div class="form-group" id="presentation">
                                            <label>Aun m&aacute;s</label>
                                            <textarea class="form-control" name="aunmas" rows="6">${aunmas}</textarea>
                                        </div>
                                        <div class="form-group" id="presentation">
                                            <label>Historia</label>
                                            <textarea class="form-control" name="historia" rows="6">${historia}</textarea>
                                        </div>
                                        <div class="form-group" id="presentation">
                                            <label>Inquietudes</label>
                                            <textarea class="form-control" name="inquietudes" rows="6">${inquietudes}</textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Inquietudes imagen</label>
                                            <input type="file" name="inquietudesImg" onchange="loadFile(event,document.getElementById('output1'))"/>
                                            <p class="help-block">Es la im&aacute;gen : ${inquietudesImg}</p>
                                             <img id="output1" height="42" width="42" src="${prm.HOST_STATIC_FILES}/images/350x275_${inquietudesImg}" />
                                        </div>
                                        <div class="form-group" id="presentation">
                                            <label>Kekas</label>
                                            <textarea class="form-control" name="kekas" rows="6">${kekas}</textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Kekas imagen</label>
                                            <input type="file" name="kekasImg" onchange="loadFile(event,document.getElementById('output2'))"/>
                                            <p class="help-block">Es la im&aacute;gen : ${kekasImg}</p>
                                             <img id="output2" height="42" width="42" src="${prm.HOST_STATIC_FILES}/images/350x275_${kekasImg}" />
                                        </div>
                                        <div class="form-group" id="presentation">
                                            <label>Libros</label>
                                            <textarea class="form-control" name="libros" rows="6">${libros}</textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Libros imagen</label>
                                            <input type="file" name="librosImg" onchange="loadFile(event,document.getElementById('output3'))"/>
                                            <p class="help-block">Es la im&aacute;gen : ${librosImg}</p>
                                             <img id="output3" height="42" width="42" src="${prm.HOST_STATIC_FILES}/images/350x275_${librosImg}" />
                                        </div>
                                        <div class="form-group" id="presentation">
                                            <label>Viajes</label>
                                            <textarea class="form-control" name="viajes" rows="6">${viajes}</textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Viajes imagen</label>
                                            <input type="file" name="viajesImg" onchange="loadFile(event,document.getElementById('output4'))"/>
                                            <p class="help-block">Es la im&aacute;gen : ${viajesImg}</p>
                                             <img id="output4" height="42" width="42" src="${prm.HOST_STATIC_FILES}/images/350x275_${viajesImg}" />
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

      <!-- BOOTSTRAP SCRIPTS -->
    <script src="${prm.HOST_STATIC_FILES}/assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="${prm.HOST_STATIC_FILES}/assets/js/jquery.metisMenu.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="${prm.HOST_STATIC_FILES}/assets/js/custom.js"></script>
    
    <script type="text/javascript">
    	$(".form-control").jqte();
    </script>
   
</body>
</html>
