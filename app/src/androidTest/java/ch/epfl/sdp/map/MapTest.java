package ch.epfl.sdp.map;

import android.os.Build;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
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
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

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

    private static ViewAction swipeFromBottomToTop() {
        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.BOTTOM_CENTER,
                GeneralLocation.TOP_CENTER, Press.FINGER);
    }

    private static ViewAction swipeFromLeftToRight() {
        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.CENTER_LEFT,
                GeneralLocation.CENTER_RIGHT, Press.FINGER);
    }

    @Test
    public void testCanOpenMap() {
        onView(ViewMatchers.withId(R.id.mapBtn)).perform(click());

        clickOkIfNeeded();
        allowPermissionsIfNeeded();

        onView(withId(R.id.mapSelect1Btn)).perform(click());
        onView(withId(R.id.showMapBtn)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.map)).perform(swipeFromRightToLeft());

        Espresso.pressBack();
        Espresso.pressBack();
        onView(withId(R.id.mapSelect2Btn)).perform(click());
        onView(withId(R.id.showMapBtn)).perform(click());

    }

    private void clickOkIfNeeded()  {
        if (Build.VERSION.SDK_INT >= 23) {
            UiObject clickOk = mDevice.findObject(new UiSelector().text("OK"));
            if (clickOk.exists()) {
                try {
                    clickOk.click();
                } catch (UiObjectNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void allowPermissionsIfNeeded()  {
        if (Build.VERSION.SDK_INT >= 23) {
            UiObject allowPermissions = mDevice.findObject(new UiSelector().text("Allow"));
            if (allowPermissions.exists()) {
                try {
                    allowPermissions.click();
                } catch (UiObjectNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else {
                allowPermissions = mDevice.findObject(new UiSelector().text("Allow only while using the app"));
                if (allowPermissions.exists()) {
                    try {
                        allowPermissions.click();
                    } catch (UiObjectNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
