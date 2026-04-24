import java.sql.*;
import java.util.Scanner;

public class EmployeeApp {

    static final String URL = "jdbc:mysql://localhost:3306/employee_management";
    static final String USER = "root";
    static final String PASS = "KIIT@123";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Driver error: " + e);
        }

        while (true) {
            System.out.println("\n===== Employee System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Batch Insert");
            System.out.println("6. Max Salary");
            System.out.println("7. Max Age");
            System.out.println("8. Exit");

            System.out.print("Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> addEmployee();
                case 2 -> displayAll();
                case 3 -> updateEmployee();
                case 4 -> deleteEmployee();
                case 5 -> batchInsert();
                case 6 -> maxSalary();
                case 7 -> maxAge();
                case 8 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    static void addEmployee() {
        try (Connection con = getConnection()) {
            System.out.print("ID: "); int id = sc.nextInt();
            System.out.print("Name: "); String name = sc.next();
            System.out.print("Salary: "); double sal = sc.nextDouble();
            System.out.print("Dept: "); String dept = sc.next();
            System.out.print("Gender: "); String gender = sc.next();
            System.out.print("DOB (YYYY-MM-DD): "); String dob = sc.next();

            String sql = "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, sal);
            ps.setString(4, dept);
            ps.setString(5, gender);
            ps.setDate(6, java.sql.Date.valueOf(dob));

            ps.executeUpdate();
            System.out.println("Employee Added!");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    static void displayAll() {
        try (Connection con = getConnection()) {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM employees");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " +
                        rs.getString(2) + " | " +
                        rs.getDouble(3) + " | " +
                        rs.getString(4) + " | " +
                        rs.getString(5) + " | " +
                        rs.getDate(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void updateEmployee() {
        try (Connection con = getConnection()) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.print("New Salary: ");
            double sal = sc.nextDouble();

            String sql = "UPDATE employees SET salary=? WHERE eno=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, sal);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Updated!" : "Not found");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void deleteEmployee() {
        try (Connection con = getConnection()) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM employees WHERE eno=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Deleted!" : "Not found");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void batchInsert() {
        try (Connection con = getConnection()) {
            System.out.print("How many? ");
            int n = sc.nextInt();

            String sql = "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            for (int i = 0; i < n; i++) {
                System.out.print("ID: "); int id = sc.nextInt();
                System.out.print("Name: "); String name = sc.next();
                System.out.print("Salary: "); double sal = sc.nextDouble();
                System.out.print("Dept: "); String dept = sc.next();
                System.out.print("Gender: "); String gender = sc.next();
                System.out.print("DOB: "); String dob = sc.next();

                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setDouble(3, sal);
                ps.setString(4, dept);
                ps.setString(5, gender);
                ps.setDate(6, java.sql.Date.valueOf(dob));

                ps.addBatch();
            }

            ps.executeBatch();
            System.out.println("Batch inserted!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void maxSalary() {
        try (Connection con = getConnection()) {
            ResultSet rs = con.createStatement()
                    .executeQuery("SELECT * FROM employees ORDER BY salary DESC LIMIT 1");

            if (rs.next()) {
                System.out.println("Max Salary Employee: " + rs.getString("ename") + " → " + rs.getDouble("salary"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void maxAge() {
        try (Connection con = getConnection()) {
            ResultSet rs = con.createStatement()
                    .executeQuery("SELECT * FROM employees ORDER BY dob ASC LIMIT 1");

            if (rs.next()) {
                System.out.println("Oldest Employee: " + rs.getString("ename") + " → " + rs.getDate("dob"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}