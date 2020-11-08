<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>all persons!</title>
    <style type="text/css">
        td {
            border: 2px solid black;
        }

        table
        {
            width: 400px;
            height: auto;
            margin: 0 auto;
        }
        .information
        {
            width: 500px;
            height: auto;
        }
    </style>
</head>
<body>
<div class="information">

    <h3>Update person with id ${personId}</h3>
    <form action="/update-person" method="post">
        <strong>Enter your information</strong>
        <br>
        <input type="text" placeholder="FIRST NAME" name="firstName">
        <input type="text" placeholder="LAST NAME" name="lastName">
        <input type="hidden" value="${personId}" name="id">
        <button>
            update person
        </button>
    </form>
</div>
</body>
</html>