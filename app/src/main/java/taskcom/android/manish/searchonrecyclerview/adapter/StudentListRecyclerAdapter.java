package taskcom.android.manish.searchonrecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import taskcom.android.manish.searchonrecyclerview.R;
import taskcom.android.manish.searchonrecyclerview.model.Student;

/**
 * Created by Manish Kumar on 10/14/2018
 */
public class StudentListRecyclerAdapter extends RecyclerView.Adapter<StudentListRecyclerAdapter.StudentListViewHolder> {

    private ArrayList<Student> studentArrayList;
    private Context context;

    public StudentListRecyclerAdapter(ArrayList<Student> studentArrayList, Context context) {
        this.studentArrayList = studentArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row, viewGroup, false);
        return new StudentListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListViewHolder studentListViewHolder, int i) {
        studentListViewHolder.tvName.setText(studentArrayList.get(i).getName());
        studentListViewHolder.tvId.setText("" + studentArrayList.get(i).getId());
        studentListViewHolder.tvBranch.setText(studentArrayList.get(i).getBranch());
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

    public void modifyList(ArrayList<Student> matchedStudentList) {
        studentArrayList = matchedStudentList;
        notifyDataSetChanged();
    }

    public class StudentListViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvId;
        public TextView tvBranch;

        public StudentListViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_student_name);
            tvId = itemView.findViewById(R.id.tv_student_id);
            tvBranch = itemView.findViewById(R.id.tv_student_branch);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "" + studentArrayList.get(getAdapterPosition()).getName() + " " + studentArrayList.get(getAdapterPosition()).getId(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}