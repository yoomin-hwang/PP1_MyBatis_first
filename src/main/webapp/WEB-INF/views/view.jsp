<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="com.example.BoardDAO, com.example.BoardVO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View</title>
</head>
<body>
<%
    BoardDAO boardDAO =new BoardDAO();
    String id = request.getParameter("id");
    BoardVO u = boardDAO.getBoard(Integer.parseInt(id));
    request.setAttribute("vo", u);
%>
    <h1>Notice</h1>
    <table id="edit">
        <tr>
            <td>#</td><td>${vo.getSeq()}</td>
        </tr>
        <tr>
            <td>Category</td><td>${vo.getCategory()}</td>
        </tr>
        <tr>
            <td>Title</td><td>${vo.getTitle()}</td>
        </tr>
        <tr>
            <td>Writer</td><td>${vo.getWriter()}</td>
        </tr>
        <tr>
            <td>Registered Date</td><td>${vo.getRegdate()}</td>
        </tr>
    </table>
    <button type="button" onclick="history.back()">Back</button>
    <button type="button" onclick="location.href=editform.jsp?id=${vo.getSeq()}">Edit</button>
</body>

</html>