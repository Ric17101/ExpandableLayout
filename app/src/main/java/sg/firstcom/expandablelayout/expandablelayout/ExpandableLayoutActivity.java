package sg.firstcom.expandablelayout.expandablelayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import sg.firstcom.expandablelayout.R;

public class ExpandableLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, ExpandableLayoutActivity.class));
    }

    private Button mExpandButton;
    private Button mMoveChildButton;
    private Button mMoveChildButton2;
    private Button mMoveTopButton;
    private Button mSetCloseHeightButton;
    private ExpandableRelativeLayout mExpandLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_layout);

        getSupportActionBar().setTitle(ExpandableLayoutActivity.class.getSimpleName());

        mExpandButton = (Button) findViewById(R.id.expandButton);
        mMoveChildButton = (Button) findViewById(R.id.moveChildButton);
        mMoveChildButton2 = (Button) findViewById(R.id.moveChildButton2);
        mMoveTopButton = (Button) findViewById(R.id.moveTopButton);
        mSetCloseHeightButton = (Button) findViewById(R.id.setCloseHeightButton);
        mExpandLayout = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout);
        mExpandButton.setOnClickListener(this);
        mMoveChildButton.setOnClickListener(this);
        mMoveChildButton2.setOnClickListener(this);
        mMoveTopButton.setOnClickListener(this);
        mSetCloseHeightButton.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.expandButton:
                mExpandLayout.toggle();
                break;
            case R.id.moveChildButton:
                mExpandLayout.moveChild(0);
                break;
            case R.id.moveChildButton2:
                mExpandLayout.moveChild(1);
                break;
            case R.id.moveTopButton:
                mExpandLayout.move(0);
                break;
            case R.id.setCloseHeightButton:
                mExpandLayout.setClosePosition(mExpandLayout.getCurrentPosition());
                break;
        }
    }
}
