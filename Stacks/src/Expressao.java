public class Expressao {

    public int verificarExpressao(String expressao){
        Pilha pilha = new Pilha(expressao.length());

       for(int i = 0; i <expressao.length(); i++){
           char caracter = expressao.charAt(i);

           if(caracter == '(' || caracter == '{' || caracter == '['){
               pilha.empilha((int) caracter);
           }
           else if(caracter == ')' || caracter == '}' || caracter == ']'){
               if(pilha.vazia() == 1){
                   return 0;
               }

               char topo = (char) pilha.desempilha();

               if ((caracter == ')' && topo != '(') || (caracter == '}' && topo != '{') || (caracter == ']' && topo != '[')) {
                   return 0;
               }
           }
       }
        return pilha.vazia() == 1 ? 1 : 0;
    }

}
