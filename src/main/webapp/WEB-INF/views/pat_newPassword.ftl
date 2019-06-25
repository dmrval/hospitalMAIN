<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Обновление пароля</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>

<h2 class="forCenterButtons">Введите новый пароль</h2>
<#if notdublicate??>
    <div class="errlogin_password">Введенные пароли не совпадают</div>
    <br>
</#if>
<#if wrongoldpass??>
    <div class="errlogin_password">Вы ввели не верный пароль</div>
    <br>
</#if>
<form method="post" action="/patNewPassword" class="forCenterButtons">
    <label for="password">Введите старый пароль
        <input class="input-field" type="password" id="oldpass" name="oldpass" required>
        <br>
    </label>
    <br>

    <label for="password">Введите новый пароль
        <input class="input-field" type="password" id="password" name="password" required>
        <br>
    </label>

    <br>

    <label for="password2">Повторите пароль
        <input class="input-field" type="password" id="password2" name="password2" required>
        <br>
    </label>

    <br>

    <button class="button21" type="submit" value="Обновить пароль">Обновить пароль</button>
</form>

<br>

<div class="forCenterButtons">
    <button class="button21" onclick="location.href = '/patient'">Главная страница</button>
</div>
<div id="footer">
    &copy; Creator - Valeev Damir Rinatovich
</div>
</body>
</html>