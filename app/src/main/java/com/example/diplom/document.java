package com.example.diplom;

public class document {
    public int doc_id;
    public String doc_name;
    public String ref;
    public int sectoin_id;

    public void document(int docId, String name, String ref, int sec_id) {
        this.doc_id = docId;
        this.doc_name = name;
        this.ref = ref;
        this.sectoin_id = sec_id;
    }
    public void setDoc_id(int docId) {
        this.doc_id = docId;
    }
    public void setDoc_name(String name) {
        this.doc_name = name;
    }
    public void setRef(String ref) {
        this.ref = ref;
    }
    public void setSectoin_id(int id) {
        this.sectoin_id = id;
    }
    public int getDoc_id() {
        return doc_id;
    }
    public int getSectoin_id() {
        return sectoin_id;
    }
    public String getDoc_name() {
        return doc_name;
    }
    public String getRef() {
        return ref;
    }
}
