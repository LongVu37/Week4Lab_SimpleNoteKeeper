<%-- 
    Document   : editnote
    Created on : 29-09-2022, 22:50:34
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form action="note" method="post">
            Title: <input type="text" name="title" value="${note.title}"><br>
            Contents: 
            <textarea name="content"  cols="30" rows="6" wrap="hard">${note.content}</textarea>
            <br><input type="submit" value="Save">
        </form>
    </body>
</html>