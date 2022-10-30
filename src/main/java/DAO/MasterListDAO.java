package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import persistence.Flight;

public class MasterListDAO {

	public static Connection getConnection() {
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Registering Database driver
			con = DriverManager.getConnection("jdbc:mysql://localhost/flyaway?useSSL=false&serverTimezone=UTC","root","Water@50%");//
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public static List<String> getMasterListOfPlaces(){
		List<String> list=new ArrayList<String>();
		
		try {
			Connection con=MasterListDAO.getConnection();
			
			String query="select distinct SOURCE from FLIGHT";
			 PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
				//list.add(rs.getString(2));
			}
			 query="select distinct DESTINATION from FLIGHT";
			  stmt = con.prepareStatement(query);
			 rs=stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
				//list.add(rs.getString(2));
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public static List<String> getMasterListOfAirLines(){
		List<String> list=new ArrayList<String>();
		
		try {
			Connection con=MasterListDAO.getConnection();
			
			String query="select AL_NAME from AIRLINE";
			 PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public static List<Flight> getMasterListOfFlights(){
		List<Flight> list=new ArrayList<Flight>();
		
		try {
			Connection con=MasterListDAO.getConnection();
			
			String query="select * from FLIGHT";
			 PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("------------in here");
				Flight flight=new Flight();
				flight.setFlightNo(rs.getString(1));
				flight.setAirlineId(rs.getInt(2));
				flight.setSource(rs.getString(3));
				flight.setDestination(rs.getString(4));
				flight.setPrice(rs.getInt(5));
				System.out.println(flight.getPrice());
				flight.setSeatCapacity(rs.getInt(6));
				System.out.println(flight.getSeatCapacity());
				list.add(flight);
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
