<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:choose>
    <c:when test="${not empty object}">
        <c:set var="EmployeeID" value="${object.getEmployeeID()}"/>
        <c:set var="Department" value="${object.getDepartment()}"/>
        <c:set var="LastName" value="${object.getLastName()}"/>
        <c:set var="FirstName" value="${object.getFirstName()}"/>
        <c:set var="MiddleName" value="${object.getMiddleName()}"/>
        <c:set var="StartDate" value="${object.getStartDate()}"/>
        <c:set var="EndDate" value="${object.getEndDate()}"/>
        <c:set var="Salary" value="${object.getSalary()}"/>
    </c:when>
    <c:otherwise>
        <c:set var="EmployeeID" value="0"/>
        <c:set var="Department" value=""/>
        <c:set var="LastName" value=""/>
        <c:set var="FirstName" value=""/>
        <c:set var="MiddleName" value=""/>
        <c:set var="StartDate" value=""/>
        <c:set var="EndDate" value=""/>
        <c:set var="Salary" value="100"/>
    </c:otherwise>
</c:choose>

<html>
<head>
    <META http-equiv="Content-Type"
          content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
    <FORM action="save.html" method="post">
        <c:if test="${not empty object}">
            <INPUT type="hidden" name="id" value="${object.id}">
            </c:if>
            <P>Код сотрудника:</P>
        <INPUT type="text" name="EmployeeID" value="${EmployeeID}">
            <P>Отдел:</P>
        <INPUT type="text" name="Department" value="${Department}">
            <P>Фамилия:</P>
        <INPUT type="text" name="LastName" value="${LastName}">
            <P>Имя:</P>
        <INPUT type="text" name="FirstName" value="${FirstName}">
            <P>Отчество:</P>
        <INPUT type="text" name="MiddleName" value="${MiddleName}">
            <P>Дата начала отпуска:</P>
        <INPUT type="text" name="StartDate" value="${StartDate}">
            <P>Дата окончания отпуска:</P>
        <INPUT type="text" name="EndDate" value="${EndDate}">
            <P>Заработная плата:</P>
        <INPUT type="text" name="Salary" value="${Salary}">
            <BUTTON type="submit">Сохранить</BUTTON>
            <A href="index.html">Назад</A>
    </FORM>
</body>
</html>
