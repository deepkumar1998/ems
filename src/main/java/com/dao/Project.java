package com.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ems.DatabaseConnectivity;


public class Project {
	Scanner sc = new Scanner(System.in);

    public void addProject() {
        try (Connection con = DatabaseConnectivity.createConnection()) {
            Statement st = con.createStatement();

            System.out.println("Enter project name: ");
            String projectName = sc.nextLine();

            System.out.println("Enter project start date (yyyy-MM-dd): ");
            String startDate = sc.nextLine();

            System.out.println("Enter project end date (yyyy-MM-dd): ");
            String endDate = sc.nextLine();

            System.out.println("Enter project status: ");
            String status = sc.nextLine();

            String insert = "INSERT INTO project (project_name, start_date, end_date, status) " +
                            "VALUES ('" + projectName + "','" + startDate + "', '" + endDate + "', '" + status + "')";

            int row = st.executeUpdate(insert);
            System.out.println(row + " project details added successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    public void modifyProject() {
        try (Connection con = DatabaseConnectivity.createConnection()) {
            Statement st = con.createStatement();

            System.out.println("Enter project ID to update: ");
            int projectId = sc.nextInt();

            sc.nextLine(); 

            System.out.println("Enter new project name: ");
            String projectName = sc.nextLine();

            System.out.println("Enter new project start date (yyyy-MM-dd): ");
            String startDate = sc.nextLine();

            System.out.println("Enter new project end date (yyyy-MM-dd): ");
            String endDate = sc.nextLine();

            System.out.println("Enter new project status: ");
            String status = sc.nextLine();

            String update = "UPDATE project " +
                    "SET project_name = '" + projectName + "', " +
                    "start_date = '" + startDate + "', " +
                    "end_date = '" + endDate + "', " +
                    "status = '" + status + "' " +
                    "WHERE project_id = " + projectId;

            int row = st.executeUpdate(update);
            System.out.println(row + " project details updated successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    public void viewProjects() {
        try (Connection con = DatabaseConnectivity.createConnection()) {
            Statement st = con.createStatement();

            String query = "SELECT * FROM project";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println("Project ID: " + rs.getInt("project_id"));
                System.out.println("Project Name: " + rs.getString("project_name"));
                System.out.println("Start Date: " + rs.getString("start_date"));
                System.out.println("End Date: " + rs.getString("end_date"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("=================================");
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }
	}
