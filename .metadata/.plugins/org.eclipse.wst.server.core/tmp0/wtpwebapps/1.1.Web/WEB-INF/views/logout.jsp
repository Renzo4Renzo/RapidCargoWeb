<%@page import="pojo.Usuario"%>
<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>

<!-- Mirrored from webapplayers.com/luna_admin-v1.3/error.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 23 Oct 2017 13:29:34 GMT -->
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
        
        
        <div class="container-center md animated slideInDown">
        
            <div class="view-header">
                <div class="header-icon">
                    <i class="pe page-header-icon pe-7s-close-circle"></i>
                </div>
                <div class="header-title">
                    <h3>Sesion Cerrada</h3>
                    <small>
                        Has cerrado la sesión.
                    </small>
                </div>
            </div>

            <div>
                <a href="${pageContext.request.contextPath}/login" class="btn btn-accent">Volver</a>
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


<!-- Mirrored from webapplayers.com/luna_admin-v1.3/error.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 23 Oct 2017 13:29:34 GMT -->
</html>