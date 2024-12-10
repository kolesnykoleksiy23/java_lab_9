package com.education.ztu.oleksiy.task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String employeesData = """
            Іван Іванов, 30 років, розробник, 5 років досвіду, 20.05.1995, Київ, ivan.ivanov@gmail.com, +380123456789
            Марія Петрівна, 25 років, тестувальник, 2 роки досвіду, 15.03.1998, Львів, maria.petrovna@gmail.com, +380987654321
            Олег Коваленко, 35 років, менеджер проектів, 10 років досвіду, 01.09.1988, Харків, oleg.kovalenko@gmail.com, +380555666777
            Наталія Сергієнко, 28 років, дизайнер, 4 роки досвіду, 12.12.1995, Одеса, natalia.sergienko@gmail.com, +380999888777
            Петро Сидоренко, 40 років, аналітик, 15 років досвіду, 25.07.1983, Дніпро, petro.sydorenko@gmail.com, +380112233445
        """;

        System.out.println("--- Номери телефонів ---");
        Pattern phonePattern = Pattern.compile("\\+380\\d{9}");
        Matcher phoneMatcher = phonePattern.matcher(employeesData);
        while (phoneMatcher.find()) {
            System.out.println(phoneMatcher.group());
        }

        System.out.println("--- Емайли ---");
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher emailMatcher = emailPattern.matcher(employeesData);
        while (emailMatcher.find()) {
            System.out.println(emailMatcher.group());
        }


        System.out.println("--- Оновлений формат дат народження ---");
        Pattern datePattern = Pattern.compile("\\b(\\d{2})\\.(\\d{2})\\.(\\d{4})\\b");
        Matcher dateMatcher = datePattern.matcher(employeesData);
        String updatedData = dateMatcher.replaceAll("$3-$2-$1");
        System.out.println(updatedData);


        System.out.println("--- Оновлені посади ---");
        updatedData = updatedData.replace("розробник", "старший розробник")
                .replace("тестувальник", "старший тестувальник")
                .replace("аналітик", "головний аналітик");
        System.out.println(updatedData);
    }
}
