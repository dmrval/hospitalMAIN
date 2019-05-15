<!DOCTYPE html>
<html lang="en" xmlns:form="http://www.w3.org/1999/html">
<head>
    <title>Все данные о записях</title>
</head>
<body>
<h2>Список всех записей</h2>
<#list lstvst as vis>

<p><a href="/administrator/allVisit/${vis.getVisitid()}">${vis.getVisitid()} (подробно)</a> ${vis} <br>

    <#else>

<p>No VISITS

    </#list>


</body>
</html>
