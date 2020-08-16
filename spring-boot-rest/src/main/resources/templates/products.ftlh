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
    <form method="post">
        <input type="text" name="name" placeholder="Наименование"/>
        <input type="text" name="price" placeholder="Цена"/>
        <input type="submit" placeholder="Отправить"/>
    </form>
</div>
<table>
    <tr>
        <th>Id</th>
        <th>Наимнование</th>
        <th>Цена</th>
    </tr>
    <#list products as product>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
        </tr>
    </#list>
</table>
</body>
</html>