package datastructure.traversingbinarytree;

import java.util.Stack;

public class BinaryTree_Stack {

	/*
	 * 
	 * 二叉树先序中序后序排序 方式：采用非递归方式。
	 */

	// 注意必须逆序简历，先建立子节点，再逆序往上建立，
	// 因为非叶子节点会使用到下面的节点，而初始化是按顺序初始化得，不逆序建立会报错
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
		return A; // 返回根节点
	}

	// 打印节点数值
	public static void printNode(Node node) {
		System.out.print(node.getData());
	}

	public static void preOrder_stack(Node root) {// 先序遍历

		Stack<Node> stack = new Stack<Node>();
		Node node = root;

		while (node != null || stack.size() > 0) {// 将所有左孩子压栈
			if (node != null) {// 压栈之前先访问
				printNode(node);
				stack.push(node);
				node = node.getLeftNode();

			} else {
				node = stack.pop();
				node = node.getRightNode();
			}
		}
	}

	public static void inOrder_Stack(Node root) {// 中序遍历

		Stack<Node> stack = new Stack<Node>();
		Node node = root;

		while (node != null || stack.size() > 0) {
			if (node != null) {
				stack.push(node);// 直接压栈
				node = node.getLeftNode();
			} else {
				node = stack.pop();// 出栈并访问
				printNode(node);
				node = node.getRightNode();
			}
		}
	}

	public static void postOrder_Stack(Node root) {// 后续遍历

		Stack<Node> stack = new Stack<Node>();
		Stack<Node> output = new Stack<Node>();// 构造一个中间栈来存储逆后续遍历的结果
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

		System.out.println("先序遍历");
		preOrder_stack(root);
		System.out.println("");

		System.out.println("中序遍历");
		inOrder_Stack(root);
		System.out.println("");

		System.out.println("后序遍历");
		postOrder_Stack(root);
		System.out.println("");
	}

}