package com.example.diplom;

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

    private List<document> documents;

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
    }

    @Override
    public int getItemCount() {
        return documents != null ? documents.size() : 0;
    }

    class DocumentViewHolder extends RecyclerView.ViewHolder {
        private ImageView icon;
        private TextView name;
        private ImageButton actionButton;

        DocumentViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.document_icon);
            name = itemView.findViewById(R.id.document_name);
            actionButton = itemView.findViewById(R.id.document_action);
        }

        void bind(document document) {
            //icon.setImageResource(document.getIconResId());
            name.setText(document.getDoc_name());

            actionButton.setOnClickListener(v -> {
                // Обработка клика по кнопке
            });
        }
    }
}
