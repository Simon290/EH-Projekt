package RightAllocation;

import Database.DBConnection;

public class Main {

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DBConnection.connect();
		} catch (Exception e) {
			System.out.println("Database connection failed!");
			e.printStackTrace();
		}
		try {
			System.out.print(DBConnection.sql("SELECT Users.Vorname, Users.Name, Users.Firma, Users.Mail, Main.App_ID FROM Users, Main WHERE User.User_ID = Main.User_ID;"));
		} catch (Exception e) {
			System.out.println("Connection failed!");
			e.printStackTrace();
		}
		try {
			DBConnection.disconnect();
		} catch (Exception e) {
			System.out.println("Database disconnection failed!");
			e.printStackTrace();
		}
	}

}
