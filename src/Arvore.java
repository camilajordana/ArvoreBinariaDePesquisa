public class Arvore {
    
    
    private No raiz = null;

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public void inserir(int valor) {
        if (this.getRaiz() == null) {
            this.raiz = new No(valor);
        } else {
            visita_Inserir(raiz, valor);
        }
    }

    public void visita_Inserir(No no, int valor) {
        if (no.getValor() == valor) {
            System.out.println("Valor já existe!!!");
        } else {
            if (valor < no.getValor()) {
                if (no.getFilhoEsquerdo() == null) {
                    No novoNo = new No(valor);
                    no.setFilhoEsquerdo(novoNo);
                } else {
                    visita_Inserir(no.getFilhoEsquerdo(), valor);
                }
            } else {
                if (no.getFilhoDireito() == null) {
                    No novoNo = new No(valor);
                    no.setFilhoDireito(novoNo);
                } else {
                    visita_Inserir(no.getFilhoDireito(), valor);
                }
            }
        }
    }

    public void remover(int valor_remover) {
        if (raiz == null) {
            System.out.println("Árvore vazia");
        } else if (raiz.getValor() == valor_remover && raiz.getFilhoDireito() == null && raiz.getFilhoEsquerdo() == null) {
            raiz = null;
        } else {
            visita_remover(raiz, raiz, valor_remover);
        }
    }

    public void visita_remover(No noAtual, No noPai, int valor_remover) {

        if (noAtual.getValor() != valor_remover) { //Se o nóAtual não for o valor q quero remover
            // Decidir se percorre a sub-arvore esquerda ou direita
            if (valor_remover < noAtual.getValor()) { //Analisa o filho esquerdo
                if (noAtual.getFilhoEsquerdo() != null) {
                    visita_remover(noAtual.getFilhoEsquerdo(), noAtual, valor_remover);
                } else {
                    System.out.println("O valor não está na árvore!!");
                }
            } else {
                // Analisa o filho direito
                if (noAtual.getFilhoDireito() != null) {
                    visita_remover(noAtual.getFilhoDireito(), noAtual, valor_remover);
                } else {
                    System.out.println("O valor não está na árvore!!");
                }
            }
        } else { //Se o noAtual tem o valor que eu quero remover
            //FOLHA
            if (noAtual.getFilhoDireito() == null && noAtual.getFilhoEsquerdo() == null) {
                //Se o noAtual for filho ESQUERDO do noPai
                if (noAtual == noPai.getFilhoEsquerdo()) {
                    noPai.setFilhoEsquerdo(null);
                }

                //Se o noAtual for filho DIREITO do noPai
                if (noAtual == noPai.getFilhoDireito()) {
                    noPai.setFilhoDireito(null);
                }
            } // TIVER 1 FILHO
            else if (noAtual.getFilhoDireito() == null || noAtual.getFilhoEsquerdo() == null) {

                //Se tiver subarvore a esquerda
                if (noAtual.getFilhoEsquerdo() != null) {
                    // Verifico se o noAtual é filho esquerdo ou direito
                    if (noAtual.getValor() < noPai.getValor()) {
                        noPai.setFilhoEsquerdo(noAtual.getFilhoEsquerdo());
                    } else {
                        noPai.setFilhoDireito(noAtual.getFilhoEsquerdo());
                    }
                } // Se tiver subarvore a direita
                else {
                    if (noAtual.getValor() < noPai.getValor()) {
                        noPai.setFilhoEsquerdo(noAtual.getFilhoDireito());
                    } else {
                        noPai.setFilhoDireito(noAtual.getFilhoDireito());
                    }
                }

            }
            // Se tiver 2 filhos
            else{
                No sucessor = noAtual.sucessor(noAtual);
                noAtual.setValor(sucessor.getValor());
                visita_remover(sucessor, noAtual, sucessor.getValor());
            }

        }
    }

    public void exibir(No no) {
        if (no.getFilhoEsquerdo() != null) {
            exibir(no.getFilhoEsquerdo());
        }
        visite(no);
        if (no.getFilhoDireito() != null) {
            exibir(no.getFilhoDireito());
        }
    }

    public void visite(No no) {
        System.out.print("Valor: " + no.getValor() + " ");
        if (no.getFilhoEsquerdo() != null) {
            System.out.println("Filho E: " + no.getFilhoEsquerdo() + " ");
        }
        if (no.getFilhoDireito() != null) {
            System.out.println("Filho D: " + no.getFilhoDireito() + " ");
        }
        System.out.println("");
    }
    
    
    public void pesquisar(No no, int valor) {

        if (no.getValor() == valor) {
            System.out.println("O nó foi encontrado!!!");
        } else if (no.getValor() > valor) {
            if (no.getFilhoEsquerdo()!= null) {
                pesquisar(no.getFilhoEsquerdo(), valor);
            } else {
                System.out.println("O nó NÃO foi encontrado!!!");
            }
        } else {
            if (no.getFilhoDireito()!= null) {
                pesquisar(no.getFilhoDireito(), valor);
            } else {
                System.out.println("O nó NÃO foi encontrado!!!");
            }
        }

    }

}
