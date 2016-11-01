<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dist/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="dist/css/bootstrap.css" type="text/css">

        <title>Alterar Funcionario</title>
    </head>
    <body>
        <h1>Alterar Funcionario</h1>
        <form action="func-action.jsp">
            <input type="hidden" name="acao" value="alterar" />
            <input type="hidden" name="codFunc" value="<%=request.getParameter("codFunc")%>" />
            <dl>
                <dt>Nome:</dt>
                <dd><input type="text" name="nomeFunc" value="<%=request.getParameter("nomeFunc")%>" /></dd>

                <dt>CPF:</dt>
                <dd><input type="text" name="cpfFunc" value="<%=request.getParameter("cpfFunc")%>" /></dd>
                
                <dt>Idade:</dt>
                <dd><input type="text" name="idade" value="<%=request.getParameter("idade")%>" /></dd>

                <dt>Departamento:</dt>
                <dd><input type="text" name="fk_codDep" value="<%=request.getParameter("fk_codDep")%>" /></dd>

               
                <dt>Endereço:</dt>
                <dd><input type="text" name="endFunc" value="<%=request.getParameter("endFunc")%>" /></dd>
            </dl>
            <input type="submit" value="Alterar" />
            <a href="lista-func.jsp">Cancelar</a>
        </form>
    </body>
</html>
