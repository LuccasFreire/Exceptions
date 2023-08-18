package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}


	public Date getCheckout() {
		return checkOut;
	}


	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Error: Reservation dates must be future!";
		}
		if (!checkOut.after(checkIn)) {
			return "Error: Check out date must be after check in date!";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Room:"
				+ roomNumber
				+ ", Check-in: "
				+ sdf.format(checkIn)
				+ ", Check-out: "
				+ sdf.format(checkOut)
				+ ", Days: "
				+ duration()
				+ " nights.";
	}
}
