// ADT Stack (LIFO) berbasis array untuk menyimpan riwayat Servis
public class Stack {
    private Servis[] data;
    private int top;
    private int kapasitas;

    public Stack(int kapasitas) {
        this.kapasitas = kapasitas;
        this.data = new Servis[kapasitas];
        this.top = -1;
    }

    public boolean isEmpty() { return top == -1; }
    public boolean isFull()  { return top == kapasitas - 1; }

    public boolean push(Servis s) {
        if (isFull()) return false;
        data[++top] = s;
        return true;
    }

    public Servis pop() {
        if (isEmpty()) return null;
        Servis s = data[top];
        data[top--] = null;
        return s;
    }

    public Servis peek() {
        if (isEmpty()) return null;
        return data[top];
    }
}
