package tests;

import com.github.javafaker.Faker;
import utils.RandomUtils;

import static utils.RandomUtils.*;

public class TestData {

    Faker faker = new Faker();
    RandomUtils randomUtils = new RandomUtils();

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = getRandomGender(),
            userPhoneNumber = faker.phoneNumber().subscriberNumber(10),
            setDayRandom = randomUtils.generateDayRandom,
            dayRandom = ((Integer.parseInt(setDayRandom) < 10) ? "00" + setDayRandom : "0" + setDayRandom),
            monthRandom = getRandomMonth(),
            yearRandom = Integer.toString((getRandomInt(1940, 2005))),
            usersubjects = getRandomSubjects(),
            userHobbies = getRandomHobbies(),
            currentAddress = faker.address().fullAddress(),
            randomState = faker.options().option("NCR",
                    "Uttar Pradesh", "Haryana", "Rajasthan"),
            randomCity = randomUtils.getRandomCity(randomState);
}

