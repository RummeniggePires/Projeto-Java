<%@page import="br.com.fasm.jdbc.dao.*, br.com.fasm.jdbc.modelo.*"%>
<%
    if (request.getParameter("acao").equals("adicionar")) {

        String nomeFunc = request.getParameter("nomeFunc");
        int idade = Integer.parseInt(request.getParameter("idade"));
        int fk_codDep = Integer.parseInt(request.getParameter("fk_codDep"));
        int cpfFunc = Integer.parseInt(request.getParameter("cpfFunc"));
        String endFunc = request.getParameter("endFunc");

        Funcionario funcionario = new Funcionario();

        funcionario.setNomeFunc(nomeFunc);
        funcionario.setIdade(idade);
        funcionario.setFk_codDep(fk_codDep);
        funcionario.setCpfFunc(cpfFunc);
        funcionario.setEndFunc(endFunc);

        FuncionarioDAO dao = new FuncionarioDAO();

        dao.adiciona(funcionario);

        response.sendRedirect("lista-func.jsp");
    } else if (request.getParameter("acao").equals("alterar")) {

        int codFunc = Integer.parseInt(request.getParameter("codFunc"));
        String nomeFunc = request.getParameter("nomeFunc");
        int idade = Integer.parseInt(request.getParameter("idade"));
        int fk_codDep = Integer.parseInt("fk_codDep");
        int cpfFunc = Integer.parseInt("cpfFunc");
        String endFunc = request.getParameter("endFunc");

        Funcionario funcionario = new Funcionario();

        funcionario.setCodFunc(codFunc);
        funcionario.setNomeFunc(nomeFunc);
        funcionario.setIdade(idade);
        funcionario.setFk_codDep(fk_codDep);
        funcionario.setCpfFunc(cpfFunc);
        funcionario.setEndFunc(endFunc);

        FuncionarioDAO dao = new FuncionarioDAO();

        dao.altera(funcionario);

        response.sendRedirect("lista-func.jsp");
    } else if (request.getParameter("acao").equals("excluir")) {

        int codFunc = Integer.parseInt(request.getParameter("codFunc"));

        Funcionario funcionario = new Funcionario();

        funcionario.setCodFunc(codFunc);

        FuncionarioDAO dao = new FuncionarioDAO();

        dao.remove(funcionario);

        response.sendRedirect("lista-func.jsp");
    }
%>