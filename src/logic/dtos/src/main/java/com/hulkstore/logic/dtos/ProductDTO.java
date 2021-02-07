package com.hulkstore.logic.dtos;

import java.util.List;

public class ProductDTO extends MasterDTO
{
    public String _image;
    public List<StockDTO> _stockList;
    public ThemeDTO _theme;
    public ProductTypeDTO _productType;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "ProductDTO{" );
        sb.append( ", _image=" ).append( _image );
        sb.append( ", _theme=" ).append( _theme );
        sb.append( ", _productType=" ).append( _productType );
        sb.append( '}' );
        return sb.toString();
    }
}
