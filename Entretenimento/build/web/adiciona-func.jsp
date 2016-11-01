<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dist/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="dist/css/bootstrap.css" type="text/css">
        <title>Inserir Funcionario</title>
    </head>
    <body>
        <h1>Inserir Funcionario</h1>
        <form action="func-action.jsp">
            <input type="hidden" name="acao" value="adicionar" />
            <dl>
                <dt>Nome:</dt>
                <dd><input type="text" name="nomeFunc" /></dd>

                <dt>CPF:</dt>
                <dd><input type="text" name="cpfFunc" /></dd>

                <dt>Idade:</dt>
                <dd><input type="text" name="idade" /></dd>

                <dt>Departamento:</dt>
                <dd><input type="text" name="fk_codDep" /></dd>

                <dt>Endereco:</dt>
                <dd><input type="text" name="endFunc" /></dd>
            </dl>
            <input type="submit" value="Adicionar" />
            <a href="lista-func.jsp">Cancelar</a>
        </form>
    </body>
</html>