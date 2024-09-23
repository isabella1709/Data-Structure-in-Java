//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FilaCircular filaCircular = new FilaCircular(5);
        FilaCircular filaCircular2 = new FilaCircular(5);
        FilaCircular filaCircular3 = new FilaCircular(10);

        System.out.println("Fila Circular cheia: " + filaCircular.cheia());
        System.out.println("Fila Circular vazia: " + filaCircular.vazia());

        filaCircular.primeiro();
        filaCircular.ultimo();

        filaCircular.insere(10);
        filaCircular.insere(20);
        filaCircular.insere(30);
        filaCircular.insere(40);
        filaCircular.insere(50);

        System.out.println("Fila Circular cheia: " + filaCircular.cheia());
        System.out.println("Fila Circular vazia: " + filaCircular.vazia());

        filaCircular.primeiro();
        filaCircular.ultimo();

        filaCircular.remove();

        filaCircular.primeiro();
        filaCircular.ultimo();

        filaCircular2.insere(25);
        filaCircular2.insere(70);
        filaCircular2.insere(35);
        filaCircular2.insere(80);
        filaCircular2.insere(55);


        filaCircular3.merge(filaCircular, filaCircular2).imprimir();


    }
}