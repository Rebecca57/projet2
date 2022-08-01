<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
<link rel="stylesheet" href="/projet2/ressources/css/style.css">
</head>
<body>

<jsp:include page="./parts/_header.jsp"/>
<jsp:include page="./parts/_menu.jsp"/>

<div>Accueil</div>
<div>${access}</div>
<input type="button" id="get" value="tester">
<div id='parent'></div>
<jsp:include page="./parts/_footer.jsp"/>

<script>
	 document.querySelector('#get').addEventListener('click',()=>{
			 fetch("/projet2/api/taches/byId/0")
			 .then((response) => response.json())
			 .then((data)=>{
				 let parent = document.getElementById('parent');
					console.table(data);
					
				let newDiv = document.createElement('div');
				newDiv.innerHTML = "Tache 0:";
				parent.appendChild(newDiv);
				let newDiv1 = document.createElement('div');
				newDiv1.innerHTML = data.nom +"| " + data.description +" | "+data.date +"<br>";
				parent.appendChild(newDiv1);
				 //for(element of data){
					//let newDiv = document.createElement('div');
					//newDiv.setAttribute("class","tache");
					//newDiv.innerHTML =  element.nom +"| " + element.description +" | "+element.date +"<br>";
					//parent.appendChild(newDiv);
				//} 
			 });
	});
 
 </script>
</body>
</html>