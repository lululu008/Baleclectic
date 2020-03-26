package ch.epfl.sdp;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.android.internal.creation.AndroidByteBuddyMockMaker;
import org.mockito.junit.MockitoJUnitRunner;

import ch.epfl.sdp.dataModel.User;

@RunWith(MockitoJUnitRunner.class)
public class CloudStoreTest {

    @Mock
    FirebaseFirestore mockFirestore = org.mockito.Mockito.mock(com.google.firebase.firestore.FirebaseFirestore.class);
    private AndroidByteBuddyMockMaker PowerMock;

    @Test
    public void test(){
        CloudFireStore cloudFireStore = new CloudFireStore();
        User john = new User("John");
        cloudFireStore.deleteUser("123");
        cloudFireStore.addNewUser(john, "123");

    }
}
