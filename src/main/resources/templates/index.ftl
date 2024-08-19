<html>
<head>
<title>Book Catalog</title>
</head>
<body>
<#include "header.ftl">
<h1>Список последних 10 добавленных книг</h1>
<table>
<tbody>
<#list books as book>
<tr>
<td><a href="/books/${book.id}">${book.title}</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>
