package ch.epfl.sdp;

import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class MainLoginTest {
    @Mock
    private ArrayList mockList;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Rule
    public final ActivityTestRule<MainLoginActivity> mainLoginActivityRule =
            new ActivityTestRule<>(MainLoginActivity.class);


    @Test
    public void test_signin(){
        assertNotNull(mainLoginActivityRule.getActivity().findViewById(R.id.signin_main));
        onView(withText("SIGN IN")).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.signin_main)).perform(click());

    }
}
