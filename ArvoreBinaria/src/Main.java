public class Main {
    public static void main(String[] args) {
        ArvoreBinaria tree = new ArvoreBinaria();

        // Inserir alguns valores na árvore
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Testar os métodos de percurso
        System.out.println("Percurso em pré-ordem:");
        tree.preOrder(); 
        System.out.println();

        System.out.println("Percurso em ordem:");
        tree.inOrder();
        System.out.println();

        System.out.println("Percurso em pós-ordem:");
        tree.postOrder();
        System.out.println();

        // Testar a busca de elementos
        int searchValue1 = 40;
        System.out.println("Buscar " + searchValue1 + ": " + tree.findElement(searchValue1));

        int searchValue2 = 90;
        System.out.println("Buscar " + searchValue2 + ": " + tree.findElement(searchValue2));

        // Testar encontrar o máximo e mínimo
        Node maxNode = tree.max(tree.root);
        if (maxNode != null) {
            System.out.println("Máximo: " + maxNode.data);
        }

        Node minNode = tree.min(tree.root);
        if (minNode != null) {
            System.out.println("Mínimo: " + minNode.data);
        }
    }
}
