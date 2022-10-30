package persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AVAILABILITY")
public class Availability {
	@Id
	@Column(name="FLT_ID")
	private int flightId;
	
	private String flightNo;
	
	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	@Column(name="DEP_DATE")
	private Date departureDate;
	
	@Column(name="ARR_DATE")
	private Date arrivalDate;
	
	@Column(name="TOTAL_SEAT")
	private int totalSeat;
	
	@Column(name="BOOKED_SEAT")
	private int bookedSeat;
	
	@Column(name="PRICE")
	private float price;

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public int getBookedSeat() {
		return bookedSeat;
	}

	public void setBookedSeat(int bookedSeat) {
		this.bookedSeat = bookedSeat;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
