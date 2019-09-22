package com.a1mobile.spaceclickeron.ui;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.a1mobile.spaceclickeron.R;

import java.math.BigDecimal;

import static java.lang.Math.getExponent;

public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    private Button damageUpgrade;
    private BigDecimal damageUpgradeCost;
    private BigDecimal damageUpgradeAmount;
    private String damageUpgradeCostString = "";
    private String damageUpgradeAmountString = "";
    private TextView damageUpgradeDesc;

    private Button accuracyUpgrade;
    private BigDecimal accuracyUpgradeCost;
    private BigDecimal accuracyUpgradeAmount;
    private String accuracyUpgradeCostString = "";
    private String accuracyUpgradeAmountString = "";
    private TextView accuracyUpgradeDesc;

    private Button speedUpgrade;
    private BigDecimal speedUpgradeCost;
    private BigDecimal speedUpgradeAmount;
    private String speedUpgradeCostString = "";
    private String speedUpgradeAmountString = "";
    private TextView speedUpgradeDesc;

    private Button armorUpgrade;
    private BigDecimal armorUpgradeCost;
    private BigDecimal armorUpgradeAmount;
    private String armorUpgradeCostString = "";
    private String armorUpgradeAmountString = "";
    private TextView armorUpgradeDesc;

    private Button planetUpgrade;
    private BigDecimal planetUpgradeCost;
    private BigDecimal planetUpgradeAmount;
    private String planetUpgradeCostString = "";
    private String planetUpgradeAmountString = "";
    private TextView planetUpgradeDesc;

    private View view;
    private MainActivity main;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab2_fragment,container,false);
        main = new MainActivity();

        runDamageUpgrade();
        runAccuracyUpgrade();
        runSpeedUpgrade();
        runarmorUpgrade();
        runplanetUpgrade();

        main.setClicks(main.getClicks().add(new BigDecimal(1)));

        if (main.getInterstitialAd1().isLoaded() & main.getClicks().compareTo(new BigDecimal(8)) >= 0) {
            main.getInterstitialAd1().show();
            main.setClicks(new BigDecimal(0));
            main.setRewardVideo("True");
        }

        return view;
    }

    protected void runDamageUpgrade() {
        damageUpgrade = view.findViewById(R.id.damageButton);
        damageUpgradeDesc = view.findViewById(R.id.damageUpgradeDesc);
        damageUpgradeCost = ((main.getPerClickAmount().multiply(new BigDecimal(56)))).pow(2);
        damageUpgradeCostString = main.stringNumber(damageUpgradeCost);
        damageUpgrade.setText(String.format(getResources().getString(R.string.damageUpgradeButton), damageUpgradeCostString));
        damageUpgrade.setTextColor(getResources().getColor(R.color.white));
        damageUpgradeAmount = (main.getPerClickAmount().multiply(new BigDecimal(8)).pow(1));
        damageUpgradeAmountString = main.stringNumber(damageUpgradeAmount.multiply(new BigDecimal(50)));
        damageUpgradeDesc.setText(String.format(getResources().getString(R.string.damageUpgrade), damageUpgradeAmountString));

        damageUpgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (main.getStarAmount().compareTo(damageUpgradeCost) == -1) {
                    Handler handler = new Handler();
                    damageUpgrade.setText(getString(R.string.notEnough));
                    damageUpgrade.setTextColor(getResources().getColor(R.color.red));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            runDamageUpgrade();
                        }
                    }, 500);
                }
                else {
                    main.setStarAmount(main.getStarAmount().subtract(damageUpgradeCost));
                    main.setPerClickAmount(damageUpgradeAmount);

                    main.setClicks(main.getClicks().add(new BigDecimal(1)));

                    if (main.getInterstitialAd1().isLoaded() & main.getClicks().compareTo(new BigDecimal(8)) >= 0) {
                        main.getInterstitialAd1().show();
                        main.setClicks(new BigDecimal(0));
                        main.setRewardVideo("True");
                    }

                    runDamageUpgrade();
                }
            }
        });
    }

    protected void runAccuracyUpgrade() {
        accuracyUpgrade = view.findViewById(R.id.accuracyButton);
        accuracyUpgradeDesc = view.findViewById(R.id.accuracyUpgradeDesc);
        accuracyUpgradeCost = ((main.getClickMultiplier().multiply(new BigDecimal(64)))).pow(2);
        accuracyUpgradeCostString = main.stringNumber(accuracyUpgradeCost);
        accuracyUpgrade.setText(String.format(getResources().getString(R.string.accuracyUpgradeButton), accuracyUpgradeCostString));
        accuracyUpgrade.setTextColor(getResources().getColor(R.color.white));
        accuracyUpgradeAmount = (main.getClickMultiplier().multiply(new BigDecimal(10)));
        accuracyUpgradeAmountString = main.stringNumber(accuracyUpgradeAmount.multiply(new BigDecimal(1)));
        accuracyUpgradeDesc.setText(String.format(getResources().getString(R.string.accuracyUpgrade), accuracyUpgradeAmountString));

        accuracyUpgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (main.getStarAmount().compareTo(accuracyUpgradeCost) == -1) {
                    Handler handler = new Handler();
                    accuracyUpgrade.setText(getString(R.string.notEnough));
                    accuracyUpgrade.setTextColor(getResources().getColor(R.color.red));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            runAccuracyUpgrade();
                        }
                    }, 500);
                }
                else {
                    main.setStarAmount(main.getStarAmount().subtract(accuracyUpgradeCost));
                    main.setClickMultiplier(accuracyUpgradeAmount);

                    main.setClicks(main.getClicks().add(new BigDecimal(1)));

                    if (main.getInterstitialAd1().isLoaded() & main.getClicks().compareTo(new BigDecimal(8)) >= 0) {
                        main.getInterstitialAd1().show();
                        main.setClicks(new BigDecimal(0));
                        main.setRewardVideo("True");
                    }

                    runAccuracyUpgrade();
                }
            }
        });
    }

    protected void runSpeedUpgrade() {
        speedUpgrade = view.findViewById(R.id.speedButton);
        speedUpgradeDesc = view.findViewById(R.id.speedUpgradeDesc);
        speedUpgradeCost = ((main.getOfflineEarnings().multiply(new BigDecimal(24)))).pow(2);
        speedUpgradeCostString = main.stringNumber(speedUpgradeCost);
        speedUpgrade.setText(String.format(getResources().getString(R.string.speedUpgradeButton), speedUpgradeCostString));
        speedUpgrade.setTextColor(getResources().getColor(R.color.white));
        speedUpgradeAmount = (main.getOfflineEarnings().multiply(new BigDecimal(32)));
        speedUpgradeAmountString = main.stringNumber(speedUpgradeAmount);
        speedUpgradeDesc.setText(String.format(getResources().getString(R.string.speedUpgrade), speedUpgradeAmountString));

        speedUpgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (main.getStarAmount().compareTo(speedUpgradeCost) == -1) {
                    Handler handler = new Handler();
                    speedUpgrade.setText(getString(R.string.notEnough));
                    speedUpgrade.setTextColor(getResources().getColor(R.color.red));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            runSpeedUpgrade();
                        }
                    }, 500);
                }
                else {
                    main.setStarAmount(main.getStarAmount().subtract(speedUpgradeCost));
                    main.setOfflineEarnings(speedUpgradeAmount);

                    main.setClicks(main.getClicks().add(new BigDecimal(1)));

                    if (main.getInterstitialAd1().isLoaded() & main.getClicks().compareTo(new BigDecimal(8)) >= 0) {
                        main.getInterstitialAd1().show();
                        main.setClicks(new BigDecimal(0));
                        main.setRewardVideo("True");
                    }

                    runSpeedUpgrade();
                }
            }
        });
    }

    protected void runarmorUpgrade() {
        armorUpgrade = view.findViewById(R.id.armorButton);
        armorUpgradeDesc = view.findViewById(R.id.armorUpgradeDesc);
        armorUpgradeCost = ((main.getOfflineMultiplier().multiply(new BigDecimal(8)))).pow(2);
        armorUpgradeCostString = main.stringNumber(armorUpgradeCost);
        armorUpgrade.setText(String.format(getResources().getString(R.string.armorUpgradeButton), armorUpgradeCostString));
        armorUpgrade.setTextColor(getResources().getColor(R.color.white));
        armorUpgradeAmount = (main.getOfflineMultiplier().multiply(new BigDecimal(24)));
        armorUpgradeAmountString = main.stringNumber(armorUpgradeAmount);
        armorUpgradeDesc.setText(String.format(getResources().getString(R.string.armorUpgrade), armorUpgradeAmountString));

        armorUpgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (main.getStarAmount().compareTo(armorUpgradeCost) == -1) {
                    Handler handler = new Handler();
                    armorUpgrade.setText(getString(R.string.notEnough));
                    armorUpgrade.setTextColor(getResources().getColor(R.color.red));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            runarmorUpgrade();
                        }
                    }, 500);
                }
                else {
                    main.setStarAmount(main.getStarAmount().subtract(armorUpgradeCost));
                    main.setOfflineMultiplier(armorUpgradeAmount);

                    main.setClicks(main.getClicks().add(new BigDecimal(1)));

                    if (main.getInterstitialAd1().isLoaded() & main.getClicks().compareTo(new BigDecimal(8)) >= 0) {
                        main.getInterstitialAd1().show();
                        main.setClicks(new BigDecimal(0));
                        main.setRewardVideo("True");
                    }

                    runarmorUpgrade();
                }
            }
        });
    }

    protected void runplanetUpgrade() {
        String planetName = "";
        planetUpgrade = view.findViewById(R.id.planetButton);
        planetUpgradeDesc = view.findViewById(R.id.planetUpgradeDesc);
        ImageView planetImage = view.findViewById(R.id.planetImage);

        if (main.getPlanetNumber().compareTo(new BigDecimal(0)) == 0) {
            planetUpgradeCost = new BigDecimal(10);
            planetUpgradeCost = planetUpgradeCost.pow(16);
            planetUpgradeAmount = new BigDecimal(10);
            planetUpgradeAmount = planetUpgradeAmount.pow(4);
            planetName = "the Moon";
            planetImage.setImageDrawable(getResources().getDrawable(R.drawable.moon));
        }
        else if (main.getPlanetNumber().compareTo(new BigDecimal(1)) == 0) {
            planetUpgradeCost = new BigDecimal(10);
            planetUpgradeCost = planetUpgradeCost.pow(30);
            planetUpgradeAmount = new BigDecimal(10);
            planetUpgradeAmount = planetUpgradeAmount.pow(6);
            planetName = "Mars";
            planetImage.setImageDrawable(getResources().getDrawable(R.drawable.mars));
        }
        else if (main.getPlanetNumber().compareTo(new BigDecimal(2)) == 0) {
            planetUpgradeCost = new BigDecimal(10);
            planetUpgradeCost = planetUpgradeCost.pow(60);
            planetUpgradeAmount = new BigDecimal(10);
            planetUpgradeAmount = planetUpgradeAmount.pow(8);
            planetName = "Jupiter";
            planetImage.setImageDrawable(getResources().getDrawable(R.drawable.jupiter));
        }
        else if (main.getPlanetNumber().compareTo(new BigDecimal(3)) == 0) {
            planetUpgradeCost = new BigDecimal(10);
            planetUpgradeCost = planetUpgradeCost.pow(95);
            planetUpgradeAmount = new BigDecimal(10);
            planetUpgradeAmount = planetUpgradeAmount.pow(12);
            planetName = "Venus";
            planetImage.setImageDrawable(getResources().getDrawable(R.drawable.venus));
        }
        else if (main.getPlanetNumber().compareTo(new BigDecimal(4)) == 0) {
            planetUpgradeCost = new BigDecimal(10);
            planetUpgradeCost = planetUpgradeCost.pow(120);
            planetUpgradeAmount = new BigDecimal(10);
            planetUpgradeAmount = planetUpgradeAmount.pow(14);
            planetName = "the sun";
            planetImage.setImageDrawable(getResources().getDrawable(R.drawable.sun));
        }
        else {
            planetUpgrade.setClickable(false);
            planetUpgradeCost = new BigDecimal(10);
            planetUpgradeCost = planetUpgradeCost.pow(150);
            planetUpgradeAmount = new BigDecimal(10);
            planetUpgradeAmount = planetUpgradeAmount.pow(16);
            planetName = "the sun";
            planetImage.setImageDrawable(getResources().getDrawable(R.drawable.sun));
        }

        planetUpgradeCostString = main.stringNumber(planetUpgradeCost);
        planetUpgrade.setText(String.format(getResources().getString(R.string.planetUpgradeButton), planetUpgradeCostString));
        planetUpgrade.setTextColor(getResources().getColor(R.color.white));
        planetUpgradeAmountString = main.stringNumber(planetUpgradeAmount);
        planetUpgradeDesc.setText(String.format(getResources().getString(R.string.planetUpgrade), planetName, planetUpgradeAmountString));

        planetUpgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (main.getStarAmount().compareTo(planetUpgradeCost) == -1) {
                    Handler handler = new Handler();
                    planetUpgrade.setText(getString(R.string.notEnough));
                    planetUpgrade.setTextColor(getResources().getColor(R.color.red));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            runplanetUpgrade();
                        }
                    }, 500);
                }
                else {
                    main.setStarAmount(main.getStarAmount().subtract(planetUpgradeCost));
                    main.setClickMultiplier(main.getClickMultiplier().multiply(planetUpgradeAmount));
                    main.setOfflineMultiplier(main.getOfflineMultiplier().multiply(planetUpgradeAmount));
                    main.setPlanetNumber(main.getPlanetNumber().add(new BigDecimal(1)));

                    main.setClicks(main.getClicks().add(new BigDecimal(1)));

                    if (main.getInterstitialAd1().isLoaded() & main.getClicks().compareTo(new BigDecimal(8)) >= 0) {
                        main.getInterstitialAd1().show();
                        main.setClicks(new BigDecimal(0));
                        main.setRewardVideo("True");
                    }

                    runplanetUpgrade();
                }
            }
        });

        if (main.getPlanetNumber().compareTo(new BigDecimal(4)) > 0) {
            planetUpgrade.setClickable(false);
            planetUpgrade.setText("MAXED OUT");
            planetUpgradeDesc.setText("The sun is as far as you can travel... for this lifetime at least. May our future generations travel out of The Milky Way.");
        }
    }

    public void onResume() {
        super.onResume();

    }
}
