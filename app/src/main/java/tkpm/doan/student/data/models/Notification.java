package tkpm.doan.student.data.models;

import java.util.Date;

public class Notification {
    private int NotificationId;
    private Date CreatedOn;
    private String ClassId;
    private String Title;
    private String Content;


    // Getter Methods

    public float getNotificationId() {
        return NotificationId;
    }

    public Date getCreatedOn() {
        return CreatedOn;
    }

    public String getClassId() {
        return ClassId;
    }

    public String getTitle() {
        return Title;
    }

    public String getContent() {
        return Content;
    }

    // Setter Methods

    public void setNotificationId(int NotificationId) {
        this.NotificationId = NotificationId;
    }

    public void setCreatedOn(Date CreatedOn) {
        this.CreatedOn = CreatedOn;
    }

    public void setClassId(String ClassId) {
        this.ClassId = ClassId;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }
}