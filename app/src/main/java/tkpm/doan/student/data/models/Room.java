package tkpm.doan.student.data.models;

public class Room {
    private String RoomId;
    private String RoomName;
    private String ClassId;


    // Getter Methods

    public String getRoomId() {
        return RoomId;
    }

    public String getRoomName() {
        return RoomName;
    }

    public String getClassId() {
        return ClassId;
    }

    // Setter Methods

    public void setRoomId(String RoomId) {
        this.RoomId = RoomId;
    }

    public void setRoomName(String RoomName) {
        this.RoomName = RoomName;
    }

    public void setClassId(String ClassId) {
        this.ClassId = ClassId;
    }
}
