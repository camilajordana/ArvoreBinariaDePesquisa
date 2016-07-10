public class Teste {

    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        arvore.inserir(6);
        arvore.inserir(9);
        arvore.inserir(10);
        arvore.inserir(1);
        
        arvore.exibir(arvore.getRaiz());
        
    }
    
}
