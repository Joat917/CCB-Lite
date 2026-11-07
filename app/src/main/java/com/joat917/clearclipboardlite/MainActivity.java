package com.joat917.clearclipboardlite;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboard != null) {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
                clipboard.clearPrimaryClip();
                Toast.makeText(this, "Clipboard Cleared", Toast.LENGTH_SHORT).show();
            }else{
                clipboard.setPrimaryClip(ClipData.newPlainText("", ""));
                Toast.makeText(this, "Clipboard Set Empty", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Clipboard is null", Toast.LENGTH_SHORT).show();
        }

        finishAndRemoveTask();
    }
}
