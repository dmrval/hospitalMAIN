<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Обновить диагноз</title>
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
</head>
<body>
<h2>Заключение осмотра:</h2>
<form action="/updateDiagosis" method="post">
    <input id="visitid" title="visitid" name="visitid" type="number" value="${visit.getVisitid()}"
           required hidden/>
    <input id="diagid" title="diagid" name="diagid" type="number" value="${visit.getDiagnosis().getDiagnosisid()}"
           required hidden/>
    <textarea id="textdiag" name="textdiag" title="textdiag" cols="100" required rows="20" >${diag.getResultofdiagnosis()}</textarea>
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