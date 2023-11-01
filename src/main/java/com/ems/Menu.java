package com.ems;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static String roleName;
    static Scanner sc=new Scanner(System.in);
    int choice;

    	public void login() {
		try (Connection con = DatabaseConnectivity.createConnection()) {
			Statement st = con.createStatement();

			System.out.println("Login.....");
			
			System.out.println("Enter email: ");
			String email = sc.next();

			System.out.println("Enter password: ");
			String password = sc.next();

			String fetchQuery = "select role_id from employee where email='" + email + "' " + "and password='"
					+ password + "'";

			ResultSet rs = st.executeQuery(fetchQuery);

			if (rs.next()) {
				int role_id = rs.getInt("role_id");

				String getRole = "select role_name from role where role_id= " + role_id + "";

				ResultSet rs1 = st.executeQuery(getRole);
				while (rs1.next()) {
					roleName = rs1.getString("role_name");
				}
			} else {
				System.out.println("Wrong credentails. Please check the email and password.");
				login();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch(InputMismatchException e ) {
			e.printStackTrace();
		}
	
	}
    
	public void mainMenu() {
		try {
			if (roleName.equals("Admin")) {
				adminMenu();
			}
			else if (roleName.equals("Guest")) {
				guestMenu();
				
			}
			
		} catch (NullPointerException e) {
			System.out.println("Not Found");
		}
		sc.next();
	}
    
		public void adminMenu() {
			do {
				System.out.println("Admin Menu");
				System.out.println("................................");
				System.out.println("1. View All Department \r\n "+"2. Add Department \r\n" 
                +"3. Modify Department\r\n"+"4. View All Employees\r\n"+"5. Add Employee\r\n"
                +"6. Modify Employee\r\n"+"7. view all projects\r\n"+"8. Add Projects"
                +"9. Modify Projects"+"10. Exit");
                System.out.println("Enter Your Choice :");
                choice=sc.nextInt();

                switch (choice) {
                    case 1:System.out.println("view all department");
                        
                        break;
                    case 2:System.out.println("Add department");

                        break;
                    case 3:System.out.println("Modify department");

                        break;
                    case 4:System.out.println("View all Employees");

                        break;
                    case 5:System.out.println("Add Employee");

                        break;
                    case 6:System.out.println("Modify Employee");

                        break;
                    case 7:System.out.println("view all projects");

                        break;
                    case 8:System.out.println("Add Projects");

                        break;
                    case 9:System.out.println("Modify Projects");

                        break;
                    case 10:System.out.println("Exit");

                        break;
                    
                
                    default:
                        System.out.println("Wrong choice !! re-enter");
                        break;
                }
				
			}while(choice!=10);
		}

        public void guestMenu(){
            do {
                System.out.println("Guest Menu");
                System.out.println("...............");
                System.out.println("1. View Dept\r\n"+"2. View Employee\r\n"+"3. view Projects\r\n"+"4. Exit");
                choice=sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("view dept");
                        break;
                    case 2:
                        System.out.println("view employee");                        
                        break;
                    case 3:
                        System.out.println("view projects");                        
                        break;
                    case 4:
                        System.out.println("Exit");                        
                        break;
                
                    default:
                        System.out.println("wrong choice !! re-enter");
                        break;
                }
                
            } while (choice!=4);
        }
}
