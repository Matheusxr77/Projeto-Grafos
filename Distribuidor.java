import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// Classe principal do projeto
public class Distribuidor {
    public static void main(String[] args) {
        // Criando os nós do grafo
        No no1 = new No(1);
        No no2 = new No(2);
        No no3 = new No(3);
        No no4 = new No(4);

        // Criando as arestas do grafo
        Aresta aresta1 = new Aresta(no1, no2, 10); // Exemplo: capacidade da linha de transmissão
        Aresta aresta2 = new Aresta(no1, no3, 15);
        Aresta aresta3 = new Aresta(no2, no3, 20);
        Aresta aresta4 = new Aresta(no2, no4, 25);

        // Adicionando as arestas aos nós correspondentes
        no1.addNeighbor(aresta1);
        no1.addNeighbor(aresta2);
        no2.addNeighbor(aresta1);
        no2.addNeighbor(aresta3);
        no2.addNeighbor(aresta4);
        no3.addNeighbor(aresta2);
        no3.addNeighbor(aresta3);
        no4.addNeighbor(aresta4);

        // Exemplo de algoritmo para percorrer o grafo
        // Aqui você pode implementar algoritmos de grafos para resolver problemas específicos

        // Exemplo: Percurso em largura (Breadth-First Search - BFS)
        breadthFirstSearch(no1);
    }

    public static void breadthFirstSearch(No startNo) {
        Queue<No> fila = new LinkedList<>();
        Set<No> visitado = new HashSet<>();

        fila.add(startNo);
        visitado.add(startNo);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.println("Visitando nó: " + atual.id);

            for (Aresta Aresta : atual.bairros) {
                No bairro = Aresta.destino;
                if (!visitado.contains(bairro)) {
                    fila.add(bairro);
                    visitado.add(bairro);
                }
            }
        }
    }
}