<%@page import="br.com.fasm.jdbc.dao.*, br.com.fasm.jdbc.modelo.*"%>
<%
    if (request.getParameter("acao").equals("adicionar")) {

        String nomeCliente = request.getParameter("nomeCliente");
        int idade = Integer.parseInt(request.getParameter("idade"));
        int cpf = Integer.parseInt(request.getParameter("cpf"));

        Cliente cliente = new Cliente();

        cliente.setNomeCliente(nomeCliente);
        cliente.setIdade(idade);
        cliente.setCpf(cpf);

        ClienteDAO dao = new ClienteDAO();

        dao.adiciona(cliente);

        response.sendRedirect("lista-cliente.jsp");
    } else if (request.getParameter("acao").equals("alterar")) {

        int codCliente = Integer.parseInt(request.getParameter("codCliente"));
        String nomeCliente = request.getParameter("nomeCliente");
        int idade = Integer.parseInt(request.getParameter("idade"));
        int cpf = Integer.parseInt("cpf");

        Cliente cliente = new Cliente();

        cliente.setCodCliente(codCliente);
        cliente.setNomeCliente(nomeCliente);
        cliente.setIdade(idade);
        cliente.setCpf(cpf);

        ClienteDAO dao = new ClienteDAO();

        dao.altera(cliente);

        response.sendRedirect("lista-cliente.jsp");
    } else if (request.getParameter("acao").equals("excluir")) {

        int codCliente = Integer.parseInt(request.getParameter("codCliente"));

        Cliente cliente = new Cliente();

        cliente.setCodCliente(codCliente);

        ClienteDAO dao = new ClienteDAO();

        dao.remove(cliente);

        response.sendRedirect("lista-cliente.jsp");
    }
%>