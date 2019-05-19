<!DOCTYPE html>
<html lang="en" xmlns:form="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
</script>
<body>
<h1>Добавить нового пациента</h1>

<form name="newPatient" action="/addPatientPost" method="post" onsubmit="return validate()">
    <div>
        <p>Дата рождения</p>
        <input id="birthday" title="Birthday" name="birthday" type="date" required>
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
        <p>Номер дома</p>
        <input id="house" title="House_number" name="house" type="number" required max="2000">
        <p>Номер квартиры</p>
        <input id="flat" title="flat_number" name="flat" type="number" required max="2000">
    </div>
    <div>
        <h3>Номер медицинского полиса</h3>
        <input id="medicalpolicy" name="medicalpolicy" type="number" required path="title">
    </div>
    <div>
        <button type="submit">Добавить</button>
    </div>
</form>
</body>
</html>

