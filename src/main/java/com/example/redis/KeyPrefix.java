package com.example.redis;

/**
 * Description:
 * All Rights Reserved.
 *
 */
public interface KeyPrefix {
    int expireSeconds();

    String getPrefix();
}