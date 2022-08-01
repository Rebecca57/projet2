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
<jsp:useBean id="listeTaches" beanName="fr.m2i.services.TachesRessource" scope ="request" type="fr.m2i.services.TachesRessource"></jsp:useBean>

<jsp:include page="./parts/_header.jsp"/>
<jsp:include page="./parts/_menu.jsp"/>

<h2>Accueil</h2>

<!--  FORM: Ajouter une tache -->

<div>
	<fieldset>
	<h3>Ajouter une tache</h3>
		<form action="/projet2/api/taches/all" method="POST">
			<label>Nom:</label>
			<input type="text" id="nom" placeholder="Nom" name="nom"><br>
			<label>Description:</label>
			<input type="text" id="description" placeholder="Description" name="desc"><br>
			<label>Date:</label>
			<input type="date" id="date" placeholder="Date" name="date"><br>
			<input type="submit" id="add" value="ajouter">
		</form>
	</fieldset>
</div>

<!--  Description de la tache sélectionnée-->
<div>
	<fieldset>
		<h3>Description de la tache</h3>
		<!--  Combo des taches -->
		<div id='parent'>
		<label>Nom de la tache: </label><br>
			<select id="comboTaches" name="combo">
				<option>Tache</option>
			</select>
		</div>
		<label>Description:</label><br>
		<input type="text" id="descTache" placeholder="DescriptionTache"><br>
		<label>Date:</label><br>
		<input type="date" id="dateTache" placeholder="Date"><br><br>
		<input type="button" id="deleteTache" value="supprimer">
		<input type="button" id="updateTache" value="modifier">
	</fieldset>
</div>


<!--  Afficher toutes les taches-->
<input type="button" id="get" value="afficherToutesLesTaches">
<div id="allTaches"></div>

<jsp:include page="./parts/_footer.jsp"/>

<script>

<%-- Afficher toutes les taches --%>
document.querySelector('#get').addEventListener('click',()=>{
    fetch("/projet2/api/taches/all")
        .then((response) => response.json())
        .then((data)=>{
            let parent = document.getElementById('allTaches');
    		while (parent.firstChild) {
    		    parent.removeChild(parent.lastChild);
    		  }
            console.table(data);
            for(element of data){
                let p = document.createElement('p');
                p.innerHTML = element.nom + "---" +element.description + " "+ element.date+"<br>";
                parent.appendChild(p);
            }
        });
});

<%-- Maj de la combo des taches en cliquant dessus --%>	 
document.querySelector('#comboTaches').addEventListener('click',()=>{
     fetch("/projet2/api/taches/all")
     .then((response) => response.json())
     .then((data)=>{
         let parent = document.getElementById('comboTaches');
         while (parent.firstChild) {
 		    parent.removeChild(parent.lastChild);
 		  }
         let title = document.createElement('option');
         title.innerHTML = "Selection de la tache";
         parent.appendChild(title);
         console.table(data);
         for(element of data){
             let option = document.createElement('option');
             option.data = element;
             option.innerHTML = element.nom;
             parent.appendChild(option);
         }
     });
});
    
<%-- Afficher les details de la tache en selection dans combos --%>
	let tachesSelect = document.querySelector('#comboTaches');
    let inputDate = document.querySelector('#dateTache');
    let inputDescription = document.querySelector('#descTache');
     tachesSelect.addEventListener('change',()=>{
         inputDescription.value = tachesSelect.options[tachesSelect.selectedIndex].data.description;
         inputDate.value = tachesSelect.options[tachesSelect.selectedIndex].data.date;
     });
     
<%--Delete la tache selectionnée  
document.querySelector('#deleteTache').addEventListener('click',()=>{
     fetch("/projet2/api/taches/all/")
     .then((response) => response.json())
     .then((data)=>{
         let parent = document.getElementById('comboTaches');
         while (parent.firstChild) {
 		    parent.removeChild(parent.lastChild);
 		  }
         console.table(data);
         for(element of data){
             let option = document.createElement('option');
             option.data = element;
             option.innerHTML = element.nom;
             parent.appendChild(option);
         }
     });
});
--%>	
	 
 </script>
</body>
</html>