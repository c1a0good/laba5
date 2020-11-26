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
<FORM action="delete.html" method="post">
    <TABLE>
        <TR>
            <TH>&nbsp;</TH>
            <TH>Код сотрудника</TH>
            <TH>Отдел</TH>
            <TH>Фамилия</TH>
            <TH>Имя</TH>
            <TH>Отчество</TH>
            <TH>Дата начала отпуска</TH>
            <TH>Дата окончания отпуска</TH>
            <TH>Заработная плата</TH>
            <TH>Размер отпускных</TH>
        </TR>
        <c:forEach var="object" items="${objects}">
            <TR>
                <TD>
                    <INPUT type="checkbox" name="id"
                           value="${object.id}">

                </TD>
                <TD>
                    <A href="edit.html?id=${object.id}">
                            ${object.getEmployeeID()}
                    </A>
                </TD>
                <TD>${object.getDepartment()}</TD>
                <TD>${object.getLastName()}</TD>
                <TD>${object.getFirstName()}</TD>
                <TD>${object.getMiddleName()}</TD>
                <TD>${object.getStartDate()}</TD>
                <TD>${object.getEndDate()}</TD>
                <TD>${object.getSalary()}</TD>
                <TD>${object.getEarnings()}</TD>
            </TR>
        </c:forEach>
    </TABLE>
    <P>
        Сумма отпускных: ${earningsSum}
    </P>
    <P>
        <A href="edit.html">Добавить</A>
        <BUTTON type="submit">Удалить</BUTTON>
    </P>
    <TABLE>
        <TR>
            <TH>Отдел</TH>
            <TH>Кол-во отсутствующих сотрудников</TH>
            <TH>Начало промежутка</TH>
            <TH>Конец промежутка</TH>
        </TR>
        <c:forEach var="d" items="${departmentEmployees}">
        <TR>
            <TD>${d.getDepartment()}</TD>
            <TD>${d.getEmployees()}</TD>
            <TD>${d.getStartDate()}</TD>
            <TD>${d.getEndDate()}</TD>
        </TR>
        </c:forEach>
    </TABLE>
</FORM>
</body>
</html>
