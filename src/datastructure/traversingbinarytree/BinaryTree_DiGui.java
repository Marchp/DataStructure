package datastructure.traversingbinarytree;

public class BinaryTree_DiGui {

	/*
	 * ��������������������� ��ʽ���ݹ顣
	 */

	// ע���������������Ƚ����ӽڵ㣬���������Ͻ�����
	// ��Ϊ��Ҷ�ӽڵ��ʹ�õ�����Ľڵ㣬����ʼ���ǰ�˳���ʼ���ã����������ᱨ��
	public static Node init() {
		Node J = new Node(8, null, null);
		Node H = new Node(4, null, null);
		Node G = new Node(2, null, null);
		Node F = new Node(7, null, J);
		Node E = new Node(5, H, null);
		Node D = new Node(1, null, G);
		Node C = new Node(9, F, null);
		Node B = new Node(3, D, E);
		Node A = new Node(6, B, C);
		return A; // ���ظ��ڵ�
	}

	// ��ӡ�ڵ���ֵ
	public static void printNode(Node node) {
		System.out.print(node.getData());
	}

	// �������
	public static void preOrder(Node root) {

		printNode(root);// ��ӡ���ڵ�

		if (root.getLeftNode() != null) {// ʹ�õݹ��������
			preOrder(root.getLeftNode());
		}
		if (root.getRightNode() != null) {// ʹ�õݹ�����Һ���
			preOrder(root.getRightNode());
		}
	}

	// �������
	public static void inOrder(Node root) {

		if (root.getLeftNode() != null) {// ʹ�õݹ��������
			inOrder(root.getLeftNode());
		}

		printNode(root);// ��ӡ���ڵ�

		if (root.getRightNode() != null) {// ʹ�õݹ�����Һ���
			inOrder(root.getRightNode());
		}
	}

	// ��������
	public static void postOrder(Node root) {

		if (root.getLeftNode() != null) {// ʹ�õݹ��������
			postOrder(root.getLeftNode());
		}

		if (root.getRightNode() != null) {// ʹ�õݹ�����Һ���
			postOrder(root.getRightNode());
		}

		printNode(root);// ��ӡ���ڵ�
	}

	public static void main(String[] args) {
		// BinaryTree tree = new BinaryTree();//ע�͵����к����з������Ϊstatic
		Node root = init();

		System.out.println("�������");
		preOrder(root);
		System.out.println("");

		System.out.println("�������");
		inOrder(root);
		System.out.println("");

		System.out.println("�������");
		postOrder(root);
		System.out.println("");

	}

}