<!DOCTYPE html>
<html lang="en" xmlns:form="http://www.w3.org/1999/html">
<head>
    <title>Добавить в базу данных нового доктора</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>

<h1>Внести в базу данных нового доктора</h1>
<form name="newDoctor" action="/addDoctorPost" method="post">
    <div>
        <p>Дата рождения</p>
        <input id="birthday" title="Birthday" name="birthday" type="date" max="2004-12-12" min="1920-12-12" required>
    </div>
    <div>
        <p>Фамилия</p>
        <input id="firstname" title="Firstname" name="firstname" type="text" required>
    </div>
    <div>
        <p>Имя</p>
        <input id="lastname" title="Lastname" name="lastname" type="text" required>
    </div>
    <div>
        <p>Специализация</p>
        <input id="specialization" title="Specialization" name="specialization" type="text" required>
    </div>
    <div>
        <h3>Номер лицензии на оказание мед помощи</h3>
        <input id="number" title="Doctorlicense" name="number" type="number" max="999999999999999999" min="0"  required>
    </div>
    <div>
        <h3>Домашний адресс</h3>
        <p>Страна</p>
        <input id="country" title="Country" name="country" type="text" required>
    </div>
    <div>
        <p>Город</p>
        <input id="city" title="City" name="city" type="text" required>
    </div>
    <div>
        <p>Улица</p>
        <input id="street" title="Street" name="street" type="text" required>
    </div>
    <div>
        <p> Номер дома</p>
        <input id="house" title="House_number" name="house" type="number" required max="2000">
        <p>Номер квартиры</p>
        <input id="flat" title="flat_number" name="flat" type="number" required max="2000">
    </div>
    <br>
    <div>
        <button class="button21" type="submit">Добавить</button>
    </div>
</form>
<br>
<div>
    <button class="button21" onclick="location.href = '/administrator/allDoctor'">Отмена</button>
</div>
</body>
</html>

