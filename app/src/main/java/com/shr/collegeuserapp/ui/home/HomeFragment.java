package com.shr.collegeuserapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shr.collegeuserapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;


public class HomeFragment extends Fragment {
    private SliderLayout sliderLayout;
    private ImageView map;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2);

        setSliderViews();

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });
        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q= AISSMS,IOIT,PUNE");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);

    }

    private void setSliderViews() {
        for (int i = 0; i< 5; i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            switch (i){
                case 0:
                    sliderView.setDescription("AISSMS,IOIT");
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/noticeapp-fc658.appspot.com/o/Gallery%2Fioit.jpg?alt=media&token=29285986-996f-4f75-af32-2c198e556ab1");
                    break;
                case 1:
                    sliderView.setDescription("NATIONAL SERVICE SCHEME");
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/noticeapp-fc658.appspot.com/o/Gallery%2Fnss.jpg?alt=media&token=05aecadb-574d-4286-aab8-d7a6a923490c");
                    break;
                case 2:
                    sliderView.setDescription("COLLEGE EVENT");
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/noticeapp-fc658.appspot.com/o/Gallery%2Falacrity1.jpg?alt=media&token=d5f5dcc1-05c4-4779-89a5-9b4c179f8a35");
                    break;
                case 3:
                    sliderView.setDescription("COLLEGE CROWD");
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/noticeapp-fc658.appspot.com/o/Gallery%2Falacrity.jpg?alt=media&token=04d4171c-a288-411f-9dcf-e39762e3b9a7");
                    break;
                case 4:
                    sliderView.setDescription("CONVOCATION");
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/noticeapp-fc658.appspot.com/o/Gallery%2Fdegree.jpg?alt=media&token=ff707cab-ef80-458b-8e84-7954d2c00e38");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);

            sliderLayout.addSliderView(sliderView);
        }
    }

}