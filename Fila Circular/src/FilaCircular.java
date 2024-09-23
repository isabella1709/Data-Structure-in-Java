public class FilaCircular {

    private int[] dado;
    private int primeiro = 0, ultimo = -1, MAX, tamanho = 0;

    public FilaCircular(int MAX) {
        this.MAX = MAX;
        dado = new int[MAX];
    }

    public int cheia() {
        if (tamanho == MAX) {
            return 1;
        }
        return 0;
    }

    public int vazia() {
        if (tamanho == 0) {
            return 1;
        }
        return 0;
    }

    public void insere(int E) {
        if (cheia() == 1) {
            System.out.println("Erro ao inserir. Lista está cheia!");
            return;
        }

        ultimo = (ultimo + 1) % MAX;
        dado[ultimo] = E;
        this.tamanho++;
    }

    public void remove() {
        if (vazia() == 1) {
            System.out.println("Erro ao remover. Lista está vazia!");
            return;
        }

        int dadoRemovido = dado[primeiro];
        System.out.println("Dado removido: " + dadoRemovido);
        primeiro = (primeiro + 1) % MAX;
        this.tamanho--;
    }

    public void primeiro() {
        if (vazia() == 1) {
            System.out.println("Lista está vazia!");
        } else {
            System.out.println("Primeiro: " + dado[primeiro]);
        }
    }

    public void ultimo() {
        if (vazia() == 1) {
            System.out.println("Lista está vazia!");
        } else {
            System.out.println("Último: " + dado[ultimo]);
        }
    }

    public FilaCircular merge(FilaCircular a, FilaCircular b) {
        int capacidade = a.tamanho + b.tamanho;
        if (this.MAX < capacidade) {
            System.out.println("Capacidade insuficiente!");
            return null;
        }

        FilaCircular c = new FilaCircular(capacidade);

        int i = a.primeiro;
        int j = b.primeiro;

        // Mesclando as duas filas, inserindo na ordem correta
        while (a.tamanho > 0 && b.tamanho > 0) {
            if (a.dado[i] <= b.dado[j]) {
                c.insere(a.dado[i]);
                a.remove();
                i = a.primeiro;
            } else {
                c.insere(b.dado[j]);
                b.remove();
                j = b.primeiro;
            }
        }

        // Insere os elementos restantes da fila A (se houver)
        while (a.tamanho > 0) {
            c.insere(a.dado[i]);
            a.remove();
            i = a.primeiro;
        }

        // Insere os elementos restantes da fila B (se houver)
        while (b.tamanho > 0) {
            c.insere(b.dado[j]);
            b.remove();
            j = b.primeiro;
        }

        return c;
    }

    public void imprimir() {
        if (this.tamanho == 0) {
            System.out.println("Fila vazia.");
            return;
        }

        int i = this.primeiro;
        for (int count = 0; count < this.tamanho; count++) {
            System.out.print(this.dado[i] + " ");
            i = (i + 1) % this.MAX;
        }
        System.out.println();
    }

}
