package taskcom.android.manish.searchonrecyclerview.model;

/**
 * Created by Manish Kumar on 10/14/2018
 */
public class Student {
    private String name;
    private int id;
    private String branch;

    // If you require profile Image
    private String studentProfileImage;

    public Student(String name, int id, String branch) {
        this.name = name;
        this.id = id;
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public int getId() {
        return id;
    }
}
