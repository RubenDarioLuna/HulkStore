package com.hulkstore.persistence.dao;

import com.hulkstore.common.entities.Customer;
import com.hulkstore.persistence.DBHandler;
import com.hulkstore.persistence.contracts.ICustomerDAO;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class CustomerDAO extends BaseDAO<Customer> implements ICustomerDAO
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public CustomerDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }
}
