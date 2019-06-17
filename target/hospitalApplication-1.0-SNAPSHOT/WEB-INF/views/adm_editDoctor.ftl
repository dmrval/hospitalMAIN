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
    <br>
    <div>
        <label>Фамилия </label>
        <input id="firstname" title="Firstname" name="firstname" type="text" value="${doctor.getFirstname()}"
               required/>
        <label>Имя </label>
        <input id="lastname" title="Lastname" name="lastname" type="text" value="${doctor.getLastname()}" required/>
    </div>
    <div>
        <p>Специализация</p>
        <input id="specialization" title="specialization" name="specialization" type="text"
               value="${doctor.getSpecialization()}" required/>
    </div>
    <h3>Номер лицензии</h3>
    <input id="doctorlicense" name="doctorlicense" type="number"
           value="${doctor.giveDoctorlicense_Number()}" max="999999999999999999" min="0" required path="title"/>
    <h3>Домашний адресс</h3>
    <div>
        <label>Страна </label>
        <input id="country" title="Country" name="country" type="text" value="${doctor.getAddress().getCountry()}"
               required>
        <label>Город </label>
        <input id="city" title="City" name="city" type="text" value="${doctor.getAddress().getCity()}" required>
        <label>Улица </label>
        <input id="street" title="Street" name="street" type="text" value="${doctor.getAddress().getStreet()}"
               required>
    </div>
    <br>
    <div>
        <label>Номер дома </label>
        <input id="house" title="House_number" name="house" type="number" value="${doctor.getAddress().getHouse()}"
               required max="2000">
        <label>Номер квартиры </label>
        <input id="flat" title="flat_number" name="flat" type="number" value="${doctor.getAddress().getFlat()}" required
               max="2000">
    </div>
    <br>
    <button class="button21" type="submit">Редактировать</button>
</form>
<br>
<div>
    <button class="button21" onclick="location.href = '/administrator/allDoctors'">Отмена</button>
</div>
</body>
</html>