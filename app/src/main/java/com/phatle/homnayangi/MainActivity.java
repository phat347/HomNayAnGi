package com.phatle.homnayangi;

import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private List<Food> mList = new ArrayList<>();
    private MenuItemAdapter mAdapter;

    FloatingActionButton random_btn;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mList.clear();
        for (int i = 0; i <= 24; i++) {

            mList.add(new Food("Canh khổ qua","Canh khổ qua nhồi thịt vừa là món ăn bổ dưỡng, ngon miệng, vừa có tác dụng thanh nhiệt, giải độc cơ thể","20.000",R.drawable.canh_kho_qua));
            mList.add(new Food("Canh chua (mình)","Canh chua cá hú có vị chua dịu, thanh mát, thơm ngon, thịt cá ngọt vô cùng hấp dẫn","20.000",R.drawable.canh_chua));
            mList.add(new Food("Canh súp","Rau củ quả giàu vitamin & chất xơ cho món canh súp tươi mát, thanh lọc cơ thể","20.000",R.drawable.canh_sup));
            mList.add(new Food("Canh chua (đuôi)","Canh chua cá hú có vị chua dịu, thanh mát, thơm ngon, thịt cá ngọt vô cùng hấp dẫn","20.000",R.drawable.canh_chua));

        }
        mAdapter = new MenuItemAdapter(mList,getApplicationContext());
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        random_btn = findViewById(R.id.fab);
        //Gen random theo tỷ lệ custom 55% súp, 15% khổ qua, 15% canh chua (mình), 15% canh chua (đuôi)
        random_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, mList.size() + 1);
                if(randomNum<=55)
                {
                    recyclerView.smoothScrollToPosition(randomNum);
                        final ErrorDialog dialog = new ErrorDialog(MainActivity.this, "Số " + (randomNum+1), "Bạn bốc trúng "+ "Canh súp",R.drawable.canh_sup);
                        dialog.setupOkButton("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                random_btn.show();
                            }
                        });
                        dialog.show();
                        dialog.setCanceledOnTouchOutside(false);
                    MediaPlayer canh_sup = MediaPlayer.create(MainActivity.this,R.raw.canh_sup);
                    canh_sup.start();
                }else if(randomNum<=70){
                    recyclerView.smoothScrollToPosition(randomNum);
                    final ErrorDialog dialog = new ErrorDialog(MainActivity.this, "Số " + (randomNum+1), "Bạn bốc trúng "+ "Canh khổ qua",R.drawable.canh_kho_qua);
                    dialog.setupOkButton("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            random_btn.show();
                        }
                    });
                    dialog.show();
                    dialog.setCanceledOnTouchOutside(false);
                    MediaPlayer canh_sup = MediaPlayer.create(MainActivity.this,R.raw.canh_kho_qua);
                    canh_sup.start();
                }else if(randomNum<=85)
                {
                    recyclerView.smoothScrollToPosition(randomNum);
                    final ErrorDialog dialog = new ErrorDialog(MainActivity.this, "Số " + (randomNum+1), "Bạn bốc trúng "+ "Canh chua (mình)",R.drawable.canh_chua);
                    dialog.setupOkButton("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            random_btn.show();
                        }
                    });
                    dialog.show();
                    dialog.setCanceledOnTouchOutside(false);
                    MediaPlayer canh_sup = MediaPlayer.create(MainActivity.this,R.raw.canh_chua_minh);
                    canh_sup.start();
                }
                else {
                    recyclerView.smoothScrollToPosition(randomNum);
                    final ErrorDialog dialog = new ErrorDialog(MainActivity.this, "Số " + (randomNum+1), "Bạn bốc trúng "+ "Canh chua (đuôi)",R.drawable.canh_chua);
                    dialog.setupOkButton("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            random_btn.show();
                        }
                    });
                    dialog.show();
                    dialog.setCanceledOnTouchOutside(false);
                    MediaPlayer canh_sup = MediaPlayer.create(MainActivity.this,R.raw.canh_chua_duoi);
                    canh_sup.start();
                }

                //Gen Random theo tỷ lệ đều
//                for (int i = 0; i < mList.size(); i++) {
//                    if(i == (randomNum))
//                    {
//                        recyclerView.smoothScrollToPosition(i);
//                        final ErrorDialog dialog = new ErrorDialog(MainActivity.this, "Số " + (i+1), "Bạn bốc trúng "+ mList.get(i).getName(),mList.get(i).getImgRes());
//                        dialog.setupOkButton("OK", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                dialog.dismiss();
//                                random_btn.show();
//                            }
//                        });
//                        dialog.show();
//                        dialog.setCanceledOnTouchOutside(false);
//                    }
//
//                }
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy < 0){
                    random_btn.show();
                }
                else if (dy > 0)
                {
                    random_btn.hide();
                }
            }
        });
    }
}
