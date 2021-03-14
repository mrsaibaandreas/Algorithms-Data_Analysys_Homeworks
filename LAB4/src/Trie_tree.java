class Node {
    boolean end;//it marks if the end of the string has been reached
    Node[] children = new Node[26];//all the letters of the alphabet

    Node() {
        for (Node el : children) {//we set all children to null
            el = null;
        }
        end = false;//set the end to false, because the end has not been reached
    }

}

class Trie_tree {
    Node root;

    Trie_tree() {
        root = new Node();
    }

    public int getIndex(char letter, int where) {
        char lower_case_char = Character.toLowerCase(letter);
        int position = (int) lower_case_char - 96;
        return position;
    }

    public void insert(String word) {
        Node actual_node = root;
        int length = word.length();
        char[] char_word = word.toCharArray();
        for (int i = 0; i < length; i++) {
            int position = getIndex(char_word[i], i);
            if (actual_node.children[position] == null)
                actual_node.children[position] = new Node();
            actual_node = actual_node.children[position];
        }
        actual_node.end = true;

    }
    public void display(Node root, char[] my_string, int tree_level)
    {

        if(root.end)
            System.out.println(my_string);
        for(int i = 0 ; i < 26; i++)
        {
            if(root.children[i] != null)
            {
                my_string[tree_level] = (char) (i + 96);
                display(root.children[i], my_string, tree_level+1);
            }
        }
    }
}

class Main{
    public static void main(String[] args)
    {
        Trie_tree tree = new Trie_tree();
        tree.insert("blabla");
        tree.insert("blead");
        tree.insert("aada");
        char[] string = new char[20];//set empty string
        tree.display(tree.root, string, 0);
    }
}