package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomnumber = kb.nextInt();
		System.out.print("Check in date: ");
		Date checkIn = sdf.parse(kb.next());
		System.out.print("Check out date: ");
		Date checkOut = sdf.parse(kb.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error: Check out date must be after check in date!");
		} else {
			Reservation reserv = new Reservation(roomnumber, checkIn, checkOut);
			System.out.println("Reservation " + reserv.toString());
			
			System.out.println("");
			System.out.println("Enter the new data to update the reservation: ");
			System.out.print("Check in date: ");
			checkIn = sdf.parse(kb.next());
			System.out.print("Check out date: ");
			checkOut = sdf.parse(kb.next());
			
			String error = reserv.updateDates(checkIn, checkOut);
			
			if (error != null) {
				System.out.println("Error in reservation: "+ error);
			} else {
				System.out.println("Reservation " + reserv.toString());				
			}
			
		}
		
		kb.close();
	}

}
