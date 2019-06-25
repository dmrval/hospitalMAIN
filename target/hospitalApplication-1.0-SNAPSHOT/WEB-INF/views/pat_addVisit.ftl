<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Выберите специалиста</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>
<h2 class="forCenterButtons">Выберите специалиста и подходящее время</h2>
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
            <td>Доктор</td>
            <td>Специализация</td>
        </tr>
        <br>
        <#list lstdoctor as doctor>
        <tr>
            <td>${doctor.getFirstname()} ${doctor.getLastname()}</td>
            <td>${doctor.getSpecialization()}</td>
            <td><a href="/patient/addVisit/${doctor.getDoctorid()}/getFreeTimes">ВЫБРАТЬ</a></td>
        </tr>
        <#else>
        <p>Докторов в базе нет
            </#list>
    </table>
    <br>
    <div class="forCenterButtons">
        <button class="button21" onclick="location.href = '/patient'">Главная страница</button>
    </div>
</div>
<div id="footer">
    &copy; Creator - Valeev Damir Rinatovich
</div>
</body>
</html>