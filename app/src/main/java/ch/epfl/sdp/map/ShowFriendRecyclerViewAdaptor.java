package ch.epfl.sdp.map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ch.epfl.sdp.CloudFireStore;
import ch.epfl.sdp.R;
import ch.epfl.sdp.dataModel.User;
import ch.epfl.sdp.map.MeetingPoint;

public class ShowFriendRecyclerViewAdaptor extends RecyclerView.Adapter<ShowFriendRecyclerViewAdaptor.MyViewHolder> {

    //using ArrayList or String []
    private ArrayList<String> friendList = new ArrayList<>();
    private Context context;
    private ArrayList<User> meetingUsers;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser mUser = mAuth.getCurrentUser();
    //from Firebase user.getEmail() to User class user
    private String mEmail = mUser.getEmail();
    private User user = CloudFireStore.getUser();
    private ArrayList<User> mFriends = user.getFriends();



    public ShowFriendRecyclerViewAdaptor(Context ct, MeetingPoint meetingPoint){
            context=ct;
            getFriendList(meetingPoint);
        }


        public void getFriendList(MeetingPoint meetingPoint) {

            meetingUsers = meetingPoint.getMeetingUsers();

            //getName()from each user
            for (User user : meetingUsers) {
                for (User matchFriends : mFriends) {
                    //if this user is in my friendslist
                    if (user.equals(matchFriends)) {
                        friendList.add(user.getName());
                    }
                }
            }
        }


        public static class MyViewHolder extends RecyclerView.ViewHolder{
        //each data item is just a string in this case
            TextView friendName;
            public MyViewHolder(View itemView){
                super(itemView);
                 friendName=itemView.findViewById(R.id.friendName);
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
            View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.show_friend_textview,parent,false);
            MyViewHolder vh = new MyViewHolder(v);
            return vh;
            }

        public void onBindViewHolder(@NonNull MyViewHolder holder,int position){
            holder.friendName.setText(friendList.get(position)); }

        @Override
        public int getItemCount(){
            return friendList.size();
        }
}
