package com.example.projekat2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.projekat2.adapter.BannerMoviesPagerAdapter;
import com.example.projekat2.adapter.MainRecyclerAdapter;
import com.example.projekat2.model.AllCategory;
import com.example.projekat2.model.BannerMovies;
import com.example.projekat2.model.CategoryItem;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout indicatorTab,categoryTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> tvShowBannerList;
    List<BannerMovies> movieBannerList;
    List<BannerMovies> kidsBannerList;

    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    List<AllCategory> allCategoryList;
    List<CategoryItem> homeCatListItem1;
    List<CategoryItem> homeCatListItem2;
    List<CategoryItem> homeCatListItem3;
    List<CategoryItem> homeCatListItem4;

    Timer sliderTimer;
    NestedScrollView nestedScrollView;
    AppBarLayout appBarLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        indicatorTab =findViewById(R.id.tab_indicator);
        categoryTab=findViewById(R.id.tabLayout);
        nestedScrollView=findViewById(R.id.nested_scroll);
        appBarLayout=findViewById(R.id.appbar);




        homeBannerList =new ArrayList<>();
        homeBannerList.add(new BannerMovies(1,"The holiday","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2F5fd7f05bdf92d0af4c0d92ede73cfea4534890b4b7fb1c7cc3d9f65f1ba7e9f7._UY500_UX667_RI_V_TTW_.jpg?alt=media&token=f8df2eb9-d2c8-4b17-8c71-551cfd8ad257","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FThe%20Holiday%20(2006)%20Official%20Trailer%201%20-%20Kate%20Winslet%20Movie.mp4?alt=media&token=79837cea-9af4-485a-ac23-27331bed1f32"));
        homeBannerList.add(new BannerMovies(2,"Fast and furious 6","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fnbcu-2418-Full-Image_GalleryCover-en-GB-1486516959140._UR1920%2C1080_RI_.jpg?alt=media&token=2566bdb1-1e00-4bf0-b11b-37315bb48b59","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FFast%20%26%20Furious%208%20-%20Official%20Trailer%201%20(Universal%20Pictures)%20HD.mp4?alt=media&token=f017cd35-77a1-4101-a61c-7a3ceaed60ea"));
        homeBannerList.add(new BannerMovies(3,"Little Woman","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2F5eb5bb06eb74af961d77903a1c20dee0.jpg?alt=media&token=cb2007a0-4c4b-4756-af9c-a29aeab9fcac","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FLITTLE%20WOMEN%20-%20Official%20Trailer%20(HD).mp4?alt=media&token=f42cb35c-046b-4c0c-9b8e-724ba80590e7"));
        homeBannerList.add(new BannerMovies(4,"Bhoot a hunted ship","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fpjimage-13-1587544294.jpg?alt=media&token=d426a69b-9b86-43ed-9ff6-af2d37efa2eb","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FBhoot%20The%20Haunted%20Ship%20OFFICIAL%20TEASER%20Vicky%20Kaushal%2C%20Bhumi%20Pednekar%2021st%20Feb.mp4?alt=media&token=f70b374c-54c8-4a5d-9cdf-c6c1b35acfea"));
        homeBannerList.add(new BannerMovies(5,"Pikachu","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fwb-2082372_6000120896-Full-Image_GalleryCover-en-US-1588670867937._UY500_UX667_RI_VjORLkbIrAd0F8ssOaDd11t68nClrmmv_TTW_.jpg?alt=media&token=31558dc0-8c52-4674-a506-466c2fa95460","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FPOKEMON%20Detective%20Pikachu%20Trailer%20(2019).mp4?alt=media&token=0d558345-e0bb-4c3c-8cd6-1343bcf69075"));


        tvShowBannerList =new ArrayList<>();
        tvShowBannerList.add(new BannerMovies(1,"Skull and Roses","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fskulls-and-roses-review-759.jpg?alt=media&token=860635eb-e8d9-4fbb-86cb-959b2c352e00","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FSkulls%20%26%20Roses%20Official%20Trailer%20Raghu%20Ram%2C%20Rajiv%20Lakshman%20Amazon%20Original%202019.mp4?alt=media&token=f2f611d4-96e5-4d9d-b97d-0b0e515c670c"));
        tvShowBannerList.add(new BannerMovies(2,"ComicStaan","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2F91pCYhXsxqL._RI_.jpg?alt=media&token=e18f5e73-0d9d-4bfb-a5ac-94cfbdcd9d21","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FComicstaan%20-%20Official%20Trailer%202018%20Prime%20Original%20Amazon%20Prime%20Video.mp4?alt=media&token=9fc1e434-3638-4a70-b2b4-50dfbf19ddba"));
        tvShowBannerList.add(new BannerMovies(3,"Upload","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Funnamed2.jpg?alt=media&token=300bfd6c-99a6-4f5f-a3d2-e5e9e2ad4af9","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FUpload%20-%20Official%20Trailer%20I%20Prime%20Video.mp4?alt=media&token=c2dff762-0015-4133-8218-06efdfcdbe22"));
        tvShowBannerList.add(new BannerMovies(4,"Hunters","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2F91cPp8Ufe8L._RI_.jpg?alt=media&token=1fe2b5e4-c976-4869-adc8-6ab0012e2c63","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FHunters%20Season%201%20Official%20Trailer%20(2020)%20Al%20Pacino.mp4?alt=media&token=79e127b4-f84f-4777-9d4f-616bb6804690"));

        movieBannerList =new ArrayList<>();
        movieBannerList.add(new BannerMovies(1,"A beautiful day in neighboors","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2FSPHE-11007212-Full-Image_GalleryCover-en-US-1602141602687._UR1920%2C1080_RI_SX329_.jpg?alt=media&token=964f6a43-0142-43f2-b2ac-2d279ce4aa7d","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FA%20BEAUTIFUL%20DAY%20IN%20THE%20NEIGHBORHOOD%20-%20Official%20Trailer%20(HD).mp4?alt=media&token=4fcb37fb-e4fd-4332-8820-a6605b7c5752"));
        movieBannerList.add(new BannerMovies(2,"Black mail","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fbg10.jpg?alt=media&token=d3cc7274-fe6f-4941-bbfe-bcf8d83e112b","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FOfficial%20Trailer%20Black%E0%A4%AE%E0%A4%B2%20Irrfan%20Khan%20Abhinay%20Deo%206th%20April%202018.mp4?alt=media&token=2791133a-e7e0-4b77-aff4-4e0dbc0b4f66"));
        movieBannerList.add(new BannerMovies(3,"Sufna","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2F171091.jpg?alt=media&token=9a4e1634-7d41-4caa-acdb-8ed18c24cbae","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FSufna%20(Official%20Trailer)%20Ammy%20Virk%20Tania%20Jaani%20B%20Praak%20Releasing%20on%2014th%20Feb%202020.mp4?alt=media&token=35b244ef-5496-49fe-8de8-75777db07414"));

        kidsBannerList=new ArrayList<>();
        kidsBannerList.add(new BannerMovies(1,"Bajrangi","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2F73e4ef85-7acc-4089-952e-d4b344c3afef-56de7751-4c6b-4051-a837-55f229889c5d_RGB_SD._RI_Vc5MekJNDXxD2sA0dr8Jt8LPvVd5px0G_TTW_.jpg?alt=media&token=998a91a4-a657-4217-b799-01664a9838b6","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FBajrangi%20cartoon%20full%20video%20song%20in%20HD.mp4?alt=media&token=ca1bae6e-6e75-4d26-a742-e9d28f123a4d"));
        kidsBannerList.add(new BannerMovies(2,"Inspector chingum","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2FChingum_show.jpg?alt=media&token=f21813dc-a3f5-4943-bde2-46cc3cbe1eb5","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FInspector%20Chingum%20Animated%20Kids%20Series%20Official%20Trailer%20Amazon%20Prime%20Video.mp4?alt=media&token=fd2c7606-211c-4fb3-88bd-e0ed499e2092"));
        kidsBannerList.add(new BannerMovies(3,"Oodbods","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fx1080.jpg?alt=media&token=79018666-0f27-46d1-9acf-77e8a4214ac3","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FOddbods%20Season%201%20Trailer%20Funny%20Cartoons%20For%20Kids.mp4?alt=media&token=daa03800-34f8-4405-9b49-cf6dae2772bb"));
        kidsBannerList.add(new BannerMovies(4,"adventures tanliraman","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2F7a8aa16cba3d9af53af801fde238caafae248719d14b21e60fbd771583573315._RI_V_TTW_.jpg?alt=media&token=3d0fa370-75a9-457a-9266-728ccaa12728","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FThe%20Adventure%20Of%20Tenali%20Raman%20Hindi%20Intro%20Opening.mp4?alt=media&token=8ff6fde1-9de8-4931-9e53-f00f8f591533"));
        kidsBannerList.add(new BannerMovies(5,"wishenproof","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Ff27c884548f4590f27495b1244ff3287fcfa1ba2838ca67acf7cc2d7d964235d._RI_V_TTW_%20(1).jpg?alt=media&token=0b678bf2-717e-465e-9803-46c4755c4b75","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FWishenpoof!%20-%20Official%20Trailer%20Prime%20Video.mp4?alt=media&token=82f72344-6d2a-4969-b9e2-dddf392171da"));

        setBannerMoviesPagerAdapter(homeBannerList);

        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(tvShowBannerList);
                        return;
                    case 2:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(movieBannerList);
                        return;
                    case 3:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(kidsBannerList);
                        return;
                    default:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(homeBannerList);

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        homeCatListItem1=new ArrayList<>();
        homeCatListItem1.add(new CategoryItem(1,"Love and other drugs","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fnull.jpg?alt=media&token=e2f9a8d5-8899-49f0-afa3-30fba95cc285","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FLove%20and%20Other%20Drugs%20Trailer%20HD%2020th%20Century%20FOX%20(1).mp4?alt=media&token=79a1ec9b-8d01-4cb2-92df-d8866db6d1e5"));
        homeCatListItem1.add(new CategoryItem(2,"Bewakoofiyaan","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fd7c6ad0bbd2ba9e09b6bebca5bc41eac6286aff64962ce90797b79c0d26c9379._UY500_UX667_RI_V_TTW_.jpg?alt=media&token=2c39aae1-be81-49fb-bd1d-61dffc8e90f0","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FBewakoofiyaan%20Official%20Trailer%20Ayushmann%20Khurrana%20Sonam%20Kapoor%20(1).mp4?alt=media&token=68206699-5824-411c-86f2-f4d9446e8390"));
        homeCatListItem1.add(new CategoryItem(3,"Supernatural","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fwb-888574546441-Full-Image_GalleryCover-en-US-1507752672514._UY500_UX667_RI_V1e2cebf2f4a43995a3490e4f3e3cc37d_TTW_.jpg?alt=media&token=38072e3b-c512-4dac-a383-8e7652a63e90","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FSupernatural%20Season%201%20Trailer%20(1).mp4?alt=media&token=2cff3fa7-2eb0-499d-9ec9-8e1c0eb69b4b"));
        homeCatListItem1.add(new CategoryItem(4,"T-34","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fd7c6ad0bbd2ba9e09b6bebca5bc41eac6286aff64962ce90797b79c0d26c9379._UY500_UX667_RI_V_TTW_.jpg?alt=media&token=2c39aae1-be81-49fb-bd1d-61dffc8e90f0","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FT-34%20official%20trailer%20(2018)%20(1).mp4?alt=media&token=410e2efb-1310-4802-80f8-1c3f10251a5c"));
        homeCatListItem1.add(new CategoryItem(5,"Season of the witch","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Frelativity-season-Full-Image_GalleryCover-en-US-1537211248886._UY500_UX667_RI_Vdfe095090e718f8b9cd43f7ae5169054_TTW_.jpg?alt=media&token=11501f5b-a649-4c64-a3cc-ebbf7ce29ae2","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FSeason%20of%20the%20Witch%20Trailer%20(1).mp4?alt=media&token=71b23ac5-9483-4a63-8f9b-5f0ab0a07027"));

        homeCatListItem2=new ArrayList<>();
        homeCatListItem2.add(new CategoryItem(1,"Bhoot","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fbee4c34123ee1b254dc1d55abc8f708b34a3827892588d6819d5c20fd6a5da13._UY500_UX667_RI_V_TTW_.jpg?alt=media&token=30f776e0-ddad-4f6d-9f66-c014db4339f4","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FBhoot%20The%20Haunted%20Ship%20OFFICIAL%20TRAILER%20Vicky%20Kaushal%20%26%20Bhumi%20Pednekar%20Bhanu%20Pratap%20Singh.mp4?alt=media&token=5c025efc-5e7c-4712-a3ea-436aa0687786"));
        homeCatListItem2.add(new CategoryItem(2,"Black mail","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2F2f813d581199099922bd238aa1d407babc3b3bf5112bb835b95c26fabda69e9a._UY500_UX667_RI_V_TTW_.jpg?alt=media&token=c716be87-b487-4ac6-bbdf-582d4e99569f","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FKarwaan%20Official%20Trailer%20Irrfan%20Khan%20DulQuer%20Salmaan%20Mithila%20Palkar%203rd%20Aug%202018.mp4?alt=media&token=a2dc4f97-e8e4-4ae5-bf65-d55e9e391d4a"));
        homeCatListItem2.add(new CategoryItem(4,"102 not out","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2F9d56fc21312c828d7f4d90361d272a9f2d45af640a0f8ef6cbe38c0a4c866e65._UY500_UX667_RI_V_TTW_.jpg?alt=media&token=dd76b4bd-12c8-41d1-9216-5b05dc4ffc9e","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2F102%20Not%20Out%20Official%20Trailer%20Amitabh%20Bachchan%20Rishi%20Kapoor%20Umesh%20Shukla%20In%20Cinemas%20May.mp4?alt=media&token=c54b01cd-7828-4ab0-934f-249a61f62cf1"));
        homeCatListItem2.add(new CategoryItem(5,"Shikara","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fvcf-SHIKARA_2020-Full-Image_GalleryCover-en-US-1585331858979._UY500_UX667_RI_VIYrKIaPzAbgcd6uyX4Ch2aWOghegwR_TTW_.jpg?alt=media&token=945714d2-6bb3-4212-ba2a-42fb1bbf3507","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FShikara%20Official%20Trailer%20Dir%20Vidhu%20Vinod%20Chopra%207th%20February%202020.mp4?alt=media&token=b1540969-6502-4cc7-b02d-23efbd3a18c2"));

        homeCatListItem3=new ArrayList<>();
        homeCatListItem3.add(new CategoryItem(1,"Madagascar","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fnbcu-10A14-Full-Image_GalleryCover-en-US-1516995447966._UY500_UX667_RI_V4MBZU9n9QbNYlkacnHIpuyP4Iqwz6uD_TTW_.jpg?alt=media&token=fd30e757-2812-44d0-a7a0-0e348feea5e5","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FMadagascar%20(2005)%20Trailer%20%231%20Movieclips%20Classic%20Trailers.mp4?alt=media&token=9ff7c282-37a2-4170-bd1c-3f46f48ff7df"));
        homeCatListItem3.add(new CategoryItem(2,"Harry Poter","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fwb-WBTEMP0001416_TVOD-Full-Image_GalleryCover-en-GB-1483993659696._UR1920%2C1080_RI_.jpg?alt=media&token=40386c37-3bc0-418f-a09f-520ddf128385","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FHarry%20Potter%20and%20the%20Sorcerer's%20Stone%20(2001)%20Official%20Trailer%20-%20Daniel%20Radcliffe%20Movie%20HD.mp4?alt=media&token=5fa8192b-b5dd-4c88-8074-3cd8966e2a72"));
        homeCatListItem3.add(new CategoryItem(3,"Jurassic park","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fnbcu-U2274-Full-Image_GalleryCover-en-US-1530130125302._UR1920%2C1080_RI_.jpg?alt=media&token=f68b6191-8945-471c-b9dc-4be86d2458fb","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FJurassic%20Park%20Trailer.mp4?alt=media&token=64e940bd-7466-463d-b165-75541f488fe3"));
        homeCatListItem3.add(new CategoryItem(4,"Storks","https://i0.wp.com/thepeoplesmovies.com/wp-content/uploads/2020/11/A-Storks-Journey-2017.jpg?fit=740%2C416&ssl=1","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FStorks%20Official%20Trailer%20%231%20(2016)%20-%20Kelsey%20Grammer%20Animated%20Movie%20HD.mp4?alt=media&token=38c0484c-5b5c-47e6-ab4d-4571c9b31f1c"));
        homeCatListItem3.add(new CategoryItem(5,"Lost and found","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2FA-Storks-Journey-2017.jpg?alt=media&token=68dc5f2e-04cd-49e4-81b5-84ce7627a6ac","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FLost%20%26%20Found%20Trailer%20-%20On%20DVD%20%26%20Digital%20110.mp4?alt=media&token=1f250985-60a3-4ffd-8cf7-9def3b4ca811"));

        homeCatListItem4=new ArrayList<>();
        homeCatListItem4.add(new CategoryItem(1,"El President","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Ftv-drama-amazon-el-presidente.jpg?alt=media&token=55886892-3c7c-4c9e-b173-afba2c6a521c","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FEl%20Presidente%20Exclusive%20Trailer%20Prime%20Video.mp4?alt=media&token=f0b3981e-fab1-4a8b-9442-803e375dea14"));
        homeCatListItem4.add(new CategoryItem(2,"Patallok","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fbb5464f24fac148a1b244c03d96f9be6f43c67cbbc164ae9017a75ec6d09d3e5._RI_V_TTW_.jpg?alt=media&token=683b561f-e4bd-4b97-803d-dc0f088b9149","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FPaatal%20Lok%20%E0%A4%AA%E0%A4%A4%E0%A4%B2%20%E0%A4%B2%E0%A4%95%20-%20Official%20Trailer%20Amazon%20Original%2015th%20May%202020.mp4?alt=media&token=c4065614-3db5-411c-8eb0-58615655ee9c"));
        homeCatListItem4.add(new CategoryItem(3,"Upload","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2Fupload-1.jpg?alt=media&token=d7947962-fd61-4b0e-8e60-9d17a13bea45","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FUpload%20-%20Official%20Trailer%20I%20Prime%20Video%20(1).mp4?alt=media&token=ebcf9c10-c3d6-4113-adfa-ce6174af883a"));
        homeCatListItem4.add(new CategoryItem(4,"The family man","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/VideoThumnails%2F39b1017ec2506aefff23a334862f0cb03e90b3ce6e26e78d2ddd978e7954aa20._RI_V_TTW_.jpg?alt=media&token=7d6ec5f2-b11b-4729-8c8c-620eb82fd201","https://firebasestorage.googleapis.com/v0/b/projekat2-9c0f7.appspot.com/o/videos%2FThe%20Family%20Man%20Official%20Trailer%20Raj%20%26%20DK%20Manoj%20Bajpayee%20Amazon%20Original%20Watch%20Now.mp4?alt=media&token=ead8b7ae-b132-4575-b643-d7c3a2948042"));


        allCategoryList=new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"Gledajte druge tv emisije i filmove",homeCatListItem1));
        allCategoryList.add(new AllCategory(2,"Filmovi u HINDI ",homeCatListItem2));
        allCategoryList.add(new AllCategory(3,"Filmovi za decu i porodicu",homeCatListItem3));
        allCategoryList.add(new AllCategory(4,"Original serije na amazonu",homeCatListItem4));
        setMainRecycler(allCategoryList);


    }


    class AutoSlider extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(bannerMoviesViewPager.getCurrentItem() < homeBannerList.size()-1){
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem()+1);
                    }
                    else
                    {
                        bannerMoviesViewPager.setCurrentItem(0);
                    }


                }

            });


        }
    }
    public void setMainRecycler(List<AllCategory> allCategoryList){
        mainRecycler=findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter=new MainRecyclerAdapter(this,allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);
    }
    private void setScrollDefaultState(){
        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0,0);
        appBarLayout.setExpanded(true);
    }



    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList){
        bannerMoviesViewPager=findViewById(R.id.banner_viewPager);
        bannerMoviesPagerAdapter= new BannerMoviesPagerAdapter(this,bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager);

        sliderTimer=new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(),4000,6000);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager,true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item:
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Provera admina: ");

               /* final EditText input=new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);*/

                final EditText input2=new EditText(MainActivity.this);
                input2.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                builder.setView(input2);

                builder.setPositiveButton("U redu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(/*input.getText().toString().equals("admin")&&*/input2.getText().toString().equals("123")){
                            Intent intent=new Intent(MainActivity.this,AdminActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Pogresan unos", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                builder.setNegativeButton("Ponisti", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}