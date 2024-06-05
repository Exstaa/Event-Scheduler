package az.hafizrzazade.eventscheduler.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import az.hafizrzazade.eventscheduler.database.Database;
import az.hafizrzazade.eventscheduler.model.Event;

public class EventRepository {
    private Connection con;
    
    public void createEvent(Event e) {
    	con = Database.connect();
		try {
			String query = "INSERT INTO events (title,date_time,description) VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, e.getTitle());
			st.setString(2, e.getDateTime()); //for example: 10-10-2024 17:40
			st.setString(3, e.getDescription());
			st.execute();
			st.close();
			con.close();
		} catch (SQLException exc) {
			// TODO Auto-generated catch block
			exc.printStackTrace();
		}
    }
    
    public void updateEvent(Event e, Integer id) {
    	con = Database.connect();
        try {
        	String query = "UPDATE FROM events SET title = ?, date_time = ?, description = ? WHERE id = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, e.getTitle());
			st.setString(2, e.getDateTime()); //for example: 10-10-2024 17:40
			st.setString(3, e.getDescription());
			st.executeUpdate();
			st.close();
			con.close();
        } catch (SQLException exc) {
			// TODO Auto-generated catch block
			exc.printStackTrace();
		}
    }
    
    public void deleteEvent(Integer id) {
    	con = Database.connect();
        try {
        	String query = "DELETE FROM events WHERE id = ?";
			PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, id);
            st.execute();
        } catch (SQLException exc) {
			// TODO Auto-generated catch block
			exc.printStackTrace();
		}
    }
    
    public ArrayList<Event> getAllEvents() {
    	con = Database.connect();
        ArrayList<Event> events = new ArrayList();
        String query = "SELECT * FROM events";
        try {
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Event e = new Event();
                e.setId(rs.getInt("id"));
                e.setTitle(rs.getString("title"));
                e.setDateTime(rs.getString("date_time"));
                e.setDescription(rs.getString("description"));
                events.add(e);
            }
            st.close();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return events;
    }
}
