package ch.epfl.sdp;

import android.view.Gravity;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.epfl.sdp.timetable.Timetable;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.is;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public final ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

//    Instrumentation.ActivityMonitor monitor_login = getInstrumentation().addMonitor(MainLoginActivity.class.getName(),null,false);
//    Instrumentation.ActivityMonitor monitor_timetable = getInstrumentation().addMonitor(Timetable.class.getName(),null,false);

    @Test
    public void test_toolbar() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        //check toolbar tile
        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("Home")));

//        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.nav_map),
//                ViewMatchers.hasSibling(ViewMatchers.withText(((NavDrawerItem)item).
//                        getItemName())))).perform(ViewActions.click());

//        // onView(withId(R.id.mainName)).perform(typeText("from my unit test")).perform(closeSoftKeyboard());
//        onView(withId(R.id.timetableBtn)).perform(click());
//        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(swipeFromRightToLeft());
//        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(swipeFromBottomToTop());
//        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(swipeFromLeftToRight());
//        // onView(withId(R.id.greetingMessage)).check(matches(withText("Hello from my unit test!")));
//        Espresso.pressBack();
    }

    //check toolbar title function
    public static Matcher<View> withToolbarTitle(CharSequence title) {
        return withToolbarTitle(is(title));
    }

    public static Matcher<View> withToolbarTitle(final Matcher<CharSequence> textMatcher) {
        return new BoundedMatcher<View, Toolbar>(Toolbar.class) {
            @Override
            public boolean matchesSafely(Toolbar toolbar) {
                return textMatcher.matches(toolbar.getTitle());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with toolbar title: ");
                textMatcher.describeTo(description);
            }
        };
    }

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
    public void clickOnNavigationDrawer(){
        //timetable click
        Intents.init();
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer
        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_timetable));
        // Check that you Activity was opened.
        intended(hasComponent(Timetable.class.getName()));
        Intents.release();

        //Sign In click
        pressBack();
        Intents.init();
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer
        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_signin));
        // Check that you Activity was opened.
        intended(hasComponent(MainLoginActivity.class.getName()));
        Intents.release();

        //Profile
        pressBack();
        Intents.init();
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer
        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_profile));
        // Check that you Activity was opened.
        intended(hasComponent(ProfileActivity.class.getName()));
        Intents.release();
        pressBack();
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
