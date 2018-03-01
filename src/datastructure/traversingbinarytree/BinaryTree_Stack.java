package datastructure.traversingbinarytree;

import java.util.Stack;

public class BinaryTree_Stack {

	/*
	 * 
	 * ��������������������� ��ʽ�����÷ǵݹ鷽ʽ��
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

	public static void preOrder_stack(Node root) {// �������

		Stack<Node> stack = new Stack<Node>();
		Node node = root;

		while (node != null || stack.size() > 0) {// ����������ѹջ
			if (node != null) {// ѹջ֮ǰ�ȷ���
				printNode(node);
				stack.push(node);
				node = node.getLeftNode();

			} else {
				node = stack.pop();
				node = node.getRightNode();
			}
		}
	}

	public static void inOrder_Stack(Node root) {// �������

		Stack<Node> stack = new Stack<Node>();
		Node node = root;

		while (node != null || stack.size() > 0) {
			if (node != null) {
				stack.push(node);// ֱ��ѹջ
				node = node.getLeftNode();
			} else {
				node = stack.pop();// ��ջ������
				printNode(node);
				node = node.getRightNode();
			}
		}
	}

	public static void postOrder_Stack(Node root) {// ��������

		Stack<Node> stack = new Stack<Node>();
		Stack<Node> output = new Stack<Node>();// ����һ���м�ջ���洢����������Ľ��
		Node node = root;
		while (node != null || stack.size() > 0) {
			if (node != null) {
				output.push(node);
				stack.push(node);
				node = node.getRightNode();
			} else {
				node = stack.pop();
				node = node.getLeftNode();
			}
		}

		while (output.size() > 0) {
			printNode(output.pop());
		}

	}

	public static void main(String[] args) {

		Node root = init();

		System.out.println("�������");
		preOrder_stack(root);
		System.out.println("");

		System.out.println("�������");
		inOrder_Stack(root);
		System.out.println("");

		System.out.println("�������");
		postOrder_Stack(root);
		System.out.println("");
	}

}