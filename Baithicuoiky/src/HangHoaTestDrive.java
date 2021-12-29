import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HangHoaTestDrive {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Date ngayNhap = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        //String strDate = df.format(ngayNhap);
        ListHangHoa listHangHoa = new ListHangHoa();
        int yes;
        listHangHoa.DuLieuMacDinh();
        do{
            System.out.println(" **************MENU***************");
            System.out.println("1.********Thêm Hàng Hoá************");
            System.out.println("2.********Xoá Hàng Hoá********");
            System.out.println("3.********Sua Hàng Hoá********");
            System.out.println("4.********Sap Xep Hàng Hoá********");
            System.out.println("5.********Thong kê Hàng Hoá********");
            System.out.println("6.********Xem List Hàng Hoá********");
            System.out.println("7.********Search Hàng Hoá********");
            System.out.println("0.********Quit********");
            System.out.println("Moi nhâp lua chon:");
            int lc = sc.nextInt();
            switch(lc)
            {
                case 0:
                    break;
                case 1:
                String loaiHh = null;
                sc.nextLine();
                System.out.println("Nhap Ten Hang:");
                String ten = sc.nextLine();
                System.out.println("Nhap So Luong:");
                int soLuong = sc.nextInt();
                System.out.println("Nhap Gia:");
                float gia = sc.nextFloat();
                System.err.println("Nhap Loai Hang [1: Thuc Pham; 2: Sanh Su; 3: Dien May]");
                int l = sc.nextInt();
                switch(l)
                {
                    case 1: loaiHh = "Thuc Pham";
                    break;
                    case 2: loaiHh = "Sanh Su";
                    break;
                    case 3: loaiHh = "Dien May";
                    break;
                    default: System.out.println("Loai khong hop le!!!");
                    break;
                }
                sc.nextLine();
                try {
                    System.out.println("Nhap Ngay Vao Kho [dd/MM/yyyy]");
                    ngayNhap = df.parse(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Ngay Khong Hop Le!!!!");
                }
                HangHoa hangHoa = new HangHoa(soLuong, ten, loaiHh, gia, ngayNhap);
                listHangHoa.ThemHangHoa(hangHoa);
                    break;
                case 2:
                System.out.println("Hay nhap id muon xoa:");
                int id = sc.nextInt();
                listHangHoa.XoaHangHoa(id);
                    break;
                case 3:
                System.out.println("Hay nhap id can sua");
                int id1 = sc.nextInt();
                listHangHoa.SuaThongTin(id1);
                    break;
                case 4:
                System.out.println("Lua chon cua ban: [1:Sap Xep Tang Dan, 2:Sap xep giam dan]");
                int NNN = sc.nextInt();
                String llc = null;
                switch(NNN){
                    case 1: llc = "Sap Xep Tang Dan";
                    listHangHoa.SapXepTangDan();
                    break;
                    case 2: llc = "Sap Xep Giam Dan";
                    listHangHoa.SapXepGiamDan();
                    break;
                    default:
                    System.out.println("Lua chon khong hop le");
                    break;
                }
                    break;

                case 5:
                listHangHoa.ThongKe();
                    break;
                case 6:
                listHangHoa.HienThiHangHoa();
                    break;
                case 7:
                    System.out.println("Muon Tim Theo [1:Loai] ; [2:Gia] ");
                    int III = sc.nextInt();
                    switch(III)
                    {
                        case 1:
                        System.out.println("Nhap Loai Muon Tim [1: Thuc Pham; 2: Sanh Su; 3: Dien May]");
                        System.out.println("Nhap Loai Muon Tim:");
                        int l1 = sc.nextInt();
                        String ll = null;
                        switch(l1){
                            case 1: ll = "Thuc Pham";
                            break;
                            case 2: ll = "Sanh Su";
                            break;
                            case 3: ll = "Dien May";
                            break;
                            default: System.out.println("Loai khong hop le!");
                            break;
                        }
                        // Thực Hiện Chức năng tìm kiếm theo loại
                        listHangHoa.TimKiemTheoLoai(ll);
                        break;
                           
                            case 2:
                            System.out.println("Nhap Gia Muon Tim: [Ket Qua Đuoc Tinh Tu ... Den]");
                            System.out.println("Tu:");
                            float gF = sc.nextFloat();
                            System.out.println("Den:");
                            float gT = sc.nextFloat();
                            listHangHoa.TimKiemTheoGia(gF, gT);
                            break;
                            
                    }
                    break;
            }
        }while(true);
    }   
}
