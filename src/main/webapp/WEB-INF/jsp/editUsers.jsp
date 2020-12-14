<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:choose>
    <c:when test="${not empty User}">
        <c:set var="Login" value="${User.getLogin()}"/>
        <c:set var="Password" value="${User.getPassword()}"/>
        <c:set var="Role" value="${User.getRole()}"/>
        <c:set var="New" value="false"/>
        <c:choose>
            <c:when test="${Role == 0}">
                <c:set var="CheckTemp0" value="selected"/>
                <c:set var="CheckTemp1" value=""/>
                <c:set var="CheckTemp2" value=""/>
            </c:when>
            <c:when test="${Role == 1}">
                <c:set var="CheckTemp0" value=""/>
                <c:set var="CheckTemp1" value="selected"/>
                <c:set var="CheckTemp2" value=""/>
            </c:when>
            <c:otherwise>
                <c:set var="CheckTemp0" value=""/>
                <c:set var="CheckTemp1" value=""/>
                <c:set var="CheckTemp2" value="selected"/>
            </c:otherwise>
        </c:choose>
    </c:when>
    <c:otherwise>
        <c:set var="Login" value=""/>
        <c:set var="Password" value=""/>
        <c:set var="Role" value="0"/>
        <c:set var="New" value="true"/>
        <c:set var="CheckTemp0" value="selected"/>
        <c:set var="CheckTemp1" value=""/>
        <c:set var="CheckTemp2" value=""/>
    </c:otherwise>
</c:choose>

<html>
<head>
    <META http-equiv="Content-Type"
          content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<c:if test="${LoginCheck}">
    <P style="color: red;">Данный логин уже занят</P>
</c:if>
<FORM action="saveUsers.html" method="post">
    <input type="hidden" name="New" value="${New}">
    <P>Логин:</P>
    <c:choose>
        <c:when test="${New}"><INPUT type="text" name="Login" value="${Login}"></c:when>
        <c:otherwise><input type="hidden" name="Login" value="${Login}"><P>${Login}</P></c:otherwise>
    </c:choose>
    <P>Пароль:</P>
    <INPUT type="text" name="Password" value="${Password}">
    <P>Роль:</P>
    <c:choose>
        <c:when test="${Login == 'admin'}">
            <input type="hidden" name="Role" value="${Role}">
            <p>Admin</p>
        </c:when>
        <c:when test="${Login == 'master'}">
            <input type="hidden" name="Role" value="${Role}">
            <p>Master</p>
        </c:when>
        <c:otherwise>
    <SELECT size="3" name="Role" value="${Role}">
        <OPTION ${CheckTemp0} value="0">DefaultUser</OPTION>
        <OPTION ${CheckTemp1} value="1">Admin</OPTION>
        <OPTION ${CheckTemp2} value="2">Master</OPTION>
    </SELECT>
        </c:otherwise>
    </c:choose>
    <BUTTON type="submit">Сохранить</BUTTON>
    <A href="indexUsers.html">Назад</A>
</FORM>
</body>
</html>