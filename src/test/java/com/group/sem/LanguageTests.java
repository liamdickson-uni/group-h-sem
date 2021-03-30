package com.group.sem;

import org.junit.jupiter.api.BeforeAll;

public class LanguageTests {


    static Language language;

    @BeforeAll
    static void init()
    {
       language = Language.getInstance();
    }

}
