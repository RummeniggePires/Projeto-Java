<%@page import="br.com.fasm.jdbc.dao.*, br.com.fasm.jdbc.modelo.*"%>
<%
    if (request.getParameter("acao").equals("adicionar")) {

        int fk_codCliente  = Integer.parseInt(request.getParameter("fk_codCliente"));
        int fk_codFunc  = Integer.parseInt(request.getParameter("fk_codFunc"));
        int fk_codServ  = Integer.parseInt(request.getParameter("fk_codServ"));
        

        Atendimento atendimento = new Atendimento();

        atendimento.setFk_codCliente(fk_codCliente);
        atendimento.setFk_codFunc(fk_codFunc);
        atendimento.setFk_codServ(fk_codServ);
        
        AtendimentoDAO dao = new AtendimentoDAO();

        dao.adiciona(atendimento);

        response.sendRedirect("lista-atendimento.jsp");
    } else if (request.getParameter("acao").equals("alterar")) {

        int fk_codCliente = Integer.parseInt("fk_codCliente");
        int fk_codFunc = Integer.parseInt("fk_codFunc");
        int fk_codServ = Integer.parseInt("fk_codServ");

        Atendimento atendimento = new Atendimento();

        atendimento.setFk_codCliente(fk_codCliente);
        atendimento.setFk_codFunc(fk_codFunc);
        atendimento.setFk_codServ(fk_codServ);

        AtendimentoDAO dao = new AtendimentoDAO();

        dao.altera(atendimento);

        response.sendRedirect("lista-atendimento.jsp");
    } else if (request.getParameter("acao").equals("excluir")) {

        int codAtendimento = Integer.parseInt(request.getParameter("codAtendimento"));

        Atendimento atendimento = new Atendimento();

        atendimento.setCodAtendimento(codAtendimento);

        AtendimentoDAO dao = new AtendimentoDAO();

        dao.remove(atendimento);

        response.sendRedirect("lista-atendimento.jsp");
    }
%>