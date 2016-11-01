<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="dist/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="dist/css/bootstrap.css" type="text/css">
        <title>Inserir Cliente</title>
    </head>
    <body>
        <h1>Inserir Cliente</h1>
        <form action="cliente-action.jsp">
            <input type="hidden" name="acao" value="adicionar" />
            <dl>
                <dt>Nome:</dt>
                <dd><input type="text" name="nomeCliente" /></dd>

                <dt>CPF:</dt>
                <dd><input type="text" name="cpf" /></dd>

                <dt>Idade:</dt>
                <dd><input type="text" name="idade" /></dd>

            </dl>
            <input type="submit" value="Adicionar" />
            <a href="lista-cliente.jsp">Cancelar</a>
        </form>
    </body>
</html>