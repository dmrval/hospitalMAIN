<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Рузультат осмотра пациента ${visit.getPatient().getFirstname()} ${visit.getPatient().getLastname()}</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>
<h2>Заключение осмотра:</h2>
<form action="/setDiagosis" method="post">
    <input id="visitid" title="visitid" name="visitid" type="number" value="${visit.getVisitid()}"
           required hidden/>
    <textarea id="textdiag" name="textdiag" title="textdiag" cols="100" required rows="20"></textarea>
    <div>
        <button class="button21" type="submit">Готово</button>
    </div>
</form>
<br>
<#if isADMIN??>
    <div>
        <button class="button21" onclick="location.href = '/administrator/allVisits/${visit.getVisitid()}'">Отмена</button>
    </div>
<#else>
    <div>
        <button class="button21" onclick="location.href = '/doctor/allVisits/${visit.getVisitid()}'">Отмена</button>
    </div>
</#if>


</body>
</html>