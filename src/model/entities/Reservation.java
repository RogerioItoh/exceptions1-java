package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy"); 
		
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	public Integer getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}


	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		
		// devolve o intervalo dps dias em milisegundos
		long diff = checkOut.getTime() - checkIn.getTime();

		// converte o milisegundos para dias
		return TimeUnit.DAYS.convert(diff , TimeUnit.MILLISECONDS);
		
	}
	
	public String updateDate(Date checkIn , Date checkOut)
	{

		Date now = new Date();   // Pega a data atual
		
		if (checkIn.before(now) || checkOut.before(now))
			return "Error in reservation: Reservation dates for update must be future.");
			
		if (!checkOut.after(checkIn))			
			return "Error reservation: check-out date must be after check-in date.";
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
	}


	@Override
	public String toString() {
		return "Room =" + 
				roomNumber + 
				", checkIn= " + 
				sdf.format(checkIn) + 
				", checkOut= " + 
				sdf.format(checkIn) +
				" , " +
				duration() +
				" nights" 				
;
	}
	
	
}
