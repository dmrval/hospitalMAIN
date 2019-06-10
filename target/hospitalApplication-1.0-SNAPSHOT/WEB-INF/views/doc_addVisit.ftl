<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Добавить запись</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>
<h2 class="forCenterButtons">Выберите пациента</h2>
<#if calendarDay??>
    <form class="forCenterButtons" name="patAddvisit" action="/patAddvisit" method="post">
        <h3>Запись к ${doc.getSpecialization()} - ${doc.getFirstname()} ${doc.getLastname()}</h3>
        <br>
        <label>Выберите удобное время</label>
        <div>
            <select class="forCenterButtons" id="currTime" name="currTime" size="12" required>
                <#list calendarDay.getWorkCalendar() as time>
                    <option value="${calendarDay.checkPosition_OfWorkCalendar(time)}">${time}</option>
                </#list>
            </select>
        </div>
        <input id="doctor" title="doctor" name="doctor" value="${doc.getDoctorid()}"
               required hidden/>
        <br>
        <input class="forCenterButtons" type="submit" value="Подтвердить запись!"/>
    </form>
</#if>
<div>
    <table>
        <caption>Наши специалисты</caption>
        <tr>
            <td>Пациент</td>
            <td>Дата рождения</td>
            <td>Адрес</td>
            <td>Медицинский полис</td>
        </tr>
        <br>
        <#list lstpatient as patient>
        <tr>
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
            <td>${patient.getMedicalpolicy()}</td>
            <td><a href="/doctor/addVisit/${patient.getPatientid()}/getFreeTimes">ВЫБРАТЬ</a></td>
        </tr>
        <#else>
        <p>Пациентов в базе нет
            </#list>
    </table>
    <br>
    <div class="forCenterButtons">
        <button class="button21" onclick="location.href = '/doctor'">Главная страница</button>
    </div>
</div>
</body>
</html>