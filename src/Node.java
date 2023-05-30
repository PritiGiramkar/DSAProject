public class Node {
    private String song;
    private Node next;
    private Node prev;
    private String time;

    private static int count;

    public Node(String data,String time) {
        this.song = data;
        this.next = null;
        this.prev = null;
        this.time=time;
        this.count+=1;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
