package com.example.diplom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.DocumentViewHolder> {
public ImageButton button;
private List<document> documents;
public static int DocOutID;
    public void setDocuments(List<document> documents) {
        this.documents = documents;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DocumentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.document_item, parent, false);
        return new DocumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentViewHolder holder, int position) {
        document document = documents.get(position);
        holder.bind(document);
        holder.setOnClickListener();
    }

    @Override
    public int getItemCount() {
        return documents != null ? documents.size() : 0;
    }

    class DocumentViewHolder extends RecyclerView.ViewHolder {
        private ImageView icon;
        private TextView name;

        public void setOnClickListener() {
            ImageButton button = itemView.findViewById(R.id.document_action);
            button.setOnClickListener(v -> {
                Context context = itemView.getContext();

                Intent intent = new Intent(context, readerActivity.class);
                context.startActivity(intent);
                if (button.getTag() instanceof Number) {
                    DocOutID = ((Number) button.getTag()).intValue();
                } else if (button.getTag() instanceof String) {
                    try {
                        DocOutID = Integer.parseInt((String) button.getTag());
                    } catch (NumberFormatException e) {
                        // Обработка ошибки
                    }
                }
            });
        }
        void bind(document document) {
            //icon.setImageResource(document.getIconResId());
            button = itemView.findViewById(R.id.document_action);
            name.setText(document.getDoc_name());
            button.setOnClickListener(v -> {    // Обработка клика по кнопке
            });
            button.setTag(document.getDoc_id());  //присвоение кнопке документа тега (такой же, как id)
        }
        DocumentViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.document_icon);
            name = itemView.findViewById(R.id.document_name);
            button = itemView.findViewById(R.id.document_action);
        }


    }
}
