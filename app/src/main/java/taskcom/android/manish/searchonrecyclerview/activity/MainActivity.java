package taskcom.android.manish.searchonrecyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

import taskcom.android.manish.searchonrecyclerview.R;
import taskcom.android.manish.searchonrecyclerview.adapter.StudentListRecyclerAdapter;
import taskcom.android.manish.searchonrecyclerview.model.Student;

/**
 * Created by Manish Kumar on 10/14/2018
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentListRecyclerAdapter adapter;
    private EditText etSearch;
    private ArrayList<Student> studentArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        studentArrayList = getStudentList();
        adapter = new StudentListRecyclerAdapter(studentArrayList, this);
        recyclerView.setAdapter(adapter);


        etSearch = findViewById(R.id.et_search);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String studentToSearch = s.toString();
                findMatchedStudent(studentToSearch);
            }
        });
    }

    private void findMatchedStudent(String studentToSearch) {
        ArrayList<Student> matchedStudentList = new ArrayList<>();
        for (Student student : studentArrayList) {
            if (student.getName().toLowerCase().contains(studentToSearch.toLowerCase())) {
                matchedStudentList.add(student);
            }

        }
        adapter.modifyList(matchedStudentList);
    }

    private ArrayList<Student> getStudentList() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("Manish", 1001, "CSE"));
        studentArrayList.add(new Student("Rahul", 1002, "ME"));
        studentArrayList.add(new Student("Rakesh", 1003, "EEE"));
        studentArrayList.add(new Student("Harry", 1004, "ME"));
        studentArrayList.add(new Student("Vikash", 1005, "ME"));
        studentArrayList.add(new Student("Pranav", 1006, "EEE"));
        studentArrayList.add(new Student("Deepak", 1007, "ME"));
        studentArrayList.add(new Student("Viru", 1008, "IT"));
        studentArrayList.add(new Student("Gopal", 1009, "IT"));
        return studentArrayList;
    }
}
