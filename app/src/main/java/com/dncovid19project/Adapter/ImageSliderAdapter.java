package com.dncovid19project.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dncovid19project.HomeTreamentActivity;
import com.dncovid19project.ImageDetailedActivity;
import com.dncovid19project.Models.Image_Slider;
import com.dncovid19project.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ImageSliderAdapter extends
        SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH> {

    private Context context;
    private List<Image_Slider> mSliderItems = new ArrayList<>();

    public ImageSliderAdapter(HomeTreamentActivity homeTreamentActivity, List<Image_Slider> image_sliders) {
        this.context = homeTreamentActivity;
        mSliderItems = image_sliders;
    }


    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_image_slider, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        final Image_Slider image_slider = mSliderItems.get(position);

        Glide.with(viewHolder.itemView)
                .load(image_slider.getImage())
                .fitCenter().placeholder(R.drawable.placeholder)
                .into(viewHolder.Image);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ImageDetailedActivity.class);
                intent.putExtra("image", image_slider.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView Image;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            Image = itemView.findViewById(R.id.image);
            this.itemView = itemView;
        }
    }

}
