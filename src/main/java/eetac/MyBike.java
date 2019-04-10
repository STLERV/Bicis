package eetac;

import java.util.List;

public interface MyBike {

    public static final int S = 10;


    public void addUser (String idUser, String name, String surname );
    public void addStation (String idStation, String name);
    public void addBike(String id, String  idStation, double km) throws StationException;
    public int numUsers();
    public int numStations();
    public int numBikes(String idStation) throws StationException;
    public List<Bike> listabicis(String idStation) throws StationException;
    public List<Bike> listabicidporkm (String idStation) throws StationException;
    public Bike getBike (String idStation, String idUser) throws StationException;
}
