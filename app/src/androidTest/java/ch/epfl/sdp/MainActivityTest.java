package ch.epfl.sdp;

import android.view.Gravity;

import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public final ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickOnHomePage() {
        //Home page click
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer
        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_home));
    }

    @Test
    public void check_onBackPressed() {
        // Open Drawer
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer
        pressBack();
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))); // Left Drawer should be closed.
    }

    @Test
    public void check_notifications(){
        onView(withId(R.id.action_notifications))
                .perform(click());
        onView(withText(R.string.TOAST_notifications)).
                inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView()))).
                check(matches(isDisplayed()));
    }

//    @Test
//    public void check_settings(){
//        onView(withId(R.id.action_settings))
//                .perform(click());
//        onView(withText(R.string.TOAST_settings)).
//                inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView()))).
//                check(matches(isDisplayed()));
//    }

//    @Test
//    public void testButtons(){
//        //test timetable Button
//        assertNotNull(mActivityRule.getActivity().findViewById(R.id.timetableBtn));
//        onView(withId(R.id.timetableBtn)).perform(click());
//        Activity Timetable = getInstrumentation().waitForMonitorWithTimeout(monitor_timetable, 5000);
//        assertNotNull(Timetable);
//        Espresso.pressBack();
//    }

}
