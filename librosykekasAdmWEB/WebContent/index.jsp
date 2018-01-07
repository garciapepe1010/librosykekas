<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Administrador librosykekas</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="<%=getServletContext().getInitParameter("HOST_STATIC_FILES")%>/assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="<%=getServletContext().getInitParameter("HOST_STATIC_FILES")%>/assets/css/font-awesome.css" rel="stylesheet" />
     <!-- MORRIS CHART STYLES-->
    <link href="<%=getServletContext().getInitParameter("HOST_STATIC_FILES")%>/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="<%=getServletContext().getInitParameter("HOST_STATIC_FILES")%>/assets/css/custom.css" rel="stylesheet" />
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
                <a class="navbar-brand" href="index2.jsp">Administrador librosykekas</a> 
            </div>
  <div style="color: white;
padding: 15px 50px 5px 50px;
float: right;
font-size: 16px;"> Last access : 30 May 2014 &nbsp; <a href="#" class="btn btn-danger square-btn-adjust">Logout</a> </div>
        </nav>   
           <!-- /. NAV TOP  -->
                <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
				<li class="text-center">
                    <img src="<%=getServletContext().getInitParameter("HOST_STATIC_FILES")%>/assets/img/find_user.png" class="user-image img-responsive"/>
					</li>
				
					
                    <li>
                        <a class="active-menu"  href="index.jsp"><i class="fa fa-dashboard fa-3x"></i> Dashboard</a>
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

                </ul>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Admin librosykekas</h2>   
                        <h5>Bienvenida tata. Me alegro de verte de nuevo.</h5>
                    </div>
                </div>              
                

                    </div>
                    
                </div>
                    <div class="col-md-6 col-sm-12 col-xs-12">
                         <div class="panel panel-default">
                        <div class="panel-heading">
                           Label Examples
                        </div>
                        <div class="panel-body">
                            <span class="label label-default">Default</span>
							<span class="label label-primary">Primary</span>
							<span class="label label-success">Success</span>
							<span class="label label-info">Info</span>
							<span class="label label-warning">Warning</span>
							<span class="label label-danger">Danger</span>
                        </div>
                    </div>
                         
                         <div class="panel panel-default">
                        <div class="panel-heading">
                            Donut Chart Example
                        </div>
                        <div class="panel-body">
                            <div id="morris-donut-chart"></div>
                        </div>
                    </div>
                      
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
    <script src="<%=getServletContext().getInitParameter("HOST_STATIC_FILES")%>/assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="<%=getServletContext().getInitParameter("HOST_STATIC_FILES")%>/assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="<%=getServletContext().getInitParameter("HOST_STATIC_FILES")%>/assets/js/jquery.metisMenu.js"></script>
     <!-- MORRIS CHART SCRIPTS -->
     <script src="<%=getServletContext().getInitParameter("HOST_STATIC_FILES")%>/assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="<%=getServletContext().getInitParameter("HOST_STATIC_FILES")%>/assets/js/morris/morris.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="<%=getServletContext().getInitParameter("HOST_STATIC_FILES")%>/assets/js/custom.js"></script>
    
   
</body>
</html>