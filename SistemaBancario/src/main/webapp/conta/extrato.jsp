<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="table table-hover" >
    <thead >
        <tr>
            <th scope="col">Tipo</th>
            <th scope="col">Valor</th>
            <th scope="col">Data</th>
            <th scope="col">Saldo</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="acao" items="${transacoes}">
            <tr>
                <td><c:out value="${acao.getTipo()}" /></td>
                <td><c:out value="${acao.getValorFormatado()}" /></td>
                <td><c:out value="${acao.getDataFormatada()}" /></td>
                <td><c:out value="${acao.getSaldoFormatado()}" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>