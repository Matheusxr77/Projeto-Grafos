import java.util.ArrayList;
import java.util.List;

public class No {
    int id;
    List<Aresta> bairros; // Lista de arestas conectadas a este nó

    public No (int id) {
        this.id = id;
        this.bairros = new ArrayList<>(); // Inicializa a lista de vizinhos
    }

    public void addNeighbor(Aresta aresta) {
        bairros.add(aresta); // Adiciona uma aresta à lista de vizinhos
    }
}