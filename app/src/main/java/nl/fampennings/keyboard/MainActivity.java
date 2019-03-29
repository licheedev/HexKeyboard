package nl.fampennings.keyboard;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends Activity {

    CustomKeyboard mCustomKeyboard;
    value v;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v = new value();
        //demo();
        //print();
        mCustomKeyboard = new CustomKeyboard(this, R.id.keyboardview, R.xml.hexkbd);
        txt = (TextView) findViewById(R.id.textview0);

        mCustomKeyboard.registerEditText(R.id.edittext1);
        mCustomKeyboard.registerEditText(R.id.edittext2);
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
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        txt.setText("X " + touchX + "  Y " + touchY);
        return super.onTouchEvent(event);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.wrap(newBase, "fr"));
    }

    public void demo() {

        // Color threshold
        int th = 85;
        int count = 0;
        for (int i = 0; i <= 255; i = i + th) {
            for (int j = 0; j <= 255; j = j + th) {
                for (int k = 0; k <= 255; k = k + th) {
                    System.out.print(" value are " + i + "  " + j + "   " + k);
                    Log.e(" value are", " " + i + "  " + j + "   " + k);

                    v.setArray(i, j, k);

                    count++;
                }
            }
        }
        Log.e(" counts are ", String.valueOf(count));
    }

    public void print() {

        for (int i = 0; i < v.getarraylist().size(); i++) {

            Log.e(" new  value are", " "
                + v.getarraylist().get(i).get(0)
                + "  "
                + v.getarraylist().get(i).get(1)
                + "   "
                + v.getarraylist().get(i).get(2));
        }
    }
}

