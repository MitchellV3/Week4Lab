<%-- 
    Document   : viewnote
    Created on : 4-Feb-2023, 4:00:03 AM
    Author     : Mitchell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <h3>Title: </h3>
        <p>${note.title}</p>
        <h3>Contents: </h3>
        <p>${note.body}</p>
        <br>
        <a href="note?edit=clicked">Edit</a>
    </body>
</html>
