import java.io.*;
import java.util.*;

/**
 * A model for the game of 20 questions
 *
 * @author Rick Mercer
 */
public class GameTree {
	private class Node {
		String val;
		Node left, right;

		public Node(String val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	private Node root;
	private String fileName;
	private Node curr;

	/**
	 * Constructor needed to create the game.
	 *
	 * @param fileName
	 *                 this is the name of the file we need to import the game
	 *                 questions
	 *                 and answers from.
	 */
	public GameTree(String fileName) throws FileNotFoundException {
		Scanner fr = new Scanner(new File(fileName));
		this.fileName = fileName;

		this.root = buildTree(fr);
		this.curr = this.root;
	}

	private Node buildTree(Scanner sc) {
		if (sc.hasNextLine()) {
			Node node = new Node(sc.nextLine().trim());
			if (node.val.charAt(node.val.length() - 1) == '?') {
				return node;
			}
			node.left = buildTree(sc);
			node.right = buildTree(sc);
			return root;
		}
		return null;
	}

	/*
	 * Add a new question and answer to the currentNode. If the current node has
	 * the answer chicken, theGame.add("Does it swim?", "goose"); should change
	 * that node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQ
	 *             The question to add where the old answer was.
	 * @param newA
	 *             The new Yes answer for the new question.
	 */
	public void add(String newQ, String newA) {
		String curr = this.curr.val;
		this.curr.val = newQ;
		this.curr.left = new Node(newA);
		this.curr.right = new Node(curr);
	}

	/**
	 * True if getCurrent() returns an answer rather than a question.
	 *
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
	public boolean foundAnswer() {
		return curr.val.charAt(curr.val.length() - 1) != '?' ? false : true;
	}

	/**
	 * Return the data for the current node, which could be a question or an
	 * answer. Current will change based on the users progress through the game.
	 *
	 * @return The current question or answer.
	 */
	public String getCurrent() {
		return (curr != null) ? curr.val : "";
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or
	 * right for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 *
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo) {
		if (yesOrNo.equals(Choice.Yes)) {
			curr = curr.left;
			return;
		}
		curr = curr.right;
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the question
	 * at the root of this GameTree.
	 */
	public void reStart() {

	}

	@Override
	public String toString() {
		return toString(this.root, "");
	}

	private String toString(Node node, String c) {
		return (node == null) ? "" : toString(node.right, c + "-") + node.val + toString(node.left, "-" + c);
	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may
	 * have new questions added since the game started.
	 *
	 */
	public void saveGame() {

	}
}
