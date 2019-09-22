package com.a1mobile.spaceclickeron.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.a1mobile.spaceclickeron.R;
import com.a1mobile.spaceclickeron.ui.Tab1Fragment;
import com.a1mobile.spaceclickeron.ui.Tab2Fragment;
import com.a1mobile.spaceclickeron.ui.Tab3Fragment;
import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener, BillingProcessor.IBillingHandler {

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionPageAdapter;

    private ViewPager mViewPager;

    public static BigDecimal getStarAmount() {
        return starAmount;
    }

    public static BigDecimal getClickMultiplier() {
        return clickMultiplier;
    }

    public static BigDecimal getPerClickAmount() {
        return perClickAmount;
    }

    public static BigDecimal getOfflineAmount() {
        return offlineAmount;
    }

    public static void setStarAmount(BigDecimal starAmount) {
        MainActivity.starAmount = starAmount;
    }

    public static void setClickMultiplier(BigDecimal clickMultiplier) {
        MainActivity.clickMultiplier = clickMultiplier;
    }

    public static void setPerClickAmount(BigDecimal perClickAmount) {
        MainActivity.perClickAmount = perClickAmount;
    }

    public static void setOfflineAmount(BigDecimal offlineAmount) {
        MainActivity.offlineAmount = offlineAmount;
    }

    public static BigDecimal getPlanetNumber() {
        return planetNumber;
    }

    public static void setPlanetNumber(BigDecimal planetNumber) {
        MainActivity.planetNumber = planetNumber;
    }

    private String clicksString = "";

    private static BigDecimal planetNumber = new BigDecimal(0);
    private static BigDecimal starAmount = new BigDecimal(0);
    private static BigDecimal clickMultiplier = new BigDecimal(0);
    private static BigDecimal perClickAmount = new BigDecimal(0);

    public static String getResume() {
        return resume;
    }

    public static void setResume(String resume) {
        MainActivity.resume = resume;
    }

    private static String resume = "";

    public static void setOfflineHours(BigDecimal offlineHours) {
        MainActivity.offlineHours = offlineHours;
    }

    private static BigDecimal offlineAmount = new BigDecimal(0);

    public static BigDecimal getOfflineHours() {
        return offlineHours;
    }

    private static BigDecimal offlineHours = new BigDecimal(0);

    public static BigDecimal getOfflineHoursUsed() {
        return offlineHoursUsed;
    }

    private static BigDecimal offlineHoursUsed = new BigDecimal(0);

    public static BigDecimal getOfflineTotalHours() {
        return offlineTotalHours;
    }

    private static BigDecimal offlineTotalHours = new BigDecimal(0);

    public static String getMaxHours() {
        return maxHours;
    }

    private static String maxHours = "False";

    private static BigDecimal date2;
    private static long timeDifference;
    private static Date date1date;
    private static long date1Long;
    private static Date date2date;
    private static long date2Long;

    private static long totalTime;

    public static BigDecimal getOfflineEarnings() {
        return offlineEarnings;
    }

    public static BigDecimal getOfflineMultiplier() {
        return offlineMultiplier;
    }

    public static void setOfflineEarnings(BigDecimal offlineEarnings) {
        MainActivity.offlineEarnings = offlineEarnings;
    }

    public static void setOfflineMultiplier(BigDecimal offlineMultiplier) {
        MainActivity.offlineMultiplier = offlineMultiplier;
    }

    private static BigDecimal offlineEarnings = new BigDecimal(0);
    private static BigDecimal offlineMultiplier = new BigDecimal(0);
    private String starAmountString = "";
    private String clickMultiplierString = "";
    private String perClickAmountString = "";
    private String offlineEarningsString = "";
    private String offlineMultiplierString = "";
    private String planetNumberString = "";
    private String offlineHoursString = "";

    public String getPause() {
        return pause;
    }

    public void setPause(String pause) {
        this.pause = pause;
    }

    private String pause = "False";

    public BigDecimal getClicks() {
        return clicks;
    }

    public void setClicks(BigDecimal clicks) {
        this.clicks = clicks;
    }

    private BigDecimal clicks = new BigDecimal(0);

    public String getOfflineAmountString() {
        return offlineAmountString;
    }

    private static String offlineAmountString = "";

    public static InterstitialAd getInterstitialAd1() {
        return interstitialAd1;
    }

    public static RewardedVideoAd getRewardAd() {
        return rewardAd;
    }

    private static RewardedVideoAd rewardAd;
    private static InterstitialAd interstitialAd1;

    public static String getRewardVideo() {
        return rewardVideo;
    }

    public static void setRewardVideo(String rewardVideo) {
        MainActivity.rewardVideo = rewardVideo;
    }

    private static String rewardVideo = "False";

    public static BigDecimal getShipLevel() {
        return shipLevel;
    }

    private static BigDecimal shipLevel = new BigDecimal(0);
    private static String shipLevelString = "";

    public static String getRevealNumber() {
        return revealNumber;
    }

    public static void setRevealNumber(String revealNumber) {
        MainActivity.revealNumber = revealNumber;
    }

    private static String revealNumber = "False";

    public static BillingProcessor getBp() {
        return bp;
    }

    private static BillingProcessor bp;

    public static String getFirstTime() {
        return firstTime;
    }

    public static void setFirstTime(String firstTime) {
        MainActivity.firstTime = firstTime;
    }

    private static String firstTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bp = new BillingProcessor(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnkhQUr0sANjT1MqsdjgJCE1wlvsd8wFF/HoODsCgg3DX7HOyZihAlzI1iOvz8clhZ3L+YJcfBi4VXO4IYMipDkjUKdoYx7NyBUetEqDLidk8vajlcHKCEHVcr9PXOdkT5ul5cdyNs/XkV3MaJc/DxuDG+ta84/TzzE2XxW3WpOEOeYgWHpGfxDzpzS+tmQkyOHQZMhnx3Iw8CcEN0OurntE1K2tOvMUAlzFGVam5FaTqr1e0IxQ0dJSckLQs9yragPj0V/Wnj6CI2ojk3xCAlEp0kd+XxHU4bhYPrYyxTKarNk1fASiBb3jc4G1d/83IIoO+r3Y52cnL6Q0DD0nbIQIDAQAB", this);

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        interstitialAd1 = new InterstitialAd(this);
        interstitialAd1.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd1.loadAd(new AdRequest.Builder().build());

        interstitialAd1.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                interstitialAd1.loadAd(new AdRequest.Builder().build());
                pause = "False";
            }
        });

        rewardAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardAd.setRewardedVideoAdListener(this);

        mSectionPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        loadSave();

        resume = "True";

        date2date = new Date(System.currentTimeMillis());
        date2Long = date2date.getTime();
        date2 = new BigDecimal(date2Long);

        timeDifference = (date2Long - date1Long)/1000;

        if (new BigDecimal(timeDifference).compareTo(offlineHours.multiply(new BigDecimal(3600))) > 0) {
            totalTime = timeDifference;
            offlineTotalHours = (new BigDecimal(totalTime)).divide((new BigDecimal(3600)), 2, RoundingMode.HALF_UP);
            timeDifference = offlineHours.longValue();
            timeDifference = timeDifference * 3600;
            maxHours = "True";
        }

        offlineAmount = (new BigDecimal(timeDifference)).multiply((offlineEarnings).multiply(offlineMultiplier));

        offlineAmountString = stringNumber(offlineAmount);
        offlineHoursUsed = (new BigDecimal(timeDifference)).divide((new BigDecimal(3600)), 2, RoundingMode.HALF_UP);

        loadRewardedVideoAd();
    }

    protected void onPause() {
        super.onPause();

        pause = "True";

        date1date = new Date(System.currentTimeMillis());
        long millis = date1date.getTime();
        runSave("STARAMOUNT", starAmount);
        runSave("CLICKMULTIPLIER", clickMultiplier);
        runSave("PERCLICKAMOUNT", perClickAmount);
        runSave("OFFLINEEARNINGS", offlineEarnings);
        runSave("OFFLINEMULTIPLIER", offlineMultiplier);
        runSave("PLANETNUMBER", planetNumber);
        runSave("OFFLINEHOURS", offlineHours);
        runSave("CLICKS", clicks);
        runSave("SHIPLEVEL", shipLevel);
        runSaveString("REVEALNUMBER", revealNumber);
        runSaveString("FIRSTTIME", firstTime);
        runSaveCalendar("DATE1", millis);
    }

    protected void onResume() {
        super.onResume();
        loadSave();

        if (rewardVideo.equals("False")) {
            resume = "True";

            date2date = new Date(System.currentTimeMillis());
            date2Long = date2date.getTime();
            date2 = new BigDecimal(date2Long);

            timeDifference = (date2Long - date1Long)/1000;

            if (new BigDecimal(timeDifference).compareTo(offlineHours.multiply(new BigDecimal(3600))) > 0) {
                totalTime = timeDifference;
                offlineTotalHours = (new BigDecimal(totalTime)).divide((new BigDecimal(3600)), 2, RoundingMode.HALF_UP);
                timeDifference = offlineHours.longValue();
                timeDifference = timeDifference * 3600;
                maxHours = "True";
            }

            offlineAmount = (new BigDecimal(timeDifference)).multiply((offlineEarnings).multiply(offlineMultiplier));

            offlineAmountString = stringNumber(offlineAmount);
            offlineHoursUsed = (new BigDecimal(timeDifference)).divide((new BigDecimal(3600)), 2, RoundingMode.HALF_UP);
        }
    }

    private void loadRewardedVideoAd() {
        rewardAd.loadAd("ca-app-pub-3940256099942544/5224354917",
                new AdRequest.Builder().build());
    }

    @Override
    protected void onDestroy() {
        if (bp != null) {
            bp.release();
        }
        super.onDestroy();
        date1date = new Date(System.currentTimeMillis());
        long millis = date1date.getTime();
        runSave("STARAMOUNT", starAmount);
        runSave("CLICKMULTIPLIER", clickMultiplier);
        runSave("PERCLICKAMOUNT", perClickAmount);
        runSave("OFFLINEEARNINGS", offlineEarnings);
        runSave("OFFLINEMULTIPLIER", offlineMultiplier);
        runSave("PLANETNUMBER", planetNumber);
        runSave("OFFLINEHOURS", offlineHours);
        runSave("CLICKS", clicks);
        runSave("SHIPLEVEL", shipLevel);
        runSaveString("REVEALNUMBER", revealNumber);
        runSaveString("FIRSTTIME", firstTime);
        runSaveCalendar("DATE1", millis);
    }

    private void runSaveCalendar(String key, long value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = sp.edit();

        edit.putLong(key, value);
        edit.commit();
    }

    private void runSave(String key, BigDecimal value) {
        String valueUse = value.toString();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = sp.edit();

        edit.putString(key, valueUse);
        edit.commit();
    }

    private void runSaveString(String key, String value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = sp.edit();

        edit.putString(key, value);
        edit.commit();
    }

    private void loadSave() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        starAmountString = sp.getString("STARAMOUNT", "0");
        clickMultiplierString = sp.getString("CLICKMULTIPLIER", "1");
        perClickAmountString = sp.getString("PERCLICKAMOUNT", "2");
        offlineEarningsString = sp.getString("OFFLINEEARNINGS", "1");
        offlineMultiplierString = sp.getString("OFFLINEMULTIPLIER", "1");
        planetNumberString = sp.getString("PLANETNUMBER", "0");
        offlineHoursString = sp.getString("OFFLINEHOURS", "2");
        clicksString = sp.getString("CLICKS", "1");
        shipLevelString = sp.getString("SHIPLEVEL", "1");
        revealNumber = sp.getString("REVEALNUMBER", "False");
        firstTime = sp.getString("FIRSTTIME", "True");

        date1date = new Date(System.currentTimeMillis());
        long millis = date1date.getTime();

        date1Long = sp.getLong("DATE1", millis);

        shipLevel = new BigDecimal(shipLevelString);
        starAmount = new BigDecimal(starAmountString);
        clickMultiplier = new BigDecimal(clickMultiplierString);
        perClickAmount = new BigDecimal(perClickAmountString);
        offlineEarnings = new BigDecimal(offlineEarningsString);
        offlineMultiplier = new BigDecimal(offlineMultiplierString);
        planetNumber = new BigDecimal(planetNumberString);
        offlineHours = new BigDecimal(offlineHoursString);
        clicks = new BigDecimal(clicksString);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "Ship");
        adapter.addFragment(new Tab2Fragment(), "Upgrades");
        adapter.addFragment(new Tab3Fragment(), "Shop");
        viewPager.setAdapter(adapter);
    }

    protected static String stringNumber(BigDecimal x) {
        String number = "";
        BigDecimal y = x;
        BigInteger d = x.toBigInteger();
        BigDecimal c = new BigDecimal(10);
        int length = String.valueOf(d).length();

        if (length <= 3) {
            x.setScale(2, RoundingMode.CEILING);
            number = x.toString();
        }
        else if (length <= 6) {
            y = y.divide(new BigDecimal(1000), 2, RoundingMode.HALF_UP);
            number = y + " Thousand";
        }
        else if (length <= 9) {
            y = y.divide(new BigDecimal(1000000), 2, RoundingMode.HALF_UP);
            number = y + " Million";
        }
        else if (length <= 12) {
            y = y.divide(new BigDecimal(1000000000), 2, RoundingMode.HALF_UP);
            number = y + " Billion";
        }
        else if (length <= 15) {
            y = y.divide(new BigDecimal(Math.pow(10, 12)), 2, RoundingMode.HALF_UP);
            number = y + " Trillion";
        }
        else if (length <= 18) {
            y = y.divide(new BigDecimal(Math.pow(10, 15)), 2, RoundingMode.HALF_UP);
            number = y + " Quadrillion";
        }
        else if (length <= 21) {
            y = y.divide(new BigDecimal(Math.pow(10, 18)), 2, RoundingMode.HALF_UP);
            number = y + " Quintillion";
        }
        else if (length <= 24) {
            y = y.divide(new BigDecimal(Math.pow(10, 21)), 2, RoundingMode.HALF_UP);
            number = y + " Sextillion";
        }
        else if (length <= 27) {
            y = y.divide(new BigDecimal(Math.pow(10, 24)), 2, RoundingMode.HALF_UP);
            number = y + " Septillion";
        }
        else if (length <= 30) {
            y = y.divide(new BigDecimal(Math.pow(10, 27)), 2, RoundingMode.HALF_UP);
            number = y + " Octillion";
        }
        else if (length <= 33) {
            y = y.divide(new BigDecimal(Math.pow(10, 30)), 2, RoundingMode.HALF_UP);
            number = y + " Nonillion";
        }
        else if (length <= 36) {
            y = y.divide(new BigDecimal(Math.pow(10, 33)), 2, RoundingMode.HALF_UP);
            number = y + " Decillion";
        }
        else if (length <= 39) {
            y = y.divide(new BigDecimal(Math.pow(10, 36)), 2, RoundingMode.HALF_UP);
            number = y + " Undecillion";
        }
        else if (length <= 42) {
            y = y.divide(new BigDecimal(Math.pow(10, 39)), 2, RoundingMode.HALF_UP);
            number = y + " Duodecillion";
        }
        else if (length <= 45) {
            y = y.divide(new BigDecimal(Math.pow(10, 42)), 2, RoundingMode.HALF_UP);
            number = y + " Tredecillion";
        }
        else if (length <= 48) {
            y = y.divide(new BigDecimal(Math.pow(10, 45)), 2, RoundingMode.HALF_UP);
            number = y + " Quattuordecillion";
        }
        else if (length <= 51) {
            y = y.divide(new BigDecimal(Math.pow(10, 48)), 2, RoundingMode.HALF_UP);
            number = y + " Quindecillion";
        }
        else if (length <= 54) {
            y = y.divide(new BigDecimal(Math.pow(10, 51)), 2, RoundingMode.HALF_UP);
            number = y + " Sexdecillion";
        }
        else if (length <= 57) {
            y = y.divide(new BigDecimal(Math.pow(10, 54)), 2, RoundingMode.HALF_UP);
            number = y + " Septen-decillion";
        }
        else if (length <= 60) {
            y = y.divide(new BigDecimal(Math.pow(10, 57)), 2, RoundingMode.HALF_UP);
            number = y + " Octodecillion";
        }
        else if (length <= 63) {
            y = y.divide(new BigDecimal(Math.pow(10, 60)), 2, RoundingMode.HALF_UP);
            number = y + " Novemdecillion";
        }
        else if (length <= 66) {
            y = y.divide(new BigDecimal(Math.pow(10, 63)), 2, RoundingMode.HALF_UP);
            number = y + " Vigintillion";
        }
        else if (length <= 69) {
            y = y.divide(new BigDecimal(Math.pow(10, 66)), 2, RoundingMode.HALF_UP);
            number = y + " Trigintillion";
        }
        else if (length <= 72) {
            y = y.divide(new BigDecimal(Math.pow(10, 69)), 2, RoundingMode.HALF_UP);
            number = y + " Quadragintillion";
        }
        else if (length <= 75) {
            y = y.divide(new BigDecimal(Math.pow(10, 72)), 2, RoundingMode.HALF_UP);
            number = y + " Quintagintillion";
        }
        else if (length <= 78) {
            y = y.divide(new BigDecimal(Math.pow(10, 75)), 2, RoundingMode.HALF_UP);
            number = y + " Sextagintillion";
        }
        else if (length <= 81) {
            y = y.divide(new BigDecimal(Math.pow(10, 78)), 2, RoundingMode.HALF_UP);
            number = y + " Septagintillion";
        }
        else if (length <= 84) {
            y = y.divide(new BigDecimal(Math.pow(10, 81)), 2, RoundingMode.HALF_UP);
            number = y + " Ocragintillion";
        }
        else if (length <= 87) {
            y = y.divide(new BigDecimal(Math.pow(10, 84)), 2, RoundingMode.HALF_UP);
            number = y + " Nonagintillion";
        }
        else if (length <= 90) {
            y = y.divide(new BigDecimal(Math.pow(10, 87)), 2, RoundingMode.HALF_UP);
            number = y + " Centillion";
        }
        else if (length <= 93) {
            y = y.divide(new BigDecimal(Math.pow(10, 90)), 2, RoundingMode.HALF_UP);
            number = y + " Decicentillion";
        }
        else if (length <= 96) {
            y = y.divide(new BigDecimal(Math.pow(10, 93)), 2, RoundingMode.HALF_UP);
            number = y + " Vigincentillion";
        }
        else if (length <= 99) {
            y = y.divide(new BigDecimal(Math.pow(10, 96)), 2, RoundingMode.HALF_UP);
            number = y + " Trigincentillion";
        }
        else if (length <= 102) {
            y = y.divide(new BigDecimal(Math.pow(10, 99)), 2, RoundingMode.HALF_UP);
            number = y + " Bicentillion";
        }
        else if (length <= 105) {
            y = y.divide(new BigDecimal(Math.pow(10, 102)), 2, RoundingMode.HALF_UP);
            number = y + " Tricentillion";
        }
        else if (length <= 108) {
            y = y.divide(new BigDecimal(Math.pow(10, 105)), 2, RoundingMode.HALF_UP);
            number = y + " Tretrigintricentillion";
        }
        else if (length <= 111) {
            y = y.divide(new BigDecimal(Math.pow(10, 108)), 2, RoundingMode.HALF_UP);
            number = y + " Quadricentillion";
        }
        else if (length <= 114) {
            y = y.divide(new BigDecimal(Math.pow(10, 111)), 2, RoundingMode.HALF_UP);
            number = y + " Quindecillion";
        }
        else if (length <= 117) {
            y = y.divide(new BigDecimal(Math.pow(10, 114)), 2, RoundingMode.HALF_UP);
            number = y + " Sexdecillion";
        }
        else if (length <= 120) {
            y = y.divide(new BigDecimal(Math.pow(10, 117)), 2, RoundingMode.HALF_UP);
            number = y + " Septendecillion";
        }
        else if (length <= 123) {
            y = y.divide(new BigDecimal(Math.pow(10, 120)), 2, RoundingMode.HALF_UP);
            number = y + " Octodecillion";
        }
        else if (length <= 126) {
            y = y.divide(new BigDecimal(Math.pow(10, 123)), 2, RoundingMode.HALF_UP);
            number = y + " Novemdecillion";
        }
        else if (length <= 129) {
            y = y.divide(new BigDecimal(Math.pow(10, 126)), 2, RoundingMode.HALF_UP);
            number = y + " Vigintillion";
        }
        else if (length <= 132) {
            y = y.divide(new BigDecimal(Math.pow(10, 129)), 2, RoundingMode.HALF_UP);
            number = y + " Trigintillion";
        }
        else if (length <= 135) {
            y = y.divide(new BigDecimal(Math.pow(10, 132)), 2, RoundingMode.HALF_UP);
            number = y + " Quadragintillion";
        }
        else if (length <= 138) {
            y = y.divide(new BigDecimal(Math.pow(10, 135)), 2, RoundingMode.HALF_UP);
            number = y + " Quintagintillion";
        }
        else if (length <= 141) {
            y = y.divide(new BigDecimal(Math.pow(10, 138)), 2, RoundingMode.HALF_UP);
            number = y + " Killion";
        }
        else if (length <= 144) {
            y = y.divide(new BigDecimal(Math.pow(10, 141)), 2, RoundingMode.HALF_UP);
            number = y + " Myrillion";
        }
        else if (length <= 147) {
            y = y.divide(new BigDecimal(Math.pow(10, 144)), 2, RoundingMode.HALF_UP);
            number = y + " Dekamyrillion";
        }
        else if (length <= 150) {
            y = y.divide(new BigDecimal(Math.pow(10, 147)), 2, RoundingMode.HALF_UP);
            number = y + " Megalillion";
        }
        else if (length <= 153) {
            y = y.divide(new BigDecimal(Math.pow(10, 150)), 2, RoundingMode.HALF_UP);
            number = y + " Gigalillion";
        }
        else if (length <= 156) {
            y = y.divide(new BigDecimal(Math.pow(10, 153)), 2, RoundingMode.HALF_UP);
            number = y + " Teralillion";
        }
        else if (length <= 159) {
            y = y.divide(new BigDecimal(Math.pow(10, 156)), 2, RoundingMode.HALF_UP);
            number = y + " Petalillion";
        }
        else if (length <= 162) {
            y = y.divide(new BigDecimal(Math.pow(10, 159)), 2, RoundingMode.HALF_UP);
            number = y + " Exalillion";
        }
        else if (length <= 165) {
            y = y.divide(new BigDecimal(Math.pow(10, 162)), 2, RoundingMode.HALF_UP);
            number = y + " Zettalillion";
        }
        else if (length <= 168) {
            y = y.divide(new BigDecimal(Math.pow(10, 165)), 2, RoundingMode.HALF_UP);
            number = y + " Yottalillion";
        }
        else if (length <= 171) {
            y = y.divide(new BigDecimal(Math.pow(10, 168)), 2, RoundingMode.HALF_UP);
            number = y + " Keilillion";
        }
        else if (length <= 174) {
            y = y.divide(new BigDecimal(Math.pow(10, 171)), 2, RoundingMode.HALF_UP);
            number = y + " Natilillion";
        }
        else if (length <= 177) {
            y = y.divide(new BigDecimal(Math.pow(10, 174)), 2, RoundingMode.HALF_UP);
            number = y + " Nimillion";
        }
        else if (length <= 180) {
            y = y.divide(new BigDecimal(Math.pow(10, 177)), 2, RoundingMode.HALF_UP);
            number = y + " Listillion";
        }
        else if (length <= 183) {
            y = y.divide(new BigDecimal(Math.pow(10, 180)), 2, RoundingMode.HALF_UP);
            number = y + " Yololillion";
        }
        else if (length <= 186) {
            y = y.divide(new BigDecimal(Math.pow(10, 183)), 2, RoundingMode.HALF_UP);
            number = y + " Cralillion";
        }
        else if (length <= 189) {
            y = y.divide(new BigDecimal(Math.pow(10, 186)), 2, RoundingMode.HALF_UP);
            number = y + " Aarulillion";
        }
        else if (length <= 192) {
            y = y.divide(new BigDecimal(Math.pow(10, 189)), 2, RoundingMode.HALF_UP);
            number = y + " Willulillion";
        }
        else if (length <= 195) {
            y = y.divide(new BigDecimal(Math.pow(10, 192)), 2, RoundingMode.HALF_UP);
            number = y + " Hulillion";
        }
        else {
            number = "Infinity - Go To Contest Details To Enter";
        }

        return number;
    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();
        rewardVideo = "True";
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        offlineAmount = offlineAmount.multiply(new BigDecimal(10));
        offlineAmountString = stringNumber(offlineAmount);
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onProductPurchased(@NonNull String productId, @Nullable TransactionDetails details) {
        if (productId.equals("shiptolevel2")) {
            Toast.makeText(this, "Thank you for your purchase! - Upgrade Ship To Level 2", Toast.LENGTH_LONG).show();
            shipLevel = new BigDecimal(2);
            offlineHours = new BigDecimal(8);
            //bp.consumePurchase("shiptolevel2");
            rewardVideo = "True";
        }
        else if (productId.equals("shiptolevel3")) {
            Toast.makeText(this, "Thank you for your purchase! - Upgrade Ship To Level 3", Toast.LENGTH_LONG).show();
            shipLevel = new BigDecimal(3);
            offlineHours = new BigDecimal(24);
            //bp.consumePurchase("shiptolevel3");
            rewardVideo = "True";
        }
        else if (productId.equals("revealnumber")) {
            Toast.makeText(this, "Thank you for your purchase! - Reveal Number", Toast.LENGTH_LONG).show();
            revealNumber = "True";
            //bp.consumePurchase("revealNumber");
            rewardVideo = "True";
        }
    }

    @Override
    public void onPurchaseHistoryRestored() {

    }

    @Override
    public void onBillingError(int errorCode, @Nullable Throwable error) {
        Toast.makeText(this, "Something went wrong with your purchase - please try again", Toast.LENGTH_LONG).show();
        rewardVideo = "True";
    }

    @Override
    public void onBillingInitialized() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

