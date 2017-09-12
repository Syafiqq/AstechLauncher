package id.ac.ub.filkom.se.kcv.astechlauncher.controller.mainsubapp.forcast;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import id.ac.ub.filkom.se.kcv.astechlauncher.R;


public class AboutUsPage extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.appmedis_launcher_about_us_container);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.appmedis_aboutuspage_toolbar);
        super.setSupportActionBar(toolbar);
        final ActionBar actionBar = super.getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            toolbar.setContentInsetStartWithNavigation(4);
//            toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.appmedis_toolbar_button_back));
//            toolbar.setNavigationOnClickListener(new View.OnClickListener()
//            {
//                @Override
//                public void onClick(View v)
//                {
//                    AboutUsPage.this.onBackButtonPressed();
//                }
//            });
        }
    }

    //---------------------------------------------------------------------------------------------
    //----------------Listener Button Edit Below---------------------------------------------------
    //---------------------------------------------------------------------------------------------

    private void onBackButtonPressed()
    {
        super.onBackPressed();
        super.finish();
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case android.R.id.home:
                //perhaps use intent if needed but i'm sure there's a specific intent action for up you can use to handle
                this.onBackButtonPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
