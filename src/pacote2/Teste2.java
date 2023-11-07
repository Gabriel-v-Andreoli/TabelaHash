package pacote2;

import java.util.Random;
import java.util.Scanner;

public class Teste2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long seed = 735192042L;
        Random aleatorio = new Random(seed);
        TabelaPorMultiplicacao tabela2 = new TabelaPorMultiplicacao(10);
        for (int i = 0; i < 1500000; i++){
            Registro r = new Registro();
            r.setInfo(aleatorio.nextInt(0, 300));
            r.setChave(aleatorio.nextInt(100000000, 1000000000));
            tabela2.inserirNaTabela(r);
        }

        long inicio = System.currentTimeMillis();
        tabela2.buscarNaTabela(999420024);
        long fim = System.currentTimeMillis(); System.out.println(fim - inicio);


        //
    }
}
