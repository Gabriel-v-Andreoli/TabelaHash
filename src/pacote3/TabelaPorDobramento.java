package pacote3;

public class TabelaPorDobramento {
    private Registro[] vetor;
    private Integer tamanho;
    private Integer colisoes;

    public TabelaPorDobramento(int tamanho){
        this.tamanho = tamanho;
        vetor = new Registro[this.tamanho];
        colisoes = 0;
    }

    public Integer getColisoes() {
        return colisoes;
    }

    public int pegaChave(Registro r){
        if (r != null){
            return r.getChave();
        } else {
            return 0;
        }
    }

    public int dobramento(int chave){
        int valorFinal = 0;
        while (chave > 0){
            int digito = chave % 10;
            valorFinal += digito;
            chave /= 10;
        }
        return valorFinal;
    }
    public void inserirNaTabela(Registro registro){
        int lugar = dobramento(pegaChave(registro)) % tamanho;
        for (int i = 0; i < tamanho; i++) {
            if (lugar == i){
                if (vetor[i] == null){
                    vetor[i] = registro;
                } else if(vetor[i].getProx() == null){
                    if (pegaChave(vetor[i]) < pegaChave(registro)){
                        vetor[i].setProx(registro);
                    } else if (pegaChave(vetor[i]) > pegaChave(registro)) {
                        Registro atual = vetor[i];
                        vetor[i] = registro;
                        registro.setProx(atual);
                    }
                    colisoes++;
                } else {
                    Registro atual = vetor[i];
                    if (pegaChave(vetor[i]) > pegaChave(registro)){
                        registro.setProx(atual);
                        vetor[i] = registro;
                    } else if (pegaChave(registro) > pegaChave(atual) && pegaChave(registro) < pegaChave(atual.getProx())) {
                        registro.setProx(atual.getProx());
                        atual.setProx(registro);
                    } else {
                        Registro anterior = new Registro();
                        while (atual.getProx() != null) {
                            anterior = atual;
                            atual = atual.getProx();
                            if (pegaChave(registro) > pegaChave(atual) && pegaChave(registro) < pegaChave(atual.getProx())) {
                                registro.setProx(atual.getProx());
                                atual.setProx(registro);
                                break;
                            }
                        }
                        if (atual.getProx() == null) {
                            if (atual.getChave() < registro.getChave()) {
                                atual.setProx(registro);
                            } else if (atual.getChave() > registro.getChave()) {
                                registro.setProx(atual);
                                anterior.setProx(registro);
                            }
                        }
                    }
                    colisoes++;
                }
                break;
            }
        }
    }

    public void buscarNaTabela(int chave){
        int lugar = dobramento(chave) % tamanho;
        for (int i = 0; i < tamanho; i++) {
            if (lugar == i){
                if (chave == pegaChave(vetor[i])){
                    System.out.printf("Chave encontrada!! - sua info é %d%n", vetor[i].getInfo());
                    break;
                } else {
                    Registro atual = vetor[i];
                    while (atual.getProx() != null){
                        atual = atual.getProx();
                        if (chave == pegaChave(atual)){
                            System.out.printf("Chave encontrada!! - sua info é %d%n", atual.getInfo());
                            break;
                        }
                    }
                    if (atual.getProx() == null && chave == pegaChave(atual)) {
                        System.out.printf("Chave encontrada!! - sua info é %d%n", atual.getInfo());
                        break;
                    } else if (atual.getProx() == null && chave != pegaChave(atual)){
                        System.out.println("Chave não encontrada :(");
                        break;
                    }
                }
            }
        }
    }

    public void imprimirTabela(int qtdLinhas){
        Registro[] r2 = vetor;
        for (int i = 0; i < qtdLinhas; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (r2[j] != null){
                    System.out.printf("%d ",pegaChave(r2[j]));
                    r2[j] = r2[j].getProx();
                } else if (r2[j] == null) {
                    System.out.print("null ");
                }
            }
            System.out.println();
        }
    }
    //
}
