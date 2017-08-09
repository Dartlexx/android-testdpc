package com.afwsamples.testdpc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * This service is needed to emulate background activity in application for "Background activity" option to appear in
 * app's settings.
 */
public class FakeBackgroundActivityService extends Service {

	@Override
	public void onCreate() {
		super.onCreate();

		Log.d("FakeBackgroundService", "START FakeBackgroundActivityService");

		new Thread(() -> {
			try {
				for (int i=0; i < 100; i++) {
					Thread.sleep(100);
				}
			} catch (InterruptedException ignored) {
			}
		}).start();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return START_NOT_STICKY;
	}

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
