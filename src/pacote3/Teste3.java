package pacote3;

import java.util.Random;
import java.util.Scanner;

public class Teste3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long seed = 735192042L;
        Random aleatorio = new Random(seed);
        TabelaPorDobramento tabela3 = new TabelaPorDobramento(100000);

        for (int i = 0; i < 1500000; i++){
            Registro r = new Registro();
            r.setInfo(aleatorio.nextInt(0, 300));
            r.setChave(aleatorio.nextInt(100000000, 1000000000));
            tabela3.inserirNaTabela(r);
        }
        System.out.println(tabela3.getColisoes());
        long inicio = System.currentTimeMillis();
        tabela3.buscarNaTabela(958592912);
        long fim = System.currentTimeMillis(); System.out.println(fim - inicio);



    }
}
