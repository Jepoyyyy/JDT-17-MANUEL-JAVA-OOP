package org.indivaragroup.generic.compareableinterface;

public class Mahasiswa implements Comparable<Mahasiswa>{
    public String getNama() {
        return nama;
    }

    public double getIpk() {
        return ipk;
    }

    private String nama;
    private double ipk;
    public Mahasiswa(String nama,double ipk){
        this.nama=nama;
        this.ipk=ipk;
    }
    @Override
    public int compareTo(Mahasiswa lain) {
        return Double.compare(this.ipk,lain.ipk);
    }
    @Override
    public String toString() {
        return nama + " " + "IPK :" +ipk;
    }
}
