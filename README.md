
# Capital Gain


Esta aplicação tem como objetivo calcular o imposto a ser pago sobre
lucros ou prejuízos de operações no mercado financeiro de ações.
## Frameworks e Bibliotecas

Foi utilizado Java como a stack principal de desenvolvimento desse projeto. 
Foi utilizado o Maven como ferramenta para gerenciamento do projeto e suas dependências.
Foram utilizadas 4 bibliotecas para facilitar o desenvolvimento da aplicacao.

    1) gson
Auxiliar na conversão de arquivos texto no formato JSON para objetos Java e vice e versa.

    2) lombok
Utilizado para aumentar a produtividade e diminuir a escrita de código boilerplate

    3) mockito
Utilizado para instanciar e mockar objetos durante a escrita de testes

    4) junit
Foi utilizado para ajudar na escrita de testes
## Arquitetura

Foram utilizados alguns padrões de projetos e algumas boas praticas de desenvolvimento na concepção dessa aplicação.

    1) Foi utilizado o design pattern Factory Method para entregar o servico correto (sell ou buy) de acordo com a operação enviada no input da aplicação
    2) Foi utilizado o design pattern Strategy para separar a logica de operacao de venda e compra
    3) Foi utilizado através do lombok o design pattern Builder para a construção e manejo dos pojos.
    4) E também foi utilizado os principios de SOLID e clean code durante a codificação da aplicação
## Execução

Para executar a aplicação, basta seguir os seguintes passos:

    1) Na pasta root da aplicação executar o seguinte comando:
$ mvn clean install

    2) Depois executar o comando:
$ docker build -f Dockerfile -t capitalgainjava .

    3) E por ultimo rodar a aplicação conteinerizada:
$ docker run -i -t capitalgainjava