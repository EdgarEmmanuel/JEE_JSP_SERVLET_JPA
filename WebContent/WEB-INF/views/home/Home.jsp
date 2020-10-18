<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"  href=<c:out value="${base}public/css/home.css"/> />
<link rel="shortcut icon" href=<c:out value="${base}asset/favicon.ico"/> type="image/x-icon">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" href=<c:out value="${base}asset/favicon.ico"/> type="image/x-icon">
<title>HOME | PAGE </title>
</head>
<body>
	<div class="info"> INFORMATIONS 
	<a href="tel:+221897676549"><i class="fa fa-phone" aria-hidden="true"></i> 897676549</a>
	<a href="mailto:senforage@gmail.com"> <i class="fa fa-envelope" aria-hidden="true"></i> senforage@gmail.com</a>
	</div>
	<header>
		<div class="brand">
			<img src="${base}asset/logo_senForage.png" alt="sen forage" />
		</div>
		<div class="menu">
			<a href="">VILLAGE</a>
			<a href="">CLIENT</a>
			<a href="">DECONNEXION</a>
		</div>
	</header>
	
	<main>
		<div class="section-1">
			<div class="left">
				<p>WELCOME MR <br/> TALL FALL</p>
			</div>
			<div class="right">
				<img src="${base}asset/admin.png" alt="admin sen forage"/>
			</div>
		</div>
	</main>
</body>
</html>