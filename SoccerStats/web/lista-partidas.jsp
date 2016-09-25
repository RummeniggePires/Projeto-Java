<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de partidas</title>
    </head>
    <body>
        <%@page import="dao.*, modelo.*, java.util.*" %>
        <h1>Lista de partidas</h1>
        <a href="adicionar-partida.jsp">Adicionar</a>
        <table>
            <thead>
                <th>Jogador</th>
                <th>Distância</th>
                <th>Gols</th>
                <th>Faltas S.</th>
                <th>Faltas F.</th>
                <th>Impedimentos</th>
                <th>Assistências</th>
                <th>CA</th>
                <th>CV</th>
                <th>Data</th>
                <th>Escalado</th>
                <th>Editar</th>
                <th>Excluir</th>
            </thead>
            <%
                PartidaDao dao = new PartidaDao();
                List<Partida> partidas = dao.getLista();

                for (Partida partida : partidas) {
            %>
            <tr>
                <td><%=partida.getJogador()%></td>
                <td><%=partida.getDistanciaPercorrida()%></td>
                <td><%=partida.getGolsFeitos()%></td>
                <td><%=partida.getFaltasSofridas()%></td>
                <td><%=partida.getFaltasFeitas()%></td>
                <td><%=partida.getImpedimentos()%></td>
                <td><%=partida.getAssistencias()%></td>
                <td><%=partida.getCartaoAmarelo()%></td>
                <td><%=partida.getCartaoVermelho()%></td>
                <%
                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.DATE, 1);
                    SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");

                    String dataPartida = format1.format(partida.getDataPartida().getTime());
                %>
                <td><%=dataPartida%></td>
                <td><% if (partida.isEscalado()) { %>Sim<% } else { %>Nao<% } %></td>
                <td>
                    <a href="alterar-partida.jsp?id=<%=partida.getPartidaId()%>">Editar</a>
                </td>
                <td>
                    <a href="partidaAction.jsp?id=<%=partida.getPartidaId()%>&acao=excluir">Excluir</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
