package algoritmos.SelectionSort;

public class Teste01 {
    public static void main(String[] args) {
        int [] lista = {0,8,3,9,2,5,10};
        int aux;
        System.out.println(lista.length);

        for (int i = 0; i <lista.length ; i++) {
            for (int j = 0; j < lista.length-1; j++) {
                if(lista[j]>lista[j+1]){
                    aux=lista[j];
                    lista[j]=lista[j+1];
                    lista[j+1]=aux;
                }
            }
        }
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i]+",");
        }

       /* for (int i = 0; i <lista.length ; i++) {
            System.out.println(lista[i]);
        }*/
    }
}
