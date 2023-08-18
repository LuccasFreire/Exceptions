package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.print("Room number: ");
		int roomnumber = kb.nextInt();
		System.out.print("Check in date: ");
		Date checkIn = sdf.parse(kb.next());
		System.out.print("Check out date: ");
		Date checkOut = sdf.parse(kb.next());
		
		Reservation reserv = new Reservation(roomnumber, checkIn, checkOut);
		System.out.println("Reservation " + reserv.toString());
			
		System.out.println("");
		System.out.println("Enter the new data to update the reservation: ");
		System.out.print("Check in date: ");
		checkIn = sdf.parse(kb.next());
		System.out.print("Check out date: ");
		checkOut = sdf.parse(kb.next());
			
		String error = reserv.updateDates(checkIn, checkOut);
			
		System.out.println("Error in reservation: "+ error);
		System.out.println("Reservation " + reserv.toString());				
		
		} catch (ParseException e) {
			System.out.println("Invalid date format!");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}
		
		kb.close();
	}

}
