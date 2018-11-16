<%@page import="pojo.Usuario"%>
<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900' rel='stylesheet' type='text/css'>
    
    <%
		response.setHeader("Pragma","no-cache"); // HTTP 1.0
		response.setHeader("Cache-Control","no-store"); // HTTP 1.1
		response.setDateHeader("Expires", 0);
	%> 
	
    <!-- Page title -->
    <title>Rapid Cargo Encomiendas</title>
    <!-- Vendor styles -->
    <s:url value="/resources/bootstrapIntranet/vendor/fontawesome/css/font-awesome.css" var="css1"/>
    <link href="${css1}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/vendor/animate.css/animate.css" var="css2"/>
    <link href="${css2}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/vendor/bootstrap/css/bootstrap.css" var="css3"/>
    <link href="${css3}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/vendor/toastr/toastr.min.css" var="css4"/>
    <link href="${css4}" rel="stylesheet" type="text/css"/>
    <!-- App styles -->
    <s:url value="/resources/bootstrapIntranet/styles/pe-icons/pe-icon-7-stroke.css" var="css4"/>
    <link href="${css4}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/styles/pe-icons/helper.css" var="css5"/>
    <link href="${css5}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/styles/stroke-icons/style.css" var="css6"/>
    <link href="${css6}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/styles/style.css" var="css7"/>
    <link href="${css7}" rel="stylesheet" type="text/css"/>
    
    <s:url value="/resources/bootstrapIntranet/images/profile.jpg" var="img"/>
</head>
<body>

<!-- Wrapper-->
<div class="wrapper">
    <!-- Header-->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <div id="mobile-menu">
                    <div class="left-nav-toggle">
                        <a href="#">
                            <i class="stroke-hamburgermenu"></i>
                        </a>
                    </div>
                </div>
                <a class="navbar-brand" href="index-2.html">
                    CARGO
                </a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <div class="left-nav-toggle">
                    <a href="#">
                        <i class="stroke-hamburgermenu"></i>
                    </a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li class=" profil-link">
                        <a href="${pageContext.request.contextPath}/logout">
                            <span class="profile-address"><% Usuario u = (Usuario)session.getAttribute("usuario"); out.print(u.getNombreUsuario()); %></span>
                            <img src="${img}" class="img-circle" alt="">
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- End header-->

    <!-- Navigation-->
    <aside class="navigation">
        <nav>
            <ul class="nav luna-nav">
            	<li class="">
                    <a href="${pageContext.request.contextPath}/principalAlmacen">Principal</a>
                </li>
                <li class="nav-category">
                    Carga
                </li>
                <li class="">
                    <a href="${pageContext.request.contextPath}/ListarEncomiendasSalida">Asignar a Bus</a>
                </li>
                <li class="active">
                    <a href="${pageContext.request.contextPath}/ListarEncomiendasDomicilio">Asignar a Van</a>
                </li>
                <li class="nav-category">
                    Entrega
                </li>
                <li class="inactive">
                    <a href="${pageContext.request.contextPath}/ListarEntregasEnSucursal">Validar Entrega</a>
                </li>
                <li class="nav-info">
                    <i class="pe pe-7s-shield text-accent"></i>
                    <div class="m-t-xs">
                       <span class="c-white"></span> Sistema administrativo desarrollado por Bullet Club para RapidCargo EIRL.
                    </div>
                </li>
            </ul>
        </nav>
    </aside>
    <!-- End navigation-->


    <!-- Main content-->
    <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="view-header">
                            <div class="header-icon">
                                <i class="pe page-header-icon pe-7s-shield"></i>
                            </div>
                            <div class="header-title">
                                <h3 class="m-b-xs">Encomiendas Esperando Salida A Domicilio</h3>
                            </div>
                        </div>
                        <hr>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-lg-12">
                    	   <div class="table-responsive">
                    	   		 <%
								if(request.getParameter("msg")!=null){
									out.print("<br>");
					 				out.print("<p style='color: green'>"+request.getParameter("msg")+"</p>");	
								}
						  		%>
                                <table  class="table table-hover table-striped table-bordered table-condensed">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nombre Destinatario</th>
                                        <th>Direccion Destinatario</th>
                                        <th>Fecha Llegada</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
										<c:forEach items="${listita}" var = "list">
											<tr>
												<td><c:out value="${list.idEncomienda}"/></td>
												<td><c:out value="${list.nombreDestinatario}"/></td>
												<td><c:out value="${list.direccionDestinatario}"/></td>
												<td><c:out value="${list.fechaLlegada}"/></td>
												<td><a href="${pageContext.request.contextPath}/AsignarEncomiendasDomicilio?idEncomienda=${list.idEncomienda}"> Asignar </a></td>
											</tr>
										</c:forEach>
                                    </tbody>
                                </table>
                            </div>
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
<!-- App scripts -->
<s:url value="/resources/bootstrapIntranet/scripts/luna.js" var="js4"/>
<script src="${js4}"></script>
</body>
</html>