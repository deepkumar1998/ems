package com.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ems.DatabaseConnectivity;

public class Employee {
	Scanner sc = new Scanner(System.in);

    public void addEmployee() {
        try (Connection con = DatabaseConnectivity.createConnection()) {
            Statement st = con.createStatement();

            System.out.println("Enter employee name: ");
            String empName = sc.nextLine();

            System.out.println("Enter employee designation: ");
            String designation = sc.nextLine();

            System.out.println("Enter employee salary: ");
            double salary = sc.nextDouble();

            sc.nextLine();

            System.out.println("Enter employee email: ");
            String email = sc.nextLine();

            System.out.println("Enter employee phone number: ");
            String phoneNo = sc.nextLine();

            System.out.println("Enter employee joining date (yyyy-MM-dd): ");
            String joiningDate = sc.nextLine();

            System.out.println("Enter employee role ID: ");
            int roleId = sc.nextInt();

            sc.nextLine(); 

            // System.out.println("Enter employee password: ");
            // String password = sc.nextLine();

            String insert = "INSERT INTO employee (emp_name, designation, salary, email, phone_no, joining_date, role_id) " +
                            "VALUES ('" + empName + "', '" + designation + "', " + salary + ", '" + email + "', '" + phoneNo + "', '" + joiningDate + "', " + roleId + " )";

            int row = st.executeUpdate(insert);
            System.out.println(row + " employee details added successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    public void modifyEmployee() {
        try (Connection con = DatabaseConnectivity.createConnection()) {
            Statement st = con.createStatement();

            System.out.println("Enter employee ID to update: ");
            int empId = sc.nextInt();

            sc.nextLine();

            System.out.println("Enter new employee name: ");
            String empName = sc.nextLine();

            System.out.println("Enter new employee designation: ");
            String designation = sc.nextLine();

            System.out.println("Enter new employee salary: ");
            double salary = sc.nextDouble();

            sc.nextLine();

            System.out.println("Enter new employee email: ");
            String email = sc.nextLine();

            System.out.println("Enter new employee phone number: ");
            String phoneNo = sc.nextLine();

            System.out.println("Enter new employee joining date (yyyy-MM-dd): ");
            String joiningDate = sc.nextLine();

            System.out.println("Enter new employee role ID: ");
            int roleId = sc.nextInt();

            

            String update = "UPDATE employee " +
                    "SET emp_name = '" + empName + "', " +
                    "designation = '" + designation + "', " +
                    "salary = " + salary + ", " +
                    "email = '" + email + "', " +
                    "phone_no = '" + phoneNo + "', " +
                    "joining_date = '" + joiningDate + "', " +
                    "role_id = " + roleId + ", " +
                    "WHERE emp_id = " + empId;

            int row = st.executeUpdate(update);
            System.out.println(row + " employee details updated successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    public void viewEmployees() {
        try (Connection con = DatabaseConnectivity.createConnection()) {
            Statement st = con.createStatement();

            String query = "SELECT * FROM employee";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println("Employee ID: " + rs.getInt("emp_id"));
                System.out.println("Employee Name: " + rs.getString("emp_name"));
                System.out.println("Designation: " + rs.getString("designation"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Phone Number: " + rs.getString("phone_no"));
                System.out.println("Joining Date: " + rs.getString("joining_date"));
                System.out.println("Role ID: " + rs.getInt("role_id"));
                System.out.println("=================================");
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }}

