<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dist/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="dist/css/bootstrap.css" type="text/css">

        <title>Alterar Departamento</title>
    </head>
    <body>
        <h1>Alterar Departamento</h1>
        <form action="dep-action.jsp">
            <input type="hidden" name="acao" value="alterar" />
            <input type="hidden" name="codDepartamento" value="<%=request.getParameter("codDepartamento")%>" />
            <dl>
                <dt>Nome:</dt>
                <dd><input type="text" name="nomeDep" value="<%=request.getParameter("nomeDep")%>" /></dd>

                <dt>Salario:</dt>
                <dd><input type="text" name="salario" value="<%=request.getParameter("salario")%>" /></dd>

            </dl>
            <input type="submit" value="Alterar" />
            <a href="lista-dep.jsp">Cancelar</a>
        </form>
    </body>
</html>
