package com.pratishtha.android.upcomingmovies.api.mapper;


public interface Mapper<TFrom, TTo> {

  TTo map(TFrom from);
}
