package pacote1;

import java.util.Random;
import java.util.Scanner;

public class Teste1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long seed = 735192042L;
        Random aleatorio = new Random(seed);
        TabelaPorResto tabela1 = new TabelaPorResto(10000);
        for (int i = 0; i < 1500000; i++){
            Registro r = new Registro();
            r.setInfo(aleatorio.nextInt(0, 300));
            r.setChave(aleatorio.nextInt(100000000, 1000000000));
            tabela1.inserirNaTabela(r);
        }
        System.out.println(tabela1.getColisoes());


    }
}
