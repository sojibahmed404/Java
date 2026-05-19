
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title, author;
    boolean isBorrowed = false;

    Book(String t, String a) { 
        title = t; 
        author = a; 
    }
}

public class Library {
    public static void main(String[] args) {
        ArrayList<Book> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

       
        list.add(new Book("Java Basics", "Herbert Schildt"));
        list.add(new Book("Data Structures", "Robert Lafore"));

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book ");
            System.out.println("2. Borrow Book ");
            System.out.println("3. Return Book ");
            System.out.println("4. Display Books ");
            System.out.println("5. Exit ");
            System.out.print("Enter choice : ");
            
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 5) {
                System.out.println("Program terminated.");
                break;
            }

            if (choice == 1) {
                System.out.print("Enter Title: "); 
                String t = sc.nextLine();
                System.out.print("Enter Author: "); 
                String a = sc.nextLine();
                list.add(new Book(t, a));
                System.out.println("Book Added Successfully!");
            } 
            else if (choice == 2 || choice == 3) {
                System.out.print("Enter Book Title: "); 
                String t = sc.nextLine();
                boolean found = false;
                
                for (Book b : list) {
                    if (b.title.equalsIgnoreCase(t)) {
                        found = true;
                        if (choice == 2 && !b.isBorrowed) { 
                            b.isBorrowed = true; 
                            System.out.println("Successfully Borrowed!"); 
                        }
                        else if (choice == 3 && b.isBorrowed) { 
                            b.isBorrowed = false; 
                            System.out.println("Successfully Returned!"); 
                        }
                        else {
                            System.out.println("Not possible! Check if the book is already borrowed or not.");
                        }
                    }
                }
                if (!found) System.out.println("Book not found!");
            } 
            else if (choice == 4) {
                System.out.println("\n--- Available Books ---");
                boolean anyAvailable = false;
                for (Book b : list) {
                    if (!b.isBorrowed) {
                        System.out.println("- " + b.title + " by " + b.author);
                        anyAvailable = true;
                    }
                }
                if (!anyAvailable) System.out.println("No books available right now.");
            }
            else {
                System.out.println("Invalid choice! Try again.");
            }
        }
        sc.close();
    }
}