<%@page import="java.util.Calendar"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.*, modelo.*"%>

<%
    if (request.getParameter("acao").equals("adicionar")) {

        int jogadorId = Integer.parseInt(request.getParameter("jogador_id"));
        double distanciaPercorrida = Double.parseDouble(request.getParameter("distancia_percorrida").replace(",", "."));
        int golsFeitos = Integer.parseInt(request.getParameter("gols_feitos"));
        int faltasSofridas = Integer.parseInt(request.getParameter("faltas_sofridas"));
        int faltasFeitas = Integer.parseInt(request.getParameter("faltas_feitas"));
        int impedimentos = Integer.parseInt(request.getParameter("impedimentos"));
        int assistencias = Integer.parseInt(request.getParameter("assistencias"));
        int cartaoAmarelo = Integer.parseInt(request.getParameter("cartao_amarelo"));
        int cartaoVermelho = Integer.parseInt(request.getParameter("cartao_vermelho"));
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data_partida"));
        Calendar dataPartida = Calendar.getInstance();
        dataPartida.setTime(date);

        boolean escalado = Boolean.parseBoolean(request.getParameter("escalado"));

        Partida partida = new Partida();

        partida.setJogadorId(jogadorId);
        partida.setDistanciaPercorrida(distanciaPercorrida);
        partida.setGolsFeitos(golsFeitos);
        partida.setFaltasSofridas(faltasSofridas);
        partida.setFaltasFeitas(faltasFeitas);
        partida.setImpedimentos(impedimentos);
        partida.setAssistencias(assistencias);
        partida.setCartaoAmarelo(cartaoAmarelo);
        partida.setCartaoVermelho(cartaoVermelho);
        partida.setDataPartida(dataPartida);
        partida.setEscalado(escalado);

        PartidaDao dao = new PartidaDao();

        dao.adiciona(partida);

        response.sendRedirect("lista-partidas.jsp");
    } else if (request.getParameter("acao").equals("alterar")) {

        int partidaId = Integer.parseInt(request.getParameter("partida_id"));
        int jogadorId = Integer.parseInt(request.getParameter("jogador_id"));
        double distanciaPercorrida = Double.parseDouble(request.getParameter("distancia_percorrida").replace(",", "."));
        int golsFeitos = Integer.parseInt(request.getParameter("gols_feitos"));
        int faltasSofridas = Integer.parseInt(request.getParameter("faltas_sofridas"));
        int faltasFeitas = Integer.parseInt(request.getParameter("faltas_feitas"));
        int impedimentos = Integer.parseInt(request.getParameter("impedimentos"));
        int assistencias = Integer.parseInt(request.getParameter("assistencias"));
        int cartaoAmarelo = Integer.parseInt(request.getParameter("cartao_amarelo"));
        int cartaoVermelho = Integer.parseInt(request.getParameter("cartao_vermelho"));
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data_partida"));
        Calendar dataPartida = Calendar.getInstance();
        dataPartida.setTime(date);

        boolean escalado = Boolean.parseBoolean(request.getParameter("escalado"));

        Partida partida = new Partida();

        partida.setPartidaId(partidaId);
        partida.setJogadorId(jogadorId);
        partida.setDistanciaPercorrida(distanciaPercorrida);
        partida.setGolsFeitos(golsFeitos);
        partida.setFaltasSofridas(faltasSofridas);
        partida.setFaltasFeitas(faltasFeitas);
        partida.setImpedimentos(impedimentos);
        partida.setAssistencias(assistencias);
        partida.setCartaoAmarelo(cartaoAmarelo);
        partida.setCartaoVermelho(cartaoVermelho);
        partida.setDataPartida(dataPartida);
        partida.setEscalado(escalado);

        PartidaDao dao = new PartidaDao();

        dao.altera(partida);

        response.sendRedirect("lista-partidas.jsp");
    } else if (request.getParameter("acao").equals("excluir")) {

        int partidaId = Integer.parseInt(request.getParameter("id"));

        Partida partida = new Partida();

        partida.setPartidaId(partidaId);

        PartidaDao dao = new PartidaDao();

        dao.remove(partida);

        response.sendRedirect("lista-partidas.jsp");
    }
%>