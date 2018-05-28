<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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
    <title>Atividades</title>
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
                    <h3 class="col s12">AÇÕES</h3>
                    <div class="col s6">
                        <div class="card hoverable">
                            <a class="modal-trigger" href="#cadastrar-cliente-modal">
                                <div class="card-content">
                                    <i class="material-icons">account_box</i>
                                    <span>Cadastrar Cliente</span>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col s6">
                        <div class="card hoverable">
                            <a class="modal-trigger" href="#cadastrar-conta-modal">
                                <div class="card-content">
                                    <i class="material-icons">card_membership</i>
                                    <span>Cadastrar Conta</span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="col s6">
                        <div class="card hoverable">
                            <a class="modal-trigger" href="#fechar-conta-modal">
                                <div class="card-content">
                                    <i class="material-icons">close</i>
                                    <span>Fechar Conta</span>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col s6">
                        <div class="card hoverable">
                            <a href="./logout?action=agencia">
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

        <div id="cadastrar-cliente-modal" class="modal" style="max-width: 650px;">
            <div class="modal-content">
                <h4>Cadastrar Cliente</h4>
                <form id="form-cadastrar-cliente" action="">
                    <div class="row">
                        <div class="input-field col s7">
                            <input id="nome" name="nome" type="text" autocomplete="off" required>
                            <label for="nome">Nome completo</label>
                        </div>
                        <div class="input-field col s5">
                            <select name="tipo_cliente" required>
                                <option value="pessoa_fisica" selected>Pessoa Fisica</option>
                                <option value="pessoa_juridica">Pessoa Juridica</option>
                            </select>
                        </div>
                        <div class="input-field col s6">
                            <input id="cpf_cnpj" name="cpf_cnpj" type="text" autocomplete="off" required>
                            <label for="cpf_cnpj">CPF/CNPJ</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="telefone" name="telefone" type="text" autocomplete="off" required>
                            <label for="telefone">Telefone</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="cep" name="cep" type="text" autocomplete="off" required>
                            <label for="cep">CEP</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="endereco" name="endereco" type="text" autocomplete="off" required>
                            <label for="endereco">Endereco</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="cidade" name="cidade" type="text" autocomplete="off" required>
                            <label for="cidade">Cidade</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="estado" name="estado" type="text" autocomplete="off" required>
                            <label for="estado">Estado</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s6 offset-s3">
                            <button type="submit" class="col s12 btn btn-large waves-effect teal lighten-1">Cadastrar Cliente</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div id="cadastrar-conta-modal" class="modal" style="max-width: 650px;">
            <div class="modal-content">
                <h4>Criar Conta</h4>
                <form id="form-criar-conta" action="">
                    <div class="row">
                        <div class="input-field col s4">
                            <select id="tipo_conta" name="tipo_conta">
                                <option value="corrente" selected>Conta Corrente</option>
                                <option value="poupanca">Conta Poupança</option>
                            </select>
                        </div>
                        <div class="input-field col s5">
                            <input id="cliente_conta" name="cliente_conta" type="hidden" required>
                            <input id="cpf_cnpj_conta" name="cpf_cnpj_conta" type="text" autocomplete="off" required>
                            <label for="cpf_cnpj_conta">Informe o CPF/CNPJ do cliente</label>
                        </div>

                        <div class="input-field col s3" style="margin-bottom: 34px;">
                            <button id="buscar_cliente" class="btn col s12">Buscar Cliente</button>
                        </div>
                        <div class="input-field col s6">
                            <input id="nome_cliente" name="nome_cliente" type="text" autocomplete="off" disabled>
                            <label for="nome_cliente">Nome Cliente</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="saldo" name="saldo" type="text" autocomplete="off" required>
                            <label for="saldo">Saldo Inicial (R$)</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="numero_conta" name="numero_conta" type="number" autocomplete="off" required>
                            <label for="numero_conta">Número da conta</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="senha" name="senha" type="password" autocomplete="off" required>
                            <label for="senha">Senha</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s6 offset-s3">
                            <button type="submit" class="col s12 btn btn-large waves-effect teal lighten-1">
                                Criar Conta
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div id="fechar-conta-modal" class="modal" style="max-width: 650px;">
            <div class="modal-content">
                <h4>Fechar Conta</h4>
                <form id="form-fechar-conta" action="">
                    <div class="row">
                        <div class="input-field col s5">
                            <input id="id_conta" name="id_conta" type="hidden" autocomplete="off" required>
                            <input id="numero_conta_2" name="numero_conta" type="text" autocomplete="off" required>
                            <label for="numero_conta_2">Informe o número da conta</label>
                        </div>

                        <div class="input-field col s3" style="margin-bottom: 34px;">
                            <button id="buscar_conta" class="btn col s12">Buscar Cliente</button>
                        </div>
                        <div class="input-field col s4">
                            <input id="tipo_conta_2" name="tipo_conta_2" type="text" autocomplete="off" disabled>
                            <label for="tipo_conta_2">Tipo de Conta</label>
                        </div>

                        <div class="input-field col s6">
                            <input id="nome_cliente_2" name="nome_cliente_2" type="text" autocomplete="off" disabled>
                            <label for="nome_cliente_2">Nome Cliente</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="saldo_atual" name="saldo_atual" type="text" autocomplete="off" disabled>
                            <label for="saldo_atual">Saldo Atual (R$)</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s6 offset-s3">
                            <button type="submit" class="col s12 btn btn-large waves-effect teal lighten-1">
                                Fechar Conta
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
        //FUNCIONALIDADES DA PÁGINA
        $('#nome_cliente').attr("required", true);
        $("#saldo").maskMoney({ prefix: "", decimal: ",", thousands: "." });

        var modalParams = { onCloseEnd: limparCampos }
        var modalCliente = document.querySelector('#cadastrar-cliente-modal')
        var instanceModalCliente = M.Modal.init(modalCliente, modalParams);

        var modalConta = document.querySelector('#cadastrar-conta-modal')
        var instanceModalConta = M.Modal.init(modalConta, modalParams);

        var modalFecharConta = document.querySelector('#fechar-conta-modal')
        var instancemodalFecharConta = M.Modal.init(modalFecharConta, modalParams);

        function limparCampos(e) {
            var campos = e.querySelectorAll('input[type="text"], input[type="password"]');
            for (var i = 0; i < campos.length; i++) {
                campos[i].setAttribute('class', '');
                campos[i].value = "";
            }
            M.updateTextFields();
        }

        var elemsSelect = document.querySelectorAll('select');
        var instancesSelect = M.FormSelect.init(elemsSelect);

        //BEGIN CADASTRAR CLIENTE
        $("#form-cadastrar-cliente").submit(function (e) {
            e.preventDefault();
            $.ajax({
                type: "POST",
                url: './cadastrar-cliente',
                data: $("#form-cadastrar-cliente").serialize(),
                success: function (result) {
                    instanceModalCliente.close();
                    M.toast({ html: result, displayLength: 4000 });
                }, error: function (err) {
                    M.toast({ html: "Erro ao cadastrar o cliente, tente novamente mais tarde.", displayLength: 4000 });
                    console.log(err.responseText);
                }
            });
        });
        $('#cep').keyup(function (e) {
            var cep = $('#cep').val().replace(/\D/g, '');
            if (cep.length >= 8) buscaCep(cep);
        })
        function buscaCep(cep) {
            $.ajax({
                type: "GET",
                url: 'https://viacep.com.br/ws/' + cep + '/json/',
                success: function (result) {
                    $('#estado').val(result.uf);
                    $('#cidade').val(result.localidade);
                    $('#endereco').val(result.logradouro);
                    M.updateTextFields();
                },
            });
        }
        //END CADASTRAR CLIENTE

        //BEGIN CRIAR CONTA
        $("#form-criar-conta").submit(function (e) {
            e.preventDefault();
            if (!$('#nome_cliente').val()) {
                $('#nome_cliente').addClass('invalid');
                M.toast({ html: 'Selecione um cliente.', displayLength: 2000 });
                return;
            }

            $.ajax({
                type: "POST",
                url: './cadastrar-conta',
                data: $("#form-criar-conta").serialize(),
                success: function (result) {
                    M.toast({ html: result, displayLength: 4000 });
                    instanceModalConta.close();
                }, error: function (err) {
                    console.log(err.responseText);
                    M.toast({ html: "Erro ao criar a conta, tente novamente mais tarde.", displayLength: 3500 });
                }
            });
        });

        document.querySelector('#buscar_cliente').onclick = function (e) {
            e.preventDefault();
            $.ajax({
                type: "GET",
                url: './buscar-cliente?cpf_cnpj_conta=' + $('#cpf_cnpj_conta').val(),
                success: function (result, status) {
                    $('#nome_cliente').val(result.nome);
                    $('#cliente_conta').val(result.cpf_cnpj);
                    M.updateTextFields();
                    M.toast({ html: 'Cliente Selecionado', displayLength: 2000 });
                }, error: function (err) {
                    M.toast({ html: 'Cliente não encontrado !', displayLength: 3500 });
                }
            });
        }
        //END CRIAR CONTA

        //BEGIN FECHAR CONTA
        $("#form-fechar-conta").submit(function (e) {
            e.preventDefault();
            if (!$('#form-fechar-conta #id_conta').val()) {
                M.toast({ html: "Selecione uma conta", displayLength: 3500 });
                return;
            }

            if (!confirm("Deseja realmente fechar a conta: " + $('#form-fechar-conta #numero_conta_2').val())) {
                return;
            };

            $.ajax({
                type: "POST",
                url: './fechar-conta',
                data: $("#form-fechar-conta").serialize(),
                success: function (result) {
                    M.toast({ html: "Conta fechada com sucesso", displayLength: 3500 });
                    instancemodalFecharConta.close();
                }, error: function (err) {
                    M.toast({ html: err, displayLength: 3500 });
                }
            });
        });

        document.querySelector('#buscar_conta').onclick = function (e) {
            e.preventDefault();
            $.ajax({
                type: "GET",
                url: './buscar-conta?numero_conta=' + $('#form-fechar-conta #numero_conta_2').val(),
                success: function (result, status) {
                    console.log("HERE" + result);
                    if (result.tipo_conta == 'corrente') $('#tipo_conta_2').val("Conta Corrente");
                    else $('#tipo_conta_2').val("Conta Poupança");
                    $('#nome_cliente_2').val(result.nome_cliente);
                    $('#saldo_atual').val(result.saldo);
                    $('#form-fechar-conta #id_conta').val(result.id_conta);
                    M.updateTextFields();
                    M.toast({ html: 'Conta Selecionada', displayLength: 2000 });
                }, error: function (err) {
                    console.log("HERE 0" + err);
                    M.toast({ html: 'Conta não encontrada !', displayLength: 3500 });
                }
            });
        }
        //END FECHAR CONTA
    </script>
</body>

</html>