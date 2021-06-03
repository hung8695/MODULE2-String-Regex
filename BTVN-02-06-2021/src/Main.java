import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ManageStudent manageStudent = new ManageStudent();
        manageStudent.addStudent(new Student("C0321K01", "Hung", "08-06-1995", "Nam", "hung.tran@codegym.vn", "Nam Định", 9.9f));
        WriteAndReadFile.writeFile("danhsach.csv",manageStudent.studentList);
    }
}
