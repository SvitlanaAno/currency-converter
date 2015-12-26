package com.sanoshchenko.converter;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.AdapterViewProtocol;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ConverterActivityTest {

    @Rule
    public ActivityTestRule<Converter> mActivityRule = new ActivityTestRule<>(Converter.class);

    @Test
    public void testUahToUah() {
        onView(withId(R.id.valueEditText))
                .perform(typeText("100"));

        onView(withId(R.id.startButton))
                .perform(click());

        onView(withId(R.id.textView))
                .check(ViewAssertions
                        .matches(withText("100.0")));

    }

    @Test
    public void testUahToUSD() {
        onView(withId(R.id.valueEditText))
                .perform(typeText("100"));

        onView(withId(R.id.ComboboxTo)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("USD"))).perform(click());
        onView(withId(R.id.startButton))
                .perform(click());

        onView(withId(R.id.textView))
                .check(ViewAssertions
                        .matches(withText("4.2")));

    }


    @Test
    public void testUahToEUR() {
        onView(withId(R.id.valueEditText))
                .perform(typeText("10"));

        onView(withId(R.id.ComboboxTo)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("EUR"))).perform(click());

        onView(withId(R.id.startButton))
                .perform(click());

        onView(withId(R.id.textView))
                .check(ViewAssertions
                        .matches(withText("0.39")));

    }

    @Test
    public void testUahToRUB() {
        onView(withId(R.id.valueEditText))
                .perform(typeText("10000"));

        onView(withId(R.id.ComboboxTo)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("RUB"))).perform(click());
        onView(withId(R.id.startButton))
                .perform(click());

        onView(withId(R.id.textView))
                .check(ViewAssertions
                        .matches(withText("30000.0")));

    }

    @Test
    public void testUahToGBP() {
        onView(withId(R.id.valueEditText))
                .perform(typeText("100"));

        onView(withId(R.id.ComboboxTo)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("GBP"))).perform(click());

        onView(withId(R.id.startButton)).perform(click());

        onView(withId(R.id.textView))
                .check(ViewAssertions
                        .matches(withText("3.0")));

    }
}
