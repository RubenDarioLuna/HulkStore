package com.hulkstore.persistence.dao;

import com.hulkstore.common.exceptions.jpa.AddException;
import com.hulkstore.common.exceptions.jpa.ConstraintException;
import com.hulkstore.common.exceptions.jpa.DeleteException;
import com.hulkstore.common.exceptions.jpa.DetachException;
import com.hulkstore.common.exceptions.jpa.FindAllException;
import com.hulkstore.common.exceptions.jpa.FindException;
import com.hulkstore.common.exceptions.jpa.UpdateException;
import com.hulkstore.persistence.DBHandler;
import com.hulkstore.persistence.contracts.IBaseDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class BaseDAO<T> implements IBaseDAO<T>
{
    private Class<T> _class;
    private DBHandler _handler;

    private static Logger _logger = LoggerFactory.getLogger( BaseDAO.class );

    public BaseDAO( DBHandler handler )
    {
        _handler = handler;
        _class = (Class<T>) ( ( ParameterizedType ) getClass().getGenericSuperclass() ).getActualTypeArguments()[ 0 ];
    }

    public T insert( T entity )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a BaseDAO.insert: entity {}", entity );
        //endregion

        EntityManager em = _handler.getSession();

        try
        {
            em.persist( entity );
            em.flush();
        }
        catch ( PersistenceException | IllegalStateException e )
        {
            throw new ConstraintException( e, e.getMessage() );
        }
        catch ( Exception e )
        {
            throw new AddException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de BaseDAO.insert: entity {}", entity );
        //endregion

        return entity;
    }

    public T update( T entity )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a BaseDAO.update: entity {}", entity );
        //endregion

        EntityManager em = _handler.getSession();

        try
        {
            em.merge( entity );
            em.flush();
        }
        catch ( PersistenceException | IllegalStateException e )
        {
            throw new ConstraintException( e, e.getMessage() );
        }
        catch ( Exception e )
        {
            throw new UpdateException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de BaseDAO.update: entity {}", entity );
        //endregion

        return entity;
    }

    public T delete( T entity )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a BaseDAO.delete: entity {}", entity );
        //endregion

        EntityManager em = _handler.getSession();

        try
        {
            em.remove( entity );
            em.flush();
        }
        catch ( Exception e )
        {
            throw new DeleteException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de BaseDAO.delete: entity {}", entity );
        //endregion

        return entity;
    }

    public List<T> findAll()
    {
        final CriteriaQuery<T> criteriaQuery;
        final Root<T> root;

        List<T> list;

        //region Instrumentation DEBUG
        _logger.debug( "entrando a BaseDAO.findAll: class {}", _class );
        //endregion

        EntityManager em = _handler.getSession();

        try
        {
            criteriaQuery = em.getCriteriaBuilder().createQuery( _class );

            root = criteriaQuery.from( _class );
            criteriaQuery.select( root );

            list = em.createQuery( criteriaQuery ).getResultList();
        }
        catch ( Exception e )
        {
            throw new FindAllException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de BaseDAO.findAll: list {}", list );
        //endregion

        return list;
    }

    public T find( long id )
    {
        T result;

        //region Instrumentation DEBUG
        _logger.debug( "entrando a BaseDAO.find: id {} class {}", id, _class );
        //endregion

        try
        {
            result = _handler.getSession().find( _class, id );
        }
        catch ( Exception e )
        {
            throw new FindException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de BaseDAO.find: entity {}", result );
        //endregion

        return result;
    }

    public void detach( T entity )
    {
        //region Instrumentation DEBUG
        _logger.debug( "entrando a BaseDAO.detach: entity {}", entity );
        //endregion

        EntityManager em = _handler.getSession();

        try
        {
            em.detach( entity );
        }
        catch ( Exception e )
        {
            throw new DetachException( e, e.getMessage() );
        }

        //region Instrumentation DEBUG
        _logger.debug( "saliendo de BaseDAO.detach" );
        //endregion
    }

    public DBHandler getDBHandler()
    {
        return _handler;
    }
}

