package tkpm.doan.student.data.models;

import androidx.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

public class Score {
    @NonNull
    private Student student;

    @NonNull
    private Subject subject;

    private int semester;
    private int year;

    @NonNull
    private List<Float> fifteenScores;

    @NonNull
    private List<Float> fortyFiveScores;

    private float semesterScores;

    @Inject
    public Score() {

    }

    @NonNull
    public Student getStudent() {
        return student;
    }

    @NonNull
    public Subject getSubject() {
        return subject;
    }

    @NonNull
    public List<Float> getFifteenScores() {
        return fifteenScores;
    }

    @NonNull
    public List<Float> getFortyFiveScores() {
        return fortyFiveScores;
    }

    public float getSemesterScores() {
        return semesterScores;
    }

    public int getSemester() {
        return semester;
    }

    public int getYear() {
        return year;
    }


}
