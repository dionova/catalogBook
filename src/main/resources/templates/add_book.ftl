<html>
<head>
<title>Добавить книгу</title>
</head>
<body>
<#include "header.ftl">

<h1>Добавление книги</h1>
<form action="/books/add" method="post">
        <label for="title">Название книги:</label>
        <input type="text" id="title" name="title" required><br><br>

        <label for="authors">Выберите авторов:</label>
        <select id="authors" name="authorIds" multiple="multiple" required>
            <#-- Список авторов -->
            <#list authors as author>
                <option value="${author.id}">${author.name}</option>
            </#list>
        </select><br><br>

        <button type="submit">Добавить</button>
    </form>
    <#if errorMessage??>
    <p style="color: red;">${errorMessage}</p>
    </#if>
    <#if message??>
        <p>${message}</p>
    </#if>
</body>
</html>
