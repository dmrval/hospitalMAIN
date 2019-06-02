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

<h2>Введите новый пароль</h2>
<br>
<#if notdublicate??>
    <div class="errlogin_password">Введенные пароли не совпадают</div>
</#if>
<form method="post" action="/patNewPassword" class="forCenterButtons">
    <label for="password">Введите новый пароль
        <input class="input-field" type="password" id="password" name="password" required>
        <br>

    </label>

    <br>

    <label for="password2">Повторите пароль
        <input class="input-field" type="password" id="password2" name="password2" required>
        <br>

    </label>
    <input type="submit" value="Обновить пароль">
</form>
</body>
</html>