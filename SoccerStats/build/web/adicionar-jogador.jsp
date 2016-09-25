<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Inserir Jogador</h1>
        <form action="jogadorAction.jsp">
            <input type="hidden" name="acao" value="adicionar" />
            <dl>
                <dt>Nome:</dt>
                <dd><input type="text" name="nome" /></dd>

                <dt>Idade:</dt>
                <dd><input type="text" name="idade" /></dd>

                <dt>Clube:</dt>
                <dd><input type="text" name="clube" /></dd>

                <dt>Posição:</dt>
                <dd><input type="text" name="posicao" /></dd>
            </dl>
            <input type="submit" value="Adicionar" />
            <a href="lista-partidas.jsp">Cancelar</a>
        </form>
    </body>
</html>
