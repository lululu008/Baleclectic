package ch.epfl.sdp;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class TimeTableTest {
    @Rule
    public final ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);
    private MainActivity MainActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(LoginActivity.class.getName(),null,false);

    private static ViewAction swipeFromRightToLeft() {
        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.TOP_RIGHT,
                GeneralLocation.TOP_LEFT, Press.FINGER);
    }

    private static ViewAction swipeFromBottomToTop() {
        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.BOTTOM_CENTER,
                GeneralLocation.TOP_CENTER, Press.FINGER);
    }

    private static ViewAction swipeFromLeftToRight() {
        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.TOP_LEFT,
                GeneralLocation.TOP_RIGHT, Press.FINGER);
    }

    @Before
    public void setUp() throws Exception{
        MainActivity = mActivityRule.getActivity();
    }

    @Test
    public void testCanSwipe() {
        onView(withId(R.id.timetableBtn)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(swipeFromRightToLeft());
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(swipeFromBottomToTop());
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(swipeFromLeftToRight());
    }
    public void testLoginButton(){
        View view = MainActivity.findViewById(R.id.signin_main);
        assertNotNull(view);
        onView(withId(R.id.signin_main)).perform(click());
        Activity LoginActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(LoginActivity);
        LoginActivity.finish();
    }

    @After
    public void teardown() throws Exception{
        MainActivity = null;
    }
}
