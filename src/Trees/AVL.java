package TAD.AVL;

import TAD.AVL.EXCEPTIONS.AVLENFException;

public class AVL <T>{

	private static class Node<T>{
		private int key, hight, bf, deth;
		private T data;
		private Node<T> left, right;
		
		public Node(int key, T data) {
			this.key=key;
			this.data=data;
		}
		
		@Override
		public String toString() {
			return key+" "+data.toString();
		}
		
		public boolean equals(Node<T> element) {
			return super.equals(element);
		}

		public int getHight() {
			return hight;
		}

		public void setHight(int hight) {
			this.hight = hight;
		}

		public int getBf() {
			return bf;
		}

		public void setBf(int bf) {
			this.bf = bf;
		}

		public int getKey() {
			return key;
		}

		public T getData() {
			return data;
		}

		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}

		public int getDeth() {
			return deth;
		}

		public void setDeth(int deth) {
			this.deth = deth;
		}
	}
	
	private Node<T> root, unbalanced;
	private String travessal;
	
	
	public Node<T> begin(){
		return root;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	private void hight() {
		hight(root);
	}

	private int hight(Node<T> runner) {
		if(runner == null)
			return -1;
		if(runner.getLeft()== null && runner.getRight()==null) {
			runner.setHight(0);
			runner.setBf(0);
		}else {
			int l=hight(runner.getLeft());
			int r=hight(runner.getRight());
			runner.setHight(max(l, r)+1);
			runner.setBf(l-r);
		}
		return runner.getHight();
	}

	private int max(int l, int r) {
		return (l > r)? l: r;
	}
	
	private Node<T> find(int key){
		 return find(root, key);
	}

	private Node<T>  find(Node<T> runner, int key) {
		if(runner == null || runner.getKey()==key) 
			return runner;
		
		if(runner.getKey()>key)
			return find(runner.getLeft(), key);
		return find(runner.getRight(), key);
	}
	
	public T search(int key){
		 return search(root, key);
	}

	private T search(Node<T> runner, int key) {
		if(runner == null || runner.getKey()==key) 
			return runner.getData();
		
		if(runner.getKey()>key)
			return search(runner.getLeft(), key);
		return search(runner.getRight(), key);
	}
	
	public String preOrder() {
		travessal="";
		preOrder(root);
		return travessal;
	}

	private void preOrder(Node<T> runner) {
		if(runner == null)
			return;
		
		travessal+=runner.getKey()+" "+runner.getBf()+" ";
		preOrder(runner.getLeft());
		preOrder(runner.getRight());
	}
	
	 
	public String inOrder() {
		travessal="";
		inOrder(root);
		return travessal;
	}

	private void inOrder(Node<T> runner) {
		if(runner == null)
			return;
		
		inOrder(runner.getLeft());
		travessal+=runner.getKey()+" ";
		inOrder(runner.getRight());
	}
	
	public String postOrder() {
		travessal="";
		postOrder(root);
		return travessal;
	}

	private void postOrder(Node<T> runner) {
		if(runner == null)
			return;
		
		postOrder(runner.getLeft());
		postOrder(runner.getRight());
		travessal+=runner.getKey()+" ";
	}
	
	private void checkUnbalanced() {
		unbalanced=null;
		checkUnbalanced(root);
	}
	
	private void checkUnbalanced(Node<T> runner) {
		
		if(runner == null)
			return;
		
		if(runner.getBf() < -1 || runner.getBf() > 1)
			if(unbalanced == null || unbalanced.getDeth() < runner.getDeth())
				unbalanced=runner;
			
		checkUnbalanced(runner.getLeft());
		checkUnbalanced(runner.getRight());
	}

	private Node<T> findParent(Node<T> runner, Node<T> child) {
		if(runner == null || runner.equals(child))
			return null;
		
		if(runner.getLeft().equals(child) || runner.getRight().equals(child))
			return runner;
		if(runner.getKey() > child.getKey())
			return findParent(runner.getLeft(), child);
		else
			return findParent(runner.getRight(), child);
	}
	
	public void insert(int key, T data) {
		if(isEmpty())
			root=new Node<>(key, data);
		else 
			insert(root, key, data);
		
		hight(root);	
		checkUnbalanced();
		
		if(unbalanced != null)
			if(unbalanced.getBf() < 0)
				if(unbalanced.getRight().getBf() < 0)
					//rotacao simples a esquerda
					simpleRotationToLeft();
				else
					//rotação dupla a esquerda
					dubleRotationToLeft();
			else
				if(unbalanced.getLeft().getBf() > 0)
					//rotação simples a direita
					simpleRotationToRight();
				else
					//rotação dupla a direita
					dubleRotationToRight();
	}
	
	private void simpleRotationToLeft() {
		Node<T> rightChild=unbalanced.getRight();
		unbalanced.setRight(rightChild.getLeft());
		rightChild.setLeft(unbalanced);
		
		Node<T> parent=findParent(root, unbalanced);
		
		if(parent==null)
			root=rightChild;
		else
			if(parent.getLeft().equals(unbalanced))
				parent.setLeft(rightChild);
			else
				parent.setRight(rightChild);
		hight();
	}
	
	private void simpleRotationToRight() {
		Node<T> leftChild=unbalanced.getLeft();
		unbalanced.setLeft(leftChild.getRight());
		leftChild.setRight(unbalanced);
		
		Node<T> parent=findParent(root, unbalanced);
		
		if(parent==null)
			root=leftChild;
		else
			if(parent.getLeft().equals(unbalanced))
				parent.setLeft(leftChild);
			else
				parent.setRight(leftChild);
		hight();
	}
	
	private void dubleRotationToLeft() {
		Node<T> rightChild=unbalanced.getRight();
		Node<T> leftGrandson = rightChild.getLeft();
		Node<T> parent=findParent(root, unbalanced);
		
		rightChild.setLeft(leftGrandson.getRight());
		unbalanced.setRight(leftGrandson);
		leftGrandson.setRight(rightChild);
		
		
		//rotação simples a esquerda
		unbalanced.setRight(leftGrandson.getLeft());
		leftGrandson.setLeft(unbalanced);
		
		if(parent==null)
			root=leftGrandson;
		else
			if(parent.getLeft().equals(unbalanced))
				parent.setLeft(leftGrandson);
			else
				parent.setRight(leftGrandson);
		hight();
	}
	
	private void dubleRotationToRight() {
		Node<T> leftChild=unbalanced.getLeft();
		Node<T> rightGrandson = leftChild.getRight();
		Node<T> parent=findParent(root, unbalanced);
		
		leftChild.setRight(rightGrandson.getLeft());
		unbalanced.setLeft(rightGrandson);
		rightGrandson.setLeft(leftChild);
		
		
		//rotação simples a esquerda
		unbalanced.setLeft(rightGrandson.getRight());
		rightGrandson.setRight(unbalanced);
		
		if(parent==null)
			root=rightGrandson;
		else
			if(parent.getLeft().equals(unbalanced))
				parent.setLeft(rightGrandson);
			else
				parent.setRight(rightGrandson);
		hight();
	}
	

	private void insert(Node<T> runner, int key, T data) {
		if(runner.getKey() > key)
			if(runner.getLeft() !=null)
				insert(runner.getLeft(), key, data);
			else {
				//System.out.println("left of "+runner.getKey()+" "+key);
				runner.setLeft(new Node<>(key, data));
				runner.getLeft().setDeth(runner.getDeth()+1);
			}
		else
			if(runner.getRight() != null)
				insert(runner.getRight(), key, data);
			else {
				//System.out.println("right of "+runner.getKey()+" "+key);
				runner.setRight(new Node<>(key, data));
				runner.getRight().setDeth(runner.getDeth()+1);
			}
	}
	
	public void remove(int key) throws AVLENFException {
		Node<T> deletedNode = find(key);
		
		if(deletedNode == null)
			throw new AVLENFException("Elemento não existe na AVL");
		
		Node<T> parent=findParent(root, deletedNode);
		if(deletedNode.getLeft() == deletedNode.getRight()) 
			if(parent == null)
				root = null;
			else
				if(parent.getLeft().equals(deletedNode))
					parent.setLeft(null);
				else
					parent.setRight(null);
		else if(deletedNode.getLeft()==null || deletedNode.getRight() == null)
			if(deletedNode.getLeft()==null)
				if(parent.getLeft().equals(deletedNode))
					parent.setLeft(deletedNode.getRight());
				else
					parent.setRight(deletedNode.getRight());
			else
				if(parent.getLeft().equals(deletedNode))
					parent.setLeft(deletedNode.getLeft());
				else
					parent.setLeft(deletedNode.getLeft());
		else {
			Node<T> aptChild = findAptChild(deletedNode.getRight());
			Node<T> aptParent = findParent(root, aptChild);
			aptParent.setLeft(aptChild.getRight());
			
			aptChild.setLeft(deletedNode.getLeft());
			aptChild.setRight(deletedNode.getRight());
			
			if(parent == null)
				root = aptChild;
			else
				if(parent.getLeft().equals(deletedNode))
					parent.setLeft(aptChild);
				else
					parent.setRight(aptChild);
		}
		
		hight(root);	
		checkUnbalanced();
		
		if(unbalanced != null)
			if(unbalanced.getBf() < 0)
				if(unbalanced.getRight().getBf() < 0)
					//rotacao simples a esquerda
					simpleRotationToLeft();
				else
					//rotação dupla a esquerda
					dubleRotationToLeft();
			else
				if(unbalanced.getLeft().getBf() > 0)
					//rotação simples a direita
					simpleRotationToRight();
				else
					//rotação dupla a direita
					dubleRotationToRight();
		
	}

	private Node<T> findAptChild(Node<T> runner) {
		
		if(runner.getLeft()==null)
			return runner;
		return findAptChild(runner.getLeft());
	}
}
