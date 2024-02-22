package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			// aqui pode ser uma "inesperada", por exemplo entrando com char ao invés de int
			System.out.print("Room number: ");
			int room = sc.nextInt();
			// daqui vem o ParseException
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation res = new Reservation(room, checkIn, checkOut);
			System.out.println("Reservation: " + res);
			
			System.out.println("\nEnter data to update the reservation");
			// daqui vem o ParseException
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			// daqui vem o DomainException (antes de ser personalizada, era IllegalArgumentException)
			res.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + res);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation! " + e.getMessage());
		}
		// qualquer outra exception inesperada
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}

}