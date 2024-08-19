<html>
<head>
<title>Books</title>
</head>
<body>
<#include "header.ftl">
<form action="/books/search" method="get">
        <input type="text" name="title" placeholder="Введите название книги">
        <button type="submit">Искать</button>
    </form>
<h1>Все книги</h1>
<#list books as book>
<li><a href="/books/${book.id}">${book.title}</a></li>
</#list>
</body>
</html>
