<!DOCTYPE html>
<html lang="en" xmlns:form="http://www.w3.org/1999/html">
<head>
    <title>База данных докторов</title>
</head>
<body>
<h2>Список всех докторов</h2>
<#list lstdoctor as doctor>

<p><a href="/administrator/allPatient/${doctor.getDoctorid()}">${doctor.getDoctorid()} (подробно)</a> ${doctor} <br>

    <#else>

<p>No VISITS

    </#list>


</body>
</html>
