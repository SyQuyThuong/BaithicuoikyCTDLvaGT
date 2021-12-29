public class Node {
    public HangHoa hangHoa;
    public Node next;
    public Node()
    {

    }
    public Node(HangHoa hangHoa)
    {
        this.hangHoa = hangHoa;
        this.next = null;
    }
    public HangHoa getHangHoa() {
        return hangHoa;
    }
    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node(HangHoa hangHoa, Node next) {
        this.hangHoa = hangHoa;
        this.next = next;
    }    
}
