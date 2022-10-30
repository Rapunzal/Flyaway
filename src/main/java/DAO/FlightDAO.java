package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import persistence.Availability;
import persistence.DaysOFOperation;
import persistence.Flight;

public class FlightDAO {
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
	
	public static List<Flight> getAllFlightSearch(String source,String Destination,String date,int noOfPersons){
		List<Flight> list=new ArrayList<Flight>();
		
		try {
			Connection con=FlightDAO.getConnection();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			 java.util.Date utilDate = format.parse(date);
		        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		        System.out.println(sqlDate);
			//java.sql.Date sqlDate=new java.sql.Date(date2.getTime());
			//System.out.println(sqlDate);
		        //String inputDate = "01/08/2012";
		        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		        Date dt1 = format1.parse(date);
		        DateFormat format2 = new SimpleDateFormat("EEEE"); 
		        String finalDay = format2.format(dt1);
		        
		        System.out.println(finalDay);
		        
			String query="select  * from FLIGHT f where f.SOURCE= '"+source+"' and f.DESTINATION= '"+Destination+"'";
			 PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Flight fl=new Flight();
				fl.setFlightNo(rs.getString(1));
				fl.setAirlineId(rs.getInt(2));
				fl.setSource(rs.getString(3));
				fl.setDestination(rs.getString(4));
				fl.setSeatCapacity(rs.getInt(6));
				list.add(fl);
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return list;
	}
	
	

	public static DaysOFOperation getFlightDaysOfOperation(String FlightNo,String date){
		String finalDay="";
		DaysOFOperation list=new DaysOFOperation();
		try {
			Connection con=FlightDAO.getConnection();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			 java.util.Date utilDate = format.parse(date);
		        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		        //System.out.println(sqlDate);
		        System.out.println(sqlDate);
		        
		        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		        Date dt1 = format1.parse(date);
		        DateFormat format2 = new SimpleDateFormat("EEEE"); 
		         finalDay = format2.format(dt1);
		        
		        System.out.println(finalDay.toUpperCase());
		        
		
				String query="select * from DAYS_OF_OPERATION  where FLT_NO= '"+FlightNo+"' and "+finalDay+"='yes'";
				 PreparedStatement stmt = con.prepareStatement(query);
				ResultSet rs=stmt.executeQuery();
				while(rs.next()) {
				list.setFlightNo(rs.getString(1));
				list.setMonday(rs.getString(2));
					list.setTuesday(rs.getString(3));
					list.setWednesday(rs.getString(4));
					list.setThursday(rs.getString(5));
					list.setFriday(rs.getString(6));
					list.setSaturday(rs.getString(7));
					list.setSunday(rs.getString(8));
				}
				con.close();
			}catch(Exception e) {
				System.out.println(e);
			}
			if(list.getFlightNo()!=null) {
				
			}
			
			return list;
		}
	
	
	public static int insertIntoAvaliblity(String FlightNo,String date){
		System.out.println("insert into avalibility=====");
		Availability aval=new Availability();
		int result=0;
		try {
			Connection con=FlightDAO.getConnection();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			 java.util.Date utilDate = format.parse(date);
		        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		        //System.out.println(sqlDate);
		        System.out.println(sqlDate);
				String query="INSERT INTO Availability(FLT_NO,DEP_DATE,ARR_DATE,TOTAL_SEATS,AVAILABLE_SEATS,PRICE) values(?,?,?,?,?,?)";
				System.out.println("connection made======");
				PreparedStatement stmt=con.prepareStatement(query);
				stmt.setString(1, FlightNo);
				stmt.setString(2, date);
				stmt.setString(3, date);
				stmt.setInt(4, 30);
				stmt.setInt(5, 30);
				stmt.setInt(6, 5000);
			
				//execute query
				result =stmt.executeUpdate(); 
			
				con.close();
			}catch(Exception e) {
				System.out.println(e);
			}
			if(result>0)
			System.out.println("record inserted into availablity");
			return result;
		}
	
	
	public static Availability getFlightAvaliablity(String FlightNo,String date,int noOfPersons){
		Availability aval=new Availability();
		
		try {
			Connection con=FlightDAO.getConnection();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			 java.util.Date utilDate = format.parse(date);
		        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		        //System.out.println(sqlDate);
		        System.out.println(sqlDate);
				String query="select a.PRICE , a.TOTAL_SEATS , a.AVAILABLE_SEATS from FLIGHT f,AVAILABILITY a where f.FLT_NO= '"+FlightNo+"' and a.DEP_DATE='"+sqlDate+"'";
				 PreparedStatement stmt = con.prepareStatement(query);
				ResultSet rs=stmt.executeQuery();
				while(rs.next()) {
					
					aval.setPrice(rs.getFloat(1));
					aval.setTotalSeat(rs.getInt(2));
					aval.setBookedSeat(rs.getInt(3));
					
					
				}
				con.close();
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
			return aval;
		}
	public static String delete(){
		String airlineName=null;
		
		try {
			Connection con=FlightDAO.getConnection();
			for(int i=25;i<648;i++) {
				String query="Delete from FLIGHT where FLT_ID="+i;
				 PreparedStatement stmt = con.prepareStatement(query);
				stmt.executeUpdate();
				
			}
				con.close();
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
			return airlineName;
		}
	
	public static String getAirlineName(int airlineId){
		String airlineName=null;
		
		try {
			Connection con=FlightDAO.getConnection();
			
				String query="select AL_NAME from AIRLINE where AL_ID='"+airlineId+"'";
				 PreparedStatement stmt = con.prepareStatement(query);
				ResultSet rs=stmt.executeQuery();
				while(rs.next()) {
					 airlineName=rs.getString(1);
				}
				con.close();
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
			return airlineName;
		}
	
	public static int getAirlineId(String airlineName){
		int airlineId=0;
		
		try {
			Connection con=FlightDAO.getConnection();
			
				String query="select AL_ID from AIRLINE where AL_NAME='"+airlineName+"'";
				 PreparedStatement stmt = con.prepareStatement(query);
				ResultSet rs=stmt.executeQuery();
				while(rs.next()) {
					airlineId=rs.getInt(1);
				}
				con.close();
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
			return airlineId;
		}

	public static int addFlightrecord(String flightno,String airlineName,String source,String destination,int price,int seatcapacity){
				int x=0;
		try {
			Connection con=FlightDAO.getConnection();
			
			int airlineId=getAirlineId(airlineName);
			System.out.println("add flight record--------->>>");
				String query="insert into FLIGHT (FLT_NO,AL_ID,SOURCE,DESTINATION,PRICE,SEAT_CAPACITY) values(?,?,?,?,?,?)";
				 PreparedStatement stmt = con.prepareStatement(query);
				 stmt.setString(1,flightno);
				 stmt.setInt(2,airlineId);
				 stmt.setString(3,source);
				 stmt.setString(4,destination);
				 stmt.setInt(5, price);
				 stmt.setInt(6, seatcapacity);
				 x=stmt.executeUpdate();
				
				con.close();
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
			return x;
		}
	
	public static int addAirlineName(String airlineName){
				int x=0;
		try {
			Connection con=FlightDAO.getConnection();
			
				String query="insert into AIRLINE (AL_NAME) values(?)";
				 PreparedStatement stmt = con.prepareStatement(query);
				 stmt.setString(1,airlineName);
				 x=stmt.executeUpdate();
				
				con.close();
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
			return x;
		}
	
}
