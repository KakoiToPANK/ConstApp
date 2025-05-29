package com.example.diplom;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class CourseViewHolder extends RecyclerView.ViewHolder {
    private final TextView title;

    public CourseViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.course_title);
    }

    public void bind(@NonNull kurs Kurs) {
        title.setText(Kurs.get_title());
    }
}
