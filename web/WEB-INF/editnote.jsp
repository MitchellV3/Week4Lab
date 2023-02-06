<%-- 
    Document   : editnote
    Created on : 4-Feb-2023, 4:00:11 AM
    Author     : Mitchell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
          <h3>Title: </h3>
          <input type="text" name="title" value="${note.title}"><br>
          <h3>Contents: </h3>
          <textarea cols="40" rows="5" name="body" value="${note.body}"></textarea><br>
          <br>
          <input type="submit" value="Save">
        </form>
        <br>
        <a href="note?view=clicked">View</a>
    </body>
</html>
