<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dist/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="dist/css/bootstrap.css" type="text/css">
        <title>Lista de Servicos</title>
    </head>
    <body>
        <%@page import="br.com.fasm.jdbc.dao.*, br.com.fasm.jdbc.modelo.*, java.util.*" %>
        <h1>Lista de Servicos</h1>
        <a href="index.html">Home</a>
        <a href="adiciona-serv.jsp">Adicionar</a>

        <div class="row">
            <div class="col-md-6">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nome</th><th>Preco</th><th>Descricao</th><th>Editar</th>
                        </tr>
                    </thead>
                    <%
                        ServicoDAO dao = new ServicoDAO();
                        List<Servicos> servicos = dao.getLista();

                        for (Servicos servico : servicos) {
                    %>
                    <tbody>
                        <tr>
                            <td><%=servico.getNomeServ()%></td>
                            <td><%=servico.getPreco()%></td>
                            <td><%=servico.getDescricao()%></td>

                            <td>
                                <a href="altera-serv.jsp?codServico=<%=servico.getCodServico()%>&nomeServ=<%=servico.getNomeServ()%>&preco=<%=servico.getPreco()%>&descricao=<%=servico.getDescricao()%>&acao=alterar">Editar</a>
                            </td>
                            <td>
                                <a href="serv-action.jsp?codServico=<%=servico.getCodServico()%>&acao=excluir">Excluir</a>
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