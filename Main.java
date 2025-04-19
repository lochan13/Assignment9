import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("\nStudent Management System");
      System.out.println("1. Add Student");
      System.out.println("2. Display Students");
      System.out.println("3. Delete Student");
      System.out.println("4. Update Student");
      System.out.println("5. Search by PRN");
      System.out.println("6. Search by Name");
      System.out.println("7. Exit");

      System.out.print("Enter choice: ");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          StudentOperations.insertStudent();
          break;
        case 2:
          StudentOperations.displayStudent();
          break;
        case 3:
          StudentOperations.deleteStudent();
          break;
        case 4:
          StudentOperations.updateStudent();
          break;
        case 5:
          StudentOperations.searchByPRN();
          break;
        case 6:
          StudentOperations.searchByName();
          break;
        case 7:
          System.out.println("Exiting...");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice!");
          
      }
    }
  }
}
