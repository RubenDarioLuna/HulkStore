package com.hulkstore.persistence.dao;

import com.hulkstore.common.entities.Product;
import com.hulkstore.persistence.DBHandler;
import com.hulkstore.persistence.contracts.IProductDAO;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class ProductDAO extends BaseDAO<Product> implements IProductDAO
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public ProductDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }
}
