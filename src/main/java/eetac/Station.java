package eetac;

import java.util.LinkedList;
import java.util.List;

public class Station {

    String idStation;
    String name;
    private int max;
    public LinkedList<Bike> b;
    Bike bike;

    public Station(String idStation, int max) {
        this.idStation = idStation;
        this.max = max;
        this.b = new LinkedList<Bike>();
    }

    public Station(String idStation, String name) {
        this.name = name;
    }

    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public LinkedList<Bike> getB() {
        return b;
    }

    public void addBike(Bike bike){
        this.b.add(bike);

    }
    public LinkedList<Bike> getListaBikes(){
        return this.b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
