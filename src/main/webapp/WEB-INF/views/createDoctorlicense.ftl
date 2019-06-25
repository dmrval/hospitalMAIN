<!DOCTYPE html>
<html lang="en" xmlns:form="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8"/>

    <title>Create Doctorlicense Page</title>
</head>
<body>
<h3>Input new license number</h3>
<form name="tmplicense" action="/addDoctorlicensePage" method="post">
    <input title="Number" type="text" name="number">
    <button>Add</button>
</form>

<form action="/hello">
    <button style="vertical-align: middle">Cancel</button>
</form>
<div id="footer">
    &copy; Creator - Valeev Damir Rinatovich
</div>
</body>
</html>