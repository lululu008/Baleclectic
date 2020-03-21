package ch.epfl.sdp;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class mainLoginTest {
    @Mock
    private ArrayList mockList;
//    private getInstance firebaseAuth.getInstance;
//    private getCurrentUser

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Rule
    public final ActivityTestRule<mainLoginActivity> mainLoginActivityRule =
            new ActivityTestRule<>(mainLoginActivity.class);
    private static final String TAG = "TestLogin";
    private static final String DEFAULT_APP_NAME = "[DEFAULT]";

    @Test
    public void test_signin(){
        assertNotNull(mainLoginActivityRule.getActivity().findViewById(R.id.signin_main));

//        when(FirebaseAuth.getInstance()).thenReturn(TAG,true);
//        assertEquals(FirebaseAuth.getInstance(), null);
//        //Mockito.when(FirebaseAuth.getInstance().getCurrentUser()).thenReturn(anyString());
//        when(getName()).thenReturn(DEFAULT_APP_NAME);

    }

    public void sampleTest1() throws Exception {
        mockList.add("one");
        mockList.clear();

        verify(mockList).add("one");
        verify(mockList).clear();
    }
}
