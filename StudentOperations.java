import java.sql.*;
import java.util.*;

public class StudentOperations {

  // Database connection details – update as needed
  private static final String URL = "jdbc:mysql://localhost:3306/your_database";
  private static final String USER = "your_username";
  private static final String PASSWORD = "your_password";

  public static void insertStudent() {
    try {
      Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
      PreparedStatement stmt = conn.prepareStatement(
          "INSERT INTO student (PRN, name, branch, batch, cgpa) VALUES (?, ?, ?, ?, ?)");

      Scanner scan = new Scanner(System.in);

      System.out.println("Enter PRN: ");
      int prn = scan.nextInt();
      scan.nextLine(); // consume newline

      System.out.println("Enter name: ");
      String name = scan.nextLine();

      System.out.println("Enter branch: ");
      String branch = scan.nextLine();

      System.out.println("Enter batch: ");
      String batch = scan.nextLine();

      System.out.println("Enter CGPA: ");
      float cgpa = scan.nextFloat();

      stmt.setInt(1, prn);
      stmt.setString(2, name);
      stmt.setString(3, branch);
      stmt.setString(4, batch);
      stmt.setFloat(5, cgpa);

      int rowsInserted = stmt.executeUpdate();
      if (rowsInserted > 0) {
        System.out.println("Student added successfully.");
      }

      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void displayStudent() {
    try {
      Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM student");

      System.out.println("\nAll Students:");
      while (rs.next()) {
        System.out.println("PRN: " + rs.getInt("PRN"));
        System.out.println("Name: " + rs.getString("name"));
        System.out.println("Branch: " + rs.getString("branch"));
        System.out.println("Batch: " + rs.getString("batch"));
        System.out.println("CGPA: " + rs.getFloat("cgpa"));
        System.out.println("----------------------------");
      }

      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void deleteStudent() {
    try {
      Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
      PreparedStatement stmt = conn.prepareStatement("DELETE FROM student WHERE PRN = ?");

      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the PRN of the student to delete: ");
      int prn = scan.nextInt();

      stmt.setInt(1, prn);
      int rowsDeleted = stmt.executeUpdate();
      if (rowsDeleted > 0) {
        System.out.println("Student deleted successfully.");
      } else {
        System.out.println("No student found with the given PRN.");
      }

      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void searchByPRN() {
    try {
      Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
      PreparedStatement stmt = conn.prepareStatement("SELECT * FROM student WHERE PRN = ?");

      Scanner scan = new Scanner(System.in);
      System.out.println("Enter PRN to search: ");
      int prn = scan.nextInt();

      stmt.setInt(1, prn);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        System.out.println("\nStudent Found:");
        System.out.println("PRN: " + rs.getInt("PRN"));
        System.out.println("Name: " + rs.getString("name"));
        System.out.println("Branch: " + rs.getString("branch"));
        System.out.println("Batch: " + rs.getString("batch"));
        System.out.println("CGPA: " + rs.getFloat("cgpa") + "\n");
      } else {
        System.out.println("\nNo student found with PRN: " + prn);
      }

      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void searchByName() {
    try {
      Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
      PreparedStatement stmt = conn.prepareStatement("SELECT * FROM student WHERE name LIKE ?");

      try (Scanner scan = new Scanner(System.in)) {
        System.out.println("Enter name to search: ");
        String name = scan.nextLine();

        stmt.setString(1, "%" + name + "%"); // Allows partial matches
        ResultSet rs = stmt.executeQuery();

        boolean found = false;
        System.out.println("\nSearch Results:");
        while (rs.next()) {
          found = true;
          System.out.println("PRN: " + rs.getInt("PRN"));
          System.out.println("Name: " + rs.getString("name"));
          System.out.println("Branch: " + rs.getString("branch"));
          System.out.println("Batch: " + rs.getString("batch"));
          System.out.println("CGPA: " + rs.getFloat("cgpa") + "\n");
        }

        if (!found) {
          System.out.println("\nNo students found with name containing: " + name);
        }
      }
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void updateStudent() {
    try {
      Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
      PreparedStatement stmt = conn.prepareStatement(
          "UPDATE student SET name=?, branch=?, batch=?, cgpa=? WHERE PRN=?");

      try (Scanner scan = new Scanner(System.in)) {
        System.out.println("Enter PRN of student to update: ");
        int prn = scan.nextInt();
        scan.nextLine(); // Consume newline

        System.out.println("Enter new name: ");
        String name = scan.nextLine();

        System.out.println("Enter new branch: ");
        String branch = scan.nextLine();

        System.out.println("Enter new batch: ");
        String batch = scan.nextLine();

        System.out.println("Enter new CGPA: ");
        float cgpa = scan.nextFloat();

        stmt.setString(1, name);
        stmt.setString(2, branch);
        stmt.setString(3, batch);
        stmt.setFloat(4, cgpa);
        stmt.setInt(5, prn);
      }

      int rowsUpdated = stmt.executeUpdate();
      if (rowsUpdated > 0) {
        System.out.println("Student updated successfully!");
      } else {
        System.out.println("No student found with given PRN!");
      }

      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
}
