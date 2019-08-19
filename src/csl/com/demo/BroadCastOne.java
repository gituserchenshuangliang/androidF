package csl.com.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/*
 * 广播类
 */
public class BroadCastOne extends BroadcastReceiver{
	@Override
	public void onReceive(Context context, Intent intent) {
		/*
		 * 获取连接管理器
		 */
		@SuppressWarnings("static-access")
		ConnectivityManager cm = (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
		/*
		 * 网络信息
		 */
		NetworkInfo ni = cm.getActiveNetworkInfo();
		
		if(null != ni && ni.isAvailable()){
			Toast.makeText(context, "网络已连接！", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(context, "网络不可用！", Toast.LENGTH_SHORT).show();
		}
	}
}