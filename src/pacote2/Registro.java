package pacote2;

public class Registro {
    private Integer chave;
    private Integer info;
    private Registro prox;

    public Registro(){
        chave = null;
        info = null;
        prox = null;
    }

    public Integer getChave() {
        return chave;
    }

    public void setChave(Integer chave) {
        this.chave = chave;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public Registro getProx() {
        return prox;
    }

    public void setProx(Registro prox) {
        this.prox = prox;
    }
}
