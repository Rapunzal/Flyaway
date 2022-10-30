package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import persistence.Flight;



public class BookingDAO {
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
	
	
	public static int setBookingDetails(String flightId,int passengerCount,int PassengerId,int totalprice,String date,int seat) {
		int result=0;
		try {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 java.util.Date utilDate;
		 java.sql.Date sqlDate;
		
			utilDate = format.parse(date);
			 sqlDate = new java.sql.Date(utilDate.getTime());
		int x=seat-passengerCount;
	       
		String INSERT_EMP_SQL = "INSERT INTO BOOKING(FLT_NO,PASSENGER_COUNT,PRI_PASSENGER_ID,TOTAL_PRICE) values(?,?,?,?)";
		String updateQuery="UPDATE  AVAILABILITY set AVAILABLE_SEATS='"+x +"'where FLT_NO='"+flightId+"' and DEP_DATE='"+sqlDate+"'";
		
		try {
			Connection con=BookingDAO.getConnection();
			//create a statement using connection object
			System.out.println("connection made======");
			PreparedStatement stmt=con.prepareStatement(INSERT_EMP_SQL);
			stmt.setString(1, flightId);
			stmt.setInt(2, passengerCount);
			stmt.setInt(3, PassengerId);
			stmt.setInt(4, totalprice);
			//execute query
			result =stmt.executeUpdate();
			
			  PreparedStatement ps1 = con.prepareStatement(updateQuery);
              ps1.executeUpdate();
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;
	}
	
	public static int getBookingId(String flightId){
		int bookingId=0;
		
		try {
			Connection con=BookingDAO.getConnection();
			//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			// java.util.Date utilDate = format.parse(date);
		       // java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		       // System.out.println(sqlDate);
			//java.sql.Date sqlDate=new java.sql.Date(date2.getTime());
			//System.out.println(sqlDate);
			String query="select BOOKINGID from BOOKING where FLT_NO='"+flightId+"'";
			 PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				bookingId=rs.getInt(1);
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return bookingId;
	}
}
