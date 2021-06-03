import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static final String PATH = "danhsach.csv";
    ManageStudent manageStudent = new ManageStudent();
    static Scanner sc = new Scanner(System.in);

    public Menu() {
        WriteAndReadFile.readFile(PATH, manageStudent.studentList);
    }

    void display() {
        int choice;
        do {
            menu();
            choice = (int) (Menu.checkInput());
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    manageStudent.addStudent();
                    WriteAndReadFile.writeFile(PATH, manageStudent.studentList);
                    break;
                case 2:
                    System.out.println("Nhập id cần sửa: ");
                    String id = sc.nextLine();
                    if (manageStudent.findById(id) != null) {
                        manageStudent.update(id);
                        WriteAndReadFile.writeFile(PATH, manageStudent.studentList);
                    } else System.out.println("Không tìm thấy sinh viên có id " + id);

                    break;
                case 3:
                    System.out.println("Nhập id cần xóa: ");
                    String idDel = sc.nextLine();
                    if (manageStudent.findById(idDel) != null) {
                        System.out.println("Bạn có chắc chắn muốn xóa sinh viên " + idDel + " ?");
                        System.out.println("Chọn 1 để xác nhận! ");
                        if ((int) checkInput() == 1) {
                            manageStudent.deleteStudent(idDel);
                            WriteAndReadFile.writeFile(Menu.PATH, manageStudent.studentList);
                        }
                    } else System.out.println("Không tìm thấy mã vừa nhập! ");
                    WriteAndReadFile.writeFile(PATH, manageStudent.studentList);
                    break;
                case 4:
                    System.out.println("a- Tìm theo Id");
                    System.out.println("b- Tìm theo tên");
                    System.out.println("c- Tìm theo khoảng tuổi");
                    System.out.println("d-Tìm theo khoảng điểm");
                    String select = sc.nextLine();
                    if (select.equals("a")) {
                        System.out.println("Nhập id cần tìm kiếm");
                        String idFind = sc.nextLine();
                        if (manageStudent.findById(idFind) != null) {
                            System.out.println("Thông tin sinh viên mã " + idFind + " là: ");
                            System.out.println(manageStudent.findById(idFind).toString());
                        } else System.out.println("Không tìm thấy sinh viên có mã " + idFind);
                    } else if (select.equals("b")) {
                        System.out.println("Nhập tên cần tìm");
                        String nameFind = sc.nextLine();
                        if (manageStudent.findByName(nameFind) != null) {
                            System.out.println("Kết quả tìm kiếm tên " + nameFind);
                            for (Student student : manageStudent.findByName(nameFind)) {
                                System.out.println(student.toString());
                            }
                        } else System.out.println("Không tìm thấy tên " + nameFind + " trong danh sách !");
                    } else if (select.equals("c")) {
                        System.out.println("Nhập khoảng tuổi cần tìm ");
                        System.out.println("Từ ");
                        int min = (int) Menu.checkInput();
                        System.out.println("Đến ");
                        int max = (int) Menu.checkInput();
                        if (manageStudent.findByAge(min, max) != null) {
                            for (Student student : manageStudent.findByAge(min, max)) {
                                System.out.println(student.toString());
                            }
                        } else System.out.println("Không có sinh viên nào có tuổi trong khoảng " + min + " đến " + max);

                    } else if (select.equals("d")) {
                        System.out.println("Nhập khoảng điểm cần tìm kiếm");
                        System.out.print("Từ: ");
                        float min = checkInput();
                        System.out.println("Đến: ");
                        float max = checkInput();
                        if (manageStudent.findByGpa(min, max) != null) {
                            for (Student student : manageStudent.findByGpa(min, max)) {
                                System.out.println(student.toString());
                            }
                        } else System.out.println("Không có sinh viên nào có điểm trong khoảng " + min + " đến " + max);
                    } else System.out.println("Nhập sai!");

                    break;
                case 5:
                    manageStudent.display();
                    break;
                case 6:
                    manageStudent.sort();
                    break;


            }
        } while (true);
    }

    static float checkInput() {
        float input = -1;
        while (input == -1) {
            try {
                input = sc.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Nhập lại ! ");
            } finally {
                sc.nextLine();

            }

        }
        return input;
    }

    static void menu() {
        System.out.printf("%-12s%-12s%s\n", "1. Thêm", "2.Sửa", "3. Xóa");
        System.out.printf("%-12s%-12s%s\n", "4. Tìm", "5. Hiển thị", "6. Sắp xếp");
        System.out.println("0. Thoát");
        System.out.println("Nhập lựa chọn");
    }
}
