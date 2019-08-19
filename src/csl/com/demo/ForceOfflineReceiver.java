package csl.com.demo;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.WindowManager;
/**
 * 强制下线广播
 * @author Cherry
 * @date  2019年6月11日
 */
public class ForceOfflineReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(final Context context, Intent intent) {
		AlertDialog.Builder ab = new AlertDialog.Builder(context);
		ab.setTitle("强制下线提示！");
		ab.setMessage("此账号登录异常或者其他设备上已登录！");
		ab.setCancelable(false);
		
		ab.setPositiveButton("确定", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				BaseActivity.ActivityManager.exitAllActivity();
				Intent intent = new Intent(context,LoginActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent); 
			}
		});
		
		AlertDialog alertDialog = ab.create();
		// 需要设置AlertDialog的类型，保证在广播接收器中可以正常弹出
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		alertDialog.show();
	}

}
