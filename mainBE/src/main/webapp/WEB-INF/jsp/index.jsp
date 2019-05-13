<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<div class="container">

		<div class="starter-template">
			<h1>Role Management</h1>
			<%--<h3><span>User: </span>From ${message.user}</h3>--%>
			<%--<h3><span>Visitor: </span>To ${message.visitor}</h3>--%>
			<%--<h3><span>Message: </span>${message.message}</h3>--%>
			<button><a href="/submit">SUBMIT</a></button>
		</div>

	</div>
	<!-- /.container -->

	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
