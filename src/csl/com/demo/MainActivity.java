package csl.com.demo;

import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 广播系统
 * 
 * @author Cherry
 * @date 2019年6月11日
 */
public class MainActivity extends BaseActivity {
	private IntentFilter intentFilter;
	private BroadCastOne bco;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.createListenButton(R.id.A);
		this.createListenButton(R.id.C);
		this.createListenButton(R.id.share);
		intentFilter = new IntentFilter();
		bco = new BroadCastOne();
		intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		/*
		 * 动态注册广播，参数：广播器，过滤器
		 */
		registerReceiver(bco, intentFilter);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(bco);
	}

	@Override
	public void onClick(View v) {
		if (R.id.A == v.getId()) {
			Intent intent = new Intent("com.csl.demo.MY_BROADCAST");
			/*
			 * 获取广播信息加入Intent之中
			 */
			String msg = ((TextView) findViewById(R.id.B)).getText().toString();
			intent.putExtra("broad", msg);
			/*
			 * 广播信息,标准广播,所有接收器都会一起接收
			 */
			sendBroadcast(intent);
			/*
			 * 有序广播,这种广播有阻断，只能一个一个的接收。
			 */
			// sendOrderedBroadcast(intent, null);
		} else if (R.id.C == v.getId()) {
			Intent intent = new Intent("com.csl.demo.OFFLINE");
			sendBroadcast(intent);
		} else if (R.id.share == v.getId()) {
			Uri uri = Uri.parse("content://com.csl.demo.databases.provider/book/1");
			Cursor cursor = getContentResolver().query(uri, null, null, null, null);
			if (cursor != null) {
				while (cursor.moveToNext()) {
					String name = cursor.getString(cursor.getColumnIndex("name"));
					String author = cursor.getString(cursor.getColumnIndex("author"));
					int pages = cursor.getInt(cursor.getColumnIndex("pages"));
					double price = cursor.getDouble(cursor.getColumnIndex("price"));
					Toast.makeText(this,name+author+pages+price, Toast.LENGTH_SHORT).show();
				}
				cursor.close();
			}else{
				Toast.makeText(this,"cursor is null", Toast.LENGTH_SHORT).show();
			}
			Cursor contacts = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null,
					null);
			if(contacts != null){
				Toast.makeText(this,"contacts is notnull", Toast.LENGTH_SHORT).show();
			}
		}
	}
}
