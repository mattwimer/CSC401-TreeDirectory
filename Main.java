import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        if(args.length != 0){

        }
        else{
            Scanner in = new Scanner(System.in);
            System.out.println("Please enter a directory to read from: ");
            String path = in.nextLine();
            File f = new File(path);
            File[] files = f.listFiles();

        }
    }

    public static TreeNode createTree(String path){
        File f = new File(path);
        File[] files;
        if(!f.isDirectory())
            return null;
        else
            files = 
        TreeNode root = new TreeNode(f.getName());
        
        return null;
    }
}
