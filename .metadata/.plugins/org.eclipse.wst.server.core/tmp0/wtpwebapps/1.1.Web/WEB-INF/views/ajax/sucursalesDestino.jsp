<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

<c:forEach items="${sucursales}" var="sucursales">
<option value="${sucursales.idSucursal}">${sucursales.nombreAgencia}</option>
</c:forEach>
