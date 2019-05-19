<!DOCTYPE html>
<html lang="en" xmlns:form="http://www.w3.org/1999/html">
<head>
    <title>Все данные о записях</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>
<table>
    <caption>Список записей</caption>
    <tr>
        <td>Идентификатор</td>
        <td>Дата и время</td>
        <td>Осматриваемый врач</td>
        <td>Пациент</td>
    </tr>
    <br>
    <#list lstvst as vis>
    <tr>
        <td><a href="/administrator/allVisit/${vis.getVisitid()}">${vis.getVisitid()} (подробно)</a></td>
        <td>${vis.give_DateString()}</td>
        <td>${vis.getDoctor().getFirstname()} ${vis.getDoctor().getLastname()}</td>
        <td>${vis.getPatient().getFirstname()} ${vis.getPatient().getLastname()}</td>
    </tr>
    <#else>
    <p>No VISITS

        </#list>
</table>
</body>
</html>
