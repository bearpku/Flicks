package com.codepath.richard_huang.flicks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {
    private String BASE_URI =  "https://api.themoviedb.org/3/movie/now_playing";
    private String API_KEY = "030ab859193237f03ed76f36076a2a21";

    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadMovies();
    }

    private void setAdapterByResponse(JSONObject response) throws JSONException {
        JSONArray results = response.getJSONArray("results");
        for (int i = 0; i < results.length(); i++) {
            JSONObject obj = results.getJSONObject(i);
            movies.add(new Movie(obj));
        }

        MoviesAdapter adapter = new MoviesAdapter(this, movies);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.notifyDataSetChanged();

        findViewById(R.id.spinner).setVisibility(GONE);
    }


    private void loadMovies() {
        movies = new ArrayList<>();
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("api_key", API_KEY);

        client.get(BASE_URI, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    Log.d("API", "Pull movies success");
                    setAdapterByResponse(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("API", "Pull movies failed");
            }
        });
    }
}
