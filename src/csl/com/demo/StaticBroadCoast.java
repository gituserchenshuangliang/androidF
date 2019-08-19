package csl.com.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
/**
 * 静态广播
 * @author Cherry
 * @date  2019年6月11日
 */
public class StaticBroadCoast extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "静态广播！", Toast.LENGTH_SHORT).show();
	}
}
