package com.arturomejiamarmol.droidtalks;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


/**
 * Created by Arturo Mejia on 8/14/17.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
    }

    @Test
    public void openMainActivityShouldShowTopics() {
        onView(withId(R.id.list)).check(matches(isDisplayed()));
    }

    @Test
    public void clickOnTopicShouldShowTopicDetails() {

        //Clicking  topics item
        onView(withId(R.id.list)).perform(actionOnItemAtPosition(0, click()));


        //Checking if the talks are displayed
        onView(withId(R.id.talks)).check(matches(isDisplayed()));


    }

    @Test
    public void clickOnEventsTabShouldShowEvents() {
        ViewInteraction tabView = onView(withId(R.id.viewpager));
        tabView.perform(swipeLeft());

        tabView.check(matches(isDisplayed()));

        onView(withId(R.id.events)).check(matches(isDisplayed()));

    }

}
