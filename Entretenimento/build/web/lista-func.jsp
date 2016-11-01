<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dist/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="dist/css/bootstrap.css" type="text/css">
        <title>Lista de Funcionarios</title>
    </head>
    <body>
        <%@page import="br.com.fasm.jdbc.dao.*, br.com.fasm.jdbc.modelo.*, java.util.*" %>
        <h1>Lista de Funcionarios</h1>
        <a href="index.html">Home</a>
        <a href="adiciona-func.jsp">Adicionar</a>


        <div class="row">
            <div class="col-md-6">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nome</th><th>CPF</th><th>Idade</th><th>Departamento</th><th>Endereco</th><th>Editar</th>
                        </tr>
                    </thead>
                    <%
                        FuncionarioDAO dao = new FuncionarioDAO();
                        List<Funcionario> funcionarioes = dao.getLista();

                        for (Funcionario funcionario : funcionarioes) {
                    %>
                    <tbody>
                        <tr>
                            <td><%=funcionario.getNomeFunc()%></td>
                            <td><%=funcionario.getCpfFunc()%></td>
                            <td><%=funcionario.getIdade()%></td>
                            <td><%=funcionario.getFk_codDep()%></td>
                            <td><%=funcionario.getEndFunc()%></td>
                            <td>
                                <a href="altera-func.jsp?codFunc=<%=funcionario.getCodFunc()%>&nomeFunc=<%=funcionario.getNomeFunc()%>&cpfFunc=<%=funcionario.getCpfFunc()%>&idade=<%=funcionario.getIdade()%>&=fk_codDep<%=funcionario.getFk_codDep()%>&endFunc=<%=funcionario.getEndFunc()%>&acao=alterar">Editar</a>
                            </td>
                            <td>
                                <a href="func-action.jsp?codFunc=<%=funcionario.getCodFunc()%>&acao=excluir">Excluir</a>
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