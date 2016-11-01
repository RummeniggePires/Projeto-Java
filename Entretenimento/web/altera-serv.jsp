<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dist/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="dist/css/bootstrap.css" type="text/css">

        <title>Alterar Servico</title>
    </head>
    <body>
        <h1>Alterar Servico</h1>
        <form action="serv-action.jsp">
            <input type="hidden" name="acao" value="alterar" />
            <input type="hidden" name="codServico" value="<%=request.getParameter("codServico")%>" />
            <dl>
                <dt>Nome:</dt>
                <dd><input type="text" name="nomeServ" value="<%=request.getParameter("nomeServ")%>" /></dd>

                <dt>Preco:</dt>
                <dd><input type="text" name="preco" value="<%=request.getParameter("preco")%>" /></dd>

                <dt>Descricao:</dt>
                <dd><input type="text" name="descricao" value="<%=request.getParameter("descricao")%>" /></dd>

            </dl>
            <input type="submit" value="Alterar" />
            <a href="lista-serv.jsp">Cancelar</a>
        </form>
    </body>
</html>
