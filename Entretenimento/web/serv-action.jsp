<%@page import="br.com.fasm.jdbc.dao.*, br.com.fasm.jdbc.modelo.*"%>
<%
    if (request.getParameter("acao").equals("adicionar")) {

        String nomeServ = request.getParameter("nomeServ");
        float preco = Float.parseFloat(request.getParameter("preco"));
        String descricao = request.getParameter("descricao");

        Servicos servico = new Servicos();

        servico.setNomeServ(nomeServ);
        servico.setPreco(preco);
        servico.setDescricao(descricao);

        ServicoDAO dao = new ServicoDAO();

        dao.adiciona(servico);

        response.sendRedirect("lista-serv.jsp");
    } else if (request.getParameter("acao").equals("alterar")) {

        int codServico = Integer.parseInt(request.getParameter("codServico"));
        String nomeServ = request.getParameter("nomeServ");
        float preco = Float.parseFloat("preco");
        String descricao = request.getParameter("descricao");

        Servicos servico = new Servicos();

        servico.setCodServico(codServico);
        servico.setNomeServ(nomeServ);
        servico.setPreco(preco);
        servico.setDescricao(descricao);

        ServicoDAO dao = new ServicoDAO();

        dao.altera(servico);

        response.sendRedirect("lista-servico.jsp");
    } else if (request.getParameter("acao").equals("excluir")) {

        int codServico = Integer.parseInt(request.getParameter("codServico"));

        Servicos servico = new Servicos();

        servico.setCodServico(codServico);

        ServicoDAO dao = new ServicoDAO();

        dao.remove(servico);

        response.sendRedirect("lista-servico.jsp");
    }
%>