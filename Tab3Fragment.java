package com.a1mobile.spaceclickeron.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.a1mobile.spaceclickeron.R;
import com.anjlab.android.iab.v3.BillingProcessor;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Tab3Fragment extends Fragment {
    private static final String TAG = "Tab3Fragment";

    private Button shipUpgradeButton;
    private Button revealNumberButton;
    private Button privacyPolicyButton;
    private MainActivity main;
    private TextView textViewNumber;
    private TextView textViewShipUpgrade;
    private Button contestDetails;
    private ImageView shipUpgradeView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3_fragment,container,false);

        main = new MainActivity();

        //Reveal what your number actually looks like (0.99)

        shipUpgradeButton = view.findViewById(R.id.shipUpgradeButton);
        revealNumberButton = view.findViewById(R.id.revealNumberButton);
        privacyPolicyButton = view.findViewById(R.id.privacyPolicyButton);
        textViewNumber = view.findViewById(R.id.textView12);
        textViewShipUpgrade = view.findViewById(R.id.textView11);
        contestDetails = view.findViewById(R.id.contestButton);
        shipUpgradeView = view.findViewById(R.id.imageView20);

        startShipUpgrade();
        startRevealNumber();
        privacyPolicy();
        contest();

        return view;
    }

    protected void contest() {
        contestDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigInteger d = main.getStarAmount().toBigInteger();
                int length = String.valueOf(d).length();

                if (length <= 195) {
                    Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
                    openURL.setData(Uri.parse("https://a1mobileproduction.wixsite.com/home/faq"));
                    startActivity(openURL);
                }
                else {
                    Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
                    openURL.setData(Uri.parse("https://forms.gle/uxgiuXjpvDRP1A4Y6"));
                    startActivity(openURL);
                }
            }
        });
    }

    protected void privacyPolicy() {
        privacyPolicyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
                openURL.setData(Uri.parse("https://a1mobileproduction.wixsite.com/home/privacy-policy"));
                startActivity(openURL);
            }
        });
    }

    protected void startShipUpgrade() {
        shipUpgradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (main.getShipLevel().compareTo(new BigDecimal(1)) == 0) {
                    main.getBp().purchase(getActivity(), "shiptolevel2");
                    startShipUpgrade();
                }
                else {
                    main.getBp().purchase(getActivity(), "shiptolevel3");
                    startShipUpgrade();
                }
            }
        });

        if (main.getShipLevel().compareTo(new BigDecimal(1)) == 0) {
            textViewShipUpgrade.setText(String.format(getResources().getString(R.string.shipUpgrade), "2", "8"));
        }
        if (main.getShipLevel().compareTo(new BigDecimal(2)) == 0) {
            textViewShipUpgrade.setText(String.format(getResources().getString(R.string.shipUpgrade), "8", "24"));
            shipUpgradeView.setImageDrawable(getResources().getDrawable(R.drawable.shiplevel3));
        }
        if (main.getShipLevel().compareTo(new BigDecimal(3)) == 0) {
            shipUpgradeButton.setText("Maxed Out");
            shipUpgradeButton.setTextColor(getResources().getColor(R.color.green));
            textViewShipUpgrade.setText("Thank you for purchasing this upgrade!");
            shipUpgradeButton.setClickable(false);
        }
    }

    protected void startRevealNumber() {
        revealNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (main.getRevealNumber().equals("False")) {
                    main.getBp().purchase(getActivity(), "revealnumber");
                    startRevealNumber();
                }
                else {
                    revealNumber();
                }
            }
        });

        if (main.getRevealNumber().equals("True")) {
            revealNumberButton.setText("Reveal Number - Click To Reveal");
            revealNumberButton.setTextColor(getResources().getColor(R.color.green));
        }
    }

    protected void revealNumber() {
        textViewNumber.setText("" + main.getStarAmount());
    }

    public void onResume() {
        super.onResume();
        startShipUpgrade();
        startRevealNumber();
        privacyPolicy();
        contest();
    }
}
