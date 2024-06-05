package az.hafizrzazade.eventscheduler.model;


public class Event {
	private Integer id;
    private String title;
    private String dateTime; //for example: 10-10-2024 17:40
    private String description;
    
    public Event() {
    	
    }
    
    public Event(String title, String dateTime, String description){
    	this.title = title;
    	this.dateTime = dateTime;
    	this.description = description;
    }

    public Integer getId() {
    	return id;
    }
    
    public void setId(Integer id) {
    	this.id = id;
    }
    
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", dateTime=" + dateTime + ", description=" + description + "]";
	}
    
    
}
