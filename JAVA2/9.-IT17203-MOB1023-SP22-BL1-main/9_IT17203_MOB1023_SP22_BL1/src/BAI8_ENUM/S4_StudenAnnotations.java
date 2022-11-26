/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI8_ENUM;

/**
 *
 * @author Dungna89
 */
@interface Table {

    public String value();
}

@interface Field {

    public String value();
}
public class S4_StudenAnnotations {
  @Table(value = "SinhVien")//Định nghĩa bảng sinh viên sẽ có các trường phía dưới
    public class SinhVien {

        @Field(value = "MaSV")
        public int MaSV;
        @Field(value = "TenSV")
        public String TenSV;

    }
}
