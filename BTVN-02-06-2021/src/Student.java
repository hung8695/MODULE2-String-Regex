import java.time.Year;

public class Student {
    private String id;
    private String name;
    private String dob;
    private String gender;
    private String email;
    private String address;
    private float gpa;

    public Student() {
    }

    public Student(String id, String name, String dob, String gender, String email,String address, float gpa) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.gpa = gpa;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public int getAge(){
        return Year.now().getValue()-Integer.parseInt(getDob().substring(getDob().length()-5,getDob().length()-1));
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID: " + id +
                ", Name: " + name +
                ", Age: " + getAge() +
                ", gender: " + gender +
                ", Email: " + email +
                ", Adress: " + address +
                ", Gpa: " + gpa +
                '}';
    }
}
