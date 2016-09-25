<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de contatos</title>
    </head>
    <body>
        <%@page import="dao.*, modelo.*, java.util.*" %>
        <h1>Lista de jogadores</h1>
        <a href="adicionar-jogador.jsp">Adicionar</a>
        <table>
            <thead>
                <th>Nome</th><th>Idade</th><th>Clube</th><th>Posição</th><th>Editar</th>
            </thead>
            <%
                JogadorDao dao = new JogadorDao();
                List<Jogador> jogadores = dao.getLista();

                for (Jogador jogador : jogadores) {
            %>
            <tr>
                <td><%=jogador.getNome()%></td>
                <td><%=jogador.getIdade()%></td>
                <td><%=jogador.getClube()%></td>
                <td><%=jogador.getPosicao()%></td>
                <td>
                    <a href="alterar-jogador.jsp?id=<%=jogador.getJogadorId()%>&nome=<%=jogador.getNome()%>&idade=<%=jogador.getIdade()%>&clube=<%=jogador.getClube()%>&posicao=<%=jogador.getPosicao()%>&acao=alterar">Editar</a>
                </td>
                <td>
                    <a href="jogadorAction.jsp?id=<%=jogador.getJogadorId()%>&acao=excluir">Excluir</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
