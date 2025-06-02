package com.example.diplom;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
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

    public void setOnClickListener(int position) {
        Button button = itemView.findViewById(R.id.button6);
        button.setOnClickListener(v -> {
            Context context = itemView.getContext();
            Intent intent = new Intent(context, courseUseActivity.class);
            context.startActivity(intent);
        });
    }

}
