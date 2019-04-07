
import java.util.List;
import java.util.*;


public class MyBikeImpl implements MyBike {

//////////////Singelton////////

    private static MyBike instance;

    private Station stations[]; //vector de stations
    private LinkedList<Bike> bikes;
    private HashMap<String, User> users;
    private LinkedList<Bike> listaBikes;
    int numstations;

    public MyBikeImpl() {

        stations = new Station[S];
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

        User u = new User(idUser, name, surname);
        this.users.put(idUser, u);
    }

    //Añadimos la estacion en un array de estaciones ARRAY
    public void addStation(String idStation, String name) {

        if (this.numstations < 11) {
            Station s = new Station(idStation, name);
            s = this.stations[this.numstations];
            this.numstations++;

        }
        else{}

    }

//añadir la bici  a la lista de una estacion, primero miramos que estacion es (si existe),
// despues   miramos si tiene capacidad para la bici.

    public void addBike(String id, String idStation, double km) {
        //listaBikes = new LinkedList<Bike>();

        Bike b = new Bike(id, idStation, km);
        Station s = null;

        for (int i = 0; i < this.numstations; i++) {
            if (idStation.equals(this.stations[i].idStation)) {
                s = this.stations[i];
            }
        }

        if (s != null) {

            // si la estacion existe miramos si cabe y la metemos.
            //pero de mmento solo la metemos.

            s.addBike(b);

        }
        else {}


    }


    public int numStations() {
        return this.numstations;
    }

    public int numUsers() {

            return this.users.size();

    }

    public int numBikes(String idStation) {
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
            numBikes = 0;

        }
        return numBikes;
    }
}