<!DOCTYPE html>
<html lang="en" xmlns:form="http://www.w3.org/1999/html">
<head>
    <title>База данных пациентов</title>
</head>
<body>
<h2>Список всех пациентов</h2>
<#list lstpatient as patient>

<p><a href="/administrator/allPatient/${patient.getPatientid()}">${patient.getPatientid()} (подробно)</a> ${patient} <br>

    <#else>

<p>No VISITS

    </#list>


</body>
</html>
