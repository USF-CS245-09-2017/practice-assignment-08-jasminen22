public class BST<T extends Comparable<T>> {
	
	class BSTNode{
		Comparable data;
		BSTNode left;
		BSTNode right;
		private BSTNode(Comparable value){
			data = value;
		}
	}

	private BSTNode root;
	//calls private find
	public boolean find(Comparable value){
		return find(root, value);
	}
	private boolean find(BSTNode node, Comparable value) {
		//BASE CASE
		if(node == null)
			return false;
		//if node = value return true
		if(node.data.compareTo(value) == 0){
			return true;
		}
		//if node > value
		else if(node.data.compareTo(value) > 0){
			return find(node.left, value);
		}
		//if node < value
		else{
			return find(node.right, value);
		}

	}
	//calls private insert
	public void insert(Comparable value){
		root = insert(root, value);
	}
	private BSTNode insert(BSTNode node, Comparable value) {
		if(node == null) {
			BSTNode n = new BSTNode(value);
				return n;
		} 
		//if node > value
		else if(node.data.compareTo(value) > 0) {
			node.left = insert(node.left, value);
		} 
		//if node < value
		else {
			node.right = insert(node.right, value);
		} 
		return node;
	}
	//calls private print
	public void print(){
		print(root);
	}
	private void print(BSTNode node){
		if(node != null) {
			print(node.left);
			System.out.println(node.data);
			//node.data
			print(node.right);
		}
	}
	//calls private delete
	public void delete(Comparable value){
		root = delete(root, value);
	}
	private BSTNode delete(BSTNode node, Comparable value){
		if (node == null){
			return null;
		}
		//if node is value
		if(node.data.compareTo(value) == 0){ 
			if (node.left == null){ 
				return node.right;
			} else if (node.right == null){ 
				return node.left;
			} else {
				if(node.right.left == null){
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				} else {
					node.data = removeSmallest(node.right);
					return node;
				}
			}

		} 
		//if node < value
		else if (node.data.compareTo(value) < 0){
			node.right = delete(node.right, value);
		} 
		//if node > value
		else { 
			node.left = delete(node.left, value);
		}
		return node;
	}
	private Comparable removeSmallest(BSTNode node){
		if (node.left.left == null){
			Comparable smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		} else {
			return removeSmallest(node.left);
		}
	}
}