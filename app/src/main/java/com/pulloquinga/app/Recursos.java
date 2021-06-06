package com.pulloquinga.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Recursos {
    static void texto_no_editable(EditText edit_text) {
        edit_text.setFocusable(false);
        edit_text.setEnabled(false);
        edit_text.setCursorVisible(false);
        edit_text.setKeyListener(null);

    }

    public static Intent enlaces(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
        return intent;
    }
    public static <T> ArrayList<T> listToArrayList(List<T> list) {
        return list != null ? new ArrayList<>(list) : null;
    }



}
