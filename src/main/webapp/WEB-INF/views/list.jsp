
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>free board</title>
    <style>
        #list {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        #list td, #list th {
            border: 1px solid #ddd;
            padding: 8px;
            text-align:center;
        }
        #list tr:nth-child(even){background-color: #f2f2f2;}
        #list tr:hover {background-color: #ddd;}
        #list th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;
            background-color: #006bb3;
            color: white;
        }
    </style>
    <script>
        function delete_ok(){
            alert("삭제성공 !!!");
        }

    </script>
</head>
<body>
<h1>자유게시판</h1>

<table id="list" width="90%">
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Writer</th>
        <th>Content</th>
        <th>Regdate</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.seq}</td>
            <td><a href="view/${u.seq}">${u.title}</a></td>
            <td>${u.writer}</td>
            <td>${u.content}</td>
            <td>${u.regdate}</td>
            <td><a href="editform/${u.seq}">Edit</a></td>
            <td><a href="deleteok/${u.seq}" onclick="delete_ok()">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<%--<br/><a href="addform.jsp">Add New Post</a>--%>
<br/><button type="button" onclick="location.href='add'">New Post</button>
</body>
</html>