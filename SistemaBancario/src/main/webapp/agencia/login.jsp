<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--Import materialize.css-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <title>Agência - Login</title>
    <style>
        .login {
            height: 100vh;
            display: table;
            min-height: 100%;
            width: 100%;
            background: url('https://images.unsplash.com/photo-1499083097717-a156f85f0516?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=0857182ce680e944304c9980ec175b10&auto=format&fit=crop&w=1502&q=80');
            background-size: cover;
        }

        .vertical-center {
            display: table-cell;
            vertical-align: middle;
        }

        .login-card {
            padding: 40px 40px;
            background: #FFF;
            max-width: 400px;
            box-shadow: 0 16px 24px 2px rgba(0, 0, 0, 0.14), 0 6px 30px 5px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(0, 0, 0, 0.3);
            /* float: right;
            margin-right: 60px; */
        }
    </style>
</head>

<body>
    <div class="login">
        <div class="vertical-center">
            <div class="login-card row">
                <form id="formulario" action="">
                    <div class="row">
                        <h4 class="col s12">Informe o seu login para acessar a Agência</h4>
                        <div class="input-field col s12">
                            <input id="user" name="user" type="text" autocomplete="off">
                            <label for="user">Usuário</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="pass" name="pass" type="password" autocomplete="off">
                            <label for="pass">Senha</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s12">
                            <button id="submit-button" type="submit" name="btn_login" class="col s12 btn btn-large waves-effect teal lighten-1">Entrar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
        $("#formulario").submit(function (e) {
            $('#submit-button').text('Entrando...');
            e.preventDefault();
            var rota = './login-agencia?teste=' +  Date.now();
            console.log()
            $.ajax({
                type: "POST",
                url: rota,
                data: $("#formulario").serialize(),
                success: function (result, status) {
                    console.log(result, status, rota);
                    setTimeout(function () {
                        window.location.href = './agencia-home';
                    }, 1000);

                }, error: function (err) {
                    $('#user').addClass('invalid');
                    $('#pass').addClass('invalid');
                    $('#submit-button').text('Entrar');
                    M.toast({ html: 'Erro ao efetuar o login, verifique os seus dados.', displayLength: 3500 });
                }
            });
        });
    </script>
</body>

</html>