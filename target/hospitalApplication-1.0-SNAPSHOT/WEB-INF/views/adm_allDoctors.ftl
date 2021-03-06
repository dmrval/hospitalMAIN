<!DOCTYPE html>
<html lang="en" xmlns:form="http://www.w3.org/1999/html">
<head>
    <title>База данных докторов</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>
<div class="forCenterButtons">
    <button class="button21" onclick="location.href = '/administrator/'">Вернуться назад</button>

    <button class="button21" onclick="location.href = '/administrator/addDoctor'">Добавить доктора</button>

    <button class="button21" onclick="location.href = '/administrator/'">На главную страницу</button>
</div>
<br>
<#if notEmpty??>
    <div class="errlogin_password">Нельзя удалить этого доктора, у него есть записи</div>
    <br>
</#if>
<table>
    <caption>Список докторов</caption>
    <tr>
        <td>Идентификатор</td>
        <td>Доктор</td>
        <td>Специализация</td>
        <td>Дата рождения</td>
        <td>Домашний адрес</td>
        <td>Лицензия</td>
    </tr>
    <br>
    <#list lstdoctor as doctor>
    <tr>
        <td>${doctor.getDoctorid()}</td>
        <td>${doctor.getFirstname()} ${doctor.getLastname()}</td>
        <td>${doctor.getSpecialization()}</td>
        <td>${doctor.give_BirsdayString()}</td>
        <td>${doctor.getAddress()}</td>
        <td>${doctor.getDoctorlicense().getNumber()}</td>
        <td><a href="/administrator/allDoctors/update/${doctor.getDoctorid()}">РЕДАКТИРОВАТЬ</a></td>
        <td><a href="/administrator/allDoctors/delete/${doctor.getDoctorid()}">УДАЛИТЬ</a></td>
    </tr>
    <#else>
    <p>Докторов в базе нет
        </#list>
</table>
<div id="footer">
    &copy; Creator - Valeev Damir Rinatovich
</div>
</body>
</html>
