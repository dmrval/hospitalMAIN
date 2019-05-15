<!DOCTYPE html>
<html lang="en" xmlns:form="http://www.w3.org/1999/html">
<head>
    <title>Внести в базу данных нового доктора</title>
</head>
<body>

<h1>Внести в базу данных нового доктора</h1>
<form name="newDoctor" action="/addDoctorPost" method="post">
    <div>
        Дата рождения
        <input id="birthday" title="Birthday" name="birthday" type="date" required>
    </div>
    <div>
        Фамилия
        <input id="firstname" title="Firstname" name="firstname" type="text" required>
    </div>
    <div>
        Имя
        <input id="lastname" title="Lastname" name="lastname" type="text" required>
    </div>
    <div>
        Специализация
        <input id="specialization" title="Specialization" name="specialization" type="text" required>
    </div>
    <div>
        <h3>Номер лицензии на оказание мед помощи</h3>
        <input id="number" title="Doctorlicense" name="number" type="number" required>
    </div>
    <div>
        <h3>Домашний адресс</h3>
        Страна
        <input id="country" title="Country" name="country" type="text" required>
    </div>
    <div>
        Город
        <input id="city" title="City" name="city" type="text" required>
    </div>
    <div>
        Улица
        <input id="street" title="Street" name="street" type="text" required>
    </div>
    <div>
        Номер дома
        <input id="house" title="House_number" name="house" type="number" required max="2000">
        Номер квартиры
        <input id="flat" title="flat_number" name="flat" type="number" required max="2000">
    </div>
    <div>
        <button type="submit">Добавить</button>
    </div>
</form>
</body>
</html>

