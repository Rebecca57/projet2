<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="header">
	<div>Header</div>
	<div class="droite">
		<c:choose>
			<c:when test="${sessionScope.isLogin}">
				<div>
					Bonjour ${sessionScope.user}
					<form action="/projet2/Log" method="GET">
						<input type="submit" value="LogOut">
					</form>
				</div>
				
			</c:when>
			<c:otherwise>
				<fieldset >
					<form action="/projet2/Log" method="POST">
						<label>Identifiant:</label><br>
						<input type="text" placeholder="Identifiant" name="user"><br>
						<label>Mot de passe:</label><br>
						<input type="text" placeholder="Mot de passe" name="mdp"><br>
						<input type="submit" value="Login">
					</form>
				</fieldset>
			</c:otherwise>
		</c:choose>
	</div>
</div>

