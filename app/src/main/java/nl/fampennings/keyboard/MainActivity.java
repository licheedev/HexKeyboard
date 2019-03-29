package nl.fampennings.keyboard;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.licheedev.hexkeyboard.HexKeyboard;
import com.licheedev.hexkeyboard.LocaleHelper;

public class MainActivity extends Activity {

    HexKeyboard mCustomKeyboard;

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomKeyboard = new HexKeyboard(this, R.id.keyboardview);

        //mCustomKeyboard.registerEditText(R.id.edittext1);
        //mCustomKeyboard.registerEditText(R.id.edittext2);
        mCustomKeyboard.registerEditText(R.id.edittext3);
        mCustomKeyboard.registerEditText(R.id.edittext4);
    }

    @Override
    public void onBackPressed() {
        // NOTE Trap the back key: when the CustomKeyboard is still visible hide it, only when it is invisible, finish activity 
        if (mCustomKeyboard.isCustomKeyboardVisible()) {
            mCustomKeyboard.hideCustomKeyboard();
        } else {
            this.finish();
        }
    }
    
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.wrap(newBase, "en"));
    }
}

