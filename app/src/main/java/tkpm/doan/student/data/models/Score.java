package tkpm.doan.student.data.models;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuWrapperICS;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class Score  {

    private String StudentId;
    private String SubjectName;
    private List<Float> Test15 = new ArrayList<>();
    private List<Float> Test45 = new ArrayList<>();

    private float TestFinal;
    private float Final;

    @Inject
    public Score(String studentId) {
        StudentId = studentId;
    }

    public String getStudentId() {
        return StudentId;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public List<Float> getTest15() {
        return Test15;
    }

    public List<Float> getTest45() {
        return Test45;
    }

    public float getTestFinal() {
        return TestFinal;
    }

    public float getFinal() {
        return Final;
    }
}
