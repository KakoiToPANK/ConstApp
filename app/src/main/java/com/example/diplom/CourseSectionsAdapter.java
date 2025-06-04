package com.example.diplom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourseSectionsAdapter extends RecyclerView.Adapter<CourseSectionsAdapter.SectionViewHolder> {

    private List<razdel> sections;

    public CourseSectionsAdapter(List<razdel> sections) {
        this.sections = sections;
    }

    @NonNull
    @Override
    public SectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.section, parent, false);
        return new SectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionViewHolder holder, int position) {
        razdel section = sections.get(position);
        holder.bind(section);
    }

    @Override
    public int getItemCount() {
        return sections.size();
    }

    // ViewHolder для раздела
    class SectionViewHolder extends RecyclerView.ViewHolder {
        private TextView sectionTitle;
        private RecyclerView documentsRecycler;
        private DocumentAdapter documentAdapter;

        SectionViewHolder(View itemView) {
            super(itemView);
            sectionTitle = itemView.findViewById(R.id.section_title);
            documentsRecycler = itemView.findViewById(R.id.documents_recycler);

            // Настройка RecyclerView для документов
            documentsRecycler.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            documentAdapter = new DocumentAdapter();
            documentsRecycler.setAdapter(documentAdapter);
        }

        void bind(razdel section) {
            sectionTitle.setText(section.getTitle());
            documentAdapter.setDocuments(section.getDocuments());
        }
    }
}
