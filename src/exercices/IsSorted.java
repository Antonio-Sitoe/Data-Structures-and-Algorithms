package exercices;



public class IsSorted {
    public static void main(String[] args) {
        int[] alotNumber = {1,2,3,4,5,6,7,20,8,9,10};
        boolean isSorted = false;


        for (int i = 0; i < alotNumber.length-1; i++) {
            if(alotNumber[i] < alotNumber[i+1]){
                System.out.println("Ordem "+ alotNumber[i]);
                isSorted=true;
            }else {
                System.out.println("NAO ESTA "+ alotNumber[i]);
                isSorted=false;
                break;
            }

        }

    }
}
