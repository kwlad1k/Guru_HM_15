package utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    Faker faker = new Faker();

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }

    public static String getRandomSubjects() {
        String[] genders = {"English", "Chemistry", "Computer Science",
                "Commerce", "Economics", "Social Studies", "Arts", "History",
                "Maths", "Accounting", "Social Studies"};
        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }

    public static String getRandomHobbies() {
        String[] genders = {"Sports", "Reading", "Music"};
        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }

    public String generateDayRandom = Integer.toString(faker.number().numberBetween(1, 31));

    public static String getRandomMonth() {
        String[] genders = {"January", "February", "March",
                "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};
        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }

    public String getRandomCity(String value) {
        switch (value) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
        }
        return "Not_Found";
    }

}
