package it.unipd.tos.business;

import java.time.LocalTime;


import java.util.List;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.itemType;
import it.unipd.tos.model.User;
import it.unipd.tos.model.MenuItem;

public interface TakeAwayBill {
    double getOrderPrice(List<MenuItem> itemsOrdered, User user, LocalTime time) throws RestaurantBillException;
}