package ch.epfl.sdp.map;

import android.view.Gravity;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.epfl.sdp.MainActivity;
import ch.epfl.sdp.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MapTest {

    UiDevice mDevice = UiDevice
            .getInstance(InstrumentationRegistry.getInstrumentation());

    @Rule
    public final ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    private static ViewAction swipeFromRightToLeft() {
        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.CENTER_RIGHT,
                GeneralLocation.CENTER_LEFT, Press.FINGER);
    }

    @Test
    public void testCanOpenMap() {

        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer
        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_map));

        clickOkIfNeeded();
        allowLocationPermissionsIfNeeded();
        allowLocationOnlyPermissionsIfNeeded();

        onView(withId(R.id.mapSelect1Btn)).perform(click());
        onView(withId(R.id.showMapBtn)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.map)).perform(swipeFromRightToLeft());

        Espresso.pressBack();
        Espresso.pressBack();
        onView(withId(R.id.mapSelect2Btn)).perform(click());
        onView(withId(R.id.showMapBtn)).perform(click());
        Espresso.pressBack();
        Espresso.pressBack();
        Espresso.pressBack();

    }

    @Test
    public void testCanGetLocation() {

        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer
        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_map));

        clickOkIfNeeded();
        allowLocationPermissionsIfNeeded();
        allowLocationOnlyPermissionsIfNeeded();

        onView(withId(R.id.mockMapSelectBtn)).perform(click());
        onView(withId(R.id.showDistanceBtn)).perform(click());
        onView(withId(R.id.updateLocationButton)).perform(click());

        String empty = "";
        String rlc = "Rolex Learning Center";

        onView(withId(R.id.textView)).check(matches(not(withText(empty))));
        onView(withId(R.id.textView)).check(matches(withSubstring(rlc)));

        Espresso.pressBack();
        Espresso.pressBack();
        Espresso.pressBack();

    }

    private void clickOkIfNeeded()  {
        UiObject uio = mDevice.findObject(new UiSelector().textMatches(".*(?i:ok).*"));
        clickIfExists(uio);
    }

    private void allowLocationPermissionsIfNeeded()  {
        UiObject uio = mDevice.findObject(new UiSelector().text("ALLOW"));
        clickIfExists(uio);
    }

    private void allowLocationOnlyPermissionsIfNeeded()  {
        UiObject uio = mDevice.findObject(new UiSelector().textMatches("Allow only while using the app"));
        clickIfExists(uio);
    }

    private void clickIfExists(UiObject uio) {
        if (uio.exists()) {
            try {
                uio.click();
            } catch (UiObjectNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
