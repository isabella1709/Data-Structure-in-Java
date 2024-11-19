import java.util.ArrayList;

public class Pilha {
    private int topo = -1;
    private ArrayList<Integer> dados;
    private int max;

    /*
    a) topo();  // retorna o elemento no topo da pilha
    */
    public int topo() {
        if (topo == -1) {
            System.out.println("Pilha está vazia");
            return -1; // Retorna um valor de erro
        }
        return dados.get(topo);
    }

    /*
    b) vazia();  // retorna 1 se a pilha está vazia e 0 caso contrário
    */
    public int vazia() {
        if (topo == -1){
            return 1;
        }
        return 0;
    }

    /*
    c) cheia();  // retorna 1 se a pilha está cheia e 0 caso contrário
    */
    public int cheia() {
        if (topo == max -1){
            return 1;
        }
        return 0;
    }

    /*
    d) empilha(inteiro: elemento)  // coloca o elemento na pilha
    */
    public void empilha(int elemento) {
        if (cheia() == 1) {
            System.out.println("Pilha está cheia, não é possível empilhar.");
            return;
        }
        dados.add(++topo, elemento);
    }

    /*
    e) desempilha();  // retira e retorna o elemento do topo da pilha
    */
    public int desempilha() {
        if (vazia() == 1) {
            System.out.println("Pilha está vazia, não é possível desempilhar.");
            return -1; // Retorna um valor de erro
        }
        int elementoRemovido = dados.remove(topo--);
        return elementoRemovido;
    }

    /*
    f) Pilha(n) // construtor: cria e retorna uma pilha capaz de armazenar até n elementos
    */
    public Pilha(int max) {
        this.max = max;
        this.dados = new ArrayList<>(max);
    }
}
