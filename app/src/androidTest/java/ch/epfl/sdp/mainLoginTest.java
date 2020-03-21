package ch.epfl.sdp;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

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

@RunWith(AndroidJUnit4.class)
public class mainLoginTest {
    @Mock
    private ArrayList mockList;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Rule
    public final ActivityTestRule<mainLoginActivity> mainLoginActivityRule =
            new ActivityTestRule<>(mainLoginActivity.class);

    @Test
    public void test_signin(){
        assertNotNull(mainLoginActivityRule.getActivity().findViewById(R.id.signin_main));

    }
}
