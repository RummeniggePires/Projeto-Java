<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dist/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="dist/css/bootstrap.css" type="text/css">
        <title>Inserir Servico</title>
    </head>
    <body>
        <h1>Inserir Servico</h1>
        <form action="serv-action.jsp">
            <input type="hidden" name="acao" value="adicionar" />
            <dl>
                <dt>Nome:</dt>
                <dd><input type="text" name="nomeServ" /></dd>

                <dt>Preco:</dt>
                <dd><input type="text" name="preco" /></dd>

                <dt>Descricao:</dt>
                <dd><input type="text" name="descricao" /></dd>

            </dl>
            <input type="submit" value="Adicionar" />
            <a href="lista-serv.jsp">Cancelar</a>
        </form>
    </body>
</html>