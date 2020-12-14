<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <STYLE>
        TABLE {
            border-collapse: collapse;
        }
        TH, TD {
            border: 1px solid black;
            padding: 5px 30px 5px 10px;
        }
    </STYLE>
</head>
<body>
<c:choose>
    <c:when test="${not empty user}">
        ${user.login}&nbsp;&mdash; <A href="logout.html">Выйти</A>
        <p></p>
    </c:when>
    <c:otherwise>
        <A href="../../login-form.jsp">Войти</A>
        <p></p>
    </c:otherwise>
</c:choose>
<c:if test="${not empty user && user.getRole() == 1}">
    <A href="indexUsers.html">Редактировать пользователей</A>
    <p></p>
</c:if>
<c:if test="${not empty user && user.getRole() == 2}">
<FORM action="delete.html" method="post">
</c:if>
    <TABLE>
        <TR>
            <c:if test="${not empty user && user.getRole() == 2}"><TH>&nbsp;</TH></c:if>
            <TH>Наименование специализации</TH>
            <TH>Является ли специальность узкой</TH>
            <TH>Количество врачей данной специальности</TH>
            <TH>Ставка заработной платы</TH>
            <TH>Сумма затрат на оплату зарплаты врачам</TH>
        </TR>
        <c:forEach var="specializations" items="${specializations}">
            <TR>
                <c:if test="${not empty user && user.getRole() == 2}">
                <TD>
                    <INPUT type="checkbox" name="id"
                           value="${specializations.id}">

                </TD>
                </c:if>
                <TD>
                    <c:if test="${not empty user && user.getRole() == 2}">
                    <A href="edit.html?id=${specializations.id}">
                    </c:if>
                            ${specializations.getName()}
                    <c:if test="${not empty user && user.getRole() == 2}">
                    </A>
                    </c:if>
                </TD>
                <TD>${specializations.isNarrow()}</TD>
                <TD>
                    <A href="indexDocs.html?id=${specializations.id}">
                        ${specializations.getAmountOfDocs()}
                </TD>
                <TD>${specializations.getWageRate()}</TD>
                <TD>${specializations.getCosts()}</TD>
            </TR>
        </c:forEach>
    </TABLE>
<c:if test="${not empty user && user.getRole() == 2}">
    <P>
        <A href="edit.html">Добавить</A>
        <BUTTON type="submit">Удалить</BUTTON>
    </P>
</FORM>
</c:if>
</body>
</html>
