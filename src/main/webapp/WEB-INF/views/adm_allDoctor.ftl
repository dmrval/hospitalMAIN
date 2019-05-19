<!DOCTYPE html>
<html lang="en" xmlns:form="http://www.w3.org/1999/html">
<head>
    <title>База данных докторов</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>
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
            <td><a href="/administrator/allDoctor/${doctor.getDoctorid()}">${doctor.getDoctorid()} (подробно)</a></td>
            <td>${doctor.getFirstname()} ${doctor.getLastname()}</td>
            <td>${doctor.getSpecialization()}</td>
            <td>${doctor.give_BirsdayString()}</td>
            <td>${doctor.getAddress()}</td>
            <td>${doctor.getDoctorlicense().getNumber()}</td>
        </tr>
        <#else>
<p>No Patients
    </#list>
    </table>
</body>
</html>
