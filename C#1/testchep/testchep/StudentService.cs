using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace testchep
{
    internal class StudentService
    {

        private List<Student> _lstStudents;
        private Student _student;
        private string _input;
        public StudentService()
        {
            _lstStudents = new List<Student>
            {
                new Student("A1", "01323456" , "a01", 1),
                new Student("A2", "023235456" , "a01", 2),
                new Student("A3", "0123456" , "a01", 3),
                new Student("A4", "022t3456" , "a01", 2),
                new Student("A5", "0223456" , "a01", 3),
                new Student("A6", "022363456" , "a01", 1)
            };

        }
        public void addStudent()
        {
            Console.WriteLine("Moi ban nhap so luong muon them");
            _input = Console.ReadLine();
            for (int i = 0; i < Convert.ToInt32(_input); i++)
            {
                _student = new Student();
                Console.WriteLine("Moi nhap ten: ");
                _student.Ten = Console.ReadLine();
                Console.WriteLine("Nhap sdt: ");
                _student.Sdt = Console.ReadLine();
                Console.WriteLine("Nhap msv: ");
                _student.Msv = Console.ReadLine();
                string temp;
                //do
                //{
                    Console.WriteLine("Nhap nganh");
                    Console.WriteLine("1. udpm");
                    Console.WriteLine("2. web");
                    Console.WriteLine("3. mob");
                    Console.WriteLine(" chon: ");
                    temp = Console.ReadLine();
                    switch (temp)
                    {
                        case "1":
                            _student.Nganh = 1;
                            break;
                        case "2":
                            _student.Nganh = 2;
                            break;
                        case "3":
                            _student.Nganh = 3;
                            break;
                        default:
                            Console.WriteLine("Nhap lai");
                            break;
                    }


                //} while (temp == "1" || temp == "2" || temp == "3");

                _lstStudents.Add(_student);


            }
        }
        public void editStudent()
        {
            int temp = getIndex();
            if (temp == -1)
            {
                Console.WriteLine("Khong tim thay");
                return;
            }
            Console.WriteLine("cac thong tin can sua");
            Console.WriteLine("1. Sua ten");
            Console.WriteLine("2. Sua sdt");
            Console.WriteLine("3. Sua nganh");
            Console.WriteLine("moi ban chon chuc nang: ");
            _input = Console.ReadLine();
            switch (_input)
            {
                case "1":
                    Console.WriteLine("Moi ban nhap ten");
                    _lstStudents[temp].Ten = Console.ReadLine();
                    break;

                case "2":
                    Console.WriteLine("Moi ban nhap sdt");
                    _lstStudents[temp].Sdt = Console.ReadLine();
                    break;
                case "3":
                    Console.WriteLine("Moi ban nhap nganh");
                    string temp1;
                    do
                    {
                        Console.WriteLine("Nhap nganh");
                        Console.WriteLine("1. udpm");
                        Console.WriteLine("2. web");
                        Console.WriteLine("3. mob");
                        Console.WriteLine(" chon: ");
                        temp1 = Console.ReadLine();
                        switch (temp1)
                        {
                            case "1":
                                _lstStudents[temp].Nganh = 1;
                                break;
                            case "2":
                                _lstStudents[temp].Nganh = 2;
                                break;
                            case "3":
                                _lstStudents[temp].Nganh = 3;
                                break;
                            default:
                                Console.WriteLine("Nhap lai");
                                break;
                        }


                    } while ((temp1 == "1" || temp1 == "2" || temp1 == "3"));

                    break;
                default:
                    Console.WriteLine("nhap lai di");
                    break;
            }
        }
        public void removeStudent()
        {
            int temp = getIndex();
            if (temp == -1)
            {
                Console.WriteLine("Khong tim thay");
                return;
            }
            _lstStudents.RemoveAt(temp);
            Console.WriteLine("Xoa thanh cong");
        }
        public void getStudent()
        {
            foreach (var x in _lstStudents)
            {
                x.InRaManHinh();
            }
        }
        public void findStudent()
        {

            //c1; thong thường
            //Console.WriteLine("Moi ban nhap ma: ");
            //_input= Console.ReadLine();
            //for (int i = 0; i < _lstStudents.Count; i++)
            //{
            //    if (_lstStudents[i].Msv  == _input)
            //    {
            //        _lstStudents[i].InRaManHinh();

            //    }
            //}


            //c2: sử dụng phương thức getindex

            int temp = getIndex();
            if (temp == -1)
            {
                Console.WriteLine("Khong tim thay");
                return;
            }
            _lstStudents[temp].InRaManHinh();
        }
        public void filterStudent()
        {
            Console.WriteLine("loc theo nha mang nao");
            Console.WriteLine("1. viettel");
            Console.WriteLine("2. vina");
            Console.WriteLine("moi ban chon chuc nang: ");
            _input = Console.ReadLine();
            switch (_input)
            {
                case "1":
                    foreach (var x in _lstStudents.Where(c => c.Sdt.StartsWith("01")))
                    {
                        x.InRaManHinh();
                    }
                    break;
                case "2":
                    foreach (var x in _lstStudents)
                    {
                        if (x.Sdt.StartsWith("02"))
                        {
                            x.InRaManHinh();
                        }
                    }

                    break;
                default:
                    break;
            }
        }

        public int getIndex()
        {
            Console.WriteLine("Moi ban nhap ma: ");
            _input = Console.ReadLine();
            for (int i = 0; i < _lstStudents.Count; i++)
            {
                if (_lstStudents[i].Msv == _input)
                {
                    return i;

                }
            }
            return -1;
        }
    }
}
