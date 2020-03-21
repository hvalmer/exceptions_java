package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class ProgramPersonalExceptions {

	public static void main(String[] args) {
	
					Scanner sca = new Scanner(System.in);
				SimpleDateFormat sdf = new SimpleDateFormat("dd /MM/yyyy");
				
				try {
					System.out.print("Room number: ");
					int number = sca.nextInt();
					System.out.print("Check-in date (dd/MM/yyyy): ");
					Date checkIn = sdf.parse(sca.next());
					System.out.print("Check-out date (dd/MM/yyyy): ");
					Date checkOut = sdf.parse(sca.next());
					
					Reservation reservation = new Reservation(number, checkIn, checkOut);
					System.out.println("Reservation: " + reservation);
					
					System.out.println();
					System.out.println("Enter data to update the reservation:");
					System.out.print("Check-in date (dd/MM/yyyy): ");
					checkIn = sdf.parse(sca.next());
					System.out.print("Check-out date (dd/MM/yyyy): ");
					checkOut = sdf.parse(sca.next());
					
					reservation.updatesDates(checkIn, checkOut);
					System.out.println("Reservation: " + reservation);
				}
		catch(ParseException exp) {
				System.out.println("Invalid date format");
		}
		catch(DomainException exp){
			System.out.println("Error in reservation: " + exp.getMessage());
		}
		catch(RuntimeException exp) {
			System.out.println("Unexpected error");
		}
		sca.close();
	}
}
