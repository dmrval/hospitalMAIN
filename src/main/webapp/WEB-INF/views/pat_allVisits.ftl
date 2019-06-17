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
<h2 class="forCenterButtons">Список ваших записей</h2>

<table>
    <caption>Список записей</caption>
    <tr>
        <td>Дата и время</td>
        <td>Осматриваемый врач</td>
        <td>Пациент</td>
    </tr>
    <br>
    <#list lstvst as vis>
    <tr>
        <td>${vis.give_DateString()}</td>
        <td>${vis.getDoctor().getFirstname()} ${vis.getDoctor().getLastname()}</td>
        <td>${vis.getPatient().getFirstname()} ${vis.getPatient().getLastname()}</td>
    </tr>
    <#else>
    <p>No VISITS

        </#list>
</table>
<br>
<div class="forCenterButtons">
    <button class="button21" onclick="location.href = '/patient'">Главная страница</button>
</div>
<br>
</body>
</html>