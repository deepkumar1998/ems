package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ems.DatabaseConnectivity;
import com.exceptions.ResourceNotFoundException;

public class Guest {

    static Scanner sc=new Scanner(System.in);
    // method to fetch department details
		public void getDepartmentById() throws ResourceNotFoundException {
			try (Connection con = DatabaseConnectivity.createConnection()) {
				Statement st = con.createStatement();

				System.out.println("Enter department id: ");
				String deptId = sc.next();

				String query = "select dept_id, dept_name, total_no_of_employees from" + " department where dept_id='"
						+ deptId + "'";

				ResultSet rs = st.executeQuery(query);

				if (rs.next()) {
					System.out.println("Department Id: " + rs.getString("dept_id"));
					System.out.println("Department Name: " + rs.getString("dept_name"));
					System.out.println("Total number of employees: " + rs.getString("total_no_of_employees"));
					System.out.println("=================================");
					System.out.println();
				} else {
					throw new ResourceNotFoundException("Department with id " + deptId + " not found");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InputMismatchException e) {
				e.printStackTrace();
			}
		}
            // Method to fetch Employees by ID
        public void getEmployeeById() throws ResourceNotFoundException{
            try(Connection con= DatabaseConnectivity.createConnection()){
                Statement st=con.createStatement();

                System.out.println("Enter employee id :");
                String empId=sc.next();

                String query="select emp_id,emp_name, designation, email, phone_no from "
                +"employee where emp_id='"+empId+"'";

                ResultSet rs=st.executeQuery(query);
                if(rs.next()){

                    System.out.println("Employee Id :"+rs.getString("emp_id"));
                    System.out.println("Employee Name :"+rs.getString("emp_name"));
                    System.out.println("Designation: "+rs.getString("email"));
                    System.out.println("Phone no: "+rs.getString("phone_no"));
                    System.out.println("........................");
                }
                else{
                    throw new ResourceNotFoundException("Employee with id "+empId+"not found");
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        
		 // Method to fetch project details by ID
		    public void getProjectById() throws ResourceNotFoundException {
		        try (Connection con = DatabaseConnectivity.createConnection()) {
		            Statement st = con.createStatement();

		            System.out.println("Enter project ID: ");
		            int projectId = sc.nextInt();

		            String query = "SELECT project_id, project_name, designation, start_date, end_date, status " +
		                           "FROM project WHERE project_id = " + projectId;

		            ResultSet rs = st.executeQuery(query);
		            if (rs.next()) {
		                System.out.println("Project ID: " + rs.getInt("project_id"));
		                System.out.println("Project Name: " + rs.getString("project_name"));
		                System.out.println("Designation: " + rs.getString("designation"));
		                System.out.println("Start Date: " + rs.getString("start_date"));
		                System.out.println("End Date: " + rs.getString("end_date"));
		                System.out.println("Status: " + rs.getString("status"));
		                System.out.println("=================================");
		                System.out.println();
		            } else {
		                throw new ResourceNotFoundException("Project with ID " + projectId + " not found");
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        } catch (InputMismatchException e) {
		            e.printStackTrace();
		        }
		    
	    }
    }



