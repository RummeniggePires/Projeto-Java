<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dist/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="dist/css/bootstrap.css" type="text/css">
        <title>Lista de Clientes</title>
    </head>


    <%@page import="br.com.fasm.jdbc.dao.*, br.com.fasm.jdbc.modelo.*, java.util.*" %>
    <body>

        <h1>Lista de Clientes</h1>
        <a href="index.html">Home</a>
        <a href="adiciona-cliente.jsp">Adicionar</a>
        <div class="row">
            <div class="col-md-6">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nome</th><th>CPF</th><th>Idade</th><th>Editar</th>
                        </tr>
                    </thead>
                    <%
                        ClienteDAO dao = new ClienteDAO();
                        List<Cliente> clientes = dao.getLista();

                        for (Cliente cliente : clientes) {
                    %>
                    <tbody>
                        <tr>
                            <td><%=cliente.getNomeCliente()%></td>
                            <td><%=cliente.getCpf()%></td>
                            <td><%=cliente.getIdade()%></td>
                            <td>
                                <a href="altera-cliente.jsp?codCliente=<%=cliente.getCodCliente()%>&nomeCliente=<%=cliente.getNomeCliente()%>&cpf=<%=cliente.getCpf()%>&idade=<%=cliente.getIdade()%>&acao=alterar">Editar</a>
                            </td>
                            <td>
                                <a href="cliente-action.jsp?codCliente=<%=cliente.getCodCliente()%>&acao=excluir">Excluir</a>
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