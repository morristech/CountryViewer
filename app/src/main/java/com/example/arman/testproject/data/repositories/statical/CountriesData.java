package com.example.arman.testproject.data.repositories.statical;

import com.example.arman.testproject.data.db.entity.Country;

import java.util.ArrayList;
import java.util.List;

public class CountriesData {

    public static List<Country> getCountries() {
        final List<Country> countries = new ArrayList<>();
        countries.add(new Country("Австрия", "Вена", 83859, 8534000));
        countries.add(new Country("Албания", "Тирана", 28747, 2901000));
        countries.add(new Country("Андорра", "Андорра-ла-Велья", 468, 70000));
        countries.add(new Country("Беларусь", "Минск", 208000, 9488000));
        countries.add(new Country("Великобритания", "Лондон", 242495, 66000000));
        countries.add(new Country("Венгрия", "Будапешт", 93030, 9781000));
        countries.add(new Country("Венгрия", "Будапешт", 93030, 9781000));
        countries.add(new Country("Германия", "Берлин", 357386, 82000000));
        countries.add(new Country("Греция", "Афины", 131957, 10770000));
        countries.add(new Country("Исландия", "Рейкьявик", 103000, 338349));
        countries.add(new Country("Испания", "Мадрид", 505990, 46000000));
        countries.add(new Country("Италия", "Мадрид", 505990, 46000000));
        countries.add(new Country("Италия", "Рим", 301338, 60000000));
        countries.add(new Country("Мальта", "Валлетта", 316, 460000));
        countries.add(new Country("Молдова", "Валлетта", 316, 460000));
        countries.add(new Country("Нидерланды", "Амстердам", 41543, 17000000));
        countries.add(new Country("Норвегия", "Осло", 385203, 5000000));
        countries.add(new Country("Польша", "Варшава", 312679, 37000000));
        countries.add(new Country("Россия", "Москва", 17100000, 144000000));
        countries.add(new Country("Финляндия", "Хельсинки", 338424, 5000000));
        countries.add(new Country("Франция", "Париж", 643801, 67000000));
        countries.add(new Country("Чехия", "Прага", 78865, 10000000));
        return countries;
    }
}
