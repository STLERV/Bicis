import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class MyBikeImplTest {

    MyBike mb;
       @Before

    public void SetUp()
    {
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
          this.mb.addBike( "Bici1","Station1", 12780);

          Assert.assertEquals(1, mb.numBikes("Station1"));

    }
    @Test

    public void addStation() throws StationException {

        this.mb.addStation("Station1", "Navas");
        this.mb.addStation("Station2", "manresa");
        Assert.assertEquals(2, mb.numStations());

    }

    @After

    public void tearDown(){
        this.mb = null;

    }


}
