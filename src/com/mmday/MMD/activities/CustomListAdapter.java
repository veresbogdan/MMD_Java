package com.mmday.MMD.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mmday.MMD.R;
import com.mmday.MMD.models.ImageDto;
import com.mmday.MMD.services.ThumbnailImageService;
import com.mmday.MMD.services.ThumbnailImageServiceImpl;

import java.util.List;

/**
 * Created by albert on 20.07.2014.
 */
public class CustomListAdapter extends ArrayAdapter<ImageDto> {
    private final Context context;
    private final List<ImageDto> categories;
    private final ThumbnailImageService thumbnailService;

    public CustomListAdapter(Context context, List<ImageDto> values) {
        super(context, R.layout.image_item_layout, values);
        this.context = context;
        this.categories = values;
        this.thumbnailService = new ThumbnailImageServiceImpl();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.image_item_layout, parent, false);
        TextView firstRow = (TextView) rowView.findViewById(R.id.firstLine);
        TextView secondRow = (TextView) rowView.findViewById(R.id.secondLine);

        ImageDto current = this.categories.get(position);
        firstRow.setText(current.getId().toString());
        secondRow.setText(current.getCategoryId().toString());

        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        //TODO : move away int an asyn something from here the download image method
        //ContactsContract.CommonDataKinds.Photo bitmap = this.thumbnailService.getThumbnail(current.getId().toString());
        //imageView.setImageDrawable(bitmap);

        return rowView;
    }
}
