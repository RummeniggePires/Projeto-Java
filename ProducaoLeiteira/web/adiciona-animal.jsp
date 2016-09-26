<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserção de Animais</title>
    </head>
    <body>
        <h1>Inserção de Animais</h1>
        <form action="animalAction.jsp">
            <input type="hidden" name="acao" value="adicionar" />
            <dl>
        
                <dt>Nome:</dt>
                <dd><input type="text" name="nome" /></dd>

                <dt>Numero do brinco:</dt>
                <dd><input type="text" name="numeracao_brinco" /></dd>

                <dt>Data do Nascimento:</dt>
                <dd><input type="text" name="data_nascimento" /></dd>

            </dl>
            <input type="submit" value="Adicionar" />
            <a href="lista-partidas.jsp">Cancelar</a>
        </form>
    </body>
</html>
