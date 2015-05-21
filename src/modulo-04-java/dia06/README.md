### Dia 6

### Mestre Cuca - Persistindo em Arquivo
O objetivo deste exercício é de salvar (persistir) as receitas cadastradas em um arquivo `.json`. 
De forma geral, nosso objetivo será converter um objeto do Java (a lista de receitas) para um JSON. 
Para isto, os seguintes passos deverão ser realizados;

1. Criar uma nova classe, `LivroReceitasJson` que também deverá implementar a interface `LivroReceitas`.
2. No construtor desta nova classe, devemos receber um parâmetro - o caminho do arquivo aonde as receitas deverão ser salvas.
3. Durante a instanciação de um LivroReceitasJson, caso o arquivo passado por parâmetro exista, devemos carregar as receitas contidas nele (e atualizar
a nossa lista de receitas que armazenamos na memória).
4. Para converter um objeto para JSON utilizaremos uma biblioteca chamada Jackson (procurem os arquivos `jackson-databind`, `jackson-core` e `jackson-annotations` na interwebs).
5. Após o download da biblioteca, ela deve ser importada no nosso projeto.
6. O desafio do exercício será o de descobrir como utilizar a biblioteca e converter um objeto para JSON (e um JSON para objeto). Google it!
7. Para deixar claro: toda vez que inserirmos, excluirmos ou atualizarmos uma receita, o arquivo json (ex.: `c:\tmp\receitas.json` ou `/Users/eu/receitas.json`) deverá ser atualizado.

