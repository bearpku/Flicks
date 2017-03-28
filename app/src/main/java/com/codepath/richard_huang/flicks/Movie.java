package com.codepath.richard_huang.flicks;

import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by richard_huang on 3/27/17.
 */

public class Movie {
    public String posterPath;
    public String overview;
    public Integer id;
    public String title;
    public String backdropPath;
    public Integer voteAverage;

    private String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/";

    public Movie(JSONObject data) throws JSONException {
        this.id = data.getInt("id");
        this.title = data.getString("title");
        this.overview = data.getString("overview");
        this.posterPath = IMAGE_BASE_URL + data.getString("poster_path");
        this.backdropPath = IMAGE_BASE_URL + data.getString("backdrop_path");
        this.voteAverage = data.getInt("vote_average");
    }
}
