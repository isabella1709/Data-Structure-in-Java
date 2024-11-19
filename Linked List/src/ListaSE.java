public class ListaSE {

    private No primeiro;
    private No ultimo;
    private int tamanho;

    public ListaSE(){
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public No getPrimeiro() {return primeiro;}
    public No getUltimo() {return ultimo;}
    public int getTamanho() {return tamanho;}
    public void setPrimeiro(No primeiro) {this.primeiro = primeiro;}
    public void setUltimo(No ultimo) {this.ultimo = ultimo;}
    public void setTamanho(int tamanho) {this.tamanho = tamanho;}

    //boolean vazia(); // Verifica se a lista L está vazia

    public boolean vazia(){
        return primeiro == null;
    }

    //void insere_ultimo(int info); // Insere o elemento info como último na lista L

    public void insere_ultimo(int valor){
        No novo = new No(valor);

        if(vazia()){
            primeiro = novo;
            ultimo = novo;
        }else{
            ultimo.setProximo(novo);
            ultimo = novo;
        }
        tamanho++;
    }

    //void insere_primeiro(int info); // Insere o elemento info como primeiro na lista L

    public void insere_primeiro(int valor){
        No novo = new No(valor);
        if(vazia()){
            primeiro = novo;
            ultimo = novo;
        } else {
            novo.setProximo(primeiro);
            primeiro = novo;
        }
        tamanho++;
    }

    //void insere_depois(Node * No, int info); // Insere o elemento info depois do nó No

    public void insere_depois(No no, int valor){
        if (vazia()) {
            System.out.println("A lista está vazia!");
            return;
        }

        No novo = new No(valor);
        novo.setProximo(no.getProximo());
        no.setProximo(novo);

        if (no == ultimo) {
            ultimo = novo;
        }
        tamanho++;
    }

    //void insere_ordenado(int info);

    public void insere_ordenado(int valor) {
        No novo = new No(valor);
        if (vazia()) {
            primeiro = novo;
            ultimo = novo;
            return;
        } if (valor <= primeiro.getInfo()) {
            insere_primeiro(valor);
            return;
        } if (valor >= ultimo.getInfo()) {
            insere_ultimo(valor);
            return;
        }
        No atual = primeiro;
        while (atual.getProximo() != null) {
            if (valor <= atual.getProximo().getInfo()) {
                insere_depois(atual, valor);
                return;
            }
            atual = atual.getProximo();
        }
    }

    // void mostra_lista();
    public void imprime(){
        No atual = primeiro;
        while(atual != null){
            System.out.print("[ " + atual.getInfo() + " ] --> ");
            atual = atual.getProximo();
        }
        System.out.println("Null");
    }

    // int retira_primeiro(); // Retira o primeiro elemento da Lista e retorna o valor da info do No
    public int retira_primeiro(){
        if (primeiro == null){
            System.out.println("A lista esta vazia");
            return 0;
        }
        int removido = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        tamanho--;
        return removido;
    }
    //int retira_ultimo(); // Retira o último elemento da Lista e retorna a informação do Nó
    public int retira_ultimo(){
        if (primeiro == null) {
            System.out.println("A lista está vazia");
            return -1;
        }

        if (primeiro == ultimo) {
            int removido = primeiro.getInfo();
            primeiro = null;
            ultimo = null;
            tamanho = 0;
            return removido;
        }

        No aux = primeiro;
        while (aux.getProximo() != ultimo) {
            aux = aux.getProximo();
        }

        int removido = ultimo.getInfo();
        ultimo = aux;
        ultimo.setProximo(null);
        tamanho--;

        return removido;  // Retorna o valor do nó removido
    }

    //int retira_depois(Node No); // Retira o elemento posterior ao nó No e retorna a sua informação
    public int retira_depois(No node){
        if (node == null || node.getProximo() == null) {
            System.out.println("O nó é nulo ou não há nó após o nó dado.");
            return -1;
        }

        No nodeToRemove = node.getProximo();
        int removido = nodeToRemove.getInfo();

        node.setProximo(nodeToRemove.getProximo());


        if (nodeToRemove == ultimo) {
            ultimo = node;
        }

        tamanho--;

        return removido;
    }

    //int ultimo_elemento(); // Retorna a informação do último elemento da Lista

    public void verificarElemento(int valor){
        if(primeiro.getInfo() > valor){
            System.out.println("O elemento " + valor + " é menor que o primeiro elemento da lista.");

        } else if(ultimo.getInfo() < valor) {
            System.out.println("O elemento " + valor + " é maior que o último elemento da lista.");

        }
        else{
            System.out.println("O elemento " + valor + " é intermediário da lista.");
        }
    }


}
