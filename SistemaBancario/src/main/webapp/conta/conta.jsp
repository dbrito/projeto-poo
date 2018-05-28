<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--Import materialize.css-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://cdn.rawgit.com/plentz/jquery-maskmoney/master/dist/jquery.maskMoney.min.js"></script>
    <title>Conta</title>
    <style>
        .main {
            height: auto;
            min-height: 100vh;
            display: table;
            width: 100%;
            background: url('https://images.unsplash.com/photo-1499083097717-a156f85f0516?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=0857182ce680e944304c9980ec175b10&auto=format&fit=crop&w=1502&q=80');
            background-size: cover;
        }

        .vertical-center {
            display: table-cell;
            vertical-align: middle;
        }

        .actions-card {
            background: rgba(255, 255, 255, .8);
            padding: 40px 40px;
            max-width: 700px;
            box-shadow: 0 16px 24px 2px rgba(0, 0, 0, 0.14), 0 6px 30px 5px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(0, 0, 0, 0.3);
        }

        .card-content {
            line-height: 34px;
            color: rgba(0, 0, 0, 0.87);
            font-size: 20px;
            font-weight: bold;
        }

        .card-content i {
            font-size: 34px;
        }

        .card-content span {
            vertical-align: super;
        }
    </style>
</head>

<body>
    <div class="main">
        <div class="vertical-center">
            <div class="actions-card row">
                <div class="row">
                    <h3 class="col s12">AÇÕES CONTA</h3>
                    <div class="col s6">
                        <div class="card hoverable">
                            <a class="modal-trigger" href="#modal-saque">
                                <div class="card-content">
                                    <i class="material-icons">monetization_on</i>
                                    <span>Realizar Saque</span>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col s6">
                        <div class="card hoverable">
                            <a class="modal-trigger" href="#modal-deposito">
                                <div class="card-content">
                                    <i class="material-icons">add_box</i>
                                    <span>Realizar Deposito</span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s6">
                        <div class="card hoverable">
                            <a class="modal-trigger" href="#modal-transferencia">
                                <div class="card-content">
                                    <i class="material-icons">library_add</i>
                                    <span>Realizar Tranferência</span>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col s6">
                        <div class="card hoverable">
                            <a id="bt-saldo" href="#modal-saldo">
                                <div class="card-content">
                                    <i class="material-icons">account_balance_wallet</i>
                                    <span>Ver Saldo</span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s6">
                        <div class="card hoverable">
                            <a id="bt-extrato" href="#modal-extrato">
                                <div class="card-content">
                                    <i class="material-icons">search</i>
                                    <span>Consultar Extrato</span>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col s6">
                        <div class="card hoverable">
                            <a href="./logout?action=conta">
                                <div class="card-content">
                                    <i class="material-icons">exit_to_app</i>
                                    <span>Sair</span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="modal-saque" class="modal" style="max-width: 350px;">
            <div class="modal-content">
                <h4>Realizar Saque</h4>
                <form id="form-saque" action="">
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="valor-saque" name="valor" type="text" autocomplete="off" required>
                            <label for="valor-saque">Valor (R$)</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s6 offset-s3">
                            <button type="submit" class="col s12 btn btn-large waves-effect teal lighten-1">
                                Confirmar
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div id="modal-deposito" class="modal" style="max-width: 350px;">
            <div class="modal-content">
                <h4>Realizar Depósito</h4>
                <form id="form-deposito" action="">
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="valor-deposito" name="valor" type="text" autocomplete="off" required>
                            <label for="valor-deposito">Valor (R$)</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s6 offset-s3">
                            <button type="submit" class="col s12 btn btn-large waves-effect teal lighten-1">
                                Confirmar
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div id="modal-transferencia" class="modal" style="max-width: 500px;">
            <div class="modal-content">
                <h4>Realizar Transferência</h4>
                <form id="form-transferencia" action="">
                    <div class="row">
                        <div class="input-field col s6">
                            <input id="id_conta" name="id_conta" type="hidden" autocomplete="off" required>
                            <input id="numero_conta" name="numero_conta" type="text" autocomplete="off" required>
                            <label for="numero_conta">Informe o número da conta</label>
                        </div>

                        <div class="input-field col s6" style="margin-bottom: 34px;">
                            <button id="buscar_conta" class="btn col s12">Buscar Cliente</button>
                        </div>
                        <div class="input-field col s6">
                            <input id="tipo_conta" name="tipo_conta_2" type="text" autocomplete="off" disabled>
                            <label for="tipo_conta">Tipo de Conta</label>
                        </div>

                        <div class="input-field col s6">
                            <input id="nome_cliente" name="nome_cliente" type="text" autocomplete="off" disabled>
                            <label for="nome_cliente">Nome Cliente</label>
                        </div>

                        <div class="input-field col s6">
                            <input id="valor-deposito" name="valor" type="text" autocomplete="off" required>
                            <label for="valor-deposito">Valor (R$)</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col s6 offset-s3">
                            <button type="submit" class="col s12 btn btn-large waves-effect teal lighten-1">
                                Confirmar
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div id="modal-saldo" class="modal" style="max-width: 350px;">
            <div class="modal-content">
                <h4>Saldo Atual</h4>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="valor-saldo" name="valor" type="text" autocomplete="off" disabled>
                        <label for="valor-saldo">Valor (R$)</label>
                    </div>
                </div>
            </div>
        </div>

        <div id="modal-extrato" class="modal" style="max-width: 550px;">
            <div class="modal-content">
                <h4>Extrato</h4>
                <div class="row">

                </div>
            </div>
        </div>
    </div>
    <script>
        //FUNCIONALIDADES DA PÁGINA
        $("#valor-saque, #valor-tranferencia, #valor-deposito").maskMoney({ prefix: "", decimal: ",", thousands: "." });
        var modalParams = { onCloseEnd: limparCampos }
        var modalSaque = M.Modal.init(get('#modal-saque'), modalParams);
        var modalDeposito = M.Modal.init(get('#modal-deposito'), modalParams);
        var modalTranferencia = M.Modal.init(get('#modal-transferencia'), modalParams);
        var modalSaldo = M.Modal.init(get('#modal-saldo'), modalParams);
        var modalExtrato = M.Modal.init(get('#modal-extrato'), modalParams);
        function limparCampos(e) {
            var campos = e.querySelectorAll('input[type="text"]');
            for (var i = 0; i < campos.length; i++) {
                campos[i].setAttribute('class', '');
                campos[i].value = "";
            }
            M.updateTextFields();
        }
        function get(selector) {
            return document.querySelector(selector);
        }
        function getAll(selector) {
            return document.querySelectorAll(selector);
        }

        function getSuccessCallback(modal) {
            return function (result) {
                modal.close();
                M.toast({ html: result, displayLength: 4000 });
            }
        }

        function getErrorCallback() {
            return function (err) {
                M.toast({ html: err.statusCode().statusText, displayLength: 4000 });
            }
        }

        //SAQUE
        $('#form-saque').submit(function (e) {
            e.preventDefault();
            $.ajax({
                type: "POST",
                url: './efetuar-transacao?tipo=saque',
                data: $(e.target).serialize(),
                success: getSuccessCallback(modalSaque),
                error: getErrorCallback()
            });
        });
        //SAQUE

        //DEPOSITO
        $('#form-deposito').submit(function (e) {
            e.preventDefault();
            $.ajax({
                type: "POST",
                url: './efetuar-transacao?tipo=deposito',
                data: $(e.target).serialize(),
                success: getSuccessCallback(modalDeposito),
                error: getErrorCallback()
            });
        });
        //DEPOSITO

        //TRANSFERENCIA
        $('#buscar_conta').click(function (e) {
            e.preventDefault();
            $.ajax({
                type: "GET",
                url: './buscar-conta?numero_conta=' + $('#form-transferencia #numero_conta').val(),
                success: function (result, status) {
                    if (result.tipo_conta == 'corrente') $('#tipo_conta').val("Conta Corrente");
                    else $('#tipo_conta').val("Conta Poupança");
                    $('#nome_cliente').val(result.nome_cliente);
                    $('#form-transferencia #id_conta').val(result.id_conta);
                    M.updateTextFields();
                    M.toast({ html: 'Conta Selecionada', displayLength: 2000 });
                }, error: function (err) {
                    M.toast({ html: 'Conta não encontrada !', displayLength: 3500 });
                }
            });
        });

        $('#form-transferencia').submit(function (e) {
            e.preventDefault();
            if (!$('#form-transferencia #id_conta').val()) {
                M.toast({ html: "Selecione uma conta de destino.", displayLength: 3500 });
                return;
            }

            $.ajax({
                type: "POST",
                url: './efetuar-transacao?tipo=transferencia',
                data: $(e.target).serialize(),
                success: getSuccessCallback(modalTranferencia),
                error: getErrorCallback()
            });
        });
        //TRANSFERENCIA

        //SALDO
        $('#bt-saldo').click(function (e) {
            e.preventDefault();
            $.ajax({
                type: "POST",
                url: './efetuar-transacao?tipo=saldo',
                success: function (result) {
                    $('#modal-saldo #valor-saldo').val(result);
                    modalSaldo.open();
                    M.updateTextFields();
                },
                error: getErrorCallback()
            })
        });
        //SALDO

        //EXTRATO
        $('#bt-extrato').click(function (e) {
            e.preventDefault();
            $.ajax({
                type: "GET",
                url: './extrato',
                success: function (result) {
                    $('#modal-extrato .modal-content .row').html(result);
                    modalExtrato.open();
                },
                error: getErrorCallback()
            })
        });
        //EXTRATO
    </script>
</body>

</html>