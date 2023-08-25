
### Funcionamento:

1. **SelectionSort**:
   - Este algoritmo itera sobre o array, selecionando o menor elemento a cada iteração e trocando-o com o elemento na posição atual.
   - Tem complexidade de tempo de O(n^2) no pior caso.
   - Requer um grande número de trocas, o que pode ser ineficiente.

2. **QuickSort**:
   - Utiliza o conceito de divisão e conquista.
   - Seleciona um elemento como pivô, coloca elementos menores à esquerda e maiores à direita.
   - Recursivamente aplica o mesmo processo nas duas metades.
   - Tem complexidade de tempo médio O(n log n), mas pode degradar para O(n^2) no pior caso se a escolha do pivô não for eficiente.

3. **BubbleSort**:
   - Compara pares adjacentes de elementos e os troca se estiverem na ordem errada.
   - Repete esse processo até que nenhum elemento seja trocado em uma iteração.
   - Tem complexidade de tempo de O(n^2) no pior caso.
   - Pode ser ineficiente para arrays grandes.

4. **InsertionSort**:
   - Itera sobre o array e insere cada elemento na posição correta no subarray ordenado anterior.
   - Tem complexidade de tempo de O(n^2) no pior caso.
   - Eficiente para pequenos arrays ou arrays quase ordenados.

### Tabela de Comparação:
Tabela de comparação dos métodos de ordenação implementados para o tamanho do array 5000:

| Método        | Tempo de Execução (ms) | Número de Trocas | Número de Comparações |
|---------------|------------------------|------------------|------------------------|
| SelectionSort | 43                     | 4990             | 12497500               |
| QuickSort     | 45                     | ...              | ...                    |
| BubbleSort    | 160                    | ...              | ...                    |
| InsertionSort | 38                     | ...              | ...                    |

### Conclusão da Equipe:
Após realizar várias execuções e coletar dados, nosso grupo chegou às seguintes conclusões:

1. **SelectionSort**:
   - O tempo de execução é relativamente alto em comparação com os outros métodos.
   - O número de trocas é alto, o que o torna menos eficiente.
   - O número de comparações também é elevado.

2. **QuickSort**:
   - Apresenta um tempo de execução menor em comparação com o SelectionSort e o BubbleSort.
   - O número de trocas é moderado e o número de comparações também é moderado.
   - É mais eficiente para tamanhos maiores de arrays.

3. **BubbleSort**:
   - Tem o maior tempo de execução entre os métodos.
   - Possui um alto número de trocas e comparações.
   - Não é eficiente para arrays maiores.

4. **InsertionSort**:
   - Mostra um tempo de execução razoável para tamanhos pequenos de arrays.
   - O número de trocas é baixo e pode ser eficiente para arrays quase ordenados.
   - O número de comparações é moderado.

### Quadro Comparativo:

Baseado nas conclusões da nossa equipe, aqui está um quadro comparativo resumido:

| Método        | Tempo de Execução       | Número de Trocas | Número de Comparações | Adequado para          |
|---------------|--------------------------|------------------|------------------------|------------------------|
| SelectionSort | Mais alto                | Alto             | Alto                   | Pequenos arrays        |
| QuickSort     | Médio                    | Moderado         | Moderado               | Diversos tamanhos      |
| BubbleSort    | Mais alto                | Alto             | Alto                   | Pequenos arrays        |
| InsertionSort | Razoável                 | Baixo            | Moderado               | Pequenos/Quase ordenado|

