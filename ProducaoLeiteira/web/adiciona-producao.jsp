<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserção de Producao</title>
    </head>
    <body>
        <%@page import="br.com.fasm.jdbc.dao.*, br.com.fasm.modelo.*, java.util.*" %>
        <h1>Adicionar Producao</h1>
        <form action="producaoAction.jsp">
            <input type="hidden" name="acao" value="adicionar" />
            <dl>
                <!-- lista animais para o select -->
                <%
                    AnimalDao dao = new AnimalDao();
                    List<Animal> animales = dao.getLista();
                %>
                <dt>Animal:</dt>
                <dd>
                    <select name="animal_id">
                        <option value="-1">Selecione um animal</option>
                        <!-- preenche as opções com os animais encontrados -->
                        <% for (Animal animal : animales) {%>
                        <option value="<%=animal.getAnimal_id()%>"><%=animal.getNome()%></option>
                        <% } %>
                    </select>
                </dd>

                <dt>Peso do leite:</dt>
                <dd><input type="text" name="kg_leite" value="0,00" /></dd>

                <dt>Teor de gordura:</dt>
                <dd><input type="text" name="teor_gordura" value="0" /></dd>

                <dt>Acidez:</dt>
                <dd><input type="text" name="acidez" value="0" /></dd>

                <!-- recupera data e hora atual para setar valor padrão para o campo -->
                <%
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar cal = Calendar.getInstance();
                %>
                <dt>Data da producao:</dt>
                <dd><input type="text" name="data_retirada" value="<%=dateFormat.format(cal.getTime())%>" /></dd>


            </dl>
            <input type="submit" value="Adicionar" />
            <a href="lista-animales.jsp">Cancelar</a>
        </form>
    </body>
</html>
