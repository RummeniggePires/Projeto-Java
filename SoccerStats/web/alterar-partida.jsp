<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.*, modelo.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar partida</title>
    </head>
    <body>
        <h1>Alterar partida</h1>
        <!-- busca informações de uma determinada partida -->
        <%
            PartidaDao dao = new PartidaDao();
            Partida partida = dao.getPartida(Integer.parseInt(request.getParameter("id")));
        %>
        <form action="partidaAction.jsp">
            <input type="hidden" name="acao" value="alterar" />
            <input type="hidden" name="partida_id" value="<%=request.getParameter("id")%>" />
            <dl>
                <!-- lista jogadores para o select -->
                <%
                    JogadorDao jogadorDao = new JogadorDao();
                    List<Jogador> jogadores = jogadorDao.getLista();
                %>
                <dt>Jogador:</dt>
                <dd>
                    <select name="jogador_id">
                        <option value="-1">Selecione um jogador</option>
                        <!-- preenche as opções com os jogadores encontrados -->
                        <% for (Jogador jogador : jogadores) { %>
                            <option 
                                <% if (partida.getJogadorId() == jogador.getJogadorId()) { %>selected<% } %> 
                                value="<%=jogador.getJogadorId()%>">
                                <%=jogador.getNome()%>
                            </option>
                        <% } %>
                    </select>
                </dd>

                <dt>Distância percorrida:</dt>
                <dd><input type="text" name="distancia_percorrida" value="<%=partida.getDistanciaPercorrida()%>" /></dd>

                <dt>Gols feitos:</dt>
                <dd><input type="text" name="gols_feitos" value="<%=partida.getGolsFeitos()%>" /></dd>

                <dt>Faltas sofridas:</dt>
                <dd><input type="text" name="faltas_sofridas" value="<%=partida.getFaltasSofridas()%>" /></dd>

                <dt>Faltas feitas:</dt>
                <dd><input type="text" name="faltas_feitas" value="<%=partida.getFaltasFeitas()%>" /></dd>

                <dt>Impedimentos:</dt>
                <dd><input type="text" name="impedimentos" value="<%=partida.getImpedimentos()%>" /></dd>

                <dt>Assistências:</dt>
                <dd><input type="text" name="assistencias" value="<%=partida.getAssistencias()%>" /></dd>

                <dt>Cartão amarelo:</dt>
                <dd><input type="text" name="cartao_amarelo" value="<%=partida.getCartaoAmarelo()%>" /></dd>

                <dt>Cartão vermelho:</dt>
                <dd><input type="text" name="cartao_vermelho" value="<%=partida.getCartaoVermelho()%>" /></dd>

                <!-- recupera data e hora atual para setar valor padrão para o campo -->
                <%
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar cal = Calendar.getInstance();
                %>
                <dt>Data da partida:</dt>
                <dd><input type="text" name="data_partida" value="<%=dateFormat.format(cal.getTime())%>" /></dd>

                <dt>Escalado:</dt>
                <dd><input type="checkbox" name="escalado" checked="<%=partida.isEscalado()%>" /></dd>

            </dl>
            <input type="submit" value="Alterar" />
            <a href="lista-partidas.jsp">Cancelar</a>
        </form>
    </body>
</html>
