import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ListHangHoa {
    private Node head, tail;
    HangHoa hangHoa = new HangHoa();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date ngayNhap = new Date();
    Scanner sc = new Scanner(System.in);
    public ListHangHoa()
    {
        hangHoa.autoId = 1;
        this.head = null;
        this.tail = null;
    }
    public boolean isEmpty()
    {
        return this.head == null;
    }
    public void ThemHangHoa(HangHoa hangHoa)
    {
        if(isEmpty())
        {
            this.head = this.tail = new Node(hangHoa);
            return;
        }
        Node newNode = new Node(hangHoa);
        this.tail.setNext(newNode);
        this.tail = newNode;

    }
    public void HienThiHangHoa()
    {
        System.out.println("************************THONG TIN HANG HOA************************");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "ma hang", "ten hang", "so luong", "gia hang", "loai hang", "ngay nhap kho");
        Node node = this.head;
        while(node != null){
            System.out.printf("%-20d %-20S %-15d %-7.3fVND %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap)); 
            node = node.getNext();
        }
    }
    public void ThemNhieuHangHoa(HangHoa...hangHoas)
    {
        for(HangHoa hangHoa : hangHoas)
        {
            ThemHangHoa(hangHoa);
        }
    }
    public boolean XoaHangHoa(int id)
    {
        Node node = this.head;
        if(this.head.getHangHoa().getiD() == id){
            this.head = this.head.getNext();
            System.out.println("Da Xoa Doi Tuong Ban Dau!!");
            return true;
        }
        while(node != null)
        {
            if(node.getNext().getHangHoa().getiD() == id){
                node.setNext(node.getNext().getNext());
                System.out.println("Da Xoa Thanh Cong!");
                return true;
            }
            else{
                System.out.println("ID Khong Ton Tai!");
            }
            node = node.getNext();
        }
        System.out.println("Xoa Khong Thanh Cong!!!");
        return false;
    }
    public boolean SuaThongTin(int id){
        Node node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getiD() == id)
            {
                String loaiHh = null;
                System.out.println("Nhap Ten Hang:");
                String ten = sc.nextLine();
                System.out.println("Nhap So Luong:");
                int soLuong = sc.nextInt();
                System.out.println("Nhap Gia:");
                float gia = sc.nextFloat();
                System.out.println("Nhap Loai Hang [1: Thuc Pham; 2: Sanh Su; 3: Dien May]");
                int l = sc.nextInt();
                switch(l)
                {
                    case 1: loaiHh = "Thuc Pham";
                    break;
                    case 2: loaiHh = "Sanh Su";
                    break;
                    case 3: loaiHh = "Dien May";
                    break;
                    default: System.out.println("Loai Khong Hop Le!");
                    break;
                }
                sc.nextLine();
                try {
                    System.out.println("Nhap Ngay Vao Kho [dd/MM/yyyy]");
                    ngayNhap = df.parse(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Ngay Khong Hop Le!");
                }
                node.getHangHoa().setTenHangHoa(ten);
                node.getHangHoa().setSoLuong(soLuong);
                node.getHangHoa().setGiaHang(gia);
                node.getHangHoa().setLoai(loaiHh);
                node.getHangHoa().setNgayNhap(ngayNhap);
                return true;
            }
            node = node.getNext();
        }
        System.out.println("Khong The Sua Duoc!");
        return false;
    }
    public void SapXepTangDan(){
        Node node = this.head, node2 = null;
        HangHoa tempHangHoa;
        if(head == null)
        return;
        else{
            while(node != null){
                node2 = node.next;
                while(node2 != null){
                    if(node.hangHoa.giaHang < node2.hangHoa.giaHang){
                        tempHangHoa = node.hangHoa;
                        node.hangHoa = node2.hangHoa;
                        node2.hangHoa = tempHangHoa;
                    }
                    node2 = node2.next;
                }
                node = node.next;
            }
        }
        HienThiHangHoa();
    }

    public void SapXepGiamDan(){
        Node node = this.head, node2 = null;
        HangHoa tempHangHoa;
        if(head == null)
        return;
        else{
            while(node != null){
                node2 = node.next;
                while(node2 != null){
                    if(node.hangHoa.giaHang > node2.hangHoa.giaHang){
                        tempHangHoa = node.hangHoa;
                        node.hangHoa = node2.hangHoa;
                        node2.hangHoa = tempHangHoa;
                    }
                    node2 = node2.next;
                }
                node = node.next;
            }
        }
        HienThiHangHoa();
    }
    public boolean TimKiemTheoLoai(String l){
        System.out.println("************************THONG TIN HANG HOA************************");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "ma hang", "ten hang", "so luong", "gia hang", "loai hang", "ngay nhap kho");
        boolean isFound = false;
        Node node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getLoai().contains(l))
            {
                System.out.printf("%-20d %-20S %-15d %-7.3fVND %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap)); 
                isFound = true;
            }
            node = node.getNext();
        }
        if(!isFound)
        {
            System.out.println("Loai Muon Tim Khong Hop Le!");
            return false;
        }
        return true;
    }
    public boolean TimKiemTheoGia(float gF, float gT){
        System.out.println("************************THONG TIN HANG HOA************************");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "ma hang", "ten hang", "so luong", "gia hang", "loai hang", "ngay nhap kho");
        boolean isFound = false;
        Node node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getGiaHang() >= gF && node.getHangHoa().getGiaHang() <= gT)
            {
                System.out.printf("%-20d %-20S %-15d %-7.3fVND %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap)); 
                isFound = true;
            }
            node = node.getNext();
        }
        if(!isFound)
        {
            System.out.println("Gia Muon Tim Khong Hop Le!");
            return false;
        }
        return true;
    }
    public void ThongKe(){
        Node node = this.head;
        int sLtemp = 0;
        float gTtemp = 0;
        while(node != null){
            sLtemp += node.getHangHoa().getSoLuong();
            gTtemp += node.getHangHoa().getGiaHang();
            node = node.getNext();
        }
        System.out.println("******************************BANG THONG KE******************************");
        System.out.printf("%-30S %-30S\n", "Tong so luong", "Tong gia tri");
        System.out.printf("%-30d %-12.3fVND\n", sLtemp, gTtemp);
    }
    public void DuLieuMacDinh(){
        try {
            String sDate1 = "1/12/2021";  
            String sDate2 = "5/12/2021";  
            String sDate3 = "13/12/2021";  
            String sDate4 = "17/12/2021";  
            String sDate5 = "22/12/2021";  
            String sDate6 = "30/12/2021";  
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");  
            Date date1=formatter1.parse(sDate1);  
            Date date2=formatter1.parse(sDate2);  
            Date date3=formatter1.parse(sDate3);  
            Date date4=formatter1.parse(sDate4);  
            Date date5=formatter1.parse(sDate5);  
            Date date6=formatter1.parse(sDate6); 
            HangHoa HangHoa1 = new HangHoa(2000, "Tao Trung Quoc", "Thuc Pham", 90, date1);
            HangHoa HangHoa2 = new HangHoa(1500, "Mit Thai", "Thuc Pham", 200, date2);
            HangHoa HangHoa3 = new HangHoa(7000, "Dia Su", "Sanh Su", 500, date3);
            HangHoa HangHoa4 = new HangHoa(30000, "To Su", "Sanh Su", 100, date4);
            HangHoa HangHoa5 = new HangHoa(50000, "May rua chen", "Dien May", 200, date1);
            HangHoa HangHoa6 = new HangHoa(6000, "Bap cai", "Thuc Pham", 70, date2);
            HangHoa HangHoa7 = new HangHoa(90000, "Chen su", "Sanh Su", 50, date4);
            HangHoa HangHoa8 = new HangHoa(1000, "Chuoi My", "Thuc Pham", 700, date4);
            HangHoa HangHoa9 = new HangHoa(300000, "Man hinh", "Dien May", 1700, date5);
            HangHoa HangHoa10 = new HangHoa(400, "Oi", "Thuc Pham", 700, date3);
            HangHoa HangHoa11 = new HangHoa(900000, "Dien thoai", "Dien May", 70, date3);
            HangHoa HangHoa12 = new HangHoa(100, "Ca vien chien", "Thuc Pham", 20, date1);
            HangHoa HangHoa13 = new HangHoa(3000, "Coc su", "Sanh Su", 40, date2);
            HangHoa HangHoa14 = new HangHoa(4000, "Ca thu", "Thuc Pham", 80, date4);
            HangHoa HangHoa15 = new HangHoa(2000000, "Tivi", "Dien May", 850, date3);
            HangHoa HangHoa16 = new HangHoa(4000000, "Lo vi song", "Dien May", 99, date1);
            HangHoa HangHoa17 = new HangHoa(300, "Rong bien", "Thuc Pham", 898, date2);
            HangHoa HangHoa18 = new HangHoa(700, "Buoi", "Thuc Pham", 55, date5);
            HangHoa HangHoa19 = new HangHoa(200, "Cam", "Thuc Pham", 880, date4);
            HangHoa HangHoa20 = new HangHoa(8000, "Thit bo", "Thuc Pham", 901, date3);
            ThemHangHoa(HangHoa1);
            ThemHangHoa(HangHoa2);
            ThemHangHoa(HangHoa3);
            ThemHangHoa(HangHoa4);
            ThemHangHoa(HangHoa5);
            ThemHangHoa(HangHoa6);
            ThemHangHoa(HangHoa7);
            ThemHangHoa(HangHoa8);
            ThemHangHoa(HangHoa9);
            ThemHangHoa(HangHoa10);
            ThemHangHoa(HangHoa11);
            ThemHangHoa(HangHoa12);
            ThemHangHoa(HangHoa13);
            ThemHangHoa(HangHoa14);
            ThemHangHoa(HangHoa15);
            ThemHangHoa(HangHoa16);
            ThemHangHoa(HangHoa17);
            ThemHangHoa(HangHoa18);
            ThemHangHoa(HangHoa19);
            ThemHangHoa(HangHoa20);
        } catch (Exception e) {
            e.getCause();
        }
    }    
}
