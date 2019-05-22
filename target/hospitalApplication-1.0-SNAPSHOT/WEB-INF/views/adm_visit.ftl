<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <style type="text/css">
        <#include "/resources/allstyle.css">
    </style>
    <title>${visit.give_DateString()}</title>
</head>
<body>
<div>
    <h3>Дата и время приема</h3>
    <p>${visit.give_DateString()}</p>
    <h3>Пациент: </h3>
    <p>${visit.getPatient().getFirstname()} ${visit.getPatient().getLastname()}</p>
    <h3>Поставленный диагноз</h3>
    <#if visit.getDiagnosis()??>
        <p>${visit.getDiagnosis().getResultofdiagnosis()}</p>
    <#else>
        <P><a href="/administrator/allVisit/${visit.getVisitid()}/setDiagosis">Поставить диагноз</a></P>
    </#if>
    <h3>Осматриваемый врач</h3>
    <p>${visit.getDoctor().getSpecialization()} - ${visit.getDoctor().getFirstname()} ${visit.getDoctor().getLastname()}</p>
</div>
<br>

<button class="button21" onclick="location.href = '/administrator/allVisit'">Назад</button>
<button class="button21" onclick="location.href = '/administrator/update/${visit.getVisitid()}'">Редактировать запись
</button>
<button class="button21" onclick="location.href = '/administrator/delete/${visit.getVisitid()}'">Удалить запись</button>


</body>
</html>