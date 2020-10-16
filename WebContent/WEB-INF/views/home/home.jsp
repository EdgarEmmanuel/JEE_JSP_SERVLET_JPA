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
<title>HOME</title>
</head>
<body>
	<div class="body_tert">
		<div class="left">
			<img src="${base}asset/logo_senForage.png" alt="forage image" />
		</div>
		<div class="right">
		<p>
		<i class="fa fa-tint" aria-hidden="true"></i>
		 <i class="fa fa-tint" aria-hidden="true"></i>
		 <i class="fa fa-tint" aria-hidden="true"></i>
		 </p>
		 <h2>HELLO <br/> WELCOME BACK </h2>
		 <small>login to do your action</small>
			<form action="/connex" method="post">
				<input type="text" placeholder="email" /><br/><br/><br/>
				<input type="password" placeholder="password" />
			</form>
		</div>
	</div>
</body>
</html>