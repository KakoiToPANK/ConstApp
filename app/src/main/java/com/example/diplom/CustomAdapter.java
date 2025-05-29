package com.example.diplom;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_COURSE = 0;
    private final List<Object> items;

    public CustomAdapter(List<Object> items) {
        this.items = items;
    }
    @Override
    public int getItemViewType(int position) {
        Object item = items.get(position);
        if (item instanceof kurs) {
            return TYPE_COURSE;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == TYPE_COURSE) {
            View view = inflater.inflate(R.layout.course_item, parent, false);
            return new CourseViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CourseViewHolder) {
            ((CourseViewHolder) holder).bind((kurs) items.get(position));
        }
    }
}