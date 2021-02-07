package com.hulkstore.common;

import com.hulkstore.common.entities.Brand;
import com.hulkstore.common.entities.Character;
import com.hulkstore.common.entities.ClothesType;
import com.hulkstore.common.entities.CrockeryType;
import com.hulkstore.common.entities.Customer;
import com.hulkstore.common.entities.Order;
import com.hulkstore.common.entities.OrderProduct;
import com.hulkstore.common.entities.Output;
import com.hulkstore.common.entities.Product;
import com.hulkstore.common.entities.ProductType;
import com.hulkstore.common.entities.Stock;
import com.hulkstore.common.entities.Theme;
import com.hulkstore.common.entities.ToyType;
import com.hulkstore.common.entities.User;


public class EntityFactory
{
    public static Brand createBrand() { return new Brand(); }

    public static Character createCharacter(){ return new Character(); }

    public static ClothesType createClothesType(){ return new ClothesType(); }

    public static CrockeryType createCrockeryType(){ return new CrockeryType(); }

    public static Customer createCustomer(){ return new Customer(); }

    public static Customer createCustomer( User user ){ return new Customer( user ); }

    public static Order createOrder(){ return new Order(); }

    public static OrderProduct createOrderProduct(){ return new OrderProduct(); }

    public static Output createOutput(){ return new Output(); }

    public static Product createProduct(){ return new Product(); }

    public static ProductType createProductType(){ return new ProductType(); }

    public static Stock createStock(){ return new Stock(); }

    public static Theme createTheme(){ return new Theme(); }

    public static ToyType createToyType(){ return new ToyType(); }

    public static User createUser(){ return new User(); }

    public static User createUser( User user){ return new User( user ); }
}