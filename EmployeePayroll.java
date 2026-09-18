import java.sql.*;
import java.util.Scanner;


public class EmployeePayroll{
    public static void main(String[] args) {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","password");

            System.out.println("database created ");

            Scanner s=new Scanner(System.in);
            int choice;

            do{
                System.out.println("1.Insert Employee");
                System.out.println("2.Display All Employees");
                System.out.println("3.Display Employees earning more than 50000");
                System.out.println("4.Increase IT employees salary by 10%");
                System.out.println("5.Delete employees without department");
                System.out.println("6.Exit");
                System.out.print("Enter your choice:");

                choice=s.nextInt();

                switch(choice)
                {
                    case 1:
                        {
                           
                        System.out.print("Enter employee name: ");
                        s.nextLine();
                        String name = s.nextLine();

                        System.out.print("Enter designation: ");
                        String designation = s.nextLine();

                        System.out.print("Enter salary: ");
                        float salary=s.nextFloat();
                        s.nextLine();

                        System.out.print("Enter department:");
                        String department = s.nextLine();
                        
                        String insert="INSERT INTO employee (emp_name,designation,salary,department) VALUES(?,?,?,?)";

                        PreparedStatement ps1=c.prepareStatement(insert);
                        ps1.setString(1,name);
                        ps1.setString(2,designation);
                        ps1.setFloat(3, salary);
                        ps1.setString(4,department);

                        ps1.executeUpdate();

                        System.out.println("emploee inserted");

                        ps1.close();
                        break;
                        }

                    case 2:
                        {
                        String select ="SELECT * FROM employee";

                        PreparedStatement ps2 = c.prepareStatement(select);

                        ResultSet rs = ps2.executeQuery();

                        System.out.println("\nEmployee Details:");

                        while (rs.next()) {

                            System.out.println(
                                rs.getInt("emp_id") + "  " +
                                rs.getString("emp_name") + "  " +
                                rs.getString("designation") + "  " +
                                rs.getFloat("salary") + "  " +
                                rs.getString("department")
                            );
                        }

                        rs.close();
                        ps2.close();

                        break;
                        }

                    case 3:
                    {
                        String highSalary ="SELECT * FROM employee WHERE salary > ?";

                        PreparedStatement ps3 =c.prepareStatement(highSalary);

                        ps3.setFloat(1, 50000);

                        ResultSet rs3 = ps3.executeQuery();

                        System.out.println("\nEmployees earning more than 50000:");

                        while (rs3.next()) {
                            System.out.println(rs3.getInt("emp_id") + "  " +
                                rs3.getString("emp_name") + "  " +
                                rs3.getString("designation") + "  " +
                                rs3.getFloat("salary") + "  " +
                                rs3.getString("department")
                            );
                        }

                        rs3.close();
                        ps3.close();

                        break;
                }

            case 4:
                {
                    String update ="UPDATE employee SET salary = salary * 1.10 WHERE department = ?";

                        PreparedStatement ps4 =c.prepareStatement(update);

                        ps4.setString(1, "IT");

                        int count = ps4.executeUpdate();

                        System.out.println(count +" IT employee(s) salary increased by 10%.");

                        ps4.close();
                        break;
                }

            case 5:
                {
                     String delete ="DELETE FROM employee WHERE department IS NULL";

                        PreparedStatement ps5 = c.prepareStatement(delete);

                        int deleted = ps5.executeUpdate();

                        System.out.println(deleted +"employee(s) without department deleted.");

                        ps5.close();
                        break;
                }

            case 6:
                {
                    System.out.println("exitng");
                    break;
                }
            }
        }while(choice!=6);

        c.close();
        s.close();
    }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}