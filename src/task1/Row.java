package task1;

public class Row implements Cloneable {
    private int id;
    private String data;

    public Row(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public Row clone() {
        return new Row(this.id, this.data);
    }

    @Override
    public String toString() {
        return "{ID=" + id + ", Data='" + data + "'}";
    }
}