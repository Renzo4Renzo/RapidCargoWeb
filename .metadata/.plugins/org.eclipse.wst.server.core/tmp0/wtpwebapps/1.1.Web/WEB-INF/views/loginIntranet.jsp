<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900' rel='stylesheet' type='text/css'>

    <!-- Page title -->
     <title>Rapid Cargo Encomiendas</title>

    <!-- Vendor styles -->
    <s:url value="/resources/bootstrapIntranet/vendor/fontawesome/css/font-awesome.css" var="css1"/>
    <link href="${css1}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/vendor/animate.css/animate.css" var="css2"/>
    <link href="${css2}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/vendor/bootstrap/css/bootstrap.css" var="css3"/>
    <link href="${css3}" rel="stylesheet" type="text/css"/>

    <!-- App styles -->
    <s:url value="/resources/bootstrapIntranet/styles/pe-icons/pe-icon-7-stroke.css" var="css4"/>
    <link href="${css4}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/styles/pe-icons/helper.css" var="css5"/>
    <link href="${css5}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/styles/stroke-icons/style.css" var="css6"/>
    <link href="${css6}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/styles/style.css" var="css7"/>
    <link href="${css7}" rel="stylesheet" type="text/css"/>
</head>
<body class="blank">

<!-- Wrapper-->
<div class="wrapper">


    <!-- Main content-->
    <section class="content">
       
        <div class="container-center animated slideInDown">


            <div class="view-header">
                <div class="header-icon">
                    <i class="pe page-header-icon pe-7s-unlock"></i>
                </div>
                <div class="header-title">
                    <h3>Login</h3>
                    <small>
                        Ingresa tus datos de usuario.
                    </small>
                </div>
            </div>

            <div class="panel panel-filled">
                <div class="panel-body">
                    <frm:form role="form" method="POST" action="VerificarAcceso">
                        <div class="form-group">
                            <label class="control-label" for="username">Username</label>
                            <frm:input path="nombreUsuario" placeholder="minombre" class="form-control" type="text"></frm:input>
                            <span class="help-block small">Tu nombre de usuario en la empresa</span>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="password">Password</label>
							<frm:input path="contrasena" class="form-control" title="Please enter your password" placeholder="******" type="password"></frm:input>
                            <span class="help-block small">La contraseña de tu cuenta</span>
                        </div>
                        <div>
                        	<input class="btn btn-accent" type="submit" value="Login"/> 
                        </div>
                    </frm:form>
            		<%
						if(request.getParameter("msg")!=null){
							out.print("<br>");
			 				out.print("<p style='color: white'>"+request.getParameter("msg")+"</p>");	
						}
					%>
                </div>
            </div>

        </div>
    </section>
    <!-- End main content-->

</div>
<!-- End wrapper-->
<!-- Vendor scripts -->
<s:url value="/resources/bootstrapIntranet/vendor/pacejs/pace.min.js" var="js1"/>
<script src="${js1}"></script>
<s:url value="/resources/bootstrapIntranet/vendor/jquery/dist/jquery.min.js" var="js2"/>
<script src="${js2}"></script>
<s:url value="/resources/bootstrapIntranet/vendor/bootstrap/js/bootstrap.min.js" var="js3"/>
<script src="${js3}"></script>

</body>
</html>