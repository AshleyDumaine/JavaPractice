package AdvancedDataStructures;
import java.util.HashMap;

public class Trie {
	private TrieNode _root;

	public Trie() {		
		_root = new TrieNode((char) 0); //null char
	}
	
	public void insert(String word) {
		// convert word into char array
		// for each character in the char array
		// get the children of the current char (initially root)
		// if any of the children is the same as the char, set the currentChar to the character
		// else the character needs to be added to the children, and this will become the currentChar
		// at end, set this to be the end of the word
		TrieNode currentChar = _root;
		for (char ch : word.toCharArray()) {
			HashMap<Character, TrieNode> children = currentChar.children();
			if (children.containsKey(ch)) {
				currentChar = children.get(ch);
			}
			else {
				TrieNode node = new TrieNode(ch);
				children.put(ch, node);
				currentChar = node;
			}
		}
		currentChar.setIsEndOfWord(true);
	}
	
	public boolean search(String word) {
		// convert word into char array
		// for each character in the char array
		// get the children of the current char (initially root)
		// if any of the children is the same as the char, set the currentChar to the character
		// else this string isn't in the trie
		// at end, check if this is considered a word in the trie 
		TrieNode currentChar = _root;
		for (char ch : word.toCharArray()) {
			HashMap<Character, TrieNode> children = currentChar.children();
			if (children.containsKey(ch)) {
				currentChar = children.get(ch);
			}
			else {
				return false;
			}
		}
		if (currentChar.isEndOfWord()) {
			return true;
		}
		return false;
	}
}
