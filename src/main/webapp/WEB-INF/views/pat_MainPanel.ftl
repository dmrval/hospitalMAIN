<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
    <title>Панель пациента</title>
</head>
<body>
<#if plschangepass??>
    <div class="logout_apply">Пожалуйста измените свой пароль</div>
    <br>
</#if>
<div class="forCenterButtons">
    <div>
        <button class="button21" onclick="location.href = '/patient/patSettings'">Редактировать профиль</button>
        <button class="button21" onclick="location.href = '/patient/newPassword'">Изменить пароль</button>
    </div>
    <br>
    <br>
    <div>
        <button class="button21" onclick="location.href = '/patient/addVisit'">Записаться на прием</button>
        <button class="button21" onclick="location.href = '/patient/allVisits'">Ваши записи</button>
    </div>
    <br>
    <div>
        <br>
        <button class="button21" onclick="location.href = '/logout'"> Выход</button>
    </div>
</div>
<div id="footer">
    &copy; Creator - Valeev Damir Rinatovich
</div>
</body>
</html>