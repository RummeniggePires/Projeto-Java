<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dist/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="dist/css/bootstrap.css" type="text/css">
        <title>Lista de Atendimentos</title>
    </head>
    <body>
        <%@page import="br.com.fasm.jdbc.dao.*, br.com.fasm.jdbc.modelo.*, java.util.*" %>
        <h1>Lista de Atendimentos</h1>
        <a href="index.html">Home</a>
        <a href="adiciona-atendimento.jsp">Adicionar</a>
        <div class="row">
            <div class="col-md-6">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Cliente</th><th>Funcionario</th><th>Servico</th><th>Editar</th>
                        </tr>
                    </thead>
                    <%
                        AtendimentoDAO dao = new AtendimentoDAO();
                        List<Atendimento> atendimentoes = dao.getLista();

                        for (Atendimento atendimento : atendimentoes) {
                    %>
                    <tr>
                        <td><%=atendimento.getFk_codCliente()%></td>
                        <td><%=atendimento.getFk_codFunc()%></td>
                        <td><%=atendimento.getFk_codServ()%></td>
                        <td>
                            <a href="altera-atendimento.jsp?codAtendimento=<%=atendimento.getCodAtendimento()%>&fk_codCliente=<%=atendimento.getFk_codCliente()%>&fk_codCliente=<%=atendimento.getFk_codFunc()%>&fk_codServ=<%=atendimento.getFk_codServ()%>&acao=alterar">Editar</a>
                        </td>
                        <td>
                            <a href="atendimento-action.jsp?codAtendimento=<%=atendimento.getCodAtendimento()%>&acao=excluir">Excluir</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>    
        </div>    

    </body>
</html>


