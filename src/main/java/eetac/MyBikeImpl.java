package eetac;
import java.util.List;
import java.util.*;
import org.apache.log4j.Logger;


public class MyBikeImpl implements MyBike {

//////////////Singelton////////

    //
    final static Logger log = Logger.getLogger(MyBikeImpl.class.getName());
    private static MyBike instance;

    private Station stations[]; //vector de stations
    private LinkedList<Bike> bikes;
    private HashMap<String, User> users;
    private LinkedList<Bike> listaBikes;
    int numstations;

    public MyBikeImpl() {

        stations = new Station[MyBike.S];
        listaBikes = new LinkedList<Bike>();
        users = new HashMap<String, User>();
        bikes = new LinkedList<Bike>();
        numstations = 0;
    }


    public static MyBike getInstance() {

        if (instance == null) instance = new MyBikeImpl();

        return instance;

    }

    ////////////////////////////////

    ///HASH MAP
    public void addUser(String idUser, String name, String surname) {
        log.info("Añadir Usuario");//Poner info al inicio
        User u = new User(idUser, name, surname);
        this.users.put(idUser, u);
        log.info("Usuario añadido con exito" + name);
    }

    //Añadimos la estacion en un array de estaciones ARRAY
    public void addStation(String idStation, String name) {

        if (this.numstations < 11) {
            Station s = new Station(idStation, name);
            this.stations[this.numstations] = s;
            this.numstations++;
            log.info("Estación añadida");
        }


    }

//añadir la bici  a la lista de una estacion, primero miramos que estacion es (si existe),
// despues   miramos si tiene capacidad para la bici.

    public void addBike(String id, String idStation, double km) throws StationException {
        //listaBikes = new LinkedList<Bike>();

        Bike b = new Bike(id, idStation, km);
        Station s = null;

        for (int i = 0; i < this.numstations; i++) {
            System.out.println(idStation);
            System.out.println(this.stations[i]);
            if (idStation.equals(this.stations[i].idStation)) {
                s = this.stations[i];
            }
        }

        if (s != null) {

            s.addBike(b);

        } else {

            throw new StationException();
        }


    }


    public int numStations() {
        return this.numstations;
    }

    public int numUsers() {

        return this.users.size();

    }

    public List<Bike> listabicis(String idStation) throws StationException {

        List<Bike> bikeList = new LinkedList<Bike>();
        Station s = null;

        for (int i = 0; i < this.numstations; i++) {
            if (idStation.equals(this.stations[i].idStation)) {
                s = this.stations[i];
            }
        }
        if (s != null) {
            bikeList = s.getListaBikes();
            return bikeList;


        } else {
            throw new StationException();
        }


    }

    public List<Bike> listabicidporkm(String idStation) throws StationException {
        List<Bike> lista = new LinkedList<Bike>();
        Station sta = null;

        for (int i = 0; i < this.numstations; i++) {
            if (idStation.equals(this.stations[i].idStation)) {
                sta = this.stations[1];
            }
        }
        if (sta != null) {
            Collections.sort(lista, new Comparator<Bike>() {
                   public int compare(Bike o1, Bike o2) {
                    return (int)(o1.getKm()- o2.getKm());
                }
            });

        }
        else {
            throw new StationException();
        }
      return lista;
    }



    public int numBikes(String idStation) throws StationException {
        int numBikes = 0;
        Station s = null;

        for (int i = 0; i < this.numstations; i++) {
            if (idStation.equals(this.stations[i].idStation)) {
                s = this.stations[i];
            }
        }
        if (s != null){
            numBikes = s.getListaBikes().size();

        }
        else {
            throw new StationException();


        }
        return numBikes;
    }

    ///el get bike quira una bici a la estacion y la añade al usuario.
    public Bike getBike (String idStation, String idUser) throws StationException{
        //le damos el id user y nos da el user//
        User u = this.users.get(idUser);
        Station s = null;
        Bike b;

        for (int i = 0; i < this.numstations; i++) {
            if (idStation.equals(this.stations[i].idStation)) {
                s = this.stations[i];
            }
        }
        if (s != null){

            b = s.getListaBikes().poll();
            u.getBikeList().add(b);

        }
        else {
            throw new StationException();


        }
        return b;

    }
}