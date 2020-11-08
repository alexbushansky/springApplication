<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>all persons!</title>
    <style type="text/css">
        body
        {
            display: inline;

        }
        td {
            border: 2px solid black;
        }

        table
        {
            padding: 30px;
            width: 800px;
            height: auto;
            margin: 0 auto;
        }
        .information
        {
            float: left;
            width: 800px;
            height: auto;
        }

        .add-p{
            padding: 30px;

        }
    </style>
</head>
<body>
    <div class="information">
    <table>
        <tr>
            <td>ID</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Options</td>
        </tr>
        <c:forEach var="person" items="${listPerson}">
            <tr>
                <td>${person.id}</td>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
                <td>
                    <form action="/delete-person" method="post">
                    <button>
                        <input type="hidden" name="id" value="${person.id}">
                        <strong>delete</strong>
                    </button>
                    </form>
                    <br>
                    <strong><a href="/update-person/${person.id}">Update Person </a></strong>
                </td>
            </tr>
        </c:forEach>
    </table>
    </div>
    <div class="add-p">
        <form action="/create-person" method="post">
            <strong>Enter your information</strong>
            <br>
            <input type="text" placeholder="FIRST NAME" name="firstName">
            <input type="text" placeholder="LAST NAME" name="lastName">
            <button>
                add person
            </button>
        </form>
    </div>
</body>
</html>