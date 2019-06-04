<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Обновление персональных данных</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>
<form name="pat" action="/pat_patSettings" method="post" class="editPatient">
    <input id="patientid" title="patientid" name="patientid" type="number" value="${patient.getPatientid()}"
           required hidden/>
    <div>
        <p>День рождения(гггг-мм-дд)</p>
        <#if patient.getBirthday()??>
            <input id="birthday" title="Birthday" name="birthday" type="text"
                   pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])"
                   value="${patient.give_BirsdayString_for_editPost()}"/>
        <#else>
            <input id="birthday" title="Birthday" name="birthday" type="text"
                   pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" required/>
        </#if>

    </div>
    <div>
        <p>Фамилия</p>
        <input id="firstname" title="Firstname" name="firstname" type="text" value="${patient.getFirstname()}"
               required/>
    </div>
    <div>
        <p>Имя</p>
        <input id="lastname" title="Lastname" name="lastname" type="text" value="${patient.getLastname()}" required/>
    </div>
    <h3>Номер медицинского полиса</h3>
    <input id="medicalpolicy" name="medicalpolicy" type="number" max="999999999999999999" min="0"
           value="${patient.giveMedicalpolicy_Number()}"
           required/>
    <h3>Домашний адресс</h3>
    <#if patient.getAddress()??>
        <p>Страна</p>
        <div>
            <input id="country" title="Country" name="country" type="text" value="${patient.getAddress().getCountry()}"
                   required>
        </div>
        <div>
            <p>Город</p>
            <input id="city" title="City" name="city" type="text" value="${patient.getAddress().getCity()}" required>
        </div>
        <div>
            <p>Улица</p>
            <input id="street" title="Street" name="street" type="text" value="${patient.getAddress().getStreet()}"
                   required>
        </div>
        <div>
            <p>Номер дома</p>
            <input id="house" title="House_number" name="house" type="number" value="${patient.getAddress().getHouse()}"
                   required
                   max="2000">
            <p>Номер квартиры</p>
            <input id="flat" title="flat_number" name="flat" type="number" value="${patient.getAddress().getFlat()}"
                   required
                   max="2000">
        </div>
        <br>
    <#else>
        <p>Страна</p>
        <div>
            <input id="country" title="Country" name="country" type="text"
                   required>
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
        <br>
    </#if>

    <button class="button21" type="submit">Редактировать</button>
</form>
<br>
<div>
    <button class="button21" onclick="location.href = '/patient'">Отмена</button>
</div>
</body>
</html>