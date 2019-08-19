package csl.com.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 自定义广播
 * @author Cherry
 * @date  2019年6月11日
 */
public class BroadCastTwo extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		/*
		 * 显示Intent中的广播信息
		 */
		Toast.makeText(context, intent.getStringExtra("broad"), Toast.LENGTH_SHORT).show();
		/*
		 * 终止广播
		 */
		//abortBroadcast();
	}

}
