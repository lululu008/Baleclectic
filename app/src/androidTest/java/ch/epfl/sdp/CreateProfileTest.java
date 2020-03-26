package ch.epfl.sdp;

import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.android.internal.creation.AndroidByteBuddyMockMaker;
import org.mockito.junit.MockitoJUnitRunner;

import ch.epfl.sdp.dataModel.User;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CreateProfileTest {
    private static final int RC_SIGN_IN = 123;
    private CloudFireStore cloudFireStore = new CloudFireStore();

    @Mock
    FirebaseFirestore db = org.mockito.Mockito.mock(com.google.firebase.firestore.FirebaseFirestore.class);
    private AndroidByteBuddyMockMaker PowerMock;
    //AuthUI mockUI = org.mockito.Mockito.mock(com.firebase.ui.auth.AuthUI.class);

    @Before
    public void setup(){
        //PowerMock.createMock(com.firebase.ui.auth.AuthUI.class);
    }

    @Rule
    public final ActivityTestRule<CreateUserProfile> CreateProfileRule =
            new ActivityTestRule<>(CreateUserProfile.class);

    @Test
    public void test_create(){

        onView(withId(R.id.user_name_edit)).perform(typeText("John")).perform(closeSoftKeyboard());
        onView(withId(R.id.date_dd)).perform(typeText("01")).perform(closeSoftKeyboard());
        onView(withId(R.id.date_mm)).perform(typeText("01")).perform(closeSoftKeyboard());
        onView(withId(R.id.date_yy)).perform(typeText("1999")).perform(closeSoftKeyboard());
        onView(withId(R.id.register_button)).perform(click());

    }

}
