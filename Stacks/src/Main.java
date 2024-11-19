//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    Pilha p1 = new Pilha(10);
    Expressao expressao = new Expressao();

        System.out.println("Topo da pilha: " + p1.topo());
        System.out.println("Está vazia: " + p1.vazia());
        System.out.println("Está cheia: " + p1.cheia());
        for(int i = 0; i < 10; i++){
            p1.empilha(i);
        }
        System.out.println("Topo da pilha: " + p1.topo());
        System.out.println("Está vazia: " + p1.vazia());
        System.out.println("Está cheia: " + p1.cheia());
        p1.desempilha();
        System.out.println("Topo da pilha: " + p1.topo());
        System.out.println("Está vazia: " + p1.vazia());
        System.out.println("Está cheia: " + p1.cheia());

        System.out.println(expressao.verificarExpressao("(1+5)*(56+12)"));
        System.out.println(expressao.verificarExpressao("(1+5)*)56+12)"));
        System.out.println(expressao.verificarExpressao("(1+5)*[56+12)"));
        System.out.println(expressao.verificarExpressao("(((1+2) - 3 )* 6)"));
    }
}