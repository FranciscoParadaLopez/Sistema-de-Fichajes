<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj" %>  

<html>
<head>
<sj:head jqueryui="true" jquerytheme="redmond" />
<script>
function anadirEmpleado(){
	alert("anadirEmpleado");
}

function buscarEmpleado(){
	alert("buscarEmpleado");
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema de Fichajes: Lista de Empleados</title>
</head>
<body>

<bean:write name="fichajeForm" property="message"/>
<br/>


	<!-- Alta / Consulta Empleado -->

<br/>

	<!-- GRID empleados --> 	
 	<s:url action="listarEmpleados.action">
     <s:param name="id" value="url" />
 	</s:url>
 
    <sjg:grid id="gridEmpleados" caption="Empleados" dataType="json" href="%{url}" 
    		pager="true" gridModel="listEmpleados" rowNum="10" navigator="true" navigatorAdd="false"
        	navigatorDelete="false" navigatorEdit="false" navigatorRefresh="true"
        	navigatorSearch="false" navigatorView="false" rownumbers="true"
        	rowList="10,20,30" viewrecords="true" autowidth="true">
        	
        <sjg:gridColumn name="object.dni" align="left" index="dni" title="DNI" sortable="false" search="false"	key="true" hidden="false"/>
        <sjg:gridColumn name="object.nombre" align="left" index="nombre" title="Nombre" sortable="false" />
        <sjg:gridColumn name="object.apellido1" align="left" index="apellido1" title="Primer apellido" sortable="false" />
        <sjg:gridColumn name="object.apellido2" align="left" index="apellido2" title="Segundo apellido" sortable="false" />
            
    </sjg:grid>

<br/>

</body>
</html>