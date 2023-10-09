package InfoSistema;

/**
 *
 * @author Arthur Felipe MS
 */
public class InfoDoSistema {
    
    private String saida = "";
    
    public InfoDoSistema(){
    
    }
    
    public String infoGeral(){
        this.saida = "Análise comparativa de algoritmos de ordenação \n" +
                    "O primeiro projeto da disciplina de Estrutura de dados visa utilizar os dados de projetos voltados para Data science para estudarmos o desempenho dos algoritmos de ordenação. Os dados foram retirados do site Kaggle através da curadoria realizada pela equipe responsável pelas disciplinas de LEDA e EDA. Os projetos que temos são:\n" +
                    "\n" +
                    "Ligas Européias de Futebol\n" +
                    "Bolsa de Valores Bovespa 1994-2020\n" +
                    "Base de dados dos 10k passwords mais comuns utilizados\n" +
                    "Lost Angeles Metro Bike Share\n" +
                    "\nATENÇÃO: ESTÁ TERMINANTEMENTE PROIBIDO USAR ESTRUTURAS DE DADOS COMPLEXAS PARA O PROCESSAMENTO E ORDENAÇÃO. VOCÊ DEVE APENAS USAR ARRAYS.\n" +
                    "\n" +
                    "Preparação do dataset > O dataset compreende um registro histórico de dados coletados em algum período do tempo.\n" +
                    "Você deve a(s) planilha(s) localmente para poder processá-la(s) no seu código Java. \n" +
                    "Você deve realizar duas transformações nas colunas de dados que serão baixados. Cada uma das transformações será detalhada de acordo com o projeto.\n" +
                    "Após realizar cada uma das transformações, você deve gerar um arquivo resultante e renomeado conforme a transformação solicitada. O nome dos arquivos serão detalhados nas páginas dos respectivos projetos.\n" +
                    "Análise dos algoritmos de ordenação\n" +
                    "Implemente e utilize todos os algoritmos de ordenação estudados (Selection Sort, Insertion Sort, Merge Sort, Quick Sort, QuickSort com Mediana de 3, counting, e HeapSort) para ordenar os registros de acordo com os seguintes parâmetros:\n" +
                    "Os atributos pelos quais os dadtasets precisam ser ordenados estarão descritos na página de cada projeto\n" +
                    "Cada arquivo de saída de ordenação deve ser gerado com base no método de ordenação e no elemento ordenado. Por exemplo, para o quick sort devem ser gerado 3 arquivos: qSort_ordena_reviews.csv e qSort_ordena_prices.csv, qSort_ordena_places.csv. Isso deve continuar para cada um dos métodos de ordenação e para cada um dos projetos.\n" +
                    "Elabore uma tabela para comparar o tempo de execução dos algoritmos.\n" +
                    "\n" +
                    "Opcional: Para a elaboração dos comparativos devem ser usados ferramentas de code profiling, como por exemplo o https://visualvm.github.io/Links to an external site.. Elabore gráficos mostrando o consumo de tempo e memória quando da execução do algoritmo.\n" +
                    "\n" +
                    "Entrega deste milestone:\n" +
                    "\n" +
                    "Entrega de um relatório descrevendo os casos de testes, ambiente de execução completo e análise comparativa dos algoritmos. (Equivale a 40% da nota)\n" +
                    "Você deve subir o projeto no GitHub e mandar o link do projeto e o link de uma versão para eu baixar no meu computador e executar com todas as instruções (arquivo readme). (Equivale a 60% da nota)\n" +
                    "Link para o templateLinks to an external site.";
        
        return this.saida;
    }
    
    public String infoProjetoSenhas(){
        this.saida = "Projeto Passwords\n" +
                    "O dataset apresentado compreende a listagem de mais de 600 mil senhas, as quais o aluno deve fazer a classificação, afiltragem e a ordenação.\n" +
                    "\n" +
                    "Você pode baixar o dataset diretamente através do linkLinks to an external site. O arquivo a ser considerado é o passwords.csv\n" +
                    "\n" +
                    "Regras para classificar senhas\n" +
                    "Para a classificação, devemos considerar como entrada dos dados o arquivo entitulado passwords.csv. O aluno deve implemtar um código seguindo as regras abaixo para classificar as senhas, e gerar um novo arquivo password_classifier com a coluna (class) com cada classe para a respectiva senha. OBS: Senhas que porventura venham a ter mais de um tipo, o aluno pode escolher o tipo de que deve ser classificado.\n" +
                    "\n" +
                    "Muito Ruim: tamanho da string menor que 5, e só um tipo de caractere, por exemplo: só letra (letras minúsculas ou maiúsculas), só número ou só caractere especial. \n" +
                    "Ruim: tamanho da string menor ou igual a 5, e só um tipos de caracteres, por exemplo: letra (letras minúsculas ou maiúsculas), número ou caractere especial. \n" +
                    "Fraca: tamanho da string menor ou igual a 6, e só dois tipos de caracteres, por exemplo: letra(letras minúsculas e maiúsculas), número ou caractere especial. \n" +
                    "Boa:  tamanho da string menor ou igual a 7, e só todos de caracteres, por exemplo: letra(letras minúsculas e maiúsculas), número ou caractere especial.\n" +
                    "Muito Boa:  tamanho da string maior que 8, e só todos os tipos de caracteres, por exemplo: letra(letras minúsculas e maiúsculas), número ou caractere especial\n" +
                    "Sem Classificação: Senhas que não se qualificam com nenhuma das classificações acima.\n" +
                    " \n" +
                    "\n" +
                    "Transformações\n" +
                    "Para as tranforamções, devemos considerar como entrada dos dados o arquivo entitulado password_classifier.csv\n" +
                    "\n" +
                    "Transformar data para o formato a seguir DD/MM/AAAA\n" +
                    "Gerar um arquivo chamado passwords_formated_data.csv\n" +
                    "Filtrar senha pela categória Boa e Muito Boa.\n" +
                    "\n" +
                    "Gerar um arquivo chamado passwords_classifier.csv\n" +
                    "Ordenações\n" +
                    "Para as ordenações, devemos considerar como entrada dos dados o arquivo entitulado passwords_formated_data.csv\n" +
                    "\n" +
                    "Lembrando que para cada questão abaixo deve ser utilizado todos os algoritmos de ordenação recomendados na descrição do projeto, sendo assim você deve gerar um arquivo diferente para cada algoritmo de ordenação / caso.\n" +
                    "\n" +
                    "Sobre os casos, para efeito de análise dos algoritmos deve-se trabalhar com 3 casos (melhor, médio e pior) para cada um dos algoritmos. \n" +
                    "\n" +
                    "Ordenar o arquivo completo de senhas pelo campo length em ordem decrescente.\n" +
                    "Deve-se gerar um arquivo para cada algoritmo de ordenação e o tipo de caso. Por exemplo, passwords_length_insertionSort_medioCaso.csv, passwords_length_insertionSort_piorCaso.csv, passwords_length_insertionSort_melhorCaso.csv\n" +
                    "Ordenar o arquivo completo de senhas por mês, (OBS: deve-se obter o mês a partir da data já formatada) da coluna data, de forma crescente.\n" +
                    "Deve-se gerar um arquivo para cada algoritmo de ordenação e o tipo de caso. Por exemplo, passwords_data_month_insertionSort_medioCaso.csv, passwords_month_data_insertionSort_piorCaso.csv, passwords_data_month_insertionSort_melhorCaso.csv\n" +
                    "Ordenar o arquivo completo de senhas pela coluna data de forma crescente.\n" +
                    "Deve-se gerar um arquivo para cada algoritmo de ordenação e o tipo de caso. Por exemplo, lpasswords_data_insertionSort_medioCaso.csv, passwords_month_insertionSort_piorCaso.csv, passwords_data_insertionSort_melhorCaso.csv";
        
        return this.saida;
    }
    
    public String infoSobreAutor(){
        this.saida = "Autor: ARTHUR FELIPE MUNIZ SALES\n\n\n" +
                    "\n" +
                    "Técnico em informática - ETER.\n" +
                    "Estudante de Computação - UEPB.\n" +
                    "\n" +
                    "Linkedin: https://www.linkedin.com/in/arthur-muniz-07b87b119\n" +
                    "\n" +
                    "E-mail: sales.arthur.fm@gmail.com\n" +
                    "\n" +
                    "Repositório: https://github.com/ArthurSalesFM\n" +
                    "\n" +
                    "Site Pessoal: https://arthursalesfm.github.io\n" ;
        
        return this.saida;
    }
    
    public String infoSelection(){
        this.saida = "SELECTION SORT\n" +
                    "\n" + 
                    "\n" + 
                    "\n" + 
                    "Análise de Casos:\n" +
                    "\n" +                
                    "Melhor Caso: O(n^2), onde n é o número de elementos na lista.\n" +
                    "Caso Médio: O(n^2).\n" +
                    "Pior Caso: O(n^2).\n" +
                    "\n" +                
                    "Características:\n" +
                    "Selection Sort é um algoritmo de ordenação in-place, o que significa que não requer espaço adicional para armazenar elementos.\n" +
                    "Divide a lista em duas partes: uma parte ordenada e uma parte não ordenada.\n" +
                    "Encontra o menor elemento na parte não ordenada e o move para a parte ordenada.\n" +
                    "Repete esse processo até que toda a lista esteja ordenada.\n" +
                    "\n" +                
                    "Prós:\n" +                    
                    "É fácil de entender e implementar.\n" +
                    "Funciona bem para listas pequenas.\n" +
                    "Requer menos trocas de elementos do que o Bubble Sort.\n" +
                    "\n" +                
                    "Contras:\n" +
                    "Ineficiente para listas grandes devido à sua complexidade O(n^2).\n" +
                    "Não é estável, o que significa que a ordem relativa de elementos iguais pode ser alterada.\n" +
                    "Realiza um número fixo de trocas, mesmo se a lista já estiver parcialmente ordenada." +
                    "\n" +
                    "\n" +                
                    "Exemplo de Pseudocódigo:\n" +
                    "\n" +
                    "procedure selectionSort(lista):\n" +
                    "    n = tamanho(lista)\n" +
                    "    para i de 0 até n-1:\n" +
                    "        índiceMenor = i\n" +
                    "        para j de i+1 até n:\n" +
                    "            se lista[j] < lista[índiceMenor]:\n" +
                    "                índiceMenor = j\n" +
                    "        trocar(lista[i], lista[índiceMenor])" ;
        
        return this.saida;
    }
    
    public String infoInsertion() {
        this.saida = "INSERTION SORT\n" +
                    "\n" + 
                    "\n" + 
                    "\n" + 
                    "Análise de Casos:\n" +
                    "\n" +
                    "Melhor Caso: O(n), onde n é o número de elementos na lista, quando a lista já está ordenada.\n" +
                    "Caso Médio: O(n^2).\n" +
                    "Pior Caso: O(n^2).\n" +
                    "\n" +
                    "Características:\n" +
                    "Insertion Sort é um algoritmo de ordenação in-place, o que significa que não requer espaço adicional para armazenar elementos.\n" +
                    "Divide a lista em duas partes: uma parte ordenada e uma parte não ordenada.\n" +
                    "Percorre a parte não ordenada, inserindo cada elemento na posição correta na parte ordenada.\n" +
                    "Eficiente para pequenas quantidades de dados ou listas quase ordenadas.\n" +
                    "\n" +
                    "Prós:\n" +
                    "É eficiente para listas pequenas ou quando a lista já está parcialmente ordenada.\n" +
                    "Requer menos comparações do que algoritmos de ordenação de seleção ou bubble sort.\n" +
                    "\n" +
                    "Contras:\n" +
                    "Ineficiente para listas grandes devido à sua complexidade O(n^2) no pior caso.\n" +
                    "Não é estável, o que significa que a ordem relativa de elementos iguais pode ser alterada.\n" +
                    "\n" +
                    "Exemplo de Pseudocódigo:\n" +
                    "\n" +
                    "procedure insertionSort(lista):\n" +
                    "    n = tamanho(lista)\n" +
                    "    para i de 1 até n-1:\n" +
                    "        elementoAtual = lista[i]\n" +
                    "        j = i-1\n" +
                    "        enquanto j >= 0 e lista[j] > elementoAtual:\n" +
                    "            lista[j+1] = lista[j]\n" +
                    "            j = j-1\n" +
                    "        lista[j+1] = elementoAtual";
    
        return this.saida;
    }
    
    public String infoMerge() {
        this.saida = "MERGE SORT\n" +
                    "\n" + 
                    "\n" + 
                    "\n" + 
                    "Análise de Casos:\n" +
                    "\n" +
                    "Melhor Caso: O(n log n), onde n é o número de elementos na lista.\n" +
                    "Caso Médio: O(n log n).\n" +
                    "Pior Caso: O(n log n).\n" +
                    "\n" +
                    "Características:\n" +
                    "Merge Sort é um algoritmo de ordenação estável que utiliza uma abordagem de 'dividir e conquistar'.\n" +
                    "Divide a lista em duas metades, ordena cada metade e depois mescla as duas metades ordenadas em uma única lista ordenada.\n" +
                    "Eficiente para listas grandes e é uma das escolhas mais rápidas para ordenação geral.\n" +
                    "\n" +
                    "Prós:\n" +
                    "Eficiente para listas grandes e em todos os casos.\n" +
                    "Ordenação estável, mantendo a ordem relativa de elementos iguais.\n" +
                    "\n" +
                    "Contras:\n" +
                    "Requer espaço adicional para a cópia temporária das sublistas durante a mesclagem, o que pode ser um problema em listas muito grandes.\n" +
                    "A implementação pode ser mais complexa do que algoritmos como Selection Sort ou Insertion Sort.\n" +
                    "\n" +
                    "Exemplo de Pseudocódigo:\n" +
                    "\n" +
                    "procedure mergeSort(lista):\n" +
                    "    se tamanho(lista) <= 1:\n" +
                    "        retorne lista\n" +
                    "    metade = dividir(lista)\n" +
                    "    esquerda = mergeSort(metade esquerda)\n" +
                    "    direita = mergeSort(metade direita)\n" +
                    "    retorne mesclar(esquerda, direita)";
    
        return this.saida;
    }    
    
    public String infoQuick() {
        this.saida = "QUICK SORT\n" +
                    "\n" + 
                    "\n" + 
                    "\n" +  
                    "Análise de Casos:\n" +
                    "\n" +
                    "Melhor Caso: O(n log n), onde n é o número de elementos na lista.\n" +
                    "Caso Médio: O(n log n).\n" +
                    "Pior Caso: O(n^2) quando o pivô é sempre o elemento mínimo ou máximo da lista.\n" +
                    "\n" +
                    "Características:\n" +
                    "Quick Sort é um algoritmo de ordenação eficiente que utiliza uma abordagem de 'dividir e conquistar'.\n" +
                    "Seleciona um elemento pivô na lista e rearranja os elementos, de modo que os elementos menores que o pivô fiquem à esquerda e os maiores fiquem à direita.\n" +
                    "Repete o processo nas duas sublistas resultantes.\n" +
                    "Eficiente para listas grandes e em casos médios.\n" +
                    "\n" +
                    "Prós:\n" +
                    "Eficiente para listas grandes e em casos médios.\n" +
                    "Em média, requer menos comparações do que o Merge Sort.\n" +
                    "\n" +
                    "Contras:\n" +
                    "Pode ser ineficiente no pior caso (quando o pivô é sempre mínimo ou máximo).\n" +
                    "Não é estável, o que significa que a ordem relativa de elementos iguais pode ser alterada.\n" +
                    "A escolha do pivô pode afetar o desempenho.\n" +
                    "\n" +
                    "Exemplo de Pseudocódigo:\n" +
                    "\n" +
                    "procedure quickSort(lista):\n" +
                    "    se tamanho(lista) <= 1:\n" +
                    "        retorne lista\n" +
                    "    pivô = selecionarPivô(lista)\n" +
                    "    menores, iguais, maiores = particionar(lista, pivô)\n" +
                    "    retorne concatena(quickSort(menores), iguais, quickSort(maiores))";
    
        return this.saida;
    }
    
    public String infoQuickMedianaDe3() {
        this.saida = "QUICK SORT COM MEDIANA DE 3\n" +
                    "\n" + 
                    "\n" + 
                    "\n" +  
                    "Análise de Casos:\n" +
                    "\n" +
                    "Melhor Caso: O(n log n), onde n é o número de elementos na lista.\n" +
                    "Caso Médio: O(n log n).\n" +
                    "Pior Caso: O(n^2) quando o pivô é sempre o elemento mínimo ou máximo da lista.\n" +
                    "\n" +
                    "Características:\n" +
                    "Quick Sort com mediana de 3 é uma variação do Quick Sort que tenta melhorar o desempenho em listas com elementos repetidos ou pré-ordenados.\n" +
                    "Seleciona três elementos (geralmente o primeiro, o do meio e o último) e usa a mediana como pivô.\n" +
                    "Rearranja os elementos de forma que os menores que o pivô fiquem à esquerda e os maiores fiquem à direita.\n" +
                    "Repete o processo nas duas sublistas resultantes.\n" +
                    "\n" +
                    "Prós:\n" +
                    "Melhora o desempenho em listas com muitos elementos repetidos.\n" +
                    "Eficiente para listas grandes e em casos médios.\n" +
                    "\n" +
                    "Contras:\n" +
                    "Pode ser ineficiente no pior caso (quando o pivô é sempre mínimo ou máximo).\n" +
                    "Não é estável, o que significa que a ordem relativa de elementos iguais pode ser alterada.\n" +
                    "A escolha da mediana de 3 não é uma garantia de melhor desempenho em todos os casos.\n" +
                    "\n" +
                    "Exemplo de Pseudocódigo:\n" +
                    "\n" +
                    "procedure quickSortMedianaDe3(lista):\n" +
                    "    se tamanho(lista) <= 1:\n" +
                    "        retorne lista\n" +
                    "    pivô = selecionarPivôMedianaDe3(lista)\n" +
                    "    menores, iguais, maiores = particionar(lista, pivô)\n" +
                    "    retorne concatena(quickSortMedianaDe3(menores), iguais, quickSortMedianaDe3(maiores))";
    
        return this.saida;
    }

    public String infoCountingSort() {
        this.saida = "COUNTING SORT\n" +
                    "\n" + 
                    "\n" + 
                    "\n" +  
                    "Análise de Casos:\n" +
                    "\n" +
                    "Melhor Caso: O(n + k), onde n é o número de elementos na lista e k é o intervalo (a diferença entre o maior e o menor elemento).\n" +
                    "Caso Médio: O(n + k).\n" +
                    "Pior Caso: O(n + k).\n" +
                    "\n" +
                    "Características:\n" +
                    "Counting Sort é um algoritmo de ordenação não comparativo que funciona bem quando os elementos da lista são inteiros não negativos e têm um intervalo relativamente pequeno.\n" +
                    "Conta a ocorrência de cada elemento e usa essa contagem para reorganizar os elementos.\n" +
                    "Eficiente para listas com intervalo pequeno de valores.\n" +
                    "\n" +
                    "Prós:\n" +
                    "É eficiente para listas com um intervalo pequeno de valores.\n" +
                    "Ordenação estável, mantendo a ordem relativa de elementos iguais.\n" +
                    "\n" +
                    "Contras:\n" +
                    "Não é eficiente para listas com um intervalo grande de valores.\n" +
                    "Requer espaço adicional para armazenar a contagem dos elementos, o que pode ser um problema para listas muito grandes.\n" +
                    "\n" +
                    "Exemplo de Pseudocódigo:\n" +
                    "\n" +
                    "procedure countingSort(lista):\n" +
                    "    intervalo = encontreIntervalo(lista)\n" +
                    "    contagem = inicializeContagem(intervalo)\n" +
                    "    para elemento em lista:\n" +
                    "        contagem[elemento] = contagem[elemento] + 1\n" +
                    "    índiceResultado = 0\n" +
                    "    para i de 0 até intervalo:\n" +
                    "        enquanto contagem[i] > 0:\n" +
                    "            lista[índiceResultado] = i\n" +
                    "            contagem[i] = contagem[i] - 1\n" +
                    "            índiceResultado = índiceResultado + 1";
    
        return this.saida;
    }

    public String infoHeapSort() {
        this.saida = "HEAP SORT\n" +
                    "\n" + 
                    "\n" + 
                    "\n" +
                    "Análise de Casos:\n" +
                    "\n" +
                    "Melhor Caso: O(n log n), onde n é o número de elementos na lista.\n" +
                    "Caso Médio: O(n log n).\n" +
                    "Pior Caso: O(n log n).\n" +
                    "\n" +
                    "Características:\n" +
                    "Heap Sort é um algoritmo de ordenação que utiliza uma estrutura de dados chamada heap (ou árvore binária) para organizar os elementos.\n" +
                    "Constrói um heap máximo (ou mínimo) a partir da lista e extrai o elemento raiz repetidamente para obter a lista ordenada.\n" +
                    "Eficiente para listas grandes e é uma das escolhas mais rápidas para ordenação geral.\n" +
                    "\n" +
                    "Prós:\n" +
                    "Eficiente para listas grandes e em todos os casos.\n" +
                    "Ordenação in-place, o que significa que não requer espaço adicional para armazenar elementos.\n" +
                    "\n" +
                    "Contras:\n" +
                    "Não é estável, o que significa que a ordem relativa de elementos iguais pode ser alterada.\n" +
                    "Implementação mais complexa do que algoritmos como Selection Sort ou Insertion Sort.\n" +
                    "\n" +
                    "Exemplo de Pseudocódigo:\n" +
                    "\n" +
                    "procedure heapSort(lista):\n" +
                    "    construirHeapMaximo(lista)\n" +
                    "    n = tamanho(lista)\n" +
                    "    para i de n-1 até 1:\n" +
                    "        trocar(lista[0], lista[i])\n" +
                    "        heapify(lista, 0, i)";
    
        return this.saida;
    }
    
}
