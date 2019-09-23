<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ваши записи</title>
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
        <td>Пациент</td>
    </tr>
    <br>
    <#list lstvst as vis>
    <tr>
        <td><a href="/doctor/allVisits/${vis.getVisitid()}">${vis.getVisitid()} (подробно)</a></td>
        <td>${vis.give_DateString()}</td>
        <td>${vis.getPatient().getFirstname()} ${vis.getPatient().getLastname()}</td>
    </tr>
    <#else>
    <p>No VISITS
        </#list>
</table>
<br>
<div class="forCenterButtons">
    <button class="button21" onclick="location.href = '/doctor'">Главная страница</button>
</div>
<br>
<div id="footer">
    &copy; Creator - Valeev Damir Rinatovich
</div>
</body>
</html>