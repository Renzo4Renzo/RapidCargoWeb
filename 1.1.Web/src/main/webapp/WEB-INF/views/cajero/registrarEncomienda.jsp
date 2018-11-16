<%@page import="pojo.Usuario"%>
<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>

<head>
	<script type="text/javascript">
    function cargarSucursales() {
    	var idRuta = $("#rutas").val();
        $.ajax({
            type: 'GET',
            url: 'cargarSucursales',
            data: {"idRuta" : idRuta} ,
            success:
                function (result) {
            	console.log(result);
				$("#select-sucursales").html(result);
            }
        });
    }
    
    function calcularMonto(){
    	var peso = $("#peso").val();
    	$.ajax({
            type: 'GET',
            url: 'calcularMonto',
            data: {"peso" : peso} ,
            success:
                function (result) {
            	console.log(result);
            	$("#pago").val(result);
            	$("#pago").text(result);
            }
    	});
    }
    
    function validarDNI() {
    	var dni = $("#txtDni").val();
        $.ajax({
            type: 'GET',
            url: 'validarDNI',
            data: {"dni" : dni} ,
            success:
                function (result) {
            	console.log(result);
            	$("#respuestaDNI").html(result);
            }
        });
    }
    
    function listarCliente() {
    	var dni = $("#txtDni").val();
        $.ajax({
            type: 'GET',
            url: 'listarCliente',
            data: {"dni" : dni} ,
            success:
                function (result) {
            	console.log(result);
            	$("#datosCliente").html(result);
            }
        });
    }
	</script>

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
            	<li class="inactive">
                    <a href="${pageContext.request.contextPath}/principalCajero">Principal</a>
                </li>
                <li class="nav-category">
                    Encomiendas
                </li>
                <li class="active">
                    <a href="${pageContext.request.contextPath}/NuevaEncomienda">Registrar Encomienda</a>
                </li>
                <li class="nav-category">
                    Cliente
                </li>
                <li class="inactive">
                    <a href="${pageContext.request.contextPath}/NuevoCliente">Nuevo Cliente</a>
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
                    <div class="col-lg-6">
                        <div class="view-header">
                            <div class="header-icon">
                                <i class="pe page-header-icon pe-7s-shield"></i>
                            </div>
                            <div class="header-title">
                                <h3 class="m-b-xs">Registro de Encomienda</h3>
                                <small>
                                    Ingrese los datos necesarios para el registro de una nueva encomienda solicitados a continuación.
                                </small>
                            </div>
                        </div>
                        <hr>
                    </div>
                    <div class="col-lg-6">
                        <div class="view-header">
                            <div class="header-icon">
                                <i class="pe page-header-icon pe-7s-shield"></i>
                            </div>
                            <div class="header-title">
                                <h3 class="m-b-xs">Cliente</h3>
                                <small>
                                    Datos del Cliente.
                                </small>
                            </div>
                        </div>
                        <hr>
                    </div>
                </div>
                
                <div class="row">
                	<div class="col-lg-6">
                		<frm:form role="form" method="POST" action="RegistrarNuevaEncomienda">
                		    <%
							if(request.getParameter("msg")!=null){
								out.print("<br>");
				 				out.print("<p style='color: green'>"+request.getParameter("msg")+"</p>");	
							}
							%>
	        		        <div class="form-group">
	                            <label class="control-label">DNI</label>
	                            <frm:input path="cliente.dniCliente" id="txtDni" oninput="validarDNI()" pattern="\d*" minlength="8"  maxlength="8" class="form-control" type="text" required="true"></frm:input>
	                            <span class="help-block small">Ingrese el DNI del cliente</span> <p id="respuestaDNI"class="help-block small"></p>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label" for="">Ruta</label>
	                            <frm:select path="ruta.idRuta" onclick="cargarSucursales()" onchange="cargarSucursales()" name="rutas" id="rutas" class="form-control"> 
									<c:forEach items="${rutas}" var="rutas">
										<frm:option value="${rutas.idRuta}">${rutas.nombreRuta}</frm:option>
									</c:forEach>
								</frm:select>
	                            <span class="help-block small">Ingrese la ruta de destino de la encomienda.</span>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label" for="">Fecha de Llegada</label>
	                            <frm:input path="fechaLlegada" placeholder="" class="form-control" type="date" required="true"></frm:input>
	                            <span class="help-block small">Ingrese la fecha de Llegada.</span>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label">Nombre Destinatario</label>
	                            <frm:input path="nombreDestinatario"  class="form-control" type="text" required="true"></frm:input>
	                            <span class="help-block small">Ingrese el Nombre del Destinatario.</span>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label">Dirección Destinatario</label>
	                            <frm:input path="direccionDestinatario"  class="form-control" type="text" required="true" ></frm:input>
	                            <span class="help-block small">Ingrese la dirección del Destinatario.</span>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label">Sucursal de Origen</label>
	                            <input class="form-control" type="text" value="<% out.print(u.getSucursal().getNombreAgencia()); %>"  readonly></input>
	                        </div>
               	            <div class="form-group" id="div-sucursales">
	                            <label class="control-label" for="">Sucursal Destino</label>
	                            <frm:select path="sucursalDestino.idSucursal" name="sucursales" id="select-sucursales" class="form-control"> 
									<c:forEach items="${sucursales}" var="sucursales">
										<frm:option value="${sucursales.idSucursal}">${sucursales.nombreAgencia}</frm:option>
									</c:forEach>
								</frm:select>
	                            <span class="help-block small">Ingrese la sucursal de destino de la encomienda.</span>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label">Peso</label>
	                            <frm:input path="peso" id="peso" oninput="calcularMonto()" class="form-control" min="0.1" max="20" type="number" step="0.01" required="true" ></frm:input>
	                            <span class="help-block small">Ingrese el peso de la encomienda.</span>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label">Monto a Pagar</label>
	                            <frm:input path="montoPago" id="pago"  class="form-control" type="number" step="0.01" required="true" readonly="true"></frm:input>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label">Detalle</label>
	                            <frm:input path="descripcionEncomienda"  class="form-control" type="text" required="true"></frm:input>
	                            <span class="help-block small">Ingrese el detalle de la encomienda.</span>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label">A domicilio</label>
	                            <frm:select path="aDomicilio" class="form-control"> 
	                          	    <frm:option value="false">No</frm:option>
									<frm:option value="true">Si</frm:option>
								</frm:select>
	                            <span class="help-block small">Indique si el paquete sera entregado a domicilio o en agencia.</span>
	                        </div>
		                    <div>
	                        	<input class="btn btn-accent" type="submit" value="Registrar"/> 
	                        	<input class="btn btn-accent" type="reset" value="Limpiar"/> 
	                        </div>
                		</frm:form>
                	</div>
                	<div class="col-lg-6">
             		<div class="form-group" id="datosCliente">
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