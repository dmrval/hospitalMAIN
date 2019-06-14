<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Главная панель</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>
<#if plschangepass??>
    <div class="logout_apply">Пожалуйста измените свой пароль</div>
    <br>
</#if>
<div class="forCenterButtons">
    <div>
        <button class="button21" onclick="location.href = '/doctor/docSettings'">Редактировать профиль</button>
        <button class="button21" onclick="location.href = '/doctor/newPassword'">Изменить пароль</button>
    </div>
    <br>
    <br>
    <div>
        <button class="button21" onclick="location.href = '/doctor/allVisits'">Записи ваших пациентов</button>
    </div>
    <br>
    <div>
        <button class="button21" onclick="location.href = '/doctor/addVisit'">Записать пациента</button>
    </div>
    <br>
    <div>
        <br>
        <button class="button21" onclick="location.href = '/logout'"> Выход</button>
    </div>
</div>
</body>
</html>