<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autre</title>
<link rel="stylesheet" href="/projet2/ressources/css/style.css">
</head>
<body>
<jsp:include page="./parts/_header.jsp"/>
<jsp:include page="./parts/_menu.jsp"/>

<div>Page 2</div>
<div>${filtre1}</div>

<jsp:include page="./parts/_footer.jsp"/>
</body>
</html>