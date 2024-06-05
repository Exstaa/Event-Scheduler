package az.hafizrzazade.eventscheduler.main;

import java.util.Scanner;

import az.hafizrzazade.eventscheduler.model.Event;
import az.hafizrzazade.eventscheduler.repository.EventRepository;

public class MainClass {
	public static void main(String[] args) {
		EventRepository repo = new EventRepository();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. Add Event");
			System.out.println("2. Update Event");
			System.out.println("3. Delete Event");
			System.out.println("4. Get All Events");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter title");
				String title = sc.nextLine();
				System.out.println("Enter DateTime, For Example: 10-10-2024 17:40");
				String dateTime = sc.nextLine();
				System.out.println("Enter description");
				String description = sc.nextLine();
				Event e = new Event(title, dateTime, description);
				repo.createEvent(e);
                break;
			case 2:
				System.out.println("Enter id");
				Integer id = sc.nextInt();
				System.out.println("Enter title");
				String updateTitle = sc.nextLine();
				System.out.println("Enter DateTime, For Example: 10-10-2024 17:40");
				String updateDateTime = sc.nextLine();
				System.out.println("Enter description");
				String updateDescription = sc.nextLine();
				Event updateEvent = new Event(updateTitle, updateDateTime, updateDescription);
				repo.updateEvent(updateEvent, id);
                break;

			case 3:
				System.out.println("Enter id");
				Integer deleteId = sc.nextInt();
				repo.deleteEvent(deleteId);
                break;

			case 4:
				System.out.println(repo.getAllEvents());
                break;

			default:
				System.out.println("Invalid choice. Please try again.");
				sc.close();
                break;

			}
		}
	}
}
