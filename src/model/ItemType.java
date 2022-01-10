package model;

public enum ItemType {
    Houseware("do gia dung"), food("thuc pham"), fashion("thoi trang");

    String value;

    ItemType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
