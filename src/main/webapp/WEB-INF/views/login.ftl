<!DOCTYPE html>
<html lang="en">
<head>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>
<#if error??>
    <div class="errlogin_password">Логин или пароль введены не верно</div>
</#if>
<#if logout??>
    <div class="logout_apply">Удачный выход из системы</div>
</#if>
<form name="f" action="/login" method="post" class="forCenterButtons">
    <fieldset>
        <legend>Пожалуйста авторизуйтесь</legend>
        <label for="username">Логин</label>
        <input type="text" id="username" name="username" value=""/>
        <br>
        <br>
        <label for="password">Пароль</label>
        <input type="password" id="password" name="password" value=""/>
        <br>
        <div class="form-actions">
            <br>
            <input name="submit" type="submit" value="Login" class="button21"/>
        </div>
    </fieldset>
</form>
<br>
<div class="forCenterButtons">
    <button class="button21" onclick="location.href = '/singUp'">Регистрация</button>
</div>
<div id="footer">
    &copy; Creator - Valeev Damir Rinatovich
</div>
</body>