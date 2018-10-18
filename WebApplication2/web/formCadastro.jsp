<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Cadastro - Cargo</h1>
        <br/>
        <form action="Cadastrar" method="POST">
          <strong>Nome do Cargo:</strong>
          <input type="text" name="cargo" value="" />
          <br>
          <br>
          <strong>Salário Mínimo:</strong>
         <input type="double" name="min_sal" value="" />
         <br>
         <br>
          <strong>Salário Máximo:</strong>
          <input type="double" name="max_sal" value="" />
          <br>
          <br>
          <input type="submit" value="Enviar" />
                        </form></td>
             

    </body>
</html>

