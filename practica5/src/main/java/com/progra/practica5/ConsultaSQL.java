package com.progra.practica5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class ConsultaSQL {
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/practicas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static final String USER = "root";
	static final String PASSWORD = "";

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			System.out.println("Conexion creada correctamente");
			st = con.createStatement();
			// Crear tabla cash sino existe y add
			rs = st.executeQuery("SHOW TABLES LIKE 'cash'");
			rs.next();
			if (rs.getRow() == 0) {
				System.out.println("no existe cash");
				st.executeUpdate("CREATE TABLE cash (IdCash int(20) PRIMARY KEY	AUTO_INCREMENT, cashTendered varchar(50))");
			}
			st.executeUpdate("INSERT INTO `cash`(`cashTendered`) VALUES ('asd'),('valor1')");
			rs = st.executeQuery("SELECT cashTendered from cash");
			while (rs.next()) {
				System.out.println("cashTendered: " + rs.getString(1));
			}

			// Crear tabla de check
			rs = st.executeQuery("SHOW TABLES LIKE 'check2'");
			rs.next();
			if (rs.getRow() == 0) {
				System.out.println("no existe check2");
				st.executeUpdate("CREATE TABLE check2 (IdCheck int(20) PRIMARY KEY AUTO_INCREMENT, name varchar(50),bankID varchar(50),authorized TINYINT(1))");
			}
			st.executeUpdate("INSERT INTO `check2`(`name`,`bankID`,`authorized`) VALUES ('asd','asdasdas','1')");
			rs = st.executeQuery("SELECT * from check2");
			while (rs.next()) {
				boolean resultado = false;
				System.out.println("name: " + rs.getString(2));
				System.out.println("bankID: " + rs.getString(3));
				if (rs.getString(4).equals("1")) {
					resultado = true;
				}
				System.out.println("authorized: " + resultado);
			}

			// Crear tabla de credit
			rs = st.executeQuery("SHOW TABLES LIKE 'credit'");
			rs.next();
			if (rs.getRow() == 0) {
				System.out.println("no existe credit");
				st.executeUpdate(
						"CREATE TABLE credit (IdCredit int(20) PRIMARY KEY AUTO_INCREMENT, number int(12),type varchar(50),expDate date,authorized TINYINT(1))");
			}
			st.executeUpdate("INSERT INTO `credit`(`number`,`type`,`expDate`,`authorized`) VALUES (1,'asd','2018/03/04','1')");
			rs = st.executeQuery("SELECT * from credit");
			while (rs.next()) {
				boolean resultado = false;
				System.out.println("number: " + rs.getInt(2));
				System.out.println("type: " + rs.getString(3));
				System.out.println("expDate: " + rs.getDate(4));
				if (rs.getString(5).equals("1")) {
					resultado = true;
				}
				System.out.println("authorized: " + resultado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
