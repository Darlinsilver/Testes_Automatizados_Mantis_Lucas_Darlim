Feature: Login functionality

Scenario: Registrar um novo usuário com dados válidos
Given que o navegador está aberto
When eu navego para "https://mantis-prova.base2.com.br/login_page.php?return=%2Fmy_view_page.php%3Frefresh%3Dtrue"
And eu insiro "Lucas_Silva" no campo de ID "username"
And eu clico no botão com valor "Entrar" And eu insiro "FR?8Q46E<tn" no campo de ID "password"
And eu clico no botão com valor "Entrar"
Then o usuário deve estar logado no sistema

Feature: Criar Tarefa

functionality Scenario: Criar uma nova Tarefa com dados válidos
Given que o navegador está aberto
And estou logado como "Lucas_Silva" com senha "FR?8Q46E<tn"
When eu clico no botão "Criar Tarefa" com a classe "btn.btn-primary.btn-sm"
And eu seleciono "[Todos os Projetos] categoria teste" no campo de ID "category_id"
And eu seleciono "às vezes" no campo de ID "reproducibility"
And eu seleciono "trivial" no campo de ID "severity"
And eu seleciono "urgente" no campo de ID "priority"
And eu clico na opção de perfil com a classe "fa fa-plus-square-o"
And eu preencho "Web" no campo de ID "platform"
And eu preencho "Windows" no campo de ID "os"
And eu preencho "11" no campo de ID "os_build"
And eu preencho "Teste resumo da nova tarefa." no campo de nome "summary"
And eu preencho "Teste descrição detalhada da nova tarefa." no campo de nome "description"
And eu preencho "Teste passos para reproduzir o apontamento da nova tarefa." no campo de nome "steps_to_reproduce"
And eu preencho "Teste informações adicionais da nova tarefa." no campo de nome "additional_info"
And eu aplico os marcadores "Atividade, bug, Desenvolvimento, Novo_Marcador_Teste" no campo de nome "tag_string"
And eu faço upload do arquivo "C:\\Users\\darli\\Downloads\\TesteUpload.png" no campo do tipo "file" com a classe "dz-hidden-input"
And eu seleciono a opção "Privado" do tipo radio com o valor "50"
And eu clico no botão "Criar Nova Tarefa"
Then a nova tarefa deve ser criada com sucesso

Feature: Registro de Mudanças functionality

Scenario: Visualizar os registros de mudanças
Given que o navegador está aberto
And estou logado como "Lucas_Silva" com senha "FR?8Q46E<tn"
When eu clico na opção "Registro de Mudanças" com a classe "menu-icon fa fa-retweet"
Then a página de registros de mudanças deve ser exibida

Feature: Visualizar Tarefas

Scenario: Visualizar as tarefas criadas
Given que o navegador está aberto
And estou logado como "Lucas_Silva" com senha "FR?8Q46E<tn"
When eu clico na opção "Ver Tarefas" com a classe "menu-icon fa fa-list-alt"
Then a página de tarefas deve ser exibida

Feature: Planejamento functionality

Scenario: Visualizar o planejamento
Given que o navegador está aberto
And estou logado como "Lucas_Silva" com senha "FR?8Q46E<tn"
When eu clico na opção "Planejamento" com a classe "menu-icon fa fa-road"
Then a página de planejamento deve ser exibida

Feature: Minha Conta functionality

Scenario: Visualizar Minha Conta
Given que o navegador está aberto
And estou logado como "Lucas_Silva" com senha "FR?8Q46E<tn"
When eu abro o sub-menu do meu usuário com a classe "ace-icon fa fa-angle-down"
And eu clico na opção "Minha Conta" com a classe "ace-icon fa fa-user"
Then a página "Minha Conta" deve ser exibida

Feature: Sair functionality

Scenario: Sair da minha conta
Given que o navegador está aberto
And estou logado como "Lucas_Silva" com senha "FR?8Q46E<tn"
When eu abro o sub-menu do meu usuário com a classe "ace-icon fa fa-angle-down"
And eu clico na opção "Sair" com a classe "ace-icon fa fa-sign-out"
Then eu devo ser desconectado do sistema