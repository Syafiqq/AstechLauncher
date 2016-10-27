package id.ac.ub.filkom.se.kcv.astechlauncher.controller.mainsubapp.forcast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import id.ac.ub.filkom.se.kcv.astechlauncher.R;
import id.ac.ub.filkom.se.kcv.astechlauncher.controller.mainapp.About;
import id.ac.ub.filkom.se.kcv.astechlauncher.controller.mainapp.Help;
import id.ac.ub.filkom.se.kcv.astechlauncher.controller.mainapp.LoginActivity;
import id.ac.ub.filkom.se.kcv.astechlauncher.controller.mainapp.MainActivity;


public class MainPage extends AppCompatActivity {
    @BindView(R.id.appforcast_button_minyak_launcher)
    Button buttonMinyak;
    @BindView(R.id.appforcast_button_prediksi_launcher)
    Button buttonPrediksi;
    @BindView(R.id.appforcast_button_saham_launcher)
    Button buttonSaham;
    @BindView(R.id.appforcast_textswitcher_application_description)
    TextSwitcher applicationShortDescriptionSwitcher;
    @BindView(R.id.appforcast_imageswitcher_application_logo)
    ImageSwitcher applicationLogoSwitcher;


    private Button[] buttonLauncherWrapper;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.appforcast_container);
        ButterKnife.bind(this);

        final Toolbar toolbar = (Toolbar) super.findViewById(R.id.appforcast_mainpage_toolbar);
        super.setSupportActionBar(toolbar);
        final ActionBar actionBar = super.getSupportActionBar();
        if (actionBar != null) {
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
//                    MainPage.this.onBackButtonPressed();
//                }
//            });
        }

        this.buttonLauncherWrapper = new Button[]{this.buttonMinyak, this.buttonPrediksi, this.buttonSaham};

        this.setLogoDescriptionSwitcher();
        this.setLogoSwictcher();


    }

    private void setLogoDescriptionSwitcher() {
        this.applicationShortDescriptionSwitcher.setInAnimation(this, R.anim.fade_in);
        this.applicationShortDescriptionSwitcher.setOutAnimation(this, R.anim.fade_out);
        this.applicationShortDescriptionSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                TextView myText = new TextView(MainPage.this);
                myText.setTextSize(18);
                return myText;
            }
        });

        this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appforcast_short_description));
    }

    private void setLogoSwictcher() {
        this.applicationLogoSwitcher.setInAnimation(this, R.anim.fade_in);
        this.applicationLogoSwitcher.setOutAnimation(this, R.anim.fade_out);
        this.applicationLogoSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                ImageView myImage = new ImageView(MainPage.this);
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(4, 16, 4, 4);
                lp.gravity = Gravity.CENTER_HORIZONTAL;
                myImage.setLayoutParams(lp);
                myImage.setContentDescription(MainPage.super.getResources().getString(R.string.appforcast_avatar_description));
                return myImage;
            }
        });

        this.applicationLogoSwitcher.setImageResource(R.drawable.appforcast);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("CekLogin", MODE_WORLD_READABLE);
        SharedPreferences.Editor editor = pref.edit();
        switch (item.getItemId()) {
            case R.id.help: {
                startActivity(new Intent(this, Help.class));
                return true;
            }
            case R.id.about: {
                startActivity(new Intent(this, About.class));
                return true;
            }
            case R.id.logout: {
                Toast.makeText(this, "You're have logout", Toast.LENGTH_LONG).show();
                editor.clear();
                editor.commit();
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            }
            case R.id.exit: {
                this.finish();
                return true;
            }
            case android.R.id.home:
                //perhaps use intent if needed but i'm sure there's a specific intent action for up you can use to handle
                MainPage.this.onBackButtonPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //---------------------------------------------------------------------------------------------
    //----------------Listener Button Edit Below---------------------------------------------------
    //---------------------------------------------------------------------------------------------

    private void onBackButtonPressed()
    {
        this.onBackPressed();
    }

    @Override
    public void onBackPressed()
    {
        final Intent intent = new Intent(this, MainActivity.class);
        super.startActivity(intent);
    }

    public void onToolbarAboutUsMenuPressed()
    {
        final Intent intent = new Intent(this, AboutUsPage.class);
        super.startActivity(intent);
    }

    public void onToolbarHelpMenuPressed()
    {
        final Intent intent = new Intent(this, Helppage.class);
        super.startActivity(intent);
    }

    @OnClick({R.id.appforcast_button_minyak_launcher, R.id.appforcast_button_prediksi_launcher, R.id.appforcast_button_saham_launcher})
    public void onApplicationLauncherChoose(Button pressedButton)
    {
        for(final Button guessedButton : this.buttonLauncherWrapper)
        {
            if(pressedButton == guessedButton)
            {
                pressedButton.setSelected(!pressedButton.isSelected());
                if(pressedButton.isSelected())
                {
                    if(pressedButton == this.buttonMinyak)
                    {
                        this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appforcast_minyak_short_description));
                        this.applicationLogoSwitcher.setImageResource(R.drawable.logo_akupuntur);
                    }
                    else if(pressedButton == this.buttonPrediksi)
                    {
                        this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appforcast_prediksi_short_description));
                        this.applicationLogoSwitcher.setImageResource(R.drawable.prediksi_big_logo);
                    }
                    else if(pressedButton == this.buttonSaham)
                    {
                        this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appforcast_saham_short_description));
                        this.applicationLogoSwitcher.setImageResource(R.drawable.logo_heart);
                    }
                }
                else
                {
                    this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appforcast_short_description));
                    this.applicationLogoSwitcher.setImageResource(R.drawable.appforcast);
                }
            }
            else
            {
                guessedButton.setSelected(false);
            }
        }
    }

    @OnLongClick({R.id.appforcast_button_minyak_launcher, R.id.appforcast_button_prediksi_launcher, R.id.appforcast_button_saham_launcher})
    public boolean onApplicationLauncherPressed(Button pressedButton)
    {
        for(final Button guessedButton : this.buttonLauncherWrapper)
        {
            if(pressedButton == guessedButton)
            {
                pressedButton.setSelected(true);
                if(pressedButton == this.buttonMinyak)
                {
                    this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appforcast_minyak_short_description));
                    this.applicationLogoSwitcher.setImageResource(R.drawable.logo_akupuntur);
                    Toast.makeText(this, "Oil Prediction Launch", Toast.LENGTH_SHORT).show();
                }
                else if(pressedButton == this.buttonPrediksi)
                {
                    this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appforcast_prediksi_short_description));
                    this.applicationLogoSwitcher.setImageResource(R.drawable.prediksi);
                    final Intent intent = new Intent(this, id.ac.ub.filkom.sekcv.appstroke.controller.MainPage.class);
                    super.startActivity(intent);
                    super.finish();
                }
                else if(pressedButton == this.buttonSaham)
                {
                    this.applicationShortDescriptionSwitcher.setText(super.getResources().getString(R.string.appforcast_saham_short_description));
                    this.applicationLogoSwitcher.setImageResource(R.drawable.logo_heart);
                    Toast.makeText(this, "Holding Prediction Launch", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                guessedButton.setSelected(false);
            }
        }
        return true;
    }
}
