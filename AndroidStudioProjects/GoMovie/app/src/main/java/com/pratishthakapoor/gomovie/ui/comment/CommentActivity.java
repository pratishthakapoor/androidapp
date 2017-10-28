package com.pratishthakapoor.gomovie.ui.comment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.pratishthakapoor.gomovie.R;
import com.pratishthakapoor.gomovie.model.Comment;
import com.pratishthakapoor.gomovie.ui.base.BaseActivity;

public class CommentActivity extends BaseActivity implements CommentView, CommentCallback {

    @Inject
    CommentPresenter<CommentView> presenter;
    @BindView(R.id.commentHolder)
    InfinitePlaceHolderView commentHolder;
    @BindView(R.id.commentEditText)
    EditText commentEditText;
    @BindView(R.id.commentPostButton)
    Button commentPostButton;

    String foreign_id;
    private static final String ARG_FOREIGN_ID = "foreign_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        commentHolder.setLayoutManager(linearLayoutManager);
        Intent i = getIntent();
        if(i != null){
            foreign_id = i.getStringExtra(ARG_FOREIGN_ID);
        }
        if(foreign_id == null){
            finish();
        }
        presenter.onAttach(this);

        commentPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String commentText = commentEditText.getText().toString();
                if(commentText.length() > 0){

                    presenter.publishComment(commentText);
                }
            }
        });
    }

    public static Intent getStartIntent(String foreign_id, Context context){
        Intent i = new Intent(context, CommentActivity.class);
        i.putExtra(ARG_FOREIGN_ID, foreign_id);
        return i;
    }

    @Override
    public void addComment(List<Comment> comments) {
        commentHolder.removeAllViews();
        commentHolder.refresh();
        for(Comment comment: comments)
            commentHolder.addView(new CommentListItem(comment, this, this));
        commentHolder.scrollToPosition(comments.size());
    }

    @Override
    public String getForeignId() {
        return foreign_id;
    }

    @Override
    public void onPublish() {
        commentEditText.setText("");
        presenter.getComments();
    }
}
