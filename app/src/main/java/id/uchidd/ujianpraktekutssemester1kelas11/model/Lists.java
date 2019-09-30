package id.uchidd.ujianpraktekutssemester1kelas11.model;

public class Lists {

    public static final String TABLE_NAME = "tbl_lists" ;

    public static final String COLUMN_ID = "id" ;
    public static final String COLUMN_LISTS = "list" ;
    public static final String COLUMN_TIMESTAMP = "timestamp" ;

    private int id;
    private String list;
    private String timestamp;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME +
                    "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_LISTS + " TEXT," +
                    COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP" +
                    ")";

    public Lists() {

    }

    public Lists(int id, String list, String timestamp) {
        this.id = id;
        this.list = list;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return list;
    }

    public void setNote(String note) {
        this.list = note;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
