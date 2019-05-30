<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Редактирование доктора ${doctor.getDoctorid()}</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>

<form name="doc" action="/updateDoctor" method="post" class="editDoctor">
    <input id="doctorid" title="doctorid" name="doctorid" type="number" value="${doctor.getDoctorid()}"
           required hidden/>
    <div>
        <p>День рождения(гггг-мм-дд)</p>
        <input id="birthday" title="Birthday" name="birthday" type="text"
               pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])"
               value="${doctor.give_BirsdayString_for_editPost()}"/>
    </div>
    <div>
        <p>Фамилия</p>
        <input id="firstname" title="Firstname" name="firstname" type="text" value="${doctor.getFirstname()}"
               required/>
    </div>
    <div>
        <p>Имя</p>
        <input id="lastname" title="Lastname" name="lastname" type="text" value="${doctor.getLastname()}" required/>
    </div>
    <div>
        <p>Специализация</p>
        <input id="specialization" title="specialization" name="specialization" type="text"
               value="${doctor.getSpecialization()}"
               required/>
    </div>
    <h3>Номер лицензии</h3>
    <input id="doctorlicense" name="doctorlicense" type="number"
           value="${doctor.giveDoctorlicense_Number()}" max="999999999999999999" min="0"  required path="title"/>
    <h3>Домашний адресс</h3>
    <div>
        <p>Страна</p>
        <input id="country" title="Country" name="country" type="text" value="${doctor.getAddress().getCountry()}"
               required>
    </div>
    <div>
        <p>Город</p>
        <input id="city" title="City" name="city" type="text" value="${doctor.getAddress().getCity()}" required>
    </div>
    <div>
        <p>Улица</p>
        <input id="street" title="Street" name="street" type="text" value="${doctor.getAddress().getStreet()}"
               required>
    </div>
    <div>
        <p>Номер дома</p>
        <input id="house" title="House_number" name="house" type="number" value="${doctor.getAddress().getHouse()}"
               required
               max="2000">
        <p>Номер квартиры</p>
        <input id="flat" title="flat_number" name="flat" type="number" value="${doctor.getAddress().getFlat()}"
               required
               max="2000">
    </div>
    <br>
    <button class="button21" type="submit">Редактировать</button>
</form>
<br>
<div>
    <button class="button21" onclick="location.href = '/administrator/allDoctor'">Отмена</button>
</div>
</body>
</html>