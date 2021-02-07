package com.hulkstore.persistence;

import com.hulkstore.persistence.dao.CustomerDAO;
import com.hulkstore.persistence.dao.ProductDAO;
import com.hulkstore.persistence.dao.UserDAO;

public class DAOFactory
{
    public static ProductDAO createProductDAO( DBHandler handler ){ return new ProductDAO( handler ); }

    public static CustomerDAO createCustomerDAO( DBHandler handler ){ return new CustomerDAO( handler ); }

    public static UserDAO createUserDAO( DBHandler handler ){ return new UserDAO( handler ); }
}
