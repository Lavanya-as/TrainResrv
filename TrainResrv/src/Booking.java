import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {
	String passengerName;
	int trainNo;
	Date date;

	Booking(Scanner scanner) {
		System.out.println("Enter name of passenger: ");
		passengerName = scanner.nextLine(); // Changed to nextLine()

		// Validate bus number input
		while (true) {
			System.out.println("Enter train no: ");
			if (scanner.hasNextInt()) {
				trainNo = scanner.nextInt();
				scanner.nextLine(); // consume the newline character left by nextInt()
				break;
			} else {
				System.out.println("Invalid input. Please enter a valid train number.");
				scanner.nextLine(); // Clear the invalid input
			}
		}

		System.out.println("Enter date dd-mm-yyyy");
		String dateInput = scanner.nextLine();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public boolean isAvailable() throws SQLException {
		TrainDAO traindao = new TrainDAO();
		BookingDAO bookingdao = new BookingDAO();
		int capacity = traindao.getCapacity(trainNo);
		int booked = bookingdao.getBookedCount(trainNo, date);
		return booked < capacity;
	}
}
