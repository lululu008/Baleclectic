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
import static androidx.test.espresso.matcher.ViewMatchers.withId;


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
    public void check_toolbar(){
        onView(withId(R.id.action_notifications))
                .perform(click());
        // Open the overflow menu OR open the options menu,
        // depending on if the device has a hardware or software overflow menu button.
//        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
//        onView(withText("About"))
//                .perform(click());
////        onView(withId(R.id.action_about))
////                .perform(click());
////        onView(withId(R.id.action_settings))
////                .perform(click());
    }
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
