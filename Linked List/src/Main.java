import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ListaSE lista = new ListaSE();
        System.out.println("Lista vazia= " + lista.vazia());

        lista.insere_ultimo(10); lista.insere_ultimo(20); lista.insere_ultimo(30);
        lista.insere_ultimo(40);lista.insere_ordenado(35);
        lista.imprime();

        System.out.println("Lista vazia= " + lista.vazia());
        //lista.verificarElemento(50);
        //lista.verificarElemento(5);
        //lista.verificarElemento(25);

        System.out.println("Inserindo na primeira posição: ");
        lista.insere_primeiro(2);
        lista.imprime();
        System.out.println("Inserindo na última posição: ");
        lista.insere_ultimo(45);
        lista.imprime();

        System.out.println("Inserindo depois de um nó (nesse caso, o segundo): ");
        No segundo= lista.getPrimeiro().getProximo();
        lista.insere_depois(segundo, 90);
        lista.imprime();

        System.out.println("Retirando o primeiro elemento: ");
        lista.retira_primeiro();
        lista.imprime();

        System.out.println("Retirando o último elemento: ");
        lista.retira_primeiro();
        lista.imprime();

        System.out.println("Retirando depois de um nó (nesse caso, o segundo): ");
        segundo = lista.getPrimeiro().getProximo();
        lista.retira_depois(segundo);
        lista.imprime();

        System.out.println("Tamanho da lista: " + lista.getTamanho());

        ListaSE lista1 = new ListaSE();
        ListaSE lista2 = new ListaSE();

        ListaSE lista3 = new ListaSE();
        lista1.insere_ultimo(1); lista1.insere_ultimo(2); lista1.insere_ultimo(3); lista1.insere_ultimo(4); lista1.insere_ultimo(4); lista1.insere_ultimo(6);
        lista2.insere_ultimo(2); lista2.insere_ultimo(3); lista2.insere_ultimo(6); lista2.insere_ultimo(6);  lista2.insere_ultimo(4);
        intersecaoListas(lista1, lista2, lista3);
        //System.out.println("\nSimilaridade das listas: " + calcularSimilaridadeCosseno(lista1, lista2));
        System.out.print("Intersecção das listas: "); lista3.imprime();

    }

    public static double calcularSimilaridadeCosseno(ListaSE listaX, ListaSE listaY) {
        if (listaX.getTamanho() != listaY.getTamanho()) {
            throw new IllegalArgumentException("As listas devem ter o mesmo tamanho.");
        }

        No atualX = listaX.getPrimeiro();
        No atualY = listaY.getPrimeiro();
        int produtoInterno = 0;
        int somaQuadradosX = 0;
        int somaQuadradosY = 0;

        while (atualX != null && atualY != null) {
            int x = atualX.getInfo();
            int y = atualY.getInfo();

            produtoInterno += x * y;
            somaQuadradosX += x * x;
            somaQuadradosY += y * y;

            atualX = atualX.getProximo();
            atualY = atualY.getProximo();
        }

        double magnitudeX = Math.sqrt(somaQuadradosX);
        double magnitudeY = Math.sqrt(somaQuadradosY);

        if (magnitudeX == 0 || magnitudeY == 0) {
            return 0.0;
        }

        return produtoInterno / (magnitudeX * magnitudeY);
    }

    public static void intersecaoListas(ListaSE listaX, ListaSE listaY, ListaSE listaZ) {
        No atualX = listaX.getPrimeiro();
        Set<Integer> valoresInseridos = new HashSet<>();

        while (atualX != null) {
            No atualY = listaY.getPrimeiro();
            while(atualY != null) {
                if (atualX.getInfo() == atualY.getInfo()) {
                    if (!valoresInseridos.contains(atualX.getInfo())) {
                        listaZ.insere_ordenado(atualX.getInfo());
                        valoresInseridos.add(atualX.getInfo());
                    }
                }
                atualY = atualY.getProximo();
            }
            atualX = atualX.getProximo();
        }
    }

}