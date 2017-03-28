package com.codepath.richard_huang.flicks;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by richard_huang on 3/27/17.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView tvTitle;
    private TextView tvOverview;
    private ImageView ivPoster;

    public ViewHolder(View itemView) {
        super(itemView);

        tvTitle = (TextView) itemView.findViewById(R.id.title);
        tvOverview = (TextView) itemView.findViewById(R.id.overview);
        ivPoster = (ImageView) itemView.findViewById(R.id.moviePoster);
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void setOverview(String overview) {
        tvOverview.setText(overview);
    }

    public ImageView getPoster() {
        return ivPoster;
    }
}
