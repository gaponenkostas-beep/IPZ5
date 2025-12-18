package task1;

// 1. Клас Row (Рядок) - елемент таблиці
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

    // Метод для створення глибокої копії рядка
    @Override
    public Row clone() {
        return new Row(this.id, this.data);
    }

    @Override
    public String toString() {
        return "{ID=" + id + ", Data='" + data + "'}";
    }
}