<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dist/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="dist/css/bootstrap.css" type="text/css">
        <title>Inserir Atendimento</title>
    </head>
    <body>
        <h1>Inserir Atendimento</h1>
        <form action="aten-action.jsp">
            <input type="hidden" name="acao" value="adicionar" />
            <dl>
                <dt>Cliente:</dt>
                <dd><input type="text" name="nomeFunc" /></dd>

                <dt>Funcionario:</dt>
                <dd><input type="text" name="cpfFunc" /></dd>

                <dt>Servico:</dt>
                <dd><input type="text" name="idade" /></dd>

            </dl>
            <input type="submit" value="Adicionar" />
            <a href="lista-atendimento.jsp">Cancelar</a>
        </form>
    </body>
</html>