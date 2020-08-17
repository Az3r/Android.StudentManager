package tkpm.doan.student.data.models;

public class RequestClass {

    String ClassId;
    String RoomId;
    String TeacherId;
    int AcademicYear;

    public String getClassId() {
        return ClassId;
    }

    public void setClassId(String classId) {
        ClassId = classId;
    }

    public String getRoomId() {
        return RoomId;
    }

    public void setRoomId(String roomId) {
        RoomId = roomId;
    }

    public String getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }

    public int getAcademicYear() {
        return AcademicYear;
    }

    public void setAcademicYear(int academicYear) {
        AcademicYear = academicYear;
    }
}
