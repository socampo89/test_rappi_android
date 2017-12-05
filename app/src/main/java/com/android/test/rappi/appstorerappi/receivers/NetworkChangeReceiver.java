package com.android.test.rappi.appstorerappi.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.test.rappi.appstorerappi.NetworkUtil;
import com.android.test.rappi.appstorerappi.application.App;

/**
 * Created by Sergio on 4/12/2017.
 */

public class NetworkChangeReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(final Context context, final Intent intent) {

        int status = NetworkUtil.getConnectivityStatusString(context);

        //if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if(status==NetworkUtil.NETWORK_STATUS_NOT_CONNECTED){
                App.getInstance().setConnected(false);
                Toast.makeText(context,"No hay coneccion a internet",Toast.LENGTH_LONG).show();
            }else{
                App.getInstance().setConnected(true);
                //Toast.makeText(context,"si hay conneccion a internet",Toast.LENGTH_SHORT).show();
            }

        //}
    }
}
