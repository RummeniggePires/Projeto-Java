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
            <input type="hidden" name="acao" value="alterar" />
            <input type="hidden" name="jogador_id" value="<%=request.getParameter("id")%>" />
            <dl>
                <dt>Nome:</dt>
                <dd><input type="text" name="nome" value="<%=request.getParameter("nome")%>" /></dd>

                <dt>Idade:</dt>
                <dd><input type="text" name="idade" value="<%=request.getParameter("idade")%>" /></dd>

                <dt>Clube:</dt>
                <dd><input type="text" name="clube" value="<%=request.getParameter("clube")%>" /></dd>

                <dt>Posição:</dt>
                <dd><input type="text" name="posicao" value="<%=request.getParameter("posicao")%>" /></dd>
            </dl>
            <input type="submit" value="Alterar" />
            <a href="lista-jogadores.jsp">Cancelar</a>
        </form>
    </body>
</html>
