public class Main {
    public static void main(String[] args) {
        int[] lista = {6,8,12,15,32,54,64,67,70};
        int x =67;

        int i = 0, j = lista.length - 1;

        int k;

        while (i<=j){
            k = i + ((j - i)/2);
            if(x==lista[k]){
                System.out.println("esta no meio "+x);
                break;
            }
            if(x < lista[k]){
                System.out.println("Quebra o array "+lista[k]);
                j = k-1;
            }
            if(x > lista[k]){
                System.out.println("Quebra o array "+lista[k]);
                i = k + 1;
            }
        }
    }
}
