<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
	<head>
		<title>Bienvenido al Sistema de Fichajes</title>
	</head>

	<body>
		Bienvenido al Sistema de Fichajes
		<s:form action="listarEmpleados" method="post">  
    		<input type="submit" value="Acceder">
		</s:form>
	</body>
</html>
