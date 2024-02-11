package tests;

import com.github.javafaker.Faker;
import config.ProjectConfig;
import org.aeonbits.owner.ConfigFactory;
import utils.RandomUtils;

import static utils.RandomUtils.*;

public class TestData {
    ProjectConfig projectConfig = ConfigFactory.create(ProjectConfig.class);
    Faker faker = new Faker();
    RandomUtils randomUtils = new RandomUtils();

    public String firstName = projectConfig.firstName(),
            lastName = projectConfig.lastName(),
            userEmail = projectConfig.userEmail(),
            userGender = getRandomGender(),
            userPhoneNumber = faker.phoneNumber().subscriberNumber(10),
            setDayRandom = randomUtils.generateDayRandom,
            dayRandom = ((Integer.parseInt(setDayRandom) < 10) ? "00" + setDayRandom : "0" + setDayRandom),
            monthRandom = getRandomMonth(),
            yearRandom = Integer.toString((getRandomInt(1940, 2005))),
            userSubjects = getRandomSubjects(),
            userHobbies = getRandomHobbies(),
            loadPicture = projectConfig.imageName(),
            currentAddress = faker.address().fullAddress(),
            randomState = faker.options().option("NCR",
                    "Uttar Pradesh", "Haryana", "Rajasthan"),
            randomCity = randomUtils.getRandomCity(randomState);
}

