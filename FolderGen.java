//pf_tiger "Booleans and conditions"
// Requirement:
/* Write a Java program which contains a WHILE loop. 
Prompt user for input which determines the number of times the loop repeats.
The program should display some output for each iteration but it should be more than just an increment.*/

// <About this program:>
// The program prompts the number for folders to be created in the while loop. 
// Then creates input numbers of folders in the current working directory depending on the number of the input

// import requirement
import java.util.Scanner;
import java.io.File; // File class 

// main class
public class FolderGen {
    public static void main (String[] args) {
        // Initiate the scanner
        Scanner input = new Scanner(System.in);

        // Indicate that the program has starteed
        System.out.println("----------------------folder maker----------------------");
        System.out.println("CAUTION: This program may delete a directory in your computer");

        // Get the current directory
        String cwd="";
        // . denotes current working directory
        File file=new File(".");
        cwd=file.getAbsolutePath();
        System.out.println("Current working directory is : "+ cwd);

        System.out.print("Get yourself some unecessary folders! How many do you want?(int):");
        int reps = input.nextInt(); // number of reps in while loop

        // create a directory for this program so that the directory does not get messy
        String fld_name = "CMIS141_wk4d";
        File rootfolder = new File(fld_name);

        boolean fl_existence = rootfolder.exists(); // checks if there is a directory with the same name in the current path

        if (! fl_existence) {
            rootfolder.mkdir();
            System.out.println("Directory " + fld_name + " created successfully");
            System.out.println("Path: "+ cwd + fld_name);
        } else {
            boolean ynok = false;
            while (!ynok) {
                System.out.print("There already is a directory called: " + fld_name + ". Do you want to delete it and create a new one? (y/n): ");
                input.nextLine();
                String del_ans = input.nextLine();

                switch (del_ans) {
                    case "y":
                        // delete the pre-existed directory and recreates a new one with the same name
                        rootfolder.delete();
                        rootfolder.mkdir();
                        System.out.println("Directory " + fld_name + " created successfully after deleting the old one");
                        System.out.println("Path: "+ cwd + fld_name);
                        ynok = true;
                        break;

                    case "n":
                        // quit the program without any actions except showing a message
                        System.out.println("QUITTING!!!");
                        ynok = true;
                        break;
                    
                    default:
                        System.out.println("ERROR: Please respond with y or n.");
                        break;
                }
            }
        }

        int reps_start = 0; // base value
        while (reps_start < reps) {
            // create directories and notify the user via message
            String fld_subname = "Week" + (reps_start + 1); // this will be the folder name for coming up subdirectories under directory "fld_name"
            
            File subdir = new File(cwd+"/"+fld_name+"/"+fld_subname);
            subdir.mkdir();
            System.out.println((reps_start + 1) + ". Directory " + fld_subname + " created successfully");
            reps_start++; //add the number to the base value reps_start
        
        }

        // indicate that the program has got out of the while loop process
        System.out.println( reps + " times: Done!");
        input.close();

    }

}
