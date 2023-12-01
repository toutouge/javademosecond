package com.example.demo.service;

import com.example.demo.model.Feed;

/**
 * @Author chen bo
 * @Date 2024/4
 * @Des
 */
public interface FeedService {
    /**
     *
     * @return
     */
    Feed getFeed(int id);

    /**
     *
     * @return
     */
    Feed index(int id);
}
