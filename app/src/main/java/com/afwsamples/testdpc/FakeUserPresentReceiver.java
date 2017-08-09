package com.afwsamples.testdpc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Only used to start FakeBackgroundActivityService
 */
public class FakeUserPresentReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		context.startService(new Intent(context, FakeBackgroundActivityService.class));
	}
}
