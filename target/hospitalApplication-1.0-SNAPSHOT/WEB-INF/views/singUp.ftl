<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
    <title>Title</title>
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        <h2 class="forCenterButtons">Зарегистрируйтесь!</h2>
    </div>
    <#if userIsExist??>
        <div class="errlogin_password">Пользователь с таким именем уже существует</div>
        <br>
    </#if>

    <#if notdublicate??>
        <div class="errlogin_password">Введенные пароли не совпадают</div>
        <br>
    </#if>
    <form method="post" action="/signUp" class="forCenterButtons">
        <label for="login">Фамилия
            <input id="firstname" title="Firstname" name="firstname" type="text" required>
            <br>

        </label>

        <br>
        <label for="login">Имя
            <input id="lastname" title="Lastname" name="lastname" type="text" required>
            <br>

        </label>

        <br>
        <label for="login">Номер медицинского полиса
            <input id="medicalpolicy" name="medicalpolicy" max="999999999999999999" min="0" type="number" required
                   path="title">
            <br>

        </label>

        <br>
        <label for="login">Логин
            <input class="input-field" type="text" id="login" name="login" required>
            <br>

        </label>

        <br>

        <label for="password">Пароль
            <input class="input-field" type="password" id="password" name="password" required>
            <br>

        </label>

        <br>

        <label for="password2">Повторите пароль
            <input class="input-field" type="password" id="password2" name="password2" required>
            <br>

        </label>

        <br>
        <div>
            <input class="button21" type="submit" value="Зарегистрироваться">
        </div>

        <br>
    </form>

</body>
</html>