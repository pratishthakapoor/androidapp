package com.pratishthakapoor.gomovie.ui.home.search;

import javax.inject.Inject;

import in.co.gomovie.gomovieapp.data.DataManager;
import in.co.gomovie.gomovieapp.data.network.response.SearchResponse;
import in.co.gomovie.gomovieapp.ui.base.BasePresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by tanmayvijayvargiya on 07/04/17.
 */

public class SearchPresenterImpl<V extends SearchView> extends BasePresenter<V> implements SearchPresenter<V>{

    @Inject
    public SearchPresenterImpl(DataManager dataManager) {
        super(dataManager);
    }


    @Override
    public void onSearchValueChange(String searchString) {
        getDataManager().search(searchString)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<SearchResponse>() {
                        @Override
                        public void call(SearchResponse searchResponse) {
                            if(searchResponse.getUsers() != null){
                                checkViewAttached();
                                getMvpView().setUsers(searchResponse.getUsers());
                            }
                            if(searchResponse.getMovies() != null){
                                checkViewAttached();
                                getMvpView().setMovies(searchResponse.getMovies());
                            }
                        }
                    });


    }

    @Override
    public void addToRecent(String recent) {

    }
}
