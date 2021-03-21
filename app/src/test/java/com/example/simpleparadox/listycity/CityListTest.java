package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());

        cityList.add(new City("Regina", "Saskatchewan"));

        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(new City("Regina", "Saskatchewan")));
    }

    @Test
    void testDelete(){
        CityList cityList = mockCityList();
        cityList.add(new City("Regina", "Saskatchewan"));

        City city = new City("Vancouver", "British Columbia");
        cityList.delete(city);

        assertEquals(false, cityList.hasCity(city));
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });

    }

}
