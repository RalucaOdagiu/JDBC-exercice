import com.sda.model.Department;
import com.sda.repository.DepartmentRepository;
import com.sda.service.DBService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DepartmentRepository departmentRepository = new DepartmentRepository();

       // Department department = createDepartmentFromKeyboard();
       // departmentRepository.insert (department);

       List<Department> departmentList = departmentRepository.findAll();
        System.out.println(departmentList);

       List<Department> departmentId = departmentRepository.findbyId();
        System.out.println(departmentId);

        List<Department> departmentName = departmentRepository.findByName();
        System.out.println(departmentName);

    }

    private static Department createDepartmentFromKeyboard() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("please insert department");
        String departmentName = scanner.next();
        System.out.println("please insert job title");
        String jobTitle = scanner.next();
        System.out.println("please insert salary");
        int salary = scanner.nextInt();

        int departmentId = 0;
        return new Department(departmentId, departmentName, jobTitle, salary);
    }

    private static void insertNormal() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please insert first name:");
        String firstName = scanner.next();
        System.out.println("please insert last name:");
        String lastName = scanner.next();

        Connection connection = DBService.getConnection();
        String sql = "insert into employees (employee_id, firstName, lastName) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,1234);
        preparedStatement.setString(2, firstName);
        preparedStatement.setString(3, lastName);


        int numarDeLiniiDinTabelAfectate = preparedStatement.executeUpdate();
        System.out.println("am modificat " + " " + numarDeLiniiDinTabelAfectate + " " + "linii");

    }
        public void selectNormal () throws SQLException {
            Connection connection = DBService.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from employees");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);

            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                System.out.println("Am gasit: " + firstName + " " + lastName);
            }
    }
}

