<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous">
    </script>
</head>
<body>
<script>
    function f(query) {
        $.ajax({
            url: '/users/search.json?q=' + query,
            type: "GET",
        }).done(function (response) {
            let str = '';
            str = '<table>';
            for (let i = 0; i < response.length; i++) {
                let response1 = response[i];
                str += '<tr>';
                str += '<td>';
                str += response1['firstName'] + ' ' + response1['lastName'] + ' ' + response1['age'];
                str += '</tr>';
                str += '</td>';
            }
            str += '</table>';
            document.getElementById('resultString').innerHTML = str;
        })
    }
</script>
<input id="query" type="text" placeholder="запрос" onkeyup="f(document.getElementById('query').value)">
<div id="resultString">

</div>
</body>
</html>