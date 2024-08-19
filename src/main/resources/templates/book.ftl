<html>
<head>
<title>${book.title}</title>
</head>
<body>
<#include "header.ftl">
<h1>Название книги: ${book.title}</h1>
<h2>Авторы:</h2>
<#list authors as author>
<a href="/authors/${author.id}">${author.name}</a>
        </#list>
</body>
</html>