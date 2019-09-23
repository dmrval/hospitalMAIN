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
        <#if isADMIN??>
            <P><a href="/administrator/allVisits/${visit.getVisitid()}/setDiagosis">Поставить диагноз</a></P>
        <#else>
            <P><a href="/doctor/allVisits/${visit.getVisitid()}/setDiagosis">Поставить диагноз</a></P>
        </#if>
    </#if>
    <h3>Осматриваемый врач</h3>
    <p>${visit.getDoctor().getSpecialization()}
        - ${visit.getDoctor().getFirstname()} ${visit.getDoctor().getLastname()}</p>
</div>
<br>

<#if isADMIN??>
    <button class="button21" onclick="location.href = '/administrator/allVisits'">Назад</button>
    <button class="button21" onclick="location.href = '/administrator/update/${visit.getVisitid()}'">
        Редактировать запись
    </button>
    <#if visit.getDiagnosis()??>
        <button class="button21"
                onclick="location.href = '/administrator/allVisits/${visit.getVisitid()}/updateDiagnosis'">
            Обновить диагноз
        </button>
    </#if>
    <button class="button21" onclick="location.href = '/administrator/delete/${visit.getVisitid()}'">
        Удалить запись
    </button>
<#else>
    <button class="button21" onclick="location.href = '/doctor/allVisits'">Назад</button>

    <#if visit.getDiagnosis()??>
        <button class="button21" onclick="location.href = '/doctor/allVisits/${visit.getVisitid()}/updateDiagnosis'">
            Обновить диагноз
        </button>
    </#if>

</#if>
<div id="footer">
    &copy; Creator - Valeev Damir Rinatovich
</div>
</body>
</html>