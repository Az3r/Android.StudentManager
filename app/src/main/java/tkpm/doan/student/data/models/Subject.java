package tkpm.doan.student.data.models;

import androidx.annotation.NonNull;

import javax.inject.Inject;

public class Subject {

    private String id;
    private String name;

    @Inject
    public Subject(@NonNull String id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
