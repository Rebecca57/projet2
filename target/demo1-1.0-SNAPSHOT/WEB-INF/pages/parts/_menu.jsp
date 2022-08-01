<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="menu">
	<a href="<c:url value='/Accueil?page=ACCUEIL'/>">Accueil</a>
	<a href="<c:url value='/Accueil?page=AUTRE'/>">Autre</a>
	<a href="<c:url value='/Accueil?page=PAGE1'/>">Page1</a>
	<a href="<c:url value='/Accueil?page=PAGE2'/>">Page2</a>
	<%--<c:if test="${sessionScope.isLogin}"><a href="<c:url value='/Accueil?page=PAGE2'/>">Page2</a></c:if>--%>
<hr>
</div>
