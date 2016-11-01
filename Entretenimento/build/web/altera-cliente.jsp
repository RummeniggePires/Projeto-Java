<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dist/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="dist/css/bootstrap.css" type="text/css">

        <title>Alterar Cliente</title>
    </head>
    <body>
        <h1>Alterar Cliente</h1>
        <form action="cliente-action.jsp">
            <input type="hidden" name="acao" value="alterar" />
            <input type="hidden" name="codCliente" value="<%=request.getParameter("codCliente")%>" />
            <dl>
                <dt>Nome:</dt>
                <dd><input type="text" name="nomeCliente" value="<%=request.getParameter("nomeCliente")%>" /></dd>

                <dt>CPF:</dt>
                <dd><input type="text" name="cpf" value="<%=request.getParameter("cpf")%>" /></dd>
                
                <dt>Idade:</dt>
                <dd><input type="text" name="idade" value="<%=request.getParameter("idade")%>" /></dd>

            </dl>
            <input type="submit" value="Alterar" />
            <a href="lista-cliente.jsp">Cancelar</a>
        </form>
    </body>
</html>
