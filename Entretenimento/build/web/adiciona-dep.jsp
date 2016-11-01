<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dist/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="dist/css/bootstrap.css" type="text/css">
        <title>Inserir Departamento</title>
    </head>
    <body>
        <h1>Inserir Departamento</h1>
        <form action="dep-action.jsp">
            <input type="hidden" name="acao" value="adicionar" />
            <dl>
                <dt>Nome Departamento:</dt>
                <dd><input type="text" name="nomeDep" /></dd>

                <dt>Salario:</dt>
                <dd><input type="text" name="salario" /></dd>

            </dl>
            <input type="submit" value="Adicionar" />
            <a href="lista-dep.jsp">Cancelar</a>
        </form>
    </body>
</html>