import java.io.*;
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
    static void readFile(String path,List<Student> studentList){
        try {
            FileReader fr=new FileReader(path);
            BufferedReader br=new BufferedReader(fr);
            String line=br.readLine();
            while ((line= br.readLine())!=null){
                String[] information=line.split(",");
                studentList.add(new Student(information[0],information[1],information[2],information[3],information[4],
                        information[5],Float.parseFloat(information[6])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
