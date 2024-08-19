<html>
<head>
<title>${author.name}</title>
</head>
<body>
<#include "header.ftl">
<h1>Автор: ${author.name}</h1>
<h2>Книги:</h2>
<#list books as book>
<li><a href="/books/${book.id}">${book.title}</a></li>
        </#list>
</body>
</html>
