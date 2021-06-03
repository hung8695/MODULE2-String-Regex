import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteAndReadFile {
    static void writeFile(String path, List<Student> studentList) {
        try {
            FileWriter fw=new FileWriter(path);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write("ID,Name,Date of birth,Gender,Email,Address,GPA"+"\n");
            for (Student  student: studentList) {
                bw.write(student.getId()+","+student.getName()+","+student.getDob()+","+student.getGender()+","+
                        student.getEmail()+","+student.getAddress()+","+student.getGpa()+"\n");
            }
            bw.close(); fw.close();
        }catch (IOException e){
            System.err.println("Không tìm thấy file hoặc có lỗi");
        }

    }


}
