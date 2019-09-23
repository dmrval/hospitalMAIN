<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Реактирование записи</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>
<form name="visit" action="/editVisit" method="post">
    <input id="visitid" title="visitid" name="visitid" type="number" value="${visit.getVisitid()}"
           required hidden/>
    <div>
        <p>Дата и время приема </p>
        <input id="dayofvisit" title="dayofvisit" name="dayofvisit" type="datetime-local"
               value="${visit.give_dayOfVisitString()}" pattern="[1-2]{1}[0-9]{3}[-]{1}[0-1]{1}[0-9]{1}[-]{1}[0-2]{1}[0-9]{1}[T]{1}[0-2]{1}[0-9]{1}[:]{1}[0-5]{1}[0-9]{1}"  />
    </div>
    <div>
        <p>Доктор</p>
        <select id="doctor" name="doctor" size="7" typeof="">
            <#list doclist as doc>
                <option value="${doc.getDoctorid()}">${doc}</option>
            </#list>
            <option selected value="${visit.getDoctor().getDoctorid()}"> ВЫБРАН - ${visit.getDoctor()}</option>
        </select>
    </div>
    <div>
        <p>Пациент</p>
        <select id="patient" name="patient" size="7">
            <#list patlist as pat>
                <option value="${pat.getPatientid()}">${pat}</option>
            </#list>
            <option selected value="${visit.getPatient().getPatientid()}"> ВЫБРАН - ${visit.getPatient()}</option>
        </select>
    </div>
    <br>
    <div>
        <button class="button21" type="submit">Редактировать</button>
    </div>
</form>
<br>
<button class="button21" onclick="location.href = '/administrator/allVisits/${visit.getVisitid()}'">Назад</button>

<div id="footer">
    &copy; Creator - Valeev Damir Rinatovich
</div>
</body>
</html>