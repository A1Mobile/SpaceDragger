package com.a1mobile.spaceclickeron.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.graphics.Point;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.a1mobile.spaceclickeron.R;

import java.math.BigDecimal;
import java.util.Random;

public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private ImageButton shipButton;
    private TextView starText;
    private TextView perClickText;
    private String starAmountString = "";
    private MainActivity main;
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;
    private ImageView star6;
    private BigDecimal perClickTextAmount;
    private String perClickTextAmountString;
    private int i = 0;
    private int z = 0;
    private ImageView starFall1;
    private ImageView starFall2;
    private ImageView starFall3;
    private ImageView starFall4;
    private ImageView starFall5;
    private ImageView starFall6;
    private ImageView starFall7;
    private ImageView starFall8;
    private ImageView starFall9;
    private ImageView starFall10;
    private ImageView planet;

    private ImageView window;
    private TextView textView8;
    private TextView textView9;
    private TextView textView17;
    private Button closeButton;
    private Button adButton;

    private ImageButton instruction1;
    private ImageButton instruction2;
    private TextView instruction1Text;
    private TextView instruction2Text;

    private boolean touch = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);
        main = new MainActivity();
        perClickText = view.findViewById(R.id.perClickText);

        planet = view.findViewById(R.id.planet);

        main.setPause("False");

        star1 = view.findViewById(R.id.star1);
        star2 = view.findViewById(R.id.star2);
        star3 = view.findViewById(R.id.star3);
        star4 = view.findViewById(R.id.star4);
        star5 = view.findViewById(R.id.star5);
        star6 = view.findViewById(R.id.star6);

        starFall1 = view.findViewById(R.id.imageView8);
        starFall2 = view.findViewById(R.id.imageView9);
        starFall3 = view.findViewById(R.id.imageView10);
        starFall4 = view.findViewById(R.id.imageView11);
        starFall5 = view.findViewById(R.id.imageView12);
        starFall6 = view.findViewById(R.id.imageView13);
        starFall7 = view.findViewById(R.id.imageView14);
        starFall8 = view.findViewById(R.id.imageView15);
        starFall9 = view.findViewById(R.id.imageView16);
        starFall10 = view.findViewById(R.id.imageView17);

        instruction1 = view.findViewById(R.id.imageButton);
        instruction2 = view.findViewById(R.id.imageButton2);
        instruction1Text = view.findViewById(R.id.textView15);
        instruction2Text = view.findViewById(R.id.textView16);

        star1.setVisibility(View.INVISIBLE);
        star2.setVisibility(View.INVISIBLE);
        star3.setVisibility(View.INVISIBLE);
        star4.setVisibility(View.INVISIBLE);
        star5.setVisibility(View.INVISIBLE);
        star6.setVisibility(View.INVISIBLE);

        starFall1.setVisibility(View.INVISIBLE);
        starFall2.setVisibility(View.INVISIBLE);
        starFall3.setVisibility(View.INVISIBLE);
        starFall4.setVisibility(View.INVISIBLE);
        starFall5.setVisibility(View.INVISIBLE);
        starFall6.setVisibility(View.INVISIBLE);
        starFall7.setVisibility(View.INVISIBLE);
        starFall8.setVisibility(View.INVISIBLE);
        starFall9.setVisibility(View.INVISIBLE);
        starFall10.setVisibility(View.INVISIBLE);

        shipButton = view.findViewById(R.id.ship);
        starText = view.findViewById(R.id.starText);

        starAmountString = main.stringNumber(main.getStarAmount());
        starText.setText("" + starAmountString);

        perClickTextAmount = (main.getOfflineEarnings().multiply(main.getOfflineMultiplier()));
        perClickTextAmountString = main.stringNumber(perClickTextAmount);

        perClickText.setText(perClickTextAmountString + " Per Second");

        shipButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                i++;
                float xCoords;
                float yCoords;

                if (touch == false) {
                    perClickTextAmount = perClickTextAmount.add(main.getPerClickAmount().multiply(main.getClickMultiplier()).multiply(new BigDecimal(50)));
                    perClickTextAmountString = main.stringNumber(perClickTextAmount);

                    perClickText.setText(perClickTextAmountString + " Per Second");
                }

                touch = true;

                main.setStarAmount((main.getStarAmount().add((main.getPerClickAmount()).multiply(main.getClickMultiplier()))));
                starAmountString = main.stringNumber(main.getStarAmount());
                starText.setText("" + starAmountString);

                xCoords = event.getX();
                yCoords = event.getY();

                switch (i) {
                    case 6:
                        star1.setX(xCoords);
                        star1.setY(yCoords);
                        startAnimationLarge(star1);
                        i = 0;
                        break;
                    case 5:
                        star2.setX(xCoords);
                        star2.setY(yCoords);
                        startAnimationLarge(star2);
                        break;
                    case 4:
                        star3.setX(xCoords);
                        star3.setY(yCoords);
                        startAnimationLarge(star3);
                        break;
                    case 3:
                        star4.setX(xCoords);
                        star4.setY(yCoords);
                        startAnimationLarge(star4);
                        break;
                    case 2:
                        star5.setX(xCoords);
                        star5.setY(yCoords);
                        startAnimationLarge(star5);
                        break;
                    case 1:
                        star6.setX(xCoords);
                        star6.setY(yCoords);
                        startAnimationLarge(star6);
                        break;
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    touch = false;
                    perClickTextAmount = (main.getOfflineEarnings().multiply(main.getOfflineMultiplier()));
                    perClickTextAmountString = main.stringNumber(perClickTextAmount);

                    perClickText.setText(perClickTextAmountString + " Per Second");
                }

                return true;
            }
        });

        if (main.getResume().equals("True")) {
            closeButton = view.findViewById(R.id.closeButton);
            adButton = view.findViewById(R.id.adButton);
            window = view.findViewById(R.id.window);
            textView8 = view.findViewById(R.id.textView8);
            textView9 = view.findViewById(R.id.textView9);
            textView17 = view.findViewById(R.id.textView17);

            closeButton.setVisibility(View.VISIBLE);
            adButton.setVisibility(View.VISIBLE);
            window.setVisibility(View.VISIBLE);
            textView8.setVisibility(View.VISIBLE);
            textView9.setVisibility(View.VISIBLE);
            textView17.setVisibility(View.VISIBLE);

            adButton.setTextColor(getResources().getColor(R.color.white));
            adButton.setText("Watch Ad = 10x Offline Earnings");

            if (main.getMaxHours().equals("True")) {
                textView8.setText(String.format(getResources().getString(R.string.offlineEarningsStringXMLMaxHours), main.getOfflineTotalHours(), main.getOfflineHours(), main.getOfflineAmountString()));
            } else {
                textView8.setText(String.format(getResources().getString(R.string.offlineEarningsStringXML), main.getOfflineHoursUsed(), main.getOfflineAmountString()));
            }

            closeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    closeButton.setVisibility(View.INVISIBLE);
                    adButton.setVisibility(View.INVISIBLE);
                    window.setVisibility(View.INVISIBLE);
                    textView8.setVisibility(View.INVISIBLE);
                    textView9.setVisibility(View.INVISIBLE);
                    textView17.setVisibility(View.INVISIBLE);
                    main.setStarAmount(main.getStarAmount().add(main.getOfflineAmount()));
                    instructions();
                }
            });

            adButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (main.getRewardAd().isLoaded()) {
                        main.getRewardAd().show();
                    }
                    else {
                        adButton.setText("Ad Failed - Try Again");
                        adButton.setTextColor(getResources().getColor(R.color.red));
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                adButton.setTextColor(getResources().getColor(R.color.white));
                                adButton.setText("Watch Ad = 10x Offline Earnings");
                            }
                        }, 500);
                    }
                }
            });

            runFallAnimation();
            runOfflineEarnings();
            main.setResume("False");
        }

        return view;
    }

    protected void instructions() {
        if (main.getFirstTime().equals("True")) {
            instruction1Text.setVisibility(View.VISIBLE);
            instruction2Text.setVisibility(View.VISIBLE);
            instruction1.setVisibility(View.VISIBLE);
            instruction2.setVisibility(View.VISIBLE);

            instruction1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    instruction1Text.setVisibility(View.INVISIBLE);
                    instruction1.setVisibility(View.INVISIBLE);
                }
            });

            instruction2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    instruction2Text.setVisibility(View.INVISIBLE);
                    instruction2.setVisibility(View.INVISIBLE);
                }
            });

            main.setFirstTime("False");
        }
        else {
            instruction1Text.setVisibility(View.INVISIBLE);
            instruction2Text.setVisibility(View.INVISIBLE);
            instruction1.setVisibility(View.INVISIBLE);
            instruction2.setVisibility(View.INVISIBLE);
        }
    }

    public void onPause() {
        super.onPause();

        main.setPause("True");
    }

    public void onResume() {
        super.onResume();

        main.setPause("False");

        if (main.getRewardVideo().equals("False")) {
            main.setResume("True");
        }

        perClickTextAmount = (main.getOfflineEarnings().multiply(main.getOfflineMultiplier()));
        perClickTextAmountString = main.stringNumber(perClickTextAmount);

        perClickText.setText(perClickTextAmountString + " Per Second");

        if (main.getRewardVideo().equals("True")) {
            if (main.getMaxHours().equals("True")) {
                textView8.setText(String.format(getResources().getString(R.string.offlineEarningsStringXMLMaxHours), main.getOfflineTotalHours(), main.getOfflineHours(), main.getOfflineAmountString()));
            } else {
                textView8.setText(String.format(getResources().getString(R.string.offlineEarningsStringXML), main.getOfflineHoursUsed(), main.getOfflineAmountString()));
            }

            adButton.setText("Ad Watched - Multiplier Added");
            adButton.setTextColor(getResources().getColor(R.color.green));
            main.setRewardVideo("False");
        }

        if (main.getResume().equals("True")) {
            closeButton.setVisibility(View.VISIBLE);
            adButton.setVisibility(View.VISIBLE);
            window.setVisibility(View.VISIBLE);
            textView8.setVisibility(View.VISIBLE);
            textView9.setVisibility(View.VISIBLE);
            textView17.setVisibility(View.VISIBLE);

            if (main.getMaxHours().equals("True")) {
                textView8.setText(String.format(getResources().getString(R.string.offlineEarningsStringXMLMaxHours), main.getOfflineTotalHours(), main.getOfflineHours(), main.getOfflineAmountString()));
            } else {
                textView8.setText(String.format(getResources().getString(R.string.offlineEarningsStringXML), main.getOfflineHoursUsed(), main.getOfflineAmountString()));
            }

            adButton.setTextColor(getResources().getColor(R.color.white));
            adButton.setText("Watch Ad = 10x Offline Earnings");

            closeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    closeButton.setVisibility(View.INVISIBLE);
                    adButton.setVisibility(View.INVISIBLE);
                    window.setVisibility(View.INVISIBLE);
                    textView8.setVisibility(View.INVISIBLE);
                    textView9.setVisibility(View.INVISIBLE);
                    textView17.setVisibility(View.INVISIBLE);
                    main.setStarAmount(main.getStarAmount().add(main.getOfflineAmount()));
                }
            });

            adButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (main.getRewardAd().isLoaded()) {
                        main.getRewardAd().show();

                        if (main.getMaxHours().equals("True")) {
                            textView8.setText(String.format(getResources().getString(R.string.offlineEarningsStringXMLMaxHours), main.getOfflineTotalHours(), main.getOfflineHours(), main.getOfflineAmountString()));
                        } else {
                            textView8.setText(String.format(getResources().getString(R.string.offlineEarningsStringXML), main.getOfflineHoursUsed(), main.getOfflineAmountString()));
                        }

                        adButton.setText("Ad Watched - Multiplier Added");
                        adButton.setTextColor(getResources().getColor(R.color.green));
                    }
                    else {
                        adButton.setText("Ad Failed - Try Again");
                        adButton.setTextColor(getResources().getColor(R.color.red));
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                            adButton.setTextColor(getResources().getColor(R.color.white));
                            adButton.setText("Watch Ad = 10x Offline Earnings");
                            }
                        }, 500);
                    }
                }
            });

            main.setResume("False");
        }
    }

    public void runOfflineEarnings() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                main.setStarAmount(((main.getStarAmount().add((main.getOfflineEarnings()).multiply(main.getOfflineMultiplier())))));
                starAmountString = main.stringNumber(main.getStarAmount());
                starText.setText("" + starAmountString);
                runOfflineEarnings();
            }
        }, 1000);
    }

    public void startAnimationLarge(final ImageView imageView) {
        imageView.setVisibility(View.VISIBLE);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(imageView,"y", 0f);
        animatorY.setDuration(500);
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(imageView, View.ALPHA, 1.0f, 0.0f);
        alphaAnimation.setDuration(500);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorY, alphaAnimation);
        animatorSet.start();
    }

    public void startFallAnimation(final ImageView imageView) {
        imageView.setVisibility(View.VISIBLE);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(imageView,"y", 5000f);
        animatorY.setDuration(3000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animatorY);
        animatorSet.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setVisibility(View.INVISIBLE);
                ObjectAnimator animatorY = ObjectAnimator.ofFloat(imageView,"y", -250f);
                animatorY.setDuration(10);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(animatorY);
                animatorSet.start();
            }
        },3010);
    }

    public void runFallAnimation() {
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (main.getPause().equals("False")) {

                    if (main.getShipLevel().compareTo(new BigDecimal(1)) == 0) {
                        shipButton.setImageDrawable(getResources().getDrawable(R.drawable.shiplevel1));
                    }
                    if (main.getShipLevel().compareTo(new BigDecimal(2)) == 0) {
                        shipButton.setImageDrawable(getResources().getDrawable(R.drawable.shiplevel2));
                    }
                    if (main.getShipLevel().compareTo(new BigDecimal(3)) == 0) {
                        shipButton.setImageDrawable(getResources().getDrawable(R.drawable.shiplevel3));
                    }

                    if (main.getPlanetNumber().compareTo(new BigDecimal(0)) == 0) {
                        planet.setImageDrawable(getResources().getDrawable(R.drawable.earth));
                    }
                    if (main.getPlanetNumber().compareTo(new BigDecimal(1)) == 0) {
                        planet.setImageDrawable(getResources().getDrawable(R.drawable.moon));
                    }
                    if (main.getPlanetNumber().compareTo(new BigDecimal(2)) == 0) {
                        planet.setImageDrawable(getResources().getDrawable(R.drawable.mars));
                    }
                    if (main.getPlanetNumber().compareTo(new BigDecimal(3)) == 0) {
                        planet.setImageDrawable(getResources().getDrawable(R.drawable.jupiter));
                    }
                    if (main.getPlanetNumber().compareTo(new BigDecimal(4)) == 0) {
                        planet.setImageDrawable(getResources().getDrawable(R.drawable.venus));
                    }
                    if (main.getPlanetNumber().compareTo(new BigDecimal(5)) == 0) {
                        planet.setImageDrawable(getResources().getDrawable(R.drawable.sun));
                    }

                    if (touch == false) {
                        perClickTextAmount = (main.getOfflineEarnings().multiply(main.getOfflineMultiplier()));
                        perClickTextAmountString = main.stringNumber(perClickTextAmount);

                        perClickText.setText(perClickTextAmountString + " Per Second");
                    }

                    starAmountString = main.stringNumber(main.getStarAmount());
                    starText.setText("" + starAmountString);

                    z++;
                    Random random = new Random();
                    if (random.nextInt(2) == 0) {
                        z++;
                    }
                    switch (z) {
                        case 1:
                            startFallAnimation(starFall1);
                            break;
                        case 2:
                            startFallAnimation(starFall7);
                            break;
                        case 3:
                            startFallAnimation(starFall3);
                            break;
                        case 4:
                            startFallAnimation(starFall4);
                            break;
                        case 5:
                            startFallAnimation(starFall8);
                            break;
                        case 6:
                            startFallAnimation(starFall6);
                            break;
                        case 7:
                            startFallAnimation(starFall2);
                            break;
                        case 8:
                            startFallAnimation(starFall5);
                            break;
                        case 9:
                            startFallAnimation(starFall9);
                            z = 0;
                            break;
                        case 10:
                            startFallAnimation(starFall10);
                            z = 0;
                            break;
                    }

                }
            }
        }, 606);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                runFallAnimation();
            }
        }, 607);

    }
}
