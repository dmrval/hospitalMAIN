<!DOCTYPE html>
<html lang="en">
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
        <p>Дата рождения (гггг-мм-дд)</p>
        <input id="birthday" title="Birthday" name="birthday"
               pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" type="date" max="2004-12-12"
               min="1920-12-12" required>
        <label>Логин </label>
        <input id="login" title="login" name="login" type="text" required>
    </div>
    <br>
    <div>
        <label>Фамилия </label>
        <input id="firstname" title="Firstname" name="firstname" type="text" required>
        <label>Имя </label>
        <input id="lastname" title="Lastname" name="lastname" type="text" required>
    </div>
    <div>
        <p>Специализация</p>
        <input id="specialization" title="Specialization" name="specialization" type="text" required>
    </div>
    <div>
        <h3>Номер лицензии на оказание мед помощи</h3>
        <input id="number" title="Doctorlicense" name="number" type="number" max="999999999999999999" min="0" required>
    </div>
    <div>
        <h3>Домашний адресс</h3>
        <label>Страна </label>
        <input id="country" title="Country" name="country" type="text" required>
        <label>Город </label>
        <input id="city" title="City" name="city" type="text" required>
        <label>Улица </label>
        <input id="street" title="Street" name="street" type="text" required>
    </div>
    <br>
    <div>
        <label>Номер дома </label>
        <input id="house" title="House_number" name="house" type="number" required max="2000">
        <label>Номер квартиры </label>
        <input id="flat" title="flat_number" name="flat" type="number" required max="2000">
    </div>
    <br>
    <div>
        <button class="button21" type="submit">Добавить</button>
    </div>
</form>
<br>
<div>
    <button class="button21" onclick="location.href = '/administrator/allDoctors'">Отмена</button>
</div>
<div id="footer">
    &copy; Creator - Valeev Damir Rinatovich
</div>
</body>
</html>

