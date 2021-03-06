<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Добавить нового пациента</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<script type="text/javascript">
    function validate() {
        var userName = document.getElementById("medicalpolicy");
        if (userName.value == null) {
            userName.style.border = "2px solid red";
            return false;
        }
        return true;
    }

    function today() {
        var d = new Date();
        var day = d.getDate();
        var month = d.getMonth() + 1;
        var year = d.getFullYear() - 16;
        var str = year + "-0" + month + "-" + day;
        document.getElementById("birthday").max = str;
        document.getElementById("birthday").value = str;
    }

    window.onload = today;
</script>
<body>
<h1>Добавить нового пациента</h1>
<form name="newPatient" action="/addPatientPost" method="post" onsubmit="return validate()">
    <div>
        <p>Дата рождения (гггг-мм-дд)</p>
        <input id="birthday" title="Birthday" min="1920-12-12" name="birthday" type="date"
               pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" required>
    </div>
    <div>
        <p>Логин</p>
        <input id="login" title="login" name="login" type="text" required>
    </div>
    <br>
    <div>
        <label>Фамилия</label>
        <input id="firstname" title="Firstname" name="firstname" type="text" required>
        <label>Имя</label>
        <input id="lastname" title="Lastname" name="lastname" type="text" required>
    </div>
    <div>
        <h3>Домашний адресс</h3>
        <label>Страна</label>
        <input id="country" title="Country" name="country" type="text" required>
        <label>Город</label>
        <input id="city" title="City" name="city" type="text" required>
        <label>Улица</label>
        <input id="street" title="Street" name="street" type="text" required>
    </div>
    <br>
    <div>
        <label>Номер дома</label>
        <input id="house" title="House_number" name="house" type="number" required max="2000">
        <label>Номер квартиры</label>
        <input id="flat" title="flat_number" name="flat" type="number" required max="2000">
    </div>
    <br>
    <div>
        <h3>Номер медицинского полиса</h3>
        <input id="medicalpolicy" name="medicalpolicy" max="999999999999999999" min="0" type="number" required
               path="title">
    </div>
    <br>
    <div>
        <button class="button21" type="submit">Добавить</button>
    </div>
</form>
<br>
<div>
    <button class="button21" onclick="location.href = '/administrator/allPatients'">Отмена</button>
</div>
<div id="footer">
    &copy; Creator - Valeev Damir Rinatovich
</div>
</body>
</html>

