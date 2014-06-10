package com.mmday.MMD.activities;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import com.mmday.MMD.R;
import com.mmday.MMD.activities.arc.ArcMenu;
import com.mmday.MMD.models.GeneralEnums;
import com.mmday.MMD.rest.RetrofitController;

public class MainActivity extends Activity {
	private static final int[] ITEM_DRAWABLES = { R.drawable.composer_camera, R.drawable.composer_music,
			R.drawable.composer_place, R.drawable.composer_sleep, R.drawable.composer_thought, R.drawable.composer_with };

    private static AccountManager accountManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        accountManager = AccountManager.get(this);

        setAuthToken();

		setContentView(R.layout.main);
		ArcMenu arcMenu = (ArcMenu) findViewById(R.id.arc_menu);

        initArcMenu(arcMenu, ITEM_DRAWABLES);
	}

    private void setAuthToken() {
        accountManager.getAuthTokenByFeatures(GeneralEnums.ACCOUNT_TYPE.getMessage(), GeneralEnums.AUTHTOKEN_TYPE_FULL_ACCESS.getMessage(), null, this, null, null,
                new AccountManagerCallback<Bundle>() {
                    @Override
                    public void run(AccountManagerFuture<Bundle> future) {
                        Bundle bundle;
                        try {
                            bundle = future.getResult();
                            RetrofitController.getInstance().setAuthToken(bundle.getString(AccountManager.KEY_AUTHTOKEN));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                , null);
    }

    private void initArcMenu(ArcMenu menu, int[] itemDrawables) {
        final int itemCount = itemDrawables.length;
        for (int i = 0; i < itemCount; i++) {
            ImageView item = new ImageView(this);
            item.setImageResource(itemDrawables[i]);

            final int position = i;
            menu.addItem(item, new OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
