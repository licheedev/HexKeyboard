# HexKeyboard
16进制键盘
http://www.fampennings.nl/maarten/android/09keyboard/index.htm

## 添加依赖

```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
	
dependencies {
        implementation 'com.github.licheedev:HexKeyboard:0.1'
}
	
```

## 使用

```xml
<android.inputmethodservice.KeyboardView
    android:id="@+id/keyboardview"
    android:layout_width="fill_parent"
    android:layout_height="wrap_content"
    android:layout_alignParentBottom="true"
    android:layout_centerHorizontal="true"
    android:focusable="true"
    android:focusableInTouchMode="true"
    android:visibility="gone" />
```

```java
public class MainActivity extends Activity {

    HexKeyboard mHexKeyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHexKeyboard = new HexKeyboard(this, R.id.keyboardview);
        
        //mHexKeyboard.registerEditText(R.id.edittext1);
        //mHexKeyboard.registerEditText(R.id.edittext2);
        mHexKeyboard.registerEditText(R.id.edittext3);
        mHexKeyboard.registerEditText(R.id.edittext4);
    }

    @Override
    public void onBackPressed() {
        // NOTE Trap the back key: when the CustomKeyboard is still visible hide it, only when it is invisible, finish activity 
        if (mHexKeyboard.isCustomKeyboardVisible()) {
            mHexKeyboard.hideCustomKeyboard();
        } else {
            this.finish();
        }
    }
    
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.wrap(newBase, "en"));
    }
}


```

