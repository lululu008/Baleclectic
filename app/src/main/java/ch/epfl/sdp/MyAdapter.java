package ch.epfl.sdp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String activitiesName[], activitiesDescription[];
    int imageSet[];
    Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    // initialize the class inside the activity
    public MyAdapter(Context ct, String activities_name[], String activities_description[], int artistImage[]) {
         context = ct;
         activitiesName = activities_name;
         activitiesDescription = activities_description;
         imageSet = artistImage;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Instantiates a layout XML file into its corresponding View objects.
        LayoutInflater inflater = LayoutInflater.from(context);
        //Inflate a new view hierarchy from the specified XML node.
        View view = inflater.inflate(R.layout.card_item, parent, false);
        return new MyViewHolder(view);
    }

    // Replace the contents of a view
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //using holder to find the elements
        holder.activities_name.setText(activitiesName[position]);
        holder.activities_details.setText(activitiesDescription[position]);
        holder.artist_image.setImageResource(imageSet[position]);
    }

    // pass number of items in the array
    @Override
    public int getItemCount() {
        return imageSet.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        //elements ID in Cardview: 2 textview and 1 imageview
        TextView activities_name, activities_details;
        ImageView artist_image;

        //MyViewHolder is communicating with onBindViewHolder
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //Find the element ID
            activities_name = itemView.findViewById(R.id.activities_name);
            activities_details = itemView.findViewById(R.id.activities_details);
            artist_image = itemView.findViewById(R.id.artist_image);
        }
    }


}