<!DOCTYPE html>
<!-- 20160407 PN HRA-1 created index.jsp class -->

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Human Resources Dashboard</title>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="dist/css/dataTables.bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="dist/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="dist/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="dit/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="dist/assets/js/ie-emulation-modes-warning.js"></script>
    
    
    <!-- Importing hra.helper.js file -->
    <script src="dist/js/hra/hra.helper.js"></script>
  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"><h4><i class="glyphicon glyphicon-gift"></i> HRIS</h4></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#"><i class="glyphicon glyphicon-envelope"></i></a></li>
            <li><a href="#"><i class="glyphicon glyphicon-flag"></i></a></li>
            <li><a href="#"><i class="glyphicon glyphicon-cog"></i></a></li>
            <li><a href="#"><i class="glyphicon glyphicon-user"></i> Admin</a></li>
            <li><a href="#"><i class="glyphicon glyphicon-log-out"></i></a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#" onclick="loadContentDashboard()"><b>Dashboard <span class="sr-only">(current)</span></a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li>Configuration</li>
            <li><a href="#" onclick="loadContentEmployee()">- Employee</a></li>
            <li><a href="#" onclick="">- Department</a></li>
          </ul>
        </div>
        
        <div id="mainContent"></div>        
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="dist/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="dist/js/bootstrap.min.js"></script>
	<script src="dist/js/dataTables.bootstrap.min.js"></script>
	<script src="dist/js/jquery.dataTables.min.js"></script>
		
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="dist/assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="dist/assets/js/ie10-viewport-bug-workaround.js"></script>
    
    
    <script>
    //Demo On
    </script>
    
  </body>
</html>
