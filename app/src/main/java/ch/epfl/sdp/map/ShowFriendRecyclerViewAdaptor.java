package ch.epfl.sdp.map;

packagech.epfl.sdp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ch.epfl.sdp.R;
import ch.epfl.sdp.dataModel.User;
import ch.epfl.sdp.map.MeetingPoint;

public class ShowFriendRecyclerViewAdaptor extends RecyclerView.Adapter<ShowFriendRecyclerViewAdaptor.MyViewHolder>{

        private MeetingPoint meetingPoint;
        private String friendList[];
        Context context;

        public ShowFriendRecyclerViewAdaptor(Context ct,MeetingPoint meetingPoint){
            context=ct;
            friendList = getFriendList(meetingPoint);
        }

        public String[]getFriendList(MeetingPoint meetingPoint){

            ArrayList<User> meetingUsers = meetingPoint.getMeetingUsers();
            friendList = new String[meetingUsers.size()];

            //getName()fromeachuser
            for(User user:meetingUsers){
                //if this user is in my friendslist
                if(meetingUsers.equals(this.getFriends())){
                //append user's name to the friendList
                    friendList.append(user.getName());
                }
            }

            return friendList;
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{
        //eachdataitemisjustastringinthiscase
            TextView friendName;
            public MyViewHolder(View itemView){
                super(itemView);
                 friendName=itemView.findViewById(R.id.friendName);
            }
        }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        TextView v=(TextView)LayoutInflater.from(parent.getContext())
        .inflate(R.layout.activity_show_friends,parent,false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
        }

    public void onBindViewHolder(@NonNull MyViewHolder holder,int position){
        holder.friendName.setText(friendList[position]); }

    @Override
    public int getItemCount(){
        return friendList.length;
        }
}
