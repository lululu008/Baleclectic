package ch.epfl.sdp;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertNotNull;
import android.app.Activity;
import android.app.Instrumentation;

import ch.epfl.sdp.login.MainLoginActivity;
import ch.epfl.sdp.timetable.Timetable;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public final ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    private static ViewAction swipeFromRightToLeft() {
        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.CENTER_RIGHT,
                GeneralLocation.CENTER_LEFT, Press.FINGER);
    }

    private static ViewAction swipeFromBottomToTop() {
        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.BOTTOM_CENTER,
                GeneralLocation.TOP_CENTER, Press.FINGER);
    }

    private static ViewAction swipeFromLeftToRight() {
        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.CENTER_LEFT,
                GeneralLocation.CENTER_RIGHT, Press.FINGER);
    }

    Instrumentation.ActivityMonitor monitor_login = getInstrumentation().addMonitor(MainLoginActivity.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor_timetable = getInstrumentation().addMonitor(Timetable.class.getName(),null,false);

    @Test
    public void testCanGreetUsers() {
        // onView(withId(R.id.mainName)).perform(typeText("from my unit test")).perform(closeSoftKeyboard());
        onView(withId(R.id.timetableBtn)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(swipeFromRightToLeft());
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(swipeFromBottomToTop());
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(swipeFromLeftToRight());
        // onView(withId(R.id.greetingMessage)).check(matches(withText("Hello from my unit test!")));
        Espresso.pressBack();
    }

    @Test
    public void testButtons(){
        //test timetable Button
        assertNotNull(mActivityRule.getActivity().findViewById(R.id.timetableBtn));
        onView(withId(R.id.timetableBtn)).perform(click());
        Activity Timetable = getInstrumentation().waitForMonitorWithTimeout(monitor_timetable, 5000);
        assertNotNull(Timetable);
        Espresso.pressBack();

        //test mainlogin Button
        assertNotNull(mActivityRule.getActivity().findViewById(R.id.mainloginBtn));
        onView(withId(R.id.mainloginBtn)).perform(click());
        Activity mainloginActivity = getInstrumentation().waitForMonitorWithTimeout(monitor_login, 5000);
        assertNotNull(mainloginActivity);
        Espresso.pressBack();
    }

}
