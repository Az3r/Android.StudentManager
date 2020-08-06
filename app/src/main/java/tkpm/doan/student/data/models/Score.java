package tkpm.doan.student.data.models;

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

    public String getTest15() {
        String value="";
        for (Float item:
                Test15) {
            value+=item+"  ";
        }
        return value;
    }

    public String getTest45() {
        String value="";
        for (Float item:
             Test45) {
            value+=item+"  ";
        }
        return value;
    }

    public float getTestFinal() {
        return TestFinal;
    }

    public float getFinal() {
        return Final;
    }
}
