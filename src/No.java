public class No {

    private int valor;
    private No filhoEsquerdo;
    private No filhoDireito;

    public No(int valor) {
        this.valor = valor;
    }

    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public No getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }
    
     @Override
    public String toString() {
        return Integer.toString(this.getValor()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    public No sucessor(No no) {
        No sucessor = no;
        sucessor = sucessor.getFilhoDireito();
        while (sucessor.getFilhoEsquerdo()!= null) {
            sucessor = sucessor.getFilhoEsquerdo();
        }
        return sucessor;
    }
    
}
