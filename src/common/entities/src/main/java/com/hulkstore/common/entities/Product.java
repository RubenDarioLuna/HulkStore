package com.hulkstore.common.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends MasterEntity
{
    @Column( name = "image")
    private String _image;

    @OneToMany( mappedBy = "product" )
    private Set<Stock> _stockList;

    @ManyToOne
    @JoinColumn( name = "idTheme", nullable = false)
    private Theme _theme;

    @ManyToOne
    @JoinColumn( name = "idTypeProduct", nullable = false)
    private ProductType _productType;

    public Product()
    {
    }

    public Set<Stock> getStockList()
    {
        return _stockList;
    }

    public void setStockList( Set<Stock> stockList )
    {
        _stockList = stockList;
    }

    public Theme getTheme()
    {
        return _theme;
    }

    public void setTheme( Theme theme )
    {
        _theme = theme;
    }

    public ProductType getProductType()
    {
        return _productType;
    }

    public void setProductType( ProductType productType )
    {
        _productType = productType;
    }

    public String getImage()
    {
        return _image;
    }

    public void setImage( String image )
    {
        _image = image;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        if ( !super.equals( o ) )
        {
            return false;
        }
        Product product = ( Product ) o;
        return _image == product._image &&
               Objects.equals( _stockList, product._stockList ) && Objects.equals( _theme, product._theme ) &&
               Objects.equals( _productType, product._productType );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _image, _stockList, _theme, _productType );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Product{" );
        sb.append( "_image=" ).append( _image );
        sb.append( "_theme=" ).append( _theme );
        sb.append( "_productType=" ).append( _productType );
        sb.append( '}' );
        return sb.toString();
    }
}
