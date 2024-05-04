package pendencySystem.data;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	private TrieNode root = new TrieNode();

	public static class TrieNode {
		Map<String, TrieNode> children = new HashMap<>();
		int count = 0;

		public Map<String, TrieNode> getChildren() {
			return children;
		}

		public void setChildren(Map<String, TrieNode> children) {
			this.children = children;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

	}

	public TrieNode getRoot() {
		return root;
	}

	public void setRoot(TrieNode root) {
		this.root = root;
	}

}
