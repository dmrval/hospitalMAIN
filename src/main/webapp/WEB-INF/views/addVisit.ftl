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
<form name="visit" action="/editVisit" method="post">
    <input id="visitid" title="visitid" name="visitid" type="number" value="${visit.getVisitid()}"
           required hidden/>
    <div>
        <p>Дата приема(гггг-мм-дд)</p>
        <input id="dayofvisit" title="dayofvisit" name="dayofvisit" type="datetime-local"
               pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])"
               value="${visit.give_DateString()}"/>
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
<button class="button21" onclick="location.href = '/administrator/allVisit/${visit.getVisitid()}'">Назад</button>


</body>
</html>