package extreme.in.co.daggerApp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import extreme.in.co.daggerApp.ui.model.GetUserModel;
import extreme.in.co.daggerApp.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>
{
    Context context;
    private List<GetUserModel.Datum> getUserList= new ArrayList<>();
    private int position;


    public UserAdapter(Context context, List<GetUserModel.Datum> getUserList)
    {
        this.context = context;
        this.getUserList = getUserList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inflate_userlist, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    public int getCount()
    {
        return getUserList.size();
    }
    public GetUserModel.Datum getItem(int position)
    {
        return getUserList.get(position);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {

        this.position = position;
        holder.tv_username.setText(getUserList.get(position).getFirstName()+" "+getUserList.get(position).getLastName());
        Picasso.with(context).load(getUserList.get(position).getAvatar()).into(holder.iv_pic);

    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public int getItemCount()
    {
        return getUserList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public final TextView tv_username;
        public final ImageView iv_pic;


        public ViewHolder(View view)
        {
            super(view);

            tv_username = view.findViewById(R.id.tv_username);
            iv_pic = (ImageView) view.findViewById(R.id.iv_pic);
        }


    }


}