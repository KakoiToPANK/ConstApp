package com.example.diplom;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class CourseViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView des;
    private ImageView preview;
    private TextView id;
    public Button button;
    public static int outID;

    public CourseViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.course_title);
        des = itemView.findViewById(R.id.course_des);
        id = itemView.findViewById(R.id.id_plate);
        button = itemView.findViewById(R.id.button6);
        preview = itemView.findViewById(R.id.imageView);
    }

    public void bind(@NonNull kurs Kurs) {
        title.setText(Kurs.get_title());
        des.setText(Kurs.get_des());
        id.setText(String.valueOf(Kurs.get_id()));
        button.setTag(Kurs.get_id());
        preview.setImageBitmap(Kurs.get_preview());
    }

    public void setOnClickListener(int position) {
        outID = -1;
        Button button = itemView.findViewById(R.id.button6);
        button.setOnClickListener(v -> {
            Context context = itemView.getContext();

            //получение тэга
            if (button.getTag() instanceof Number) {
                outID = ((Number) button.getTag()).intValue();
            } else if (button.getTag() instanceof String) {
                try {
                    outID = Integer.parseInt((String) button.getTag());
                } catch (NumberFormatException e) {
                    // Обработка ошибки
                }
            }

            Intent intent = new Intent(context, courseUseActivity.class);
            context.startActivity(intent);
        });
    }

}
