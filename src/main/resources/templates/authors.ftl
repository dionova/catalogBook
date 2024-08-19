<html>
<head>
<title>Authors</title>
</head>
<body>
<#include "header.ftl">
<form action="/authors/search" method="get">
        <input type="text" name="name" placeholder="Введите автора">
        <button type="submit">Искать</button>
    </form>
<h1>Список авторов</h1>
<#list authors as author>
<li><a href="/authors/${author.id}">${author.name}</a></li>
    </#list>
</body>
</html>
