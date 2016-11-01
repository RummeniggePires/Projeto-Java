<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dist/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="dist/css/bootstrap.css" type="text/css">

        <title>Alterar Atendimento</title>
    </head>
    <body>
        <h1>Alterar Atendimento</h1>
        <form action="atendimento-action.jsp">
            <input type="hidden" name="acao" value="alterar" />
            <input type="hidden" name="codAtendimento" value="<%=request.getParameter("codAtendimento")%>" />
            <dl>
                <dt>Cliente:</dt>
                <dd><input type="text" name="fk_codCliente" value="<%=request.getParameter("fk_codCliente")%>" /></dd>

                <dt>Funcionario:</dt>
                <dd><input type="text" name="fk_codFunc" value="<%=request.getParameter("fk_codFunc")%>" /></dd>
                
                <dt>Servico:</dt>
                <dd><input type="text" name="fk_codServ" value="<%=request.getParameter("fk_codServ")%>" /></dd>

            </dl>
            <input type="submit" value="Alterar" />
            <a href="lista-atendimento.jsp">Cancelar</a>
        </form>
    </body>
</html>
