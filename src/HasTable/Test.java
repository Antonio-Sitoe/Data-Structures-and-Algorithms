package HasTable;
public class Test {

	public static void main(String[] args) {
		HashTable<Integer> tabela = new HashTable<Integer>(10);
		try {
			tabela.add(Integer.toString(10), 10);
			tabela.add(Integer.toString(20), 20);
			tabela.add(Integer.toString(30), 30);
			tabela.add(Integer.toString(40), 40);
			tabela.add(Integer.toString(50), 50);
			tabela.add(Integer.toString(60), 60);
			tabela.add(Integer.toString(70), 70);
			tabela.add(Integer.toString(80), 80);
			tabela.add(Integer.toString(90), 90);
			tabela.add(Integer.toString(100), 100);
			tabela.add(Integer.toString(21), 21);
		} catch (HashTableEETException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabela.remove(Integer.toString(30));
			tabela.remove(Integer.toString(50));
		} catch (HashTableENETException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(tabela.toString());

	}

}
