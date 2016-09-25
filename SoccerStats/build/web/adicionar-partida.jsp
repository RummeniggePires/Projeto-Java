<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Partida</title>
    </head>
    <body>
        <%@page import="dao.*, modelo.*, java.util.*" %>
        <h1>Adicionar Partida</h1>
        <form action="partidaAction.jsp">
            <input type="hidden" name="acao" value="adicionar" />
            <dl>
                <!-- lista jogadores para o select -->
                <%
                    JogadorDao dao = new JogadorDao();
                    List<Jogador> jogadores = dao.getLista();
                %>
                <dt>Jogador:</dt>
                <dd>
                    <select name="jogador_id">
                        <option value="-1">Selecione um jogador</option>
                        <!-- preenche as opções com os jogadores encontrados -->
                        <% for (Jogador jogador : jogadores) { %>
                            <option value="<%=jogador.getJogadorId()%>"><%=jogador.getNome()%></option>
                        <% } %>
                    </select>
                </dd>

                <dt>Distância percorrida:</dt>
                <dd><input type="text" name="distancia_percorrida" value="0,00" /></dd>

                <dt>Gols feitos:</dt>
                <dd><input type="text" name="gols_feitos" value="0" /></dd>

                <dt>Faltas sofridas:</dt>
                <dd><input type="text" name="faltas_sofridas" value="0" /></dd>

                <dt>Faltas feitas:</dt>
                <dd><input type="text" name="faltas_feitas" value="0" /></dd>

                <dt>Impedimentos:</dt>
                <dd><input type="text" name="impedimentos" value="0" /></dd>

                <dt>Assistências:</dt>
                <dd><input type="text" name="assistencias" value="0" /></dd>

                <dt>Cartão amarelo:</dt>
                <dd><input type="text" name="cartao_amarelo" value="0" /></dd>

                <dt>Cartão vermelho:</dt>
                <dd><input type="text" name="cartao_vermelho" value="0" /></dd>

                <!-- recupera data e hora atual para setar valor padrão para o campo -->
                <%
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar cal = Calendar.getInstance();
                %>
                <dt>Data da partida:</dt>
                <dd><input type="text" name="data_partida" value="<%=dateFormat.format(cal.getTime())%>" /></dd>

                <dt>Escalado:</dt>
                <dd><input type="checkbox" name="escalado" checked /></dd>

            </dl>
            <input type="submit" value="Adicionar" />
            <a href="lista-jogadores.jsp">Cancelar</a>
        </form>
    </body>
</html>
