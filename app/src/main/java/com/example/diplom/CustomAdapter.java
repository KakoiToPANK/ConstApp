package com.example.diplom;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static List<kurs> items;
    public CustomAdapter(List<kurs> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size(); // Возвращает размер списка
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.course_item, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CourseViewHolder) {
            ((CourseViewHolder) holder).bind((kurs) items.get(position));
            ((CourseViewHolder) holder).setOnClickListener(position);
            items.get(position).setItemView(holder.itemView);
        }
    }
}