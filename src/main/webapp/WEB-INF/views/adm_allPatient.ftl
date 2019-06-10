<!DOCTYPE html>
<html lang="en" xmlns:form="http://www.w3.org/1999/html">
<head>
    <title>База данных пациентов</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>
<div class="forCenterButtons">
    <button class="button21" onclick="location.href = '/administrator/'">Вернуться назад</button>

    <button class="button21" onclick="location.href = '/administrator/addPatient'">Добавить пациента</button>

    <button class="button21" onclick="location.href = '/administrator/'">На главную страницу</button>
</div>
<br>
<table>
    <caption>Список пациентов</caption>
    <tr>
        <td>Идентификатор</td>
        <td>Пациент</td>
        <td>Дата рождения</td>
        <td>Домашний адрес</td>
        <td>Номер полиса</td>
    </tr>
    <br>
    <#list lstpatient as patient>
    <tr>
        <td>${patient.getPatientid()}</td>
        <td>${patient.getFirstname()} ${patient.getLastname()}</td>
        <#if patient.getBirthday()??>
            <td>${patient.give_BirsdayString()}</td>
        <#else>
            <td> ---</td>
        </#if>
        <#if patient.getAddress()??>
            <td>${patient.getAddress()}</td>
        <#else>
            <td> ---</td>
        </#if>
        <td>${patient.getMedicalpolicy().getNumber()}</td>
        <td><a href="/administrator/allPatient/update/${patient.getPatientid()}">РЕДАКТИРОВАТЬ</a></td>
        <td><a href="/administrator/allPatient/delete/${patient.getPatientid()}">УДАЛИТЬ</a></td>
    </tr>
    <#else>

    <p>Пациентов в базе нет

        </#list>
</table>
</body>
</html>
