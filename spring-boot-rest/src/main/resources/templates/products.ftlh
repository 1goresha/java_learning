<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<script
        src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous">
</script>
<body>
<script>
    function addProduct(name, price) {
        let json = {"name": name, "price": price};

        $.ajax({
            type: "POST",
            url: "/products/json",
            data: JSON.stringify(json),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (response) {
                let resultPlace = document.getElementById('productTable');
                let resultString = '<table>';
                console.clear();
                for (let i = 0; i < response.length; i++) {
                    let current = response[i];
                    resultString += '<tr>';
                    resultString += '<td>';
                    resultString += current['id'] + ' ' + current['name'] + current['price'];
                    resultString += '</td>';
                    resultString += '</tr>';
                }
                resultString += '</table>';
                resultPlace.innerHTML = resultString;
            },
            failure: function (errMsg) {
                alert(errMsg);
            }
        });

        // }).done(function (response) {
        //     let str = '';
        //     str = '<table>';
        //     for (let i = 0; i < response.length; i++) {
        //         let response1 = response[i];
        //         str += '<tr>';
        //         str += '<td>';
        //         str += response1['id'] + ' ' + response1['name'] + ' ' + response1['price'];
        //         str += '</tr>';
        //         str += '</td>';
        //     }
        //     str += '</table>';
        //     document.getElementById('productTable').innerHTML = str;
        // })
    }
</script>
<div>
    <#--    <form method="post">-->
    <input type="text" id="name" name="name" placeholder="Наименование"/>
    <input type="text" id="price" name="price" placeholder="Цена"/>
    <button onclick="addProduct(document.getElementById('name').value, document.getElementById('price').value)">Добавить продукт</button>
    <#--    </form>-->
</div>
<div id="productTable">
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
</div>
</body>
</html>