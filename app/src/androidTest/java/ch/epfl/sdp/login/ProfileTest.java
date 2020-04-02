package ch.epfl.sdp.login;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.google.firebase.auth.FirebaseAuth;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import ch.epfl.sdp.MainActivity;
import ch.epfl.sdp.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class ProfileTest {
    @Mock
    private ArrayList mockList;
    private FirebaseAuth mockedAuth;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Rule
    public final ActivityTestRule<ProfileActivity> ProfileActivityRule =
            new ActivityTestRule<>(ProfileActivity.class);

    Instrumentation.ActivityMonitor monitor_signout = getInstrumentation().addMonitor(MainActivity.class.getName(),null,false);

    @Test
    public void test_profile(){
        assertNotNull(ProfileActivityRule.getActivity().findViewById(R.id.sign_out_button));
        onView(withId(R.id.sign_out_button)).perform(click());
        Activity MainActivity = getInstrumentation().waitForMonitorWithTimeout(monitor_signout, 5000);
        assertNotNull(MainActivity);

//        User user = new User("John");
//        user.setEmail("123@gmail.com");
    }
}
