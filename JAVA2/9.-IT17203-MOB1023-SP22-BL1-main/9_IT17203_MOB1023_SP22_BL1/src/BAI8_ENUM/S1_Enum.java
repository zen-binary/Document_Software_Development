/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAI8_ENUM;

/**
 *
 * @author dungna29
 */
//Emnum có thể khai báo bên ngoài của 1 Class và lưu ý khi khai báo bên ngoài class thì sẽ ko được sử dụng Acces Modifier
enum NgayTrongTuan1 {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class S1_Enum {
//    enum NgayTrongTuan1{
//        MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
//    }

    public static void main(String[] args) {
        /*
        1. Enum là 1 từ khoá trong java, nó là 1 kiểu dữ liệu đặc biệt.
        2. Nó thường đạt diện cho hằng số cố định
        3. Enum có thể chứa các trường, phương thức và contructor.
        4. Bởi vì nó là hằng vì vậy các giá trị sẽ phải viết hoa.
        5. Trong java nếu cần xác định 1 kiểu là Enum thì bắt buộc phải sử dụng từ khoá Enum
        6. Enum có thể Implement 1 Interface.
        */
        for (NgayTrongTuan1 x : NgayTrongTuan1.values()) {
            System.out.println(x);
        }
        System.out.println("--------");
        //So sánh với ENUM
        NgayTrongTuan1 homNay = NgayTrongTuan1.FRIDAY;//
        if (homNay.equals(NgayTrongTuan1.SUNDAY)) {
            System.out.println("Vui quá không phải đi làm");
        }else {
            System.out.println("Hôm nay là ngày thường phải đi làm");
        }
        //Đối với Enum các bạn có thể sử dụng toán từ ==
        if (homNay == NgayTrongTuan1.SUNDAY) {
            System.out.println("Vui quá không phải đi làm");
        }else {
            System.out.println("Hôm nay là ngày thường phải đi làm");
        }
    }
}
