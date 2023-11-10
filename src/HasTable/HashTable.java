package HasTable;

import LinkedList.DoubleLinkedList;
import LinkedList.DoubleLinkedListEOLException;

public class HashTable<T> {

	/**
	 * @param <T>
	 */
	public static class KVP<T> {
		private String key;
		private T value;
		private int rawHash;

		public KVP(String key, T value) {
			this.key = key;
			this.value = value;
			rawHash = rawHash(key);
		}

		/*
		 * M�todo que visa calcular o hash do objecto sem ter em conta o tamanho da
		 * tabela
		 * este m�todo � est�tico para o tornar acess�vel sem que para isso se tenha de
		 * criar um objecto.
		 * �til para pesquisar elementos.
		 */
		public static int rawHash(String key) {
			int hashValue = 0;

			for (int i = 0; i < key.length(); i++) {
				int charCode = key.charAt(i) - 96;
				hashValue = hashValue * 27 + charCode;
			}
			return hashValue;
		}

		public String getKey() {
			return key;
		}

		public int getRawHash() {
			return rawHash;
		}

		public T getValue() {
			return value;
		}

		@Override
		public String toString() {
			return key + " " + value + " " + rawHash;
		}
	}

	private DoubleLinkedList<KVP<T>> hashTable[];
	private int count, size, threshold;
	private double loadFactor;
	private final double DEFAULT_LOADFACTOR = 0.75;

	@SuppressWarnings("unchecked")
	/*
	 * Construtor da classe que inicializa o loadFactor, threshold e size.
	 * se n�o se receber nenhum valor para o loadFactor por par�metro, ent�o
	 * usamos o valor da constante como default.
	 */
	public HashTable(int size, double... loadFactor) {
		this.size = size;
		hashTable = new DoubleLinkedList[this.size];
		if (loadFactor.length != 0) {
			this.loadFactor = loadFactor[0];
			this.threshold = (int) (this.loadFactor * this.size);
		} else {
			this.threshold = (int) (DEFAULT_LOADFACTOR * this.size);
		}
	}

	/*
	 * M�todo respons�vel por garantir que o hash calculado esteja dentro do
	 * intervalo
	 * legal da tabela
	 */
	public int compressFunction(int rawHas) {
		return Math.abs(rawHas) % this.size;
	}

	/*
	 * M�todo para redimensionar a tabela
	 * assim que o threshold for atingido.
	 */
	private void resizeTable() {
		this.size *= 2;
		if (this.loadFactor != 0)
			this.threshold = (int) (this.loadFactor * this.size);
		else
			this.threshold = (int) (this.DEFAULT_LOADFACTOR * this.size);

		@SuppressWarnings("unchecked")
		DoubleLinkedList<KVP<T>> newTable[] = new DoubleLinkedList[size];
		for (DoubleLinkedList<KVP<T>> bucket : hashTable) {
			if (bucket != null) {
				for (KVP<T> kvp : bucket) {
					int idx = compressFunction(kvp.getRawHash());
					if (newTable[idx] == null)
						newTable[idx] = new DoubleLinkedList<HashTable.KVP<T>>();
					newTable[idx].insert(newTable[idx].begin(), kvp);
				}
			}
		}

		hashTable = newTable;
	}

	/*
	 * M�todo respons�vel por encontrar um elemento com a chave igual a recebida por
	 * par�metro.
	 * Este m�todo retorna null no caso em que o elemento procurado n�o �
	 * encontrado.
	 */
	public KVP<T> find(String key) {
		int rawHash = KVP.rawHash(key);
		int idx = compressFunction(rawHash);
		DoubleLinkedList<KVP<T>> bucket = hashTable[idx];

		if (bucket != null) {
			for (KVP<T> kvp : bucket) {
				if (kvp.getKey().equals(key))
					return kvp;
			}
		}
		return null;
	}

	/*
	 * M�todo que insere um elemento na tabela
	 * e incrementa o count.
	 * se o count for igual ao threshold ent�o a tabela � redimensionada.
	 */
	public void add(String key, T value) throws HashTableEETException {
		if (find(key) != null)
			throw new HashTableEETException("101 - Elemento existe na TH!!");
		this.count++;
		if (this.threshold == this.count)
			resizeTable();
		KVP<T> newElement = new KVP<>(key, value);
		int idx = compressFunction(KVP.rawHash(key));
		DoubleLinkedList<KVP<T>> bucket = hashTable[idx];

		if (bucket == null)
			bucket = new DoubleLinkedList<HashTable.KVP<T>>();
		bucket.insert(bucket.begin(), newElement);
		hashTable[idx] = bucket;
	}

	/*
	 * M�todo respons�vel pela remo��o de um elemento da tabela
	 * este m�todo tamb�m decrementa o valor de count.
	 */
	public void remove(String key) throws HashTableENETException {
		KVP<T> elementToRemove = find(key);
		if (elementToRemove == null)
			throw new HashTableENETException("201 - Elemento inexistente na TH!!");
		count--;

		int idx = compressFunction(KVP.rawHash(key));
		DoubleLinkedList<KVP<T>> bucket = hashTable[idx];
		int i = -1;
		for (KVP<T> kvp : bucket) {
			i++;
			if (kvp.getKey().equals(key))
				break;
		}
		try {
			if (i == 0)
				bucket.remove(bucket.begin());
			else
				bucket.remove(bucket.nth(i - 1));
		} catch (DoubleLinkedListEOLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (bucket.lenght() == 0)
			hashTable[idx] = null;
	}

	/*
	 * M�todo respons�vel por retornar o valor
	 * do elemento kvp recebido por par�metro
	 */
	public T get(KVP<T> p) {
		if (p != null)
			return p.getValue();
		return null;
	}

	@Override
	public String toString() {
		String str = "";
		int idx = -1;
		for (DoubleLinkedList<KVP<T>> bucket : hashTable) {
			str += "[" + (++idx) + "] => ";
			if (bucket != null)
				str += bucket.toString() + "\n";
			else
				str += "\n";
		}
		return str;
	}
}
