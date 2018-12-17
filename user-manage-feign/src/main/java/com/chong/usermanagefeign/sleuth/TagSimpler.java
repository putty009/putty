package com.chong.usermanagefeign.sleuth;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.Span;

/**
 * 自定义的抽样策略
 * */
public class TagSimpler implements Sampler {
    private String tag;
    public TagSimpler(String tag) {
        this.tag = tag;
    }

    public boolean isSampled(Span span) {
        return span.tags().get(tag)!=null;
    }
}
