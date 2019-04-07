
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
        this.mb.addStation("Station1", "Navas");
        this.mb.addStation("Station2", "manresa");
        this.mb.addBike( "Bici1","Station1", 12780);

    }


    @Test
    public void addUsersTest() {
        this.mb.addUser("2", "Patatas", "AlHornoo");
        Assert.assertEquals(2, mb.numUsers());
    }
    //U

      @Test

    public void addBikesTest() {
        Assert.assertEquals(1, mb.numBikes("Station1"));

    }
    @Test

    public void addStation() {
        Assert.assertEquals(2, mb.numStations());

    }

    @After

    public void tearDown(){

    }


}
