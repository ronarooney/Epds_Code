package com.example.epds_new;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;

@TargetApi(Build.VERSION_CODES.HONEYCOMB) public class ContactusFragment extends Fragment {
	public  Context context;
	public GoogleMap map;
	@TargetApi(Build.VERSION_CODES.HONEYCOMB) @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.contact, container, false);
     Button call=(Button)rootView.findViewById(R.id.callUs);
     PhoneCallListener phoneListener = new PhoneCallListener();
		TelephonyManager telephonyManager = (TelephonyManager) getActivity()
				.getSystemService(Context.TELEPHONY_SERVICE);
		telephonyManager.listen(phoneListener,
				PhoneStateListener.LISTEN_CALL_STATE);
		context=getActivity();
     call.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
			 alertDialogBuilder.setTitle("Give a Call");
			 alertDialogBuilder
             .setMessage("You are about to call Epds Himachal Pradesh")
             .setCancelable(false)
             .setPositiveButton("Call",new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog,int id) {
                     // if this button is clicked, close
                     // current activity
                     Intent callIntent = new Intent(Intent.ACTION_CALL);
                     callIntent.setData(Uri.parse("tel:1967"));
                     startActivity(callIntent);

                 }
             })
             .setNegativeButton("Don't Call", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog, int id) {
                     // if this button is clicked, just close
                     // the dialog box and do nothing
                     dialog.cancel();
                 }
             });
			  AlertDialog alertDialog = alertDialogBuilder.create();
			  alertDialog.show();

		}
	});
     Button map = (Button)rootView.findViewById(R.id.viewMap);
     map.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		Intent i = new Intent(getActivity(),EpdsCentre.class);
		startActivity(i);
		}
	});
        return rootView;
    }
	private class PhoneCallListener extends PhoneStateListener {

		private boolean isPhoneCalling = false;

		String LOG_TAG = "LOGGING 123";

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {

			if (TelephonyManager.CALL_STATE_RINGING == state) {
				// phone ringing
				Log.i(LOG_TAG, "RINGING, number: " + incomingNumber);
			}

			if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
				// active
				Log.i(LOG_TAG, "OFFHOOK");

				isPhoneCalling = true;
			}

			if (TelephonyManager.CALL_STATE_IDLE == state) {
				// run when class initial and phone call ended, need detect flag
				Log.i(LOG_TAG, "IDLE");

				if (isPhoneCalling) {

					Log.i(LOG_TAG, "restart app");

					// restart app
					// Intent i =
					// getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
					// i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					if ((getActivity().getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
						// Activity was brought to front and not created,
						// Thus finishing this will get us to the last viewed
						// activity
						getActivity().finish();
						return;
					}
					isPhoneCalling = false;
				}

			}
		}
	}
}
