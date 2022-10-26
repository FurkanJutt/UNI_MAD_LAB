package com.UlBululStudios.mad_lab;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomHolder> {

    private List<AndroidVersions> versionsList;
    private Context context;
    private int notifCount = 0;

    public CustomAdapter(List<AndroidVersions> versionsList) {
        this.versionsList = versionsList;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        context = parent.getContext();
        return new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
        AndroidVersions android = versionsList.get(position);
        holder.tvAndroidName.setText(android.getVerName());
        holder.tvAndroidVer.setText(android.getVerNumber());
        holder.itemListMainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: implement push notifications
               /* NotificationChannel notificationChannel=new NotificationChannel("id","name",NotificationManager.IMPORTANCE_LOW);

                NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(context, "id")
                    .setSmallIcon(R.mipmap.ic_launcher_foreground)
                    .setContentTitle("@string/app_name")
                    .setContentText(holder.tvAndroidName.getText().toString())
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManager notifManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                notifManager.createNotificationChannel(notificationChannel);
                notifManager.notify(notifCount, notifBuilder.build());
                notifCount++;*/

                Toast.makeText(view.getContext(), "Clicked! " + holder.tvAndroidName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return versionsList.size();
    }

}

class CustomHolder extends RecyclerView.ViewHolder {

    protected TextView tvAndroidName, tvAndroidVer;
    protected ConstraintLayout itemListMainLayout;

    public CustomHolder(@NonNull View itemView) {
        super(itemView);

        tvAndroidName = itemView.findViewById(R.id.tv_version_name);
        tvAndroidVer = itemView.findViewById(R.id.tv_version_number);
        itemListMainLayout = itemView.findViewById(R.id.item_list_main_layout);
    }
}
