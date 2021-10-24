<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <a href="?sort=true&by=age&desc=false">(sort by age)</a>
    <a href="?sort=true&by=age&desc=true">(sort by age desc)</a>
    <a href="?sort=true&by=id&desc=false">(sort by id)</a>
    <a href="?sort=true&by=id&desc=true">(sort by id desc)</a>
    <a href="?">(show all)</a>
</div>
<table>
    <tr>
        <th>id</th>
        <th>имя</th>
        <th>фамилия</th>
        <th>возраст</th>
    </tr>
    <#list users as user>
    <tr>
        <td>${user.id}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.age}</td>
    </tr>
    </#list>
</table>
</body>
</html>