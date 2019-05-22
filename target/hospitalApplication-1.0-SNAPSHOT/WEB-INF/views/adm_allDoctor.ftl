<!DOCTYPE html>
<html lang="en" xmlns:form="http://www.w3.org/1999/html">
<head>
    <title>База данных докторов</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>
<button class="button21" onclick="location.href = '/administrator/'">Вернуться назад</button>

<button class="button21" onclick="location.href = '/administrator/addDoctor'">Добавить доктора</button>

<button class="button21" onclick="location.href = '/administrator/'">На главную страницу</button>

<br>
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
            <td><a href="/administrator/allDoctor/update/${doctor.getDoctorid()}">РЕДАКТИРОВАТЬ</a></td>
            <td><a href="/administrator/allDoctor/delete/${doctor.getDoctorid()}">УДАЛИТЬ</a></td>
        </tr>
        <#else>
<p>No Patients
    </#list>
    </table>
</body>
</html>
