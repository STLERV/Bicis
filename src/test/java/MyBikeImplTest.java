import eetac.Bike;
import eetac.MyBike;
import eetac.MyBikeImpl;
import eetac.StationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;


public class MyBikeImplTest {

    MyBike mb;
       @Before

    public void SetUp()
    {

        System.out.println("SETUP");
        mb = MyBikeImpl.getInstance();
        this.mb = new MyBikeImpl();


        this.mb.addUser("1", "Patata", "AlHorno");



    }


    @Test
    public void addUsersTest() {
        this.mb.addUser("2", "Patatas", "AlHornoo");
        Assert.assertEquals(2, mb.numUsers());
    }
    //U

      @Test

    public void addBikesTest() throws StationException {
          this.mb.addStation("Station1", "Navas");
           this.mb.addBike( "Bici1","Station1", 12780);

          Assert.assertEquals(1, mb.numBikes("Station1"));

    }
    @Test

    public void addStation() throws StationException {

        this.mb.addStation("Station1", "Navas");
        this.mb.addStation("Station2", "manresa");
        Assert.assertEquals(2, mb.numStations());

    }
    @Test
    public void getBike () throws StationException{
        this.mb.addStation("Station1", "Navas");
        this.mb.addBike( "Bici1","Station1", 12780);
        this.mb.addUser("2", "Patatas", "AlHornoo");
        Bike b1 = this.mb.getBike("Station1", "2");
        Assert.assertEquals("Bici1",b1.getId());
        Assert.assertEquals(0, this.mb.numBikes("Station1"));
        LinkedList<Bike> list =  this.mb.lisabicisusuario("2");

    }

    @After

    public void tearDown(){
        this.mb = null;

    }


}
