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
<FORM action="deleteUsers.html" method="post">
    <TABLE>
        <TR>
            <TH>&nbsp;</TH>
            <TH>Логин пользователя</TH>
            <TH>Пароль</TH>
            <TH>Роль</TH>
        </TR>
        <c:forEach var="user" items="${users}">

            <TR>
                    <TD>
                        <c:if test="${user.getLogin() != 'admin' && user.getLogin() != 'master'}">
                        <INPUT type="checkbox" name="id"
                               value="${user.getLogin()}">
                        </c:if>
                    </TD>
                <TD>
                    <A href="editUsers.html?id=${user.getLogin()}">
                            ${user.getLogin()}
                    </A>
                </TD>
                <TD>${user.getPassword()}</TD>
                <c:choose>
                    <c:when test="${user.getRole() == 0}"><td>DefaultUser</td></c:when>
                    <c:when test="${user.getRole() == 1}"><td>Admin</td></c:when>
                    <c:otherwise><td>Master</td></c:otherwise>
                </c:choose>
            </TR>
        </c:forEach>
    </TABLE>
    <P>
        <A href="editUsers.html">Добавить</A>
        <BUTTON type="submit">Удалить</BUTTON>
    </P>
</FORM>
<a href="index.html">Назад</a>
</body>
</html>
