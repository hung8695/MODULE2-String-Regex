import java.util.*;

public class ManageStudent {
    Scanner sc=new Scanner(System.in);
    List<Student> studentList;
    public ManageStudent(){
        studentList=new ArrayList<>();
    }
    void display(){
        for (Student student:studentList){
            System.out.println(student.toString());
        }
    }

    void addStudent(Student student){
        studentList.add(student);
    }

    void addStudent(){
        studentList.add(creatStudent());
    }

    Student creatStudent(){
        Student student=new Student();
        System.out.println("Nhập Id: ");
        student.setId(creatId());
        System.out.println("Nhập tên: ");
        student.setName(sc.nextLine());
        System.out.println("Nhập ngày sinh: ");
        student.setDob(creatDob());
        System.out.println("Nhập giới tính (1 chọn nam, 2 chọn nữ): ");
        student.setGender(creatGender());
        System.out.println("Nhập email: ");
        student.setEmail(creatEmail());
        System.out.println("Nhập Địa chỉ: ");
        student.setAddress(sc.nextLine());
        System.out.println("Nhập điểm trung bình: ");
        student.setGpa(Menu.checkInput());
        return student;
    }

    boolean deleteStudent(String id){
        if(findById(id)!=null){
            studentList.remove(findById(id));
            return true;
        }
        else return false;
    }
    Student update(String id){
       if(findById(id)!=null){
           System.out.println("Nhập tên: ");
           findById(id).setName(sc.nextLine());
           System.out.println("Nhập ngày sinh: ");
           findById(id).setDob(creatDob());
           System.out.println("Nhập giới tính (1 chọn nữ, 2 chọn nam): ");
           findById(id).setGender(creatGender());
           System.out.println("Nhập email: ");
           findById(id).setEmail(creatEmail());
           System.out.println("Nhập Địa chỉ: ");
           findById(id).setAddress(sc.nextLine());
           System.out.println("Nhập điểm trung bình: ");
           findById(id).setGpa(Menu.checkInput());
           return findById(id);
       }
       return null;

    }

    String creatId(){
        while (true){
            String id=sc.nextLine();
            if (Regex.validate(Regex.VALID_ID,id)){
                return id;
            }
            else {
                System.out.println("Nhập đúng dịnh dạng!");
            }
        }
    }
    String creatDob(){
        while (true){
            String dob=sc.nextLine();
            if(Regex.validate(Regex.VALID_DOB,dob)){
                return dob;
            } else {
                System.out.println("Nhập đúng định dạng DD/mm/yyyy");
            }
        }
    }
    String creatGender(){
        String gender=null;
        int choice=-1;
        while (choice==-1){
            try {
                choice= sc.nextInt();
                if(choice==1){
                    gender="Nữ";
                } else if(choice==2){
                    gender="Nam";
                } else{
                    choice=-1;
                    System.out.println("Nhập 1 hoặc 2 !");
                }

            } catch (Exception e){
                System.out.println("Nhập 1 hoặc 2 ! ");
            } finally {
                sc.nextLine();
            }
        }
            return gender;
    }
    String creatEmail(){
        String email=null;
        while (true){
            email=sc.nextLine();
            if(Regex.validate(Regex.VALID_EMAIL,email)){
                return email;
            } else
                System.out.println("Email phải có dạng \"tên.họ@codegym.vn \"");
        }
    }

    Student findById(String id){
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getId().equals(id)){
                return studentList.get(i);
            }
        }
        return null;
    }

    List<Student>findByName(String name){
        List <Student>listById=new ArrayList();
        for (int i = 0; i <studentList.size(); i++) {
            if(studentList.get(i).getName().contains(name)){
                listById.add(studentList.get(i));
            }
        }
        return listById;
    }

    List<Student> findByAge(int first, int last){
        List<Student> listByAge=new ArrayList<>();
        for (int i = 0; i <studentList.size() ; i++) {
            if(studentList.get(i).getAge()>=first && studentList.get(i).getAge()<=last){
                listByAge.add(studentList.get(i));
            }
        }
        return listByAge;
    }

    List<Student> findByGpa(float min, float max){
        List<Student> listByGpa=new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getGpa()<=max && studentList.get(i).getGpa()>=min){
                listByGpa.add(studentList.get(i));
            }
        }
        return listByGpa;
    }

    void sort(){
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if((o1.getGpa()-o2.getGpa())<0){
                    return -1;
                } else if((o1.getGpa()-o2.getGpa())>0){
                    return 1;
                } else return o1.getName().compareTo(o2.getName());
            }
        });
    }

}

