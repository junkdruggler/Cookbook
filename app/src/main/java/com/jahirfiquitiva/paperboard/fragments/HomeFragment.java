package com.jahirfiquitiva.paperboard.fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jahirfiquitiva.paperboard.activities.MainActivity;
import com.melnykov.fab.FloatingActionButton;
import com.melnykov.fab.ObservableScrollView;

import com.junkdruggler.recipebook.R;

public class HomeFragment extends Fragment {

    private static final String MARKET_URL = "https://play.google.com/store/apps/details?id=";

    private String PlayStoreDevAccount, PlayStoreListing, AppOnePackage, AppTwoPackage, AppThreePackage;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.section_home, container, false);

        PlayStoreDevAccount = getResources().getString(R.string.play_store_dev_link);
        PlayStoreListing = getActivity().getPackageName();
        AppOnePackage = getResources().getString(R.string.app_one_package);
        AppTwoPackage = getResources().getString(R.string.app_two_package);
        AppThreePackage = getResources().getString(R.string.app_three_package);

        ActionBar toolbar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (toolbar != null)
            toolbar.setTitle(R.string.app_name);

        ObservableScrollView content = (ObservableScrollView) root.findViewById(R.id.HomeContent);

        //Cards
        CardView cardone = (CardView) root.findViewById(R.id.cardOne);

        if (AppIsInstalled(AppOnePackage)) {
            cardone.setVisibility((cardone.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE));
        }



        TextView playbtn = (TextView) root.findViewById(R.id.play_button);
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent devPlay = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tramicirestaurant.com/"));
                startActivity(devPlay);
            }
        });

        TextView apponebtn = (TextView) root.findViewById(R.id.appone_button);
        apponebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appone = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.halyardsrestaurant.com/"));
                startActivity(appone);
            }
        });





        TextView ratebtn = (TextView) root.findViewById(R.id.rate_button);
        ratebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rate = new Intent(Intent.ACTION_VIEW, Uri.parse(MARKET_URL + PlayStoreListing));
                startActivity(rate);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) root.findViewById(R.id.apply_btn);
        fab.setColorNormal(getResources().getColor(R.color.accent));
        fab.setColorPressed(getResources().getColor(R.color.accent_pressed));
        fab.setColorRipple(getResources().getColor(R.color.semitransparent_white));
        fab.show(true);
        fab.attachToScrollView(content);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).result.setSelectionByIdentifier(7);
                ((MainActivity) getActivity()).switchFragment(7, getResources().getString(R.string.section_latest), "Latest");
            }
        });

        return root;
    }

    private boolean AppIsInstalled(String packageName) {
        final PackageManager pm = getActivity().getPackageManager();
        boolean installed;
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }

}
