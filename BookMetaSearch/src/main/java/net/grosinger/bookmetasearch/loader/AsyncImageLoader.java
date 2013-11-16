package net.grosinger.bookmetasearch.loader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Load an image from URL and fills an ImageView
 *
 * @author Tony
 * @since 11/16/2013
 */
public class AsyncImageLoader extends AsyncTask<String, Void, Bitmap> {
    private ImageView view;

    public AsyncImageLoader(ImageView toFill, String title) {
        Log.d(getClass().getSimpleName(), "Creating image loader for " + title);
        view = toFill;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        Log.d(getClass().getSimpleName(), "Loading image in background");

        if(urls.length != 1) {
            return null;
        }

        // TODO: Load image from cache if exists

        try {
            URL url = new URL(urls[0]);
            return BitmapFactory.decodeStream(url.openConnection().getInputStream());

            // TODO: Save image to cache
        } catch (MalformedURLException e) {
            Log.e(getClass().getSimpleName(), "Could not load image: " + urls[0], e);
        } catch (IOException e) {
            Log.e(getClass().getSimpleName(), "Could not load image: " + urls[0], e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        if(view != null) {
            view.setImageBitmap(result);
        }
    }
}
