
# Projeto sobre algoritmos de ordenação em JAVA para a disciplina LEDA-UEPB

**Desenvolvido por** *Arthur Felipe Muniz Sales*

### Desenvolvido com
* *Apache NetBeans IDE 19*

#### Tecnologias Utilizadas
* *JAVA _version "19.0.1" 2022-10-18_*

## **Como execultar o programa?**
* Insira o arquivo (**passwords.csv**) no diretório do projeto: src/main/java/**ArquivoBaseCSV**.
* Sem esse arquivo, o programa não irá seguir as tarefas de criação/ordenação dos arquivos.
* Execute a classe **Main** que está na pasta /src/main/**java**.
* Para parar o processo click no botão **Encerrar processo**.
* Após concluir todo o processo, o click no botão **Gerar Relatório**, e uma janela deverá mostrar o relatório pronto.


##
## Informações gerais do Projeto da Disciplina

**Análise comparativa de algoritmos de ordenação**

O primeiro projeto da disciplina de Estrutura de dados visa utilizar os dados de projetos voltados para Data science para estudarmos o desempenho dos algoritmos de ordenação. Os dados foram retirados do site Kaggle através da curadoria realizada pela equipe responsável pelas disciplinas de LEDA e EDA. Os projetos que temos são:

A. [Ligas Européias de Futebol]()

B. [Bolsa de Valores Bovespa 1994-2020]()

C. [Base de dados dos 10k passwords mais comuns utilizados]()

D. [Lost Angeles Metro Bike Share]()

ATENÇÃO: ESTÁ TERMINANTEMENTE PROIBIDO USAR ESTRUTURAS DE DADOS COMPLEXAS PARA O PROCESSAMENTO E ORDENAÇÃO. VOCÊ DEVE _**APENAS**_ USAR **ARRAYS**.

* Preparação do dataset > O dataset compreende um registro histórico de dados coletados em algum período do tempo.
  * Você deve a(s) planilha(s) localmente para poder processá-la(s) no seu código **Java**. 
  * Você deve realizar duas transformações nas colunas de dados que serão baixados. Cada uma das transformações será detalhada de acordo com o projeto.
  * Após realizar cada uma das transformações, você deve gerar um arquivo resultante e renomeado conforme a transformação solicitada. O nome dos arquivos serão detalhados nas páginas dos respectivos projetos.
* Análise dos algoritmos de ordenação
  * Implemente e utilize todos os algoritmos de ordenação estudados (Selection Sort, Insertion Sort, Merge Sort, Quick Sort, QuickSort com Mediana de 3, counting, e HeapSort) para ordenar os registros de acordo com os seguintes parâmetros:
    * Os atributos pelos quais os dadtasets precisam ser ordenados estarão descritos na página de cada projeto
  * Cada arquivo de saída de ordenação deve ser gerado com base no método de ordenação e no elemento ordenado. Por exemplo, para o quick sort devem ser gerado 3 arquivos: qSort_ordena_reviews.csv e qSort_ordena_prices.csv, qSort_ordena_places.csv. Isso deve continuar para cada um dos métodos de ordenação e para cada um dos projetos.
  * Elabore uma tabela para comparar o tempo de execução dos algoritmos.

Opcional: Para a elaboração dos comparativos devem ser usados ferramentas de code profiling, como por exemplo o https://visualvm.github.io/Links to an external site.. Elabore gráficos mostrando o consumo de tempo e memória quando da execução do algoritmo.

Entrega deste milestone:

  * Entrega de um relatório descrevendo os casos de testes, ambiente de execução completo e análise comparativa dos algoritmos. (Equivale a 40% da nota)
  * Você deve subir o projeto no GitHub e mandar o link do projeto e o link de uma versão para eu baixar no meu computador e executar com todas as instruções (arquivo readme). (Equivale a 60% da nota)

[Link para o templateLinks to an external site.]()

##
## Projeto Passwords

O dataset apresentado compreende a listagem de mais de 600 mil senhas, as quais o aluno deve fazer a classificação, afiltragem e a ordenação.

Você pode baixar o dataset diretamente através do linkLinks to an external site. O arquivo a ser considerado é o **passwords.csv**

### Regras para classificar senhas

Para a classificação, devemos considerar como entrada dos dados o arquivo entitulado **passwords.csv**. O aluno deve implemtar um código seguindo as regras abaixo para classificar as senhas, e gerar um novo arquivo password_classifier com a coluna (class) com cada classe para a respectiva senha. **OBS: Senhas que porventura venham a ter mais de um tipo, o aluno pode escolher o tipo de que deve ser classificado**.

* **Muito Ruim**: tamanho da string menor que 5, e só um tipo de caractere, por exemplo: só letra (letras minúsculas ou maiúsculas), só número ou só caractere especial. 
* **Ruim**: tamanho da string menor ou igual a 5, e só um tipos de caracteres, por exemplo: letra (letras minúsculas ou maiúsculas), número ou caractere especial. 
* **Fraca**: tamanho da string menor ou igual a 6, e só dois tipos de caracteres, por exemplo: letra(letras minúsculas e maiúsculas), número ou caractere especial. 
* **Boa**:  tamanho da string menor ou igual a 7, e só todos de caracteres, por exemplo: letra(letras minúsculas e maiúsculas), número ou caractere especial.
* **Muito Boa**:  tamanho da string maior que 8, e só todos os tipos de caracteres, por exemplo: letra(letras minúsculas e maiúsculas), número ou caractere especial
* **Sem Classificação**: Senhas que não se qualificam com nenhuma das classificações acima.
 

### Transformações

Para as tranforamções, devemos considerar como entrada dos dados o arquivo entitulado **password_classifier.csv**

* Transformar data para o formato a seguir DD/MM/AAAA
  * Gerar um arquivo chamado **passwords_formated_data.csv**
* Filtrar senha pela categória **Boa** e **Muito Boa**.
  * Gerar um arquivo chamado passwords_classifier.csv

### Ordenações

Para as ordenações, devemos considerar como entrada dos dados o arquivo entitulado **passwords_formated_data.csv**

Lembrando que para cada questão abaixo deve ser utilizado todos os algoritmos de ordenação recomendados na descrição do projeto, sendo assim você deve gerar um arquivo diferente para cada algoritmo de ordenação / caso.

Sobre os casos, para efeito de análise dos algoritmos deve-se trabalhar com 3 casos (melhor, médio e pior) para cada um dos algoritmos. 

* Ordenar o arquivo completo de senhas pelo campo **length** em ordem decrescente.
  * Deve-se gerar um arquivo para cada algoritmo de ordenação e o tipo de caso. Por exemplo, **passwords_length_insertionSort_medioCaso.csv, passwords_length_insertionSort_piorCaso.csv, passwords_length_insertionSort_melhorCaso.csv**
* Ordenar o arquivo completo de senhas por mês, **(OBS: deve-se obter o mês a partir da data já formatada)** da coluna **data**, de forma crescente.
  * Deve-se gerar um arquivo para cada algoritmo de ordenação e o tipo de caso. Por exemplo, **passwords_data_month_insertionSort_medioCaso.csv, passwords_month_data_insertionSort_piorCaso.csv, passwords_data_month_insertionSort_melhorCaso.csv**
* Ordenar o arquivo completo de senhas pela coluna **data** de forma crescente.
  * Deve-se gerar um arquivo para cada algoritmo de ordenação e o tipo de caso. Por exemplo, **lpasswords_data_insertionSort_medioCaso.csv, passwords_month_insertionSort_piorCaso.csv, passwords_data_insertionSort_melhorCaso.csv**
