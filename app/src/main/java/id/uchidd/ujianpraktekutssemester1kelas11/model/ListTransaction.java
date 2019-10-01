package id.uchidd.ujianpraktekutssemester1kelas11.model;

import android.os.Bundle;

public class ListTransaction {

    public static final String TABLE_NAME = "tbl_list_transaction";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_BRAND = "brand";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_COLOR = "color";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_SIZE = "size";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_SUBTOTAL = "subtotal";
    public static final String COLUMN_RECIPIENT = "recipient";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_METHODSHIPPING = "methodshipping";
    public static final String COLUMN_TAX = "tax";
    public static final String COLUMN_METHODPAYMENT = "methodpayment";
    public static final String COLUMN_TOTAL = "total";
    public static final String COLUMN_TRANSACTIONDATE = "transactiondate";

    private int id;
    private String brand;
    private String name;
    private String color;
    private String price;
    private int size;
    private int quantity;
    private String subtotal;
    private String recipient;
    private String phone;
    private String address;
    private String methodshipping;
    private String tax;
    private String methodpayment;
    private String total;
    private String transactiondate;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME +
                    "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_BRAND + " TEXT," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_COLOR + " TEXT," +
                    COLUMN_PRICE + " TEXT," +
                    COLUMN_SIZE + " INTEGER," +
                    COLUMN_QUANTITY + " INTEGER," +
                    COLUMN_SUBTOTAL + " TEXT," +
                    COLUMN_RECIPIENT + " TEXT," +
                    COLUMN_PHONE + " TEXT," +
                    COLUMN_ADDRESS + " TEXT," +
                    COLUMN_METHODSHIPPING + " TEXT," +
                    COLUMN_TAX + " TEXT," +
                    COLUMN_METHODPAYMENT + " TEXT," +
                    COLUMN_TOTAL + " TEXT," +
                    COLUMN_TRANSACTIONDATE + " DATETIME DEFAULT CURRENT_TIMESTAMP" +
                    ")";

    public ListTransaction() {

    }

    public ListTransaction(int id,
                           String brand,
                           String name,
                           String color,
                           String price,
                           int size,
                           int quantity,
                           String subtotal,
                           String recipient,
                           String phone,
                           String address,
                           String methodshipping,
                           String tax,
                           String methodpayment,
                           String total,
                           String transactiondate) {

        this.id = id;
        this.brand = brand;
        this.name = name;
        this.color = color;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.recipient = recipient;
        this.phone = phone;
        this.address = address;
        this.methodshipping = methodshipping;
        this.tax = tax;
        this.methodpayment = methodpayment;
        this.total = total;
        this.transactiondate = transactiondate;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMethodshipping() {
        return methodshipping;
    }

    public void setMethodshipping(String methodshipping) {
        this.methodshipping = methodshipping;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getMethodpayment() {
        return methodpayment;
    }

    public void setMethodpayment(String methodpayment) {
        this.methodpayment = methodpayment;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(String transactiondate) {
        this.transactiondate = transactiondate;
    }


}
