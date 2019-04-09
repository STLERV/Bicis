package eetac;
public class Bike {

    String id;
    String idStation;
    double km;


    public Bike(String id, String idStation, double km) {
        this.id = id;
        this.idStation = idStation;
        this.km = km;
    }

    public Bike(String idBike){
        this.id = id;
        this.idStation = idStation;
        this.km = km;
    }
    public Bike() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
    }
}
