package trabalho1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Exercicio1 {


    public static void main(String[] args) {
       String[] a = new String[10];
       a[0] = "António";
       a[1] = "Vagner";
       a[2] = "Titos";
       a[3] = "Maria";

       String[] b = new String[8];
       b[0] = "Bento";
       b[1] = "Sebas";
       b[2] = "Joana";
       b[3] = "Merinda";
       b[4] = "Laura";

        a[a.length-1]="Pedro";
        System.out.println("a) Adicionar o novo estudante “Pedro” no fim da lista A  "+ a[a.length-1]);

        int quantityStudets=0;
        for (var count : a) {
            if(count != null){
                quantityStudets = quantityStudets+1;
            }
        }
        System.out.println("b) Aquantidade de estudantes da lista A  "+ quantityStudets);

        String[] c = new String[8];
        c[0] = "sheila";
         for (int i = 0; i < b.length; i++) {
             if(b[i] != null){
                 c[i+1] = b[i];
             }
         }
        b = c.clone();
        System.out.println("c) Adicionar a nova estudante “Sheila” no inicio da lista B (Sem excluir o Bento da\n" +
                "lista) "+ Arrays.toString(b));

        String[] d = new String[10];
        for (int i = 0, k=0; i < a.length; i++) {
            if(a[i] != null & a[i]=="Maria"){
                b[b.length-2] = a[i];
            } else {
                d[k] = a[i];
                k++;
            }
        }
        a = d.clone();
        System.out.println("d) Transferir a Maria da turma A para B ");
        System.out.println("     A "+ Arrays.toString(a));
        System.out.println("     B "+ Arrays.toString(b));

        String[] f = new String[10];
        for (int i = 0, k=0; i < b.length; i++) {
            if((b[i] != null) & (b[i] != "Sebas")){

                f[k] = b[i];
                k++;
            }
        }
        b = f.clone();

        System.out.println("f) Imprimir a lista B ");
        for (int i = 0; i < b.length; i++) {
            System.out.println("   "+ i + " " + b[i]);
        }
        System.out.println("g) Verificar se a Maria faz parte da lista B");
        boolean isTrue=false;
        for (int i = 0; i < b.length; i++) {
            if(b[i]=="Maria"){
                isTrue=true;
            }
         }
        System.out.println("  Maria existe: " + ((isTrue == true) ? "Sim" : "Nao"));
        
    }
}
