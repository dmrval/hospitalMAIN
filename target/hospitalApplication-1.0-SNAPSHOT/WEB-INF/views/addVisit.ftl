<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Добавить запись</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
    <script type="text/javascript">
        function today() {
            var d = new Date();
            var day = d.getDate();
            var month = d.getMonth() + 2;
            var year = d.getFullYear();
            var str = year + "-0" + month + "-" + day + " 00:00";
            document.getElementById("dayofvisit").max = str;
        }

        window.onload = today;
    </script>
</head>
<body>
<form name="visit" action="/addVisit" method="post">
    <div>
        <p>Дата и время приема</p>
        <input id="dayofvisit" title="dayofvisit" name="dayofvisit" type="datetime-local"
               pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])"
               required/>
    </div>
    <div>
        <p>Доктор</p>
        <select id="doctor" name="doctor" size="7" required>
            <#list doclist as doc>
                <option value="${doc.getDoctorid()}">${doc}</option>
            </#list>
        </select>
    </div>
    <div>
        <p>Пациент</p>
        <select id="patient" name="patient" size="7" required>
            <#list patlist as pat>
                <option value="${pat.getPatientid()}">${pat}</option>
            </#list>
        </select>
    </div>
    <br>
    <div>
        <button class="button21" type="submit">Добавить запись</button>
    </div>
</form>
<br>
<button class="button21" onclick="location.href = '/administrator/allVisits/'">Отмена</button>


</body>
</html>