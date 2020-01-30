package com.example.steevegpsappclient;

import android.app.IntentService;
import android.location.Geocoder;

public class FetchAddressIntentService extends IntentService {
    protected ResultReceiver receiver;

    @Override
    protected void onHandleIntent(Intent intent) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        // ...

        private void deliverResultToReceiver ( int resultCode, String message){
            Bundle bundle = new Bundle();
            bundle.putString(Constants.RESULT_DATA_KEY, message);
            receiver.send(resultCode, bundle);

        }
    }
}
