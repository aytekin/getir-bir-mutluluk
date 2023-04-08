package com.example.demo.common.constants;

import lombok.Getter;

@Getter
public class RegexConstants {

    public static final String USERNAME = "^[a-zA-Z0-9_.]{3,20}$";

    public static final String EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String PASSWORD = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{0,}$";

    public static final String ONLY_ALPHABET = "^[A-Za-zğüşiöç]+$";
    public static final String FIRST_NAME = "^([a-zA-Zğüşiöç]{2,}\\s?([a-zA-Zğüşiöç]{1,})?\\s?([a-zA-Zğüşiöç]{1,})?)";

    public static final String ONLY_NUMBER = "^[0-9]*$";
    public static final String COMPANY_NAME = "";
    public static final String GENERAL_CHECK = "";
}
