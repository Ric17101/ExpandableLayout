package sg.firstcom.expandablelayout.exampleexpanded;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import sg.firstcom.expandablelayout.R;


public class ExampleReadMoreActivity extends AppCompatActivity implements View.OnClickListener {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, ExampleReadMoreActivity.class));
    }

    private Button mExpandButton;
    private ExpandableRelativeLayout mExpandLayout;
    private TextView mOverlayText;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_read_more);

        getSupportActionBar().setTitle(ExampleReadMoreActivity.class.getSimpleName());

        mExpandButton = (Button) findViewById(R.id.expandButton);
        mExpandLayout = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout);
        mOverlayText = (TextView) findViewById(R.id.overlayText);
        mExpandButton.setOnClickListener(this);

        mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mExpandLayout.move(mOverlayText.getHeight(), 0, null);

                mOverlayText.getViewTreeObserver().removeOnGlobalLayoutListener(mGlobalLayoutListener);
            }
        };
        mOverlayText.getViewTreeObserver().addOnGlobalLayoutListener(mGlobalLayoutListener);
    }

    @Override
    public void onClick(final View v) {
        if (v.getId() == R.id.expandButton) {
            mExpandLayout.expand();
            mExpandButton.setVisibility(View.GONE);
            mOverlayText.setVisibility(View.GONE);
        }
    }
}