package com.picklemixel.mister.colourlovers.model;

import android.content.Context;

import com.picklemixel.mister.colourlovers.R;

import java.util.ArrayList;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 16/06/16.
 */
public class Palette {

    private int id;
    private String title;
    private String userName;
    private int numViews;
    private float numVotes;
    private int numComments;
    private float numHearts;
    private float rank;
    private String dateCreated;
    private ArrayList<String> colors;
    private ArrayList<Float> colorWidths;
    private String description;
    private String url;
    private String imageUrl;
    private String badgeUrl;
    private String apiUrl;

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNumViews() {
        return numViews;
    }

    public void setNumViews(int numViews) {
        this.numViews = numViews;
    }

    public float getNumVotes() {
        return numVotes;
    }

    public void setNumVotes(float numVotes) {
        this.numVotes = numVotes;
    }

    public int getNumComments() {
        return numComments;
    }

    public void setNumComments(int numComments) {
        this.numComments = numComments;
    }

    public float getNumHearts() {
        return numHearts;
    }

    public void setNumHearts(float numHearts) {
        this.numHearts = numHearts;
    }

    public float getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public ArrayList<Float> getColorWidths() {
        return colorWidths;
    }

    public void setColorWidths(ArrayList<Float> colorWidths) {
        this.colorWidths = colorWidths;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public int getSize() {
        return colors.size();
    }

    public int getId() {
        return id;
    }

    public String getColor(Context context, int i) {
        return String.format(context.getString(R.string.hex_format), colors.get(i));
    }

    public float getColorWidth(int i) {
        return colorWidths.get(i);
    }
}
