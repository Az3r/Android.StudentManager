package tkpm.doan.student.data.models;

import androidx.annotation.NonNull;

import java.util.Date;

import javax.inject.Inject;

public class Notification {

    private String id;
    private String title;
    private String content;
    private String tags;
    private boolean important;
    private Date date;

    @Inject
    public Notification(String id, String title, String content, String tags, boolean important) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.important = important;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isImportant() {
        return important;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTags() {
        return tags;
    }

    @NonNull
    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
