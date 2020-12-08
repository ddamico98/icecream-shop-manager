package it.unipd.tos.business;

import static org.junit.Assert.*;
import java.util.List;
import it.unipd.tos.business.TakeAwayBillImpl;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.*;

import org.junit.Test;

public class TakeAwayBillTest {

    @Test
    public void sconto_5() {
        TakeAwayBillImpl bill=new TakeAwayBillImpl();
        User u=new User(1,"Giovanni",LocalDate.of(1999, 5, 3));
        List<MenuItem> ord=new ArrayList<MenuItem>();
        ord.add(new MenuItem(itemType.Gelati,"Fragola",2));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Gelati,"Nocciola",3));
        ord.add(new MenuItem(itemType.Budini,"Caramello",2));
        ord.add(new MenuItem(itemType.Bevande,"Fanta",2));
        try {
            assertEquals(bill.getOrderPrice(ord,u,LocalTime.of(18,26)),20.0,0.0001);
        }
        catch(RestaurantBillException e){
            fail();
        }
    }
	
}
