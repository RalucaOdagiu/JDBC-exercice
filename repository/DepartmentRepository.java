package com.sda.repository;

import com.sda.model.Department;
import com.sda.service.DBService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository<Departments> {

    private String SQLState;

    public void insert(Department department) throws SQLException {


        //logica de preluare a datelor de pe obioectul primit ca parametru si inserarea unui row in tabelul department

        Connection connection = DBService.getConnection();
        String sql = "INSERT INTO departments (department_name, job_title, salary) values (?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, department.getDepartmentName());
        preparedStatement.setString(2, department.getJobTitle());
        preparedStatement.setInt(3, department.getSalary());

        int numarDeRanduriAfectateDeOperatie = preparedStatement.executeUpdate();

        if (numarDeRanduriAfectateDeOperatie == 0) {

            System.out.println("failed");

        } else
            System.out.println("successful");
    }

    // ex 2a
    public List<Department> findAll() throws SQLException {
        Connection connection = DBService.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from departments");
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Department> result = new ArrayList<Department>();

        while (resultSet.next()) {
            int departmentId = resultSet.getInt("department_id");
            String departmentName = resultSet.getString("department_name");
            String jobTitle = resultSet.getString("job_title");
            int salary = resultSet.getInt("salary");

            Department department = new Department(departmentId, departmentName, jobTitle, salary);
            result.add(department);

        }

            return result;
    }

    // ex 2b;
    public List<String> findbyId() throws SQLException {
        Connection connection = DBService.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select department_id from departments");
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> result = new ArrayList<String>();

        while (resultSet.next()) {
            int departmentId = resultSet.getInt("department_id");

            Department department;
            department = new Department(departmentId);
            result.add("department Id is: " + " " + departmentId);

   }
       return result;
    }

    public List<String> findByName()  throws SQLException {
        Connection connection = DBService.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from departments");
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> result = new ArrayList<String>();

        while (resultSet.next()) {
            String departmentName = resultSet.getString("department_name");

            Department department;
            department = new Department(departmentName);
            result.add("department Name is: " + " " + departmentName);

        }
        return result;
    }

    // ex 2c in DBService
    //public void deleteById(Department department) throws SQLException {

        //logica de preluare a datelor de pe obioectul primit ca parametru si inserarea unui row in tabelul department

       // Connection connection = DBService.getConnection();
       // String sql = "DELETE FROM departments where department_id=1";

       // PreparedStatement preparedStatement = connection.prepareStatement(sql);
      //  preparedStatement.setString(1, "1");
      //  int rowDeleted = preparedStatement.executeUpdate(sql);
       // if (rowDeleted > 0){
         //   System.out.println("am sters un row");}

    // ex 2e in DBService

   // public void update (Department department) throws SQLException {
      //  Connection connection = DBService.getConnection();
      //  String sql = "ALTER TABLE departments CHANGE COLUMN contabilitate financiar string";

       // PreparedStatement preparedStatement = connection.prepareStatement(sql);
       // int numarDeNumeSchimbate = preparedStatement.executeUpdate("ALTER TABLE departments" + "set department_name=financiar where department_id=2");
        //System.out.println("am modificat " + " " + numarDeNumeSchimbate + " " + "linii");
    //  }


    }







