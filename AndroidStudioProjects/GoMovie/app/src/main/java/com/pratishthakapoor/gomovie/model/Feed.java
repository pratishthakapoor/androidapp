
package com.pratishthakapoor.gomovie.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

import com.pratishthakapoor.gomovie.data.network.response.ReviewOverview;
import com.pratishthakapoor.gomovie.util.MyDatabase;

@Table(database = MyDatabase.class, insertConflict = ConflictAction.REPLACE)
public class Feed extends BaseModel{

    @SerializedName("actor")
    @Expose
    @Column
    private String actor;
    @SerializedName("actorType")
    @Expose
    @Column
    private String actorType;
    @SerializedName("actorPhotoUrl")
    @Expose
    @Column
    private String actorPhotoUrl;

    @SerializedName("commentThreadId")
    @Expose
    @Column
    private String commentThreadId;
    @SerializedName("foreign_id")
    @Expose
    @Column
    private String foreignId;

    @SerializedName("id")
    @Expose
    @Column
    @PrimaryKey
    private String id;
    @SerializedName("like_count")
    @Expose
    @Column
    private int likeCount;
    @SerializedName("message")
    @Expose
    @Column
    private String message;
    @SerializedName("object")
    @Expose
    @Column
    private String object;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("target")
    @Expose
    private String target;
    @SerializedName("time")
    @Expose
    @Column
    private String time;
    @SerializedName("to")
    @Expose

    private List<String> to = null;
    @SerializedName("verb")
    @Expose
    @Column
    private String verb;
    @SerializedName("actorName")
    @Expose
    @Column
    private String actorName;
    @SerializedName("doLike")
    @Expose
    @Column
    private boolean doLike;
    @SerializedName("commentCount")
    @Expose
    @Column
    private int commentCount;

    @SerializedName("lastComment")
    @Expose
    @Column
    @ForeignKey(saveForeignKeyModel = true)
    private CommentMeta lastComment;

    @SerializedName("movie")
    @Expose
    private Movie movie;

    @SerializedName("photo")
    @Expose
    @Column
    @ForeignKey(saveForeignKeyModel = true)
    private Photo photo;
    @SerializedName("video")
    @Expose
    @Column
    @ForeignKey(saveForeignKeyModel = true)
    private Video video;
    @SerializedName("post")
    @Expose
    @Column
    @ForeignKey(saveForeignKeyModel = true)
    private Post post;

    @SerializedName("review")
    @Expose
    private ReviewOverview review;

    @SerializedName("activity")
    @Expose
    Feed activity;

    public ReviewOverview getReview() {
        return review;
    }

    public void setReview(ReviewOverview review) {
        this.review = review;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActorType() {
        return actorType;
    }

    public void setActorType(String actorType) {
        this.actorType = actorType;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public String getForeignId() {
        return foreignId;
    }

    public void setForeignId(String foreignId) {
        this.foreignId = foreignId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Object getOrigin() {
        return origin;
    }

    public void setOrigin(String  origin) {
        this.origin = origin;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(String  target) {
        this.target = target;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public boolean isDoLike() {
        return doLike;
    }

    public void setDoLike(boolean doLike) {
        this.doLike = doLike;
    }

    public String getActorPhotoUrl() {
        return actorPhotoUrl;
    }

    public void setActorPhotoUrl(String actorPhotoUrl) {
        this.actorPhotoUrl = actorPhotoUrl;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public CommentMeta getLastComment() {
        return lastComment;
    }

    public void setLastComment(CommentMeta lastComment) {
        this.lastComment = lastComment;
    }

    public Feed getActivity() {
        return activity;
    }

    public void setActivity(Feed activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "actor='" + actor + '\'' +
                ", actorType='" + actorType + '\'' +
                ", commentCount=" + commentCount +
                ", commentThreadId='" + commentThreadId + '\'' +
                ", foreignId='" + foreignId + '\'' +
                ", id='" + id + '\'' +
                ", likeCount=" + likeCount +
                ", message='" + message + '\'' +
                ", object='" + object + '\'' +
                ", origin=" + origin +
                ", target=" + target +
                ", time='" + time + '\'' +
                ", to=" + to +
                ", verb='" + verb + '\'' +
                ", actorName='" + actorName + '\'' +
                ", photo=" + photo +
                ", video=" + video +
                ", post=" + post +
                '}';
    }

    @Override
    public void save() {
        if(this.getPost() != null)
            this.getPost().save();
        if(this.getVideo() != null)
            this.getVideo().save();
        if(this.getPhoto() != null)
            this.getPhoto().save();
        if(this.getLastComment() != null){
            this.getLastComment().save();
        }
        super.save();
    }
}
