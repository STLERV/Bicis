public interface MyBike {

    public static final int S = 10;


    public void addUser (String idUser, String name, String surname );
    public void addStation (String idStation, String name);
    public void addBike(String id, String  idStation, double km);
    public int numUsers();
    public int numStations();
    public int numBikes(String idStation);


}