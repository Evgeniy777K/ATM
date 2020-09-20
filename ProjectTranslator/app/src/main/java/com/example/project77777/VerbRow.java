package com.example.project77777;

import androidx.annotation.NonNull;

public class VerbRow {

    String binyan;
    String table_number;
    String vocalized_inflection;
    String morphology;
    String base_form;

    public VerbRow(String binyan, String table_number, String vocalized_inflection, String morphology, String base_form) {
        this.binyan = binyan;
        this.table_number = table_number;
        this.vocalized_inflection = vocalized_inflection;
        this.morphology = morphology;
        this.base_form = base_form;
    }

    String getAbc() {
        return this.base_form.substring(0, 1) +
                this.base_form.substring(1, 2) +
                this.base_form.substring(3, 4);
    }

    String getTense() {
        String m = this.morphology;
        int fpls = m.indexOf('+');
        int spls = m.indexOf('+', fpls);
        return m.substring(0, fpls);
    }

    String getChislo() {
        String m = this.morphology;
        int fpls = m.indexOf('+');
        int spls = m.indexOf("+", fpls + 1);
        int thridpls = m.indexOf("+", spls + 1);
        int fourpls = m.indexOf("+", thridpls + 1);
        return m.substring(thridpls + 1, fourpls);
    }

    String getPol() {
        String m = this.morphology;
        int fpls = m.indexOf('+');
        int spls = m.indexOf("+", fpls + 1);
        int thridpls = m.indexOf("+", spls + 1);
        return m.substring(spls + 1, thridpls);
    }

    String getEnd() {
        String m = this.morphology;
        int fpls = m.indexOf('+');
        int spls = m.indexOf("+", fpls + 1);
        int thridpls = m.indexOf("+", spls + 1);
        int fourpls = m.indexOf("+", thridpls + 1);
        int fivepls = m.indexOf("+", fourpls + 1);
        return m.substring(fourpls + 1, fivepls);


    }

    String getLitso() {
        String m = this.morphology;
        int fpls = m.indexOf('+');
        int spls = m.indexOf("+", fpls + 1);

        return m.substring(fpls + 1, spls);

    }

    String getMesto() {
        String m = "";

//        if (getLitso().equals("FIRST") && getChislo().equals("SINGULAR")) {
//            m = "Я - אֲנִי (анИ) ";
//        } else if (getLitso().equals("FIRST") && getChislo().equals("PLURAL")) {
//            m = "Мы – אֲנַחְנוּ (анАхну)";
//        } else if (getLitso().equals("SECOND") && getChislo().equals("SINGULAR") && getPol().equals("M")) {
//            m = "Ты (м.р.) - אַתָה(атА)";
//
//        } else if (getLitso().equals("SECOND") && getChislo().equals("SINGULAR") && getPol().equals("F")) {
//            m = "Ты (ж.р.)  - אַת (Ат)";
//        } else if (getLitso().equals("SECOND") && getChislo().equals("PLURAL") && getPol().equals("M")) {
//            m = "Вы (м.р.) – אַתֶם  (атЭм) ";
//        } else if (getLitso().equals("SECOND") && getChislo().equals("PLURAL") && getPol().equals("F")) {
//            m = "Вы (ж.р.) – אַתֶן (атЭн) ";
//        } else if (getLitso().equals("THIRD") && getChislo().equals("SINGULAR") && getPol().equals("M")) {
//            m = "Он – הוּא   (hУ) ";
//        } else if (getLitso().equals("THIRD") && getChislo().equals("SINGULAR") && getPol().equals("F")) {
//            m = " Она – הִיא  (hИ)";
//        } else if (getLitso().equals("THIRD") && getChislo().equals("PLURAL") && getPol().equals("M")) {
//            m = "Они (м.р.) – הֵם  (hЭм) ";
//        } else if (getLitso().equals("THIRD") && getChislo().equals("PLURAL") && getPol().equals("F")) {
//            m = "Они (ж.р.) – הֵן (hЭн)";
//        }

        return m;
    }


    public String toString2() {
        return this.binyan + ", " +
                this.table_number + ", " +
                this.vocalized_inflection + ", " +
                this.morphology + ", " +
                this.base_form + ", " +
                this.base_form.length() + "";
    }

    @NonNull
    @Override
    public String toString() {
        if (this.base_form.length() == 3) {
            return this.base_form.substring(0, 1) + this.base_form.substring(2, 3);
        } else if (this.base_form.length() == 4) {
            return this.base_form.substring(0, 1) + this.base_form.substring(3, 4);
        } else if (this.base_form.length() == 5 && this.binyan.equals("A") || this.base_form.length() == 5 && this.binyan.equals("B")
                || this.base_form.length() == 5 && this.binyan.equals("C") || this.base_form.length() == 5 && this.binyan.equals("D")
                || this.base_form.length() == 5 && this.binyan.equals("F")) {
            return this.base_form.substring(0, 1) + this.base_form.substring(2, 3) + this.base_form.substring(4, 5);
        } else if (this.base_form.length() == 6 || this.base_form.length() == 7) {
            return this.base_form.substring(0, 1) + this.base_form.substring(3, 4) + this.base_form.substring(5, 6);
        } else if (this.base_form.length() == 8) {
            return this.base_form.substring(0, 1) + this.base_form.substring(3, 4) + this.base_form.substring(6, 7);
        } else if (this.base_form.length() == 9) {
            return this.base_form.substring(0, 1) + this.base_form.substring(2, 3) + this.base_form.substring(4, 5) + this.base_form.substring(7, 8);
        } else if (this.base_form.length() == 10) {
            return this.base_form.substring(0, 1) + this.base_form.substring(2, 3) + this.base_form.substring(5, 6) + this.base_form.substring(8, 9);
        } else if (this.base_form.length() == 11) {
            return this.base_form.substring(0, 1) + this.base_form.substring(3, 4) + this.base_form.substring(6, 7) + this.base_form.substring(9, 10);
        } else if (this.base_form.length() == 12 && this.binyan.equals("C")) {
            return this.base_form.substring(0, 1) + this.base_form.substring(4, 5) + this.base_form.substring(0, 1) + this.base_form.substring(4, 5);
        } else if (this.base_form.length() == 12 && this.binyan.equals("E")) {
            return this.base_form.substring(0, 1) + this.base_form.substring(2, 3) + this.base_form.substring(4, 5) + this.base_form.substring(10, 11);
        } else if (this.base_form.length() == 12 && this.binyan.equals("F") || this.base_form.length() == 13 && this.binyan.equals("E")) {
            return this.base_form.substring(0, 1) + this.base_form.substring(2, 3) + this.base_form.substring(5, 6) + this.base_form.substring(8, 9) +
                    this.base_form.substring(11, 12);
        } else if (this.base_form.length() == 14) {
            return this.base_form.substring(0, 1) + this.base_form.substring(2, 3) + this.base_form.substring(4, 5) +
                    this.base_form.substring(7, 8) + this.base_form.substring(9, 10) + this.base_form.substring(12, 13);
        } else if (this.base_form.length() == 15) {
            return this.base_form.substring(0, 1) + this.base_form.substring(2, 3) + this.base_form.substring(5, 6) +
                    this.base_form.substring(8, 9) + this.base_form.substring(10, 11) + this.base_form.substring(13, 14);
        }
        return "";
    }

}


