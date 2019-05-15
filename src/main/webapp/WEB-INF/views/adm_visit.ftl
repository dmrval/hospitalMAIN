<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Пациент ${visit.getPatient().getFirstname()} ${visit.getPatient().getLastname()}</title>
</head>
<body>
<div>
    <h3>Дата и время приема</h3>
    ${visit.give_DateString()}
    <h3>Пациент: </h3> ${visit.getPatient().getFirstname()} ${visit.getPatient().getLastname()}
    <h3>Поставленный диагноз</h3>
    <#if visit.getDiagnosis()??>
        ${visit.getDiagnosis().getResultofdiagnosis()}
    <#else>
        Пациенту еще не поставлен диагноз
    </#if>
    <h3>Осматриваемый врач</h3>
    ${visit.getDoctor().getFirstname()} ${visit.getDoctor().getLastname()}
</div>
<br>

<button onclick="location.href = '/administrator/'">Назад</button>
<button onclick="location.href = '/administrator/delete/${visit.getVisitid()}'">Удалить запись</button>


</body>
</html>