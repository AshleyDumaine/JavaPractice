package AdvancedDataStructures;
import java.util.HashMap;

public class TrieNode {
	private char _letter; //data
	// hashmap of children where key is character and the value is the trienode ds
	private HashMap<Character, TrieNode> _children;
	private boolean _isEndOfWord;

	public TrieNode(char letter) {
		_letter = letter;
		_isEndOfWord = false;
		_children = new HashMap<Character, TrieNode>();
	}

	public char letter() {
		return _letter;
	}

	public boolean isEndOfWord() {
		return _isEndOfWord;
	}

	public HashMap<Character, TrieNode> children() {
		return _children;
	}

	public void setIsEndOfWord(boolean isEndOfWord) {
		_isEndOfWord = isEndOfWord;
	}
}