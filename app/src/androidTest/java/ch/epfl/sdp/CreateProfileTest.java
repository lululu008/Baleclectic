package ch.epfl.sdp;

import android.content.Intent;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


public class CreateProfileTest {

    @Rule
    public final ActivityTestRule<CreateUserProfile> LoginActivityRule =
            new ActivityTestRule<>(CreateUserProfile.class);

    @Test
    public void test_create(){

        onView(withId(R.id.register_button)).perform(click());
        onView(withId(R.id.date_yy)).perform(typeText("1999")).perform(closeSoftKeyboard());
        onView(withId(R.id.register_button)).perform(click());
        onView(withId(R.id.date_mm)).perform(typeText("01")).perform(closeSoftKeyboard());
        onView(withId(R.id.register_button)).perform(click());
        onView(withId(R.id.date_dd)).perform(typeText("01")).perform(closeSoftKeyboard());
        onView(withId(R.id.register_button)).perform(click());
        onView(withId(R.id.user_name_edit)).perform(typeText("John")).perform(closeSoftKeyboard());
        onView(withId(R.id.register_button)).perform(click());
        onView(withId(R.id.female)).perform(click());
        onView(withId(R.id.register_button)).perform(click());

    }

}
