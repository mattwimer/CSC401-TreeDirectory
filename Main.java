import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        if(args.length != 0){ // if path is given by command line
            createTree(args[0]).print();
        }
        else{ // else if path was not given, prompt user for path to directory
            Scanner in = new Scanner(System.in);
            System.out.println("Please enter a directory to read from: ");
            String path = in.nextLine();           
            TreeNode tree = createTree(path);
            if(tree != null) 
                tree.print();
            else // tree is null if invalid path
                System.out.println("Invalid path.");
        }
    }

    public static TreeNode createTree(String path){ // recursive function
        File f = new File(path);
        File[] files;
        if(!f.exists() || !f.isDirectory()) // if invalid path
            return null;
        else
            files = f.listFiles();

        TreeNode root = new TreeNode(f.getName()); // create root of the tree or subtree

        for (File file : files) {
            if(file.isDirectory()) // if f contains a folder, create a subtree and add it to root
                root.addChild(createTree(file.getAbsolutePath())); 
            else // file is normal and can simply be added as child
                root.addChild(new TreeNode(file.getName())); 
        }
        return root;
    }
}
