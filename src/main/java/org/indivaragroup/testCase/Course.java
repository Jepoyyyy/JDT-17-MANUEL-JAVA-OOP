package org.indivaragroup.testCase;

public class Course<T extends Number> {
    private String namaPeserta;
    private T nilai;

    public Course(String namaPeserta, T nilai) {
        this.namaPeserta = namaPeserta;
        this.nilai = nilai;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public T getNilai() {
        return nilai;
    }

    public void setNilai(T nilai) {
        this.nilai = nilai;
    }

    public String getStatus() {
        int angkaNilai = this.nilai.intValue();
        if (angkaNilai >= 85) {
            return "Excellent";
        } else if (angkaNilai >= 70) {
            return "Good";
        } else if (angkaNilai >= 50) {
            return "Remedial";
        } else {
            return "Failed";
        }
    }

    public void tampilkanData() {
        System.out.println("Nama Peserta : " + namaPeserta);
        System.out.println("Nilai         : " + nilai);
        System.out.println("Status        : " + getStatus());
    }
}