package it.unipd.tos.business;

import java.util.ArrayList;

import java.util.List;
import java.time.LocalDate;
import java.time.Period;
import java.time.LocalTime;
import java.lang.Math;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.itemType;
import it.unipd.tos.model.User;
import it.unipd.tos.model.MenuItem;

public class TakeAwayBillImpl implements TakeAwayBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user, LocalTime time) throws RestaurantBillException {

        double price = 0;
       
        for (int i = 0; i < itemsOrdered.size(); i++) {
            
            price += itemsOrdered.get(i).getPrice();
        }
        
        return price;
    }

}