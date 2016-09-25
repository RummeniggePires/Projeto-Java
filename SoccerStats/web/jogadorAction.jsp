<%@page import="dao.*, modelo.*"%>
<%
    if (request.getParameter("acao").equals("adicionar")) {

        String nome = request.getParameter("nome");
        int idade = Integer.parseInt(request.getParameter("idade"));
        String clube = request.getParameter("clube");
        String posicao = request.getParameter("posicao");

        Jogador jogador = new Jogador();

        jogador.setNome(nome);
        jogador.setIdade(idade);
        jogador.setClube(clube);
        jogador.setPosicao(posicao);

        JogadorDao dao = new JogadorDao();

        dao.adiciona(jogador);

        response.sendRedirect("lista-jogadores.jsp");
    } else if (request.getParameter("acao").equals("alterar")) {

        int jogadorId = Integer.parseInt(request.getParameter("jogador_id"));
        String nome = request.getParameter("nome");
        int idade = Integer.parseInt(request.getParameter("idade"));
        String clube = request.getParameter("clube");
        String posicao = request.getParameter("posicao");

        Jogador jogador = new Jogador();

        jogador.setJogadorId(jogadorId);
        jogador.setNome(nome);
        jogador.setIdade(idade);
        jogador.setClube(clube);
        jogador.setPosicao(posicao);

        JogadorDao dao = new JogadorDao();

        dao.altera(jogador);

        response.sendRedirect("lista-jogadores.jsp");
    } else if (request.getParameter("acao").equals("excluir")) {

        int jogadorId = Integer.parseInt(request.getParameter("id"));

        Jogador jogador = new Jogador();

        jogador.setJogadorId(jogadorId);

        JogadorDao dao = new JogadorDao();

        dao.remove(jogador);

        response.sendRedirect("lista-jogadores.jsp");
    }
%>