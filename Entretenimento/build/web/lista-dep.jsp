<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="dist/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="dist/css/bootstrap.css" type="text/css">
        <title>Lista de Departamento</title>
    </head>
    <body>
        <%@page import="br.com.fasm.jdbc.dao.*, br.com.fasm.jdbc.modelo.*, java.util.*" %>
        <h1>Lista de Departamento</h1>
        <a href="index.html">Home</a>
        <a href="adiciona-dep.jsp">Adicionar</a>

        <div class="row">
            <div class="col-md-6">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nome</th><th>Salario</th><th>Editar</th>
                        </tr>
                    </thead>
                    <%
                        DepartamentoDAO dao = new DepartamentoDAO();
                        List<Departamento> departamentos = dao.getLista();

                        for (Departamento departamento : departamentos) {
                    %>
                    <tbody>
                        <tr>
                            <td><%=departamento.getNomeDep()%></td>
                            <td><%=departamento.getSalario()%></td>
                            <td>
                                <a href="altera-dep.jsp?codDepartamento=<%=departamento.getCodDepartamento()%>&nomeDep=<%=departamento.getNomeDep()%>&salario=<%=departamento.getSalario()%>%>&acao=alterar">Editar</a>
                            </td>
                            <td>
                                <a href="dep-action.jsp?codDepartamento=<%=departamento.getCodDepartamento()%>&acao=excluir">Excluir</a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>

                </table>
            </div>
        </div>
    </body>

</html>