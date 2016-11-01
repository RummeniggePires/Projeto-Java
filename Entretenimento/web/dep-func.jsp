<%@page import="br.com.fasm.jdbc.dao.*, br.com.fasm.jdbc.modelo.*"%>
<%
    if (request.getParameter("acao").equals("adicionar")) {

        String nomeDep = request.getParameter("nomeDep");
        float salario = Float.parseFloat("salario");
        
        Departamento departamento = new Departamento();

        departamento.setNomeDep(nomeDep);
        departamento.setSalario(salario);

        DepartamentoDAO dao = new DepartamentoDAO();

        dao.adiciona(departamento);

        response.sendRedirect("lista-dep.jsp");
    } else if (request.getParameter("acao").equals("alterar")) {

        int codDepartamento = Integer.parseInt(request.getParameter("codDepartamento"));
        String nomeDep = request.getParameter("nomeDep");
        float salario = Float.parseFloat("salario");
        
        Departamento departamento = new Departamento();

        departamento.setCodDepartamento(codDepartamento);
        departamento.setNomeDep(nomeDep);
        departamento.setSalario(salario);
        

        DepartamentoDAO dao = new DepartamentoDAO();

        dao.altera(departamento);

        response.sendRedirect("lista-dep.jsp");
    } else if (request.getParameter("acao").equals("excluir")) {

        int codDepartamento = Integer.parseInt(request.getParameter("codDepartamento"));

        Departamento departamento = new Departamento();

        departamento.setCodDepartamento(codDepartamento);

        DepartamentoDAO dao = new DepartamentoDAO();

        dao.remove(departamento);

        response.sendRedirect("lista-dep.jsp");
    }
%>