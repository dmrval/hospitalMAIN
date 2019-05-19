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

<form name="visit" action="/administrator/editVisit" method="post">
    СДЕЛАТь надо грамотно выбор времени ГРАМОТНО ВРЕМЯ
    <div>
        <p>Доктор</p>
        <select id="doctor" name="doctor" size="7">
            <#list doclist as doc>
                <option value="${doc}">${doc}</option>
            </#list>
        </select>
    </div>
    <div>
        <p>Пациент</p>
        <select id="patient" name="patient" size="7">
            <#list patlist as pat>
                <option value="${pat}">${pat}</option>
            </#list>
        </select>
    </div>
    <br>
    <div>
        <button class="button21" type="submit">Редактировать</button>
    </div>
</form>

</body>
</html>