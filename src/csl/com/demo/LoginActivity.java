package csl.com.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
/**
 * 登录
 * @author Cherry
 * @date  2019年6月11日
 */
public class LoginActivity extends BaseActivity {
	private EditText account;
	private EditText password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		account = this.getEditTextObject(R.id.account);
		password = this.getEditTextObject(R.id.password);
		this.createListenButton(R.id.login);
	}
	
	@Override
	public void onClick(View v) {
//		if("chen".equals(account.getText().toString())&&"chen".equals(password.getText().toString())){
			Intent intent = new Intent(LoginActivity.this , MainActivity.class);
			startActivity(intent);
			finish();
//		}else{
//			Toast.makeText(LoginActivity.this, "账号或密码不正确！",Toast.LENGTH_SHORT).show();
//		}
	}
}
