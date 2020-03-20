package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class ProgramPersonalExceptions {

	public static void main(String[] args) throws ParseException {
	
		Scanner sca = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd /MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sca.nextInt();
		System.out.print("Check - in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sca.next());
		System.out.print("Check - out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sca.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			//Atualizando a data de reserva
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.print("Check - in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sca.next());
			System.out.print("Check - out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sca.next());
			
			String error = reservation.updatesDates(checkIn, checkOut);
			if(error != null) {
				System.out.println("Error in reservation: " + error);
			}
			else{
				System.out.println("Reservation: " + reservation);
			}
		}
		sca.close();
	}
}
