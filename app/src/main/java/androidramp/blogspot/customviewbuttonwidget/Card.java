package androidramp.blogspot.customviewbuttonwidget;

/**
 * Created by Thanvandh on 11-11-2015.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Card extends RelativeLayout {

    private String stringHeader_1;
    private String stringHeader_2;
    private Drawable drawableIcon;
    private Drawable drawableLoyoutBg;

    private TextView textView1;
    private TextView textView2;
    private ImageView icon;
    private RelativeLayout layout;

    public Card(Context context) {
        super(context);
        init();
    }

    public Card(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init() {
        inflate(getContext(), R.layout.card, this);
        this.textView1 = (TextView) findViewById(R.id.header);
        this.textView2 = (TextView) findViewById(R.id.description);
        this.icon = (ImageView) findViewById(R.id.icon);
        this.layout = (RelativeLayout) findViewById(R.id.layout_bg);
    }

    private void init(Context context, AttributeSet attrs) {

        init();
        // Getting the attributes.
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.Card, 0, 0);
        try {
            stringHeader_1 = a.getString(R.styleable.Card_my_title_1);
            stringHeader_2 = a.getString(R.styleable.Card_my_title_2);
            drawableIcon = a.getDrawable(R.styleable.Card_my_icon);
            drawableLoyoutBg = a.getDrawable(R.styleable.Card_my_bg);

        } finally {
            a.recycle();
        }
        // Setting the attributes to view.
        this.textView1.setText(stringHeader_1);
        this.textView2.setText(stringHeader_2);
        this.icon.setImageDrawable(drawableIcon);
        this.layout.setBackgroundDrawable(drawableLoyoutBg);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);
        // Getting the height of layout.
        int h = layout.getHeight();
        // I can't set icon height here so I set the padding.
        int p = h / 4;
        this.icon.setPadding(p, p, p, p);
    }
}