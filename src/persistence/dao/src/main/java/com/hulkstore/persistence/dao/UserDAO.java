package com.hulkstore.persistence.dao;

import com.hulkstore.common.entities.User;
import com.hulkstore.persistence.DBHandler;
import com.hulkstore.persistence.contracts.IUserDAO;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class UserDAO extends BaseDAO<User> implements IUserDAO
{
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public UserDAO( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }
}